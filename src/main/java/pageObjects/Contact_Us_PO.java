package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.GlobalVars;

public class Contact_Us_PO extends Base_PO {

    public Contact_Us_PO() {
        super();
    }

    @FindBy(xpath = "//input[@name=\"first_name\"]")
    private WebElement firstname_Field;
    @FindBy(xpath = "//input[@name=\"last_name\"]")
    private WebElement lastname_Field;
    @FindBy(xpath = "//input[@name=\"email\"]")
    private WebElement email_Field;
    @FindBy(xpath = "//textarea[@name=\"message\"]")
    private WebElement comment_Field;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submit_Button;

    @FindBy(xpath = "//div[@id='contact_reply']/h1")
    private WebElement submissionMessage;

    public void navigateToContactUsPage() {
        navigateTo_URL(GlobalVars.WEBDRIVER_UNIVERSITY_BASE_URL + "/Contact-Us/contactus.html");
    }

    public void enterFirstname(String firstname) {
        waitForElementAndSendKeys(firstname_Field, firstname);
    }

    public void enterLastname(String lastname) {
        waitForElementAndSendKeys(lastname_Field, lastname);
    }

    public void enterEmail(String email) {
        waitForElementAndSendKeys(email_Field, email);
    }

    public void enterComment(String comment) {
        waitForElementAndSendKeys(comment_Field, comment);
    }

    public void clickOnSubmitButton() {
        waitForElementAndClick(submit_Button);
    }

    public String getTextofSubmissionMessage() {
        return waitForElementAndGetText(submissionMessage);
    }

}
