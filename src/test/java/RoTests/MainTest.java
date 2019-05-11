package RoTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainTest {

    public static final WebDriver driver = new ChromeDriver();
    public static final WebDriverWait wait = new WebDriverWait(driver, 25);



    @Before

    public void pageShouldBeOpened() {
//open start Page
      driver.get("https://start.ro.co/roman/ed"); //PROD ENVIRONMENT
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("temporaryEmail")));
        Assert.assertTrue(driver.findElement(By.id("temporaryEmail")).isDisplayed());

    }

//   @AfterClass
//   public static void tearDown(){driver.close();}


}



