package RoTests;


import Pages.LogInPOP;
import Pages.MedicalQuestionsPOP;
import Pages.TheBasicsPOP;
import Pages.WelcomePagePOP;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;


import static java.lang.Thread.sleep;



public class SmokeCheckTest extends MainTest {


    LogInPOP LogInPOP = PageFactory.initElements(driver, LogInPOP.class);
    WelcomePagePOP WelcomePagePOP = PageFactory.initElements(driver, WelcomePagePOP.class);
    TheBasicsPOP TheBasicsPOP = PageFactory.initElements(driver, TheBasicsPOP.class);
    MedicalQuestionsPOP MedicalQuestionsPOP = PageFactory.initElements(driver, MedicalQuestionsPOP.class);


    @Test
    public void logInAsEligibleMaleAndBuyViagra() throws InterruptedException {
        String email = "tester@gmail.com";
        String firstName = "John";
        String lastName = "Snow";
        String password = "youKnowNothing";

        LogInPOP.logIntoPortal(email, firstName, lastName, password);

        LogInPOP.checkThatUserNameIsDisplayedOnWelcomeMessage(firstName);// w tej metodzie w POP jest brzydki sleep na animacje

        WelcomePagePOP.clickOnOurTreatmentPlansTab();
        WelcomePagePOP.checkThreeProductsOnOurTreatmentPlansTab();
        WelcomePagePOP.clickOnHowItWorksTab();
        WelcomePagePOP.checkThreeStartStepsItemsOnHowItWorksTab();
        WelcomePagePOP.clickOnStartMyVisitButton();

        sleep(2000); // brzydki sleep na animacje

        TheBasicsPOP.setEligibleBirthDate();
        TheBasicsPOP.clickMaleButton();
        TheBasicsPOP.setZipCodeForNYC();
        TheBasicsPOP.clickNextButton();

        sleep(2000); //brzydki sleep na animacje

        MedicalQuestionsPOP.waitUntilMedicalQuestionsPageIsLoaded();
        MedicalQuestionsPOP.clickContinueButton();





    }
}
