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
        maleBiologicalSexButton.click();
    }

    public void clickFemaleButton() {
        wait.until(ExpectedConditions.elementToBeClickable(femaleBiologicalSexButton));
        femaleBiologicalSexButton.click();
    }

    public void setEligibleBirthDate() {
        waitUntilAnimationIsFinished();
        birthDateTextField.sendKeys("19051981");
    }

    public void setNOTEligibleBirthDate() {
        waitUntilAnimationIsFinished();
        birthDateTextField.sendKeys("01052019");
    }

    public void setZipCodeForNYC() {
        zipCodeTextField.sendKeys("10001");
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public void ConfirmMessageForLadiesThatEDIsMenThing() {
        waitUntilAnimationIsFinished();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='flow-question-header-description'])[2]")));
        String InfoForGirls = driver.findElement(By.xpath("(//div[@class='flow-question-header-description'])[2]")).getText();
        assertTrue(InfoForGirls.contains("Unfortunately our ED treatment is currently only available to men. However, we would love to know if there’s anything we can do to help."));
    }

    public void ConfirmMessageForChildThatEDIsAdultThing() {
        waitUntilAnimationIsFinished();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='flow-question-header-description'])[2]")));
        String InfoForGirls = driver.findElement(By.xpath("(//div[@class='flow-question-header-description'])[2]")).getText();
        assertTrue(InfoForGirls.contains("Unfortunately our ED treatment is not available to people under 18. However, we would love to know if there is anything we can do to help. Please confirm your email and leave comments below - we will get back to you as soon as we can."));
    }
    public void waitUntilAnimationIsFinished() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='flow-question-overlay flow-question-overlay--out animating forward']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='flow-question-overlay flow-question-overlay--out flow-question-overlay--secondary animating forward']")));
    }


}
