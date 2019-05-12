package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;


public class MedicalQuestionsPOP {
    WebDriver driver;
    WebDriverWait wait;


//Elements on the page//

    @FindBy(xpath = "(//button[@class='button button--big button--block button--primary flow-question-button'])[2 and text() = 'Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "(//div[@class='flow-question-header-title'])[2 and text() = 'Do you ever have a problem getting or maintaining an erection that is satisfying enough for sex?']")
    public WebElement firstQuestionText;

    @FindBy(xpath = "(//div[@class='flow-question-header-title'])[2 and text() = 'How did your ED begin? Select the one that best describes your ED.']")
    public WebElement secondQuestionText;

    @FindBy(xpath = "(//button[@class='flow-choice_list-link'])[2 and text() = 'Yes, every time']")
    public WebElement firstQuestionDoYouEverYesEverytimeAnswer;

    @FindBy(xpath = "(//button[@class='flow-choice_list-link'])[2 and text() = 'I do not recall how it began']")
    public WebElement secondQuestioniDoNotRecallHowItBeganAnswer;

    @FindBy(xpath = "(//label[@class='checkbox-label'])[2 and text() = 'Neither']")
    public WebElement thirdQuestionCheckboxNeither;

    @FindBy(xpath = "(//button[@class='button flow-question-button button--block button--primary'])[2 and text() = 'Next']")
    public WebElement nextButton;

    @FindBy(xpath = "(//button[@class='flow-choice_list-link'])[2 and text() = 'Less than it was']")
    public WebElement fourthQuestionAnswerLessThanItWas;

    @FindBy(xpath = "(//button[@class='flow-choice_list-link'])[2 and text() = 'No']")
    public WebElement fifthQuestionAnswerNo;

    @FindBy(xpath = "(//button[@class='flow-choice_list-link'])[2 and text() = 'Yes, and it was normal.']")
    public WebElement sixthQuestionAnswerYesAndItWasNormal;

    @FindBy(xpath = "(//button[@class='flow-choice_list-link'])[2 and text() = 'No, I don’t know my blood pressure']")
    public WebElement seventhQuestionAboutBllodPressureNoIDontKnowMyBloodPressure;







    public MedicalQuestionsPOP(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 25);
    }



    // interactions//

    public void waitUntilWelcomeMedicalQuestionsPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='flow-question-header-category'])[2 and text() = 'Let’s talk about your health']")));
    }

    public void checkFirstQuestionText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='flow-question-header-title'])[2]")));
        String Question1 = driver.findElement(By.xpath("(//div[@class='flow-question-header-title'])[2]")).getText();
        assertTrue(Question1.contains("Do you ever have a problem getting or maintaining an erection that is satisfying enough for sex?"));
    }

    public void clickContinueButton() {
        WebElement element = driver.findElement(By.xpath("(//button[@class='button button--big button--block button--primary flow-question-button'])[2 and text() = 'Continue']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        continueButton.click();
    }

    public void clickYesEveryTimeForFirstQuestion() {
        firstQuestionDoYouEverYesEverytimeAnswer.click();
    }

    public void checkSecondQuestionText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='flow-question-header-title'])[2]")));
        String Question2 = driver.findElement(By.xpath("(//div[@class='flow-question-header-title'])[2]")).getText();
        assertTrue(Question2.contains("How did your ED begin? Select the one that best describes your ED."));
    }

    public void clickIdoNotRecallForSecondQuestion() {
        secondQuestioniDoNotRecallHowItBeganAnswer.click();
    }

    public void selectNeitherCheckboxOnThirdQuestion() {
        thirdQuestionCheckboxNeither.click();
    }

    public void clickNextButtonAfterCheckboxSelection() {
        nextButton.click();
    }

    public void goToBloodPressureQuestion() {
        fourthQuestionAnswerLessThanItWas.click();
        waitUntilTrickyAnimationIsFinished();
        fifthQuestionAnswerNo.click();
        waitUntilTrickyAnimationIsFinished();
        sixthQuestionAnswerYesAndItWasNormal.click();
        waitUntilTrickyAnimationIsFinished();
        seventhQuestionAboutBllodPressureNoIDontKnowMyBloodPressure.click();
        waitUntilTrickyAnimationIsFinished();
    }

    public void waitUntilTrickyAnimationIsFinished() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='flow-question-overlay flow-question-overlay--out animating forward']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='flow-question-overlay flow-question-overlay--out flow-question-overlay--secondary animating forward']")));
    }

}
