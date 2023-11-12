package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Ajax_PO extends Base_PO {

    public Ajax_PO() {
        super();
    }

    @FindBy (id = "button1")
    private WebElement clickMe_button;

    @FindBy (css = "div.modal-content")
    private WebElement wellDoneForWaiting_modal;

    public void navigaTo_AjaxPage() {
        navigateTo_URL("https://webdriveruniversity.com/Ajax-Loader/index.html");
    }

    public void clickOn_ClickMeButton() {
        waitForElementAndClick(clickMe_button);
    }

    public void verifyThatModalIsDisplayed() {
        waitForElement(wellDoneForWaiting_modal);
        Assert.assertTrue(wellDoneForWaiting_modal.isDisplayed());
    }

}
