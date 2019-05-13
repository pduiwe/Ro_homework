package RoTests;



import org.junit.Test;


public class SmokeCheckManTest extends TestBase {


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

        MedicalQuestionsPOP.waitUntilWelcomeMedicalQuestionsPage();
        MedicalQuestionsPOP.clickContinueButton();

        MedicalQuestionsPOP.checkFirstQuestionText();
        MedicalQuestionsPOP.clickYesEveryTimeForFirstQuestion();

        MedicalQuestionsPOP.checkSecondQuestionText();
        MedicalQuestionsPOP.clickIdoNotRecallForSecondQuestion();

        MedicalQuestionsPOP.selectNeitherCheckboxOnThirdQuestion();
        MedicalQuestionsPOP.clickNextButtonAfterCheckboxSelection();

        MedicalQuestionsPOP.goFastToBloodPressureQuestion();

        GoToTheDoctorForBloodPresureReadingPOP.checkPatientEmailAddresssAndSendHimForBloodPressureReadings(email);
        GoToTheDoctorForBloodPresureReadingPOP.checkThatThankYouMessageIsDisplayedAfterSubmitingForm();

    }
}
