package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MedicalQuestionsPOP {
    WebDriver driver;
    WebDriverWait wait;


//Elements on the page//


    @FindBy(xpath = "(//button[@class='button button--big button--block button--primary flow-question-button'])[2 and text() = 'Continue']")
    public WebElement continueButton;



    //page factory constructor//
    public MedicalQuestionsPOP(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 25);
    }



    // interactions//

    public void waitUntilMedicalQuestionsPageIsLoaded() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='flow-question-header-category'])[2 and text() = 'Let’s talk about your health']")));
    }

    public void clickContinueButton() {
        continueButton.click();
    }

}
