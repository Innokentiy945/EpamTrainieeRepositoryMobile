package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;
import utils.DataReader;

public class webAndroidTest extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure that we've opened google page wirh \"EPAM\" request and find main link of company")
    public void SearchWebTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {

        getDriver().get(DataReader.getProperty("url"));

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

        getPageObject().getWebelement("addData").sendKeys(DataReader.getProperty("request"));
        getPageObject().getWebelement("pushButton").click();
        WebElement result = getPageObject().getWebelement("firstResult");
        Assert.assertEquals(result.getText(), "EPAM | Enterprise Software Development, Design & Consulting");

        // Log that test finished
        System.out.println("Search ended");
    }

}
