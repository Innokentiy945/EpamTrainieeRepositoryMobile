package scenarios;


import org.testng.annotations.Test;
import setup.BaseTest;
import utils.DataReader;



import static org.testng.Assert.assertTrue;

public class NativeMobileTests extends BaseTest {


    @Test(groups = {"native"}, description = "This test will verify registration of the new user")
    public void registerNewUserTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPageObject().getWebelement("registerButton").click();
        getPageObject().getWebelement("emailArea").sendKeys(DataReader.getProperty("email"));
        getPageObject().getWebelement("userNameArea").sendKeys(DataReader.getProperty("user"));
        getPageObject().getWebelement("passwordArea").sendKeys(DataReader.getProperty("password"));
        getPageObject().getWebelement("confirmPasswordArea").sendKeys(DataReader.getProperty("password"));
        getPageObject().getWebelement("agreamentsCheckBox").click();
        getPageObject().getWebelement("endRegistrationProcess").click();

        boolean actualConfirmingRegistration = getPageObject().getWebelement("registrationConfirm").isDisplayed();
        assertTrue(actualConfirmingRegistration);
    }


    @Test(groups = {"native"}, description = "This test will verify sigin process")
    public void signInRegisteredUser() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPageObject().getWebelement("loginEmail").sendKeys(DataReader.getProperty("email"));
        getPageObject().getWebelement("loginPassword").sendKeys(DataReader.getProperty("password"));
        getPageObject().getWebelement("signInButton").click();

        boolean actualHeaderBudgetActivity = getPageObject().getWebelement("headerAfterSignIn").isDisplayed();
        assertTrue(actualHeaderBudgetActivity);

        boolean actualButtonBudgetActivity = getPageObject().getWebelement("buttonInBudgetActivity").isDisplayed();
        assertTrue(actualButtonBudgetActivity);
    }
}
