package scenarios;


import org.testng.annotations.Test;
import setup.BaseTest;
import utils.DataReader;



import static org.testng.Assert.assertTrue;

public class nativeMobileTests extends BaseTest {


    @Test(groups = {"nativeAndroid"}, description = "This test will verify registration of the new user in Android")
    public void registerNewUserAndroidTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPageObject().getWebelement("registerButton").click();
        getPageObject().getWebelement("emailArea").sendKeys(DataReader.getProperty("email"));
        getPageObject().getWebelement("userNameArea").sendKeys(DataReader.getProperty("user"));
        getPageObject().getWebelement("passwordArea").sendKeys(DataReader.getProperty("password"));
        getPageObject().getWebelement("confirmPasswordArea").sendKeys(DataReader.getProperty("password"));
        getPageObject().getWebelement("agreementsCheckBox").click();
        getPageObject().getWebelement("endRegistrationProcess").click();

        boolean actualConfirmingRegistration = getPageObject().getWebelement("registrationConfirm").isDisplayed();
        assertTrue(actualConfirmingRegistration);
    }


    @Test(groups = {"nativeAndroid"}, description = "This test will verify sigin process in Android")
    public void signInRegisteredAndroidUserTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPageObject().getWebelement("loginEmail").sendKeys(DataReader.getProperty("email"));
        getPageObject().getWebelement("loginPassword").sendKeys(DataReader.getProperty("password"));
        getPageObject().getWebelement("signInButton").click();

        boolean actualHeaderBudgetActivity = getPageObject().getWebelement("headerAfterSignIn").isDisplayed();
        assertTrue(actualHeaderBudgetActivity);

        boolean actualButtonBudgetActivity = getPageObject().getWebelement("budgetActivityTitle").isDisplayed();
        assertTrue(actualButtonBudgetActivity);
    }

    @Test(groups = {"nativeIos"}, description = "This test will verify registration of the new user in Ios")
    public void registerNewUserIosTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPageObject().getWebelement("registerButton").click();
        getPageObject().getWebelement("emailArea").sendKeys(DataReader.getProperty("email"));
        getPageObject().getWebelement("userNameArea").sendKeys(DataReader.getProperty("user"));
        getPageObject().getWebelement("passwordArea").sendKeys(DataReader.getProperty("password"));
        getPageObject().getWebelement("confirmPasswordArea").sendKeys(DataReader.getProperty("password"));
        getPageObject().getWebelement("iosConfirmSwitch").click();
        getPageObject().getWebelement("endRegistrationProcess").click();

        boolean actualConfirmingRegistration = getPageObject().getWebelement("iosConfirmSwitch").isEnabled();
        assertTrue(actualConfirmingRegistration);
    }

    @Test(groups = {"nativeIos"}, description = "This test will verify sigin process in Ios")
    public void signInRegisteredIosUserTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPageObject().getWebelement("loginEmail").sendKeys(DataReader.getProperty("email"));
        getPageObject().getWebelement("loginPassword").sendKeys(DataReader.getProperty("password"));
        getPageObject().getWebelement("signInButton").click();

        boolean actualButtonBudgetActivity = getPageObject().getWebelement("budgetActivityTitle").isDisplayed();
        assertTrue(actualButtonBudgetActivity);
    }

}
