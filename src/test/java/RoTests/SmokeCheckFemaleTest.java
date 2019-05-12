package RoTests;



import org.junit.Test;



public class SmokeCheckFemaleTest extends TestBase {


    @Test
    public void logInAsFemaleAndCheckValidation() {
        String email = "rory@gmail.com";
        String firstName = "Rory";
        String lastName = "Snow";
        String password = "NotForYouRory";

        LogInPOP.logIntoPortal(email, firstName, lastName, password);
        waitUntilAnimationIsFinished();
        LogInPOP.checkThatUserNameIsDisplayedOnWelcomeMessage(firstName);

        WelcomePagePOP.clickOnStartMyVisitButton();

        waitUntilAnimationIsFinished();
        TheBasicsPOP.setEligibleBirthDate();
        TheBasicsPOP.clickFemaleButton();

        waitUntilAnimationIsFinished();
        TheBasicsPOP.ConfirmMessageForLadiesThatEDIsMenThing();
    }
}