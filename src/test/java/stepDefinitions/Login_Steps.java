package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Login_PO;

public class Login_Steps extends Base_PO {
    private Login_PO login_po;

    public Login_Steps(Login_PO login_po) {
        this.login_po = login_po;
    }

    @Given("I land on the WebDriver University Login page")
    public void i_land_on_the_web_driver_university_login_page() {
        login_po.navigateToLoginPage();
    }

    @When("I enter username {word}")
    public void i_enter_username(String username) {
        login_po.enterUsername(username);
    }

    @And("I enter password {word}")
    public void i_enter_password(String password) {
        login_po.enterPassword(password);
    }

    @And("I click on Submit button")
    public void i_click_on_submit_button() {
        login_po.clickOnLoginButton();
    }

    @Then("I get valid login message")
    public void i_get_valid_login_message() {
        String actualMessage = switchToAlertAndGetText();
        Assert.assertEquals(actualMessage, "validation succeeded");
    }

    @Then("I get invalid login message")
    public void i_get_invalid_login_message() {
        String actualMessage = switchToAlertAndGetText();
        Assert.assertEquals(actualMessage, "validation failed");
    }

    @Then("I get login message {string}")
    public void i_get_login_message(String message) {
        String actualMessage = switchToAlertAndGetText();
        Assert.assertEquals(actualMessage, message);
    }

}