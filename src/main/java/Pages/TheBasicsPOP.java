package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TheBasicsPOP {
    WebDriver driver;
    WebDriverWait wait;


//Elements on the page//

    @FindBy(xpath = "//label[@for='male']")
    public WebElement maleBiologicalSexButton;

    @FindBy(xpath = "//label[@for='female']")
    public WebElement femaleBiologicalSexButton;

    @FindBy(id = "dateOfBirth")
    public WebElement birthDateTextField;

    @FindBy(id = "zipcode")
    public WebElement zipCodeTextField;

    @FindBy(xpath = "(//button[@class='button button--block button--primary'])[2 and text() = 'Next']")
    public WebElement nextButton;




    public TheBasicsPOP(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 25);
    }



    // interactions//

    public void clickMaleButton() {

        wait.until(ExpectedConditions.elementToBeClickable(maleBiologicalSexButton));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='preloader preloader--is_loaded']")));
        maleBiologicalSexButton.click();
    }

    public void setEligibleBirthDate() {
        birthDateTextField.sendKeys("19051981");
    }

    public void setZipCodeForNYC() {
        zipCodeTextField.sendKeys("10001");
    }

    public void clickNextButton() {
        nextButton.click();

    }

}
