package RoTests;

import Pages.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestBase {

    public static final WebDriver driver = new ChromeDriver();
    public static final WebDriverWait wait = new WebDriverWait(driver, 25);



    LogInPOP LogInPOP = PageFactory.initElements(driver, LogInPOP.class);
    WelcomePagePOP WelcomePagePOP = PageFactory.initElements(driver, WelcomePagePOP.class);
    TheBasicsPOP TheBasicsPOP = PageFactory.initElements(driver, TheBasicsPOP.class);
    MedicalQuestionsPOP MedicalQuestionsPOP = PageFactory.initElements(driver, MedicalQuestionsPOP.class);
    GoToTheDoctorForBloodPresureReadingPOP GoToTheDoctorForBloodPresureReadingPOP = PageFactory.initElements(driver, GoToTheDoctorForBloodPresureReadingPOP.class);

    public void waitUntilAnimationIsFinished() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='flow-question-overlay flow-question-overlay--out animating forward']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='flow-question-overlay flow-question-overlay--out flow-question-overlay--secondary animating forward']")));
    }

    @Before

    public void pageShouldBeOpened() {


//open start Page
      driver.get("https://start.ro.co/roman/ed"); //PROD ENVIRONMENT
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("temporaryEmail")));
        Assert.assertTrue(driver.findElement(By.id("temporaryEmail")).isDisplayed());

    }

//   @After
//   public void tearDown()
//        {driver.quit();
//        }

}



