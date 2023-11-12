package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.GlobalVars;

public class Login_PO extends Base_PO {

    public Login_PO() {
        super();
    }

    @FindBy(id = "text")
    private WebElement username_Field;
    @FindBy(id = "password")
    private WebElement password_Field;
    @FindBy(id = "login-button")
    private WebElement login_Button;

    public void navigateToLoginPage() {
        navigateTo_URL(GlobalVars.WEBDRIVER_UNIVERSITY_BASE_URL + "/Login-Portal/index.html?");
    }

    public void enterUsername(String username) {
        waitForElementAndSendKeys(username_Field, username);
    }

    public void enterPassword(String password) {
        waitForElementAndSendKeys(password_Field, password);
    }

    public void clickOnLoginButton() {
        waitForElementAndClick(login_Button);
    }

}
