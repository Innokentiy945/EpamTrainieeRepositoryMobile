package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.DataReader;

public class WebPageObject {

    @FindBy(xpath = "//input[@name='q']")
    WebElement addData;

    @FindBy(xpath = "//button[@class='Tg7LZd']")
    WebElement pushButton;

    @FindBy(xpath = "//div[contains(text(),'EPAM | Enterprise Software Development, Design & Consulting')]")
    WebElement firstResult;


    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }



}
