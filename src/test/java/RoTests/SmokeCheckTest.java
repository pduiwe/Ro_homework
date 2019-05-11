package RoTests;


import Pages.LogInPOP;
import Pages.MedicalQuestionsPOP;
import Pages.TheBasicsPOP;
import Pages.WelcomePagePOP;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;



public class SmokeCheckTest extends MainTest {


    LogInPOP LogInPOP = PageFactory.initElements(driver, LogInPOP.class);
    WelcomePagePOP WelcomePagePOP = PageFactory.initElements(driver, WelcomePagePOP.class);
    TheBasicsPOP TheBasicsPOP = PageFactory.initElements(driver, TheBasicsPOP.class);
    MedicalQuestionsPOP MedicalQuestionsPOP = PageFactory.initElements(driver, MedicalQuestionsPOP.class);


    @Test
    public void logInAsEligibleMaleAndBuyViagra() {
        String email = "tester@gmail.com";
        String firstName = "John";
        String lastName = "Snow";
        String password = "youKnowNothing";

        LogInPOP.logIntoPortal(email, firstName, lastName, password);
        LogInPOP.checkThatUserNameIsDisplayedOnWelcomeMessage(firstName);

        WelcomePagePOP.clickOnOurTreatmentPlansTab();
        WelcomePagePOP.checkThreeProductsOnOurTreatmentPlansTab();
        WelcomePagePOP.clickOnHowItWorksTab();
        WelcomePagePOP.checkThreeStartStepsItemsOnHowItWorksTab();
        WelcomePagePOP.clickOnStartMyVisitButton();

        TheBasicsPOP.setEligibleBirthDate();
        TheBasicsPOP.clickMaleButton();
        TheBasicsPOP.setZipCodeForNYC();
        TheBasicsPOP.clickNextButton();

        MedicalQuestionsPOP.waitUntilMedicalQuestionsPageIsLoaded();
        MedicalQuestionsPOP.clickContinueButton();





    }
}
