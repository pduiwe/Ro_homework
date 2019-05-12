package RoTests;



import org.junit.Test;


public class SmokeCheckChildTest extends TestBase {



    @Test
    public void logInAsKidAndCheckValidation() {
        String email = "kid@gmail.com";
        String firstName = "Kid";
        String lastName = "Snow";
        String password = "youKnowNothingKid";


        LogInPOP.logIntoPortal(email, firstName, lastName, password);

        waitUntilAnimationIsFinished();
        LogInPOP.checkThatUserNameIsDisplayedOnWelcomeMessage(firstName);

        WelcomePagePOP.clickOnStartMyVisitButton();
        waitUntilAnimationIsFinished();

        TheBasicsPOP.setNOTEligibleBirthDate();
        TheBasicsPOP.clickMaleButton();

        waitUntilAnimationIsFinished();
        TheBasicsPOP.ConfirmMessageForChildThatEDIsAdultThing();
    }
}