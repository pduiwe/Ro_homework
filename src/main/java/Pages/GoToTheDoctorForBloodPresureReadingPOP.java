package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class GoToTheDoctorForBloodPresureReadingPOP {
    WebDriver driver;
    WebDriverWait wait;


//Elements on the page//
    @FindBy(id = "comment-email")
    public WebElement commentEmailAddressField;

    @FindBy(id = "comment-extras")
    public WebElement commentTestField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "(//div[@class='flow-question-header-title'])[2 and text() = 'Thank you!']")
    public WebElement ThankYouMessage;



    public GoToTheDoctorForBloodPresureReadingPOP(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 25);
    }


    // Interactions//
    public void checkPatientEmailAddresssAndSendHimForBloodPressureReadings(String email) {
        assertTrue(driver.findElement(By.xpath("//input[@value='"+email+"']")).isDisplayed());
        commentTestField.sendKeys("Send me please for free blood pressure reading");
        submitButton.click();
    }

    public void checkThatThankYouMessageIsDisplayedAfterSubmitingForm() {
        wait.until(ExpectedConditions.visibilityOf(ThankYouMessage));
        assertTrue((ThankYouMessage).isDisplayed());

    }


}
