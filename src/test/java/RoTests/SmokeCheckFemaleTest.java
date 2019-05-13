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
        LogInPOP.checkThatUserNameIsDisplayedOnWelcomeMessage(firstName);
        WelcomePagePOP.clickOnStartMyVisitButton();
        TheBasicsPOP.setEligibleBirthDate();
        TheBasicsPOP.clickFemaleButton();
        TheBasicsPOP.ConfirmMessageForLadiesThatEDIsMenThing();
    }
}