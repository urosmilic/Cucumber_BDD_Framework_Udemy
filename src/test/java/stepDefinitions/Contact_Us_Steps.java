package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Contact_Us_PO;

public class Contact_Us_Steps extends Base_PO {
    Contact_Us_PO contact_us_po;

    public Contact_Us_Steps(Contact_Us_PO contact_us_po) {
        this.contact_us_po = contact_us_po;
    }

    @Given("I land on the WebDriver University Contact Us page")
    public void i_land_on_the_web_driver_university_contact_us_page() {
        contact_us_po.navigateToContactUsPage();
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        contact_us_po.enterFirstname("FirstName" + generateRandomNumber(5));
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        contact_us_po.enterLastname("LastName" + generateRandomNumber(5));
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        contact_us_po.enterEmail("email" + generateRandomNumber(5) + "@gmail.com");
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        contact_us_po.enterComment("Comment" + generateRandomString(10));
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        contact_us_po.enterFirstname(firstName);
    }

    @And("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        contact_us_po.enterLastname(lastName);
    }

    @And("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        contact_us_po.enterEmail(email);
    }

    @And("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        contact_us_po.enterComment(comment);
    }

    @And("I click on submit button")
    public void i_click_on_submit_button() {
        contact_us_po.clickOnSubmitButton();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        Assert.assertEquals(contact_us_po.getCurrentURL(), "https://webdriveruniversity.com/Contact-Us/contact-form-thank-you.html");
        Assert.assertEquals(contact_us_po.getTextofSubmissionMessage(), "Thank You for your Message!");
    }

}
