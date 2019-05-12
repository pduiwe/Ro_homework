package RoTests;



import org.junit.Test;


public class SmokeCheckTest extends TestBase {


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

        waitUntilTrickyAnimationIsFinished();
        TheBasicsPOP.setEligibleBirthDate();
        TheBasicsPOP.clickMaleButton();
        TheBasicsPOP.setZipCodeForNYC();
        TheBasicsPOP.clickNextButton();

        MedicalQuestionsPOP.waitUntilWelcomeMedicalQuestionsPage();
        waitUntilTrickyAnimationIsFinished();
        MedicalQuestionsPOP.clickContinueButton();

        waitUntilTrickyAnimationIsFinished();

        MedicalQuestionsPOP.checkFirstQuestionText();
        MedicalQuestionsPOP.clickYesEveryTimeForFirstQuestion();

        waitUntilTrickyAnimationIsFinished();

        MedicalQuestionsPOP.checkSecondQuestionText();
        MedicalQuestionsPOP.clickIdoNotRecallForSecondQuestion();

        waitUntilTrickyAnimationIsFinished();

        MedicalQuestionsPOP.selectNeitherCheckboxOnThirdQuestion();
        MedicalQuestionsPOP.clickNextButtonAfterCheckboxSelection();

    }


}
