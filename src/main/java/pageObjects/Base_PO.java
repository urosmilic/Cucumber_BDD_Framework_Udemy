package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalVars;

import java.time.Duration;
public class Base_PO {

    public Base_PO() {
        PageFactory.initElements(getDriver(),this);
    }

    public static WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void navigateTo_URL(String url) {
        getDriver().get(url);
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public void waitForElementAndClick(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_TIMEOUT));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForElementAndSendKeys(WebElement element, String text) {
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_TIMEOUT));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).clear();
        element.sendKeys(text);
    }

    public String waitForElementAndGetText(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_TIMEOUT));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public void waitForElement(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_TIMEOUT));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public String switchToAlertAndGetText() {
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_TIMEOUT));
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        return getDriver().switchTo().alert().getText();
    }

    public String getCurrentURL() {
        return getDriver().getCurrentUrl();
    }

}


