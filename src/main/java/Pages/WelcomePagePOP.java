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


public class WelcomePagePOP {
    WebDriver driver;
    WebDriverWait wait;


//Elements on the page//

    @FindBy(xpath = "(//button[@class='tabs-button'])[2 and text() = 'How it works']")
    public WebElement howItWorksTab;

    @FindBy(xpath = "(//button[@class='tabs-button'])[2 and text() = 'Our treatment plans']")
    public WebElement ourTreatmentPlansTab;

    @FindBy(xpath = "(//button[@class='button start-button button--primary'])[2 and text() = 'Start my visit']")
    public WebElement startMyVisitButton;





    //page factory constructor//
    public WelcomePagePOP(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 25);
    }


    // interactions//

    public void clickOnOurTreatmentPlansTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='preloader preloader--is_loaded']")));
        ourTreatmentPlansTab.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class='treatment_plans-heading heading']")));
    }

    public void clickOnHowItWorksTab() {
        howItWorksTab.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class='heading start-heading']")));
    }

    public void clickOnStartMyVisitButton() {
        startMyVisitButton.click();
    }

    public void checkThreeProductsOnOurTreatmentPlansTab() {
        List<WebElement> elements;
        elements = driver.findElements(By.xpath("//ul[@class='product-list']//li"));
        assertEquals("3", Integer.toString(elements.size()));

        String Sildenafil = driver.findElement(By.xpath("(//h3[@class='heading product-heading'])[1]")).getText();
        assertTrue(Sildenafil.contains("Sildenafil"));

        String Viagra = driver.findElement(By.xpath("(//h3[@class='heading product-heading'])[2]")).getText();
        assertTrue(Viagra.contains("Viagra"));

        String Cialis = driver.findElement(By.xpath("(//h3[@class='heading product-heading'])[3]")).getText();
        assertTrue(Cialis.contains("Cialis"));
    }

    public void checkThreeStartStepsItemsOnHowItWorksTab() {
        List<WebElement> elements;
        elements = driver.findElements(By.xpath("//div[@class='start-steps']//div[@class='start-steps-item']"));
        assertEquals("3", Integer.toString(elements.size()));

        String FirstBlockMain = driver.findElement(By.xpath("(//h3[@class='start-steps-heading'])[1]")).getText();
        assertTrue(FirstBlockMain.contains("your health."));

        String SecondBlockText = driver.findElement(By.xpath("(//p[@class='start-steps-text'])[2]")).getText();
        assertTrue(SecondBlockText.contains("treatment best suited for you."));

        String ThirdBlockMain = driver.findElement(By.xpath("(//h3[@class='start-steps-heading'])[3]")).getText();
        assertTrue(ThirdBlockMain.contains("Your doctor will follow up."));
    }


}
