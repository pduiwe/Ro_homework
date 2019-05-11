package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;


public class LogInPOP {
    WebDriver driver;
    WebDriverWait wait;


//Elements on the page//
    @FindBy(id = "temporaryEmail")
    public WebElement emailAddressField;

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//label[@for='agreedToTos']")
    public WebElement agreeCheckbox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginPageStartMyVisitButton;




    //page factory constructor//
    public LogInPOP(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 25);
    }




    // Interactions//
    public void logIntoPortal(String email, String firstName, String lastName, String password) {
        emailAddressField.sendKeys(email);
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        passwordField.sendKeys(password);
        agreeCheckbox.click();
        loginPageStartMyVisitButton.click();
    }

    public void checkThatUserNameIsDisplayedOnWelcomeMessage(String firstName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='start-header']//h2[contains(text(),"+firstName+")]")));
        sleep(2000);
        assertTrue(driver.findElement(By.xpath("//div[@class='start-header']//h2[contains(text(),"+firstName+")]")).isDisplayed());
    }


}
