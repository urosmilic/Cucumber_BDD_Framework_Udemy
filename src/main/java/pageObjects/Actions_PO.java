package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GlobalVars;

public class Actions_PO extends Base_PO {

    public Actions_PO() {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(css = "div#draggable")
    private WebElement drag_box;
    @FindBy(css = "div#droppable")
    private WebElement drop_box;
    @FindBy(css = "div#double-click")
    private WebElement doubleCLickMe_button;
    @FindBy(xpath = "//button[text() = 'Hover Over Me First!']")
    private WebElement hoverOverMeFirst_button;
    @FindBy(xpath = "//button[text() = 'Hover Over Me Second!']")
    private WebElement hoverOverMeSecond_button;
    @FindBy(xpath = "//button[text() = 'Hover Over Me Third!']")
    private WebElement hoverOverMeThird_button;
    @FindBy(css = "div#click-box")
    private WebElement clickAndHold_button;

    Actions actions = new Actions(getDriver());

    public void navigateToActionPAge() {
        navigateTo_URL(GlobalVars.WEBDRIVER_UNIVERSITY_BASE_URL + "/Actions/index.html");
    }

    public void dragAndDropAction() {
        waitForElement(drag_box);
        actions.dragAndDrop(drag_box, drop_box).build().perform();
    }

    public String getTextFromDroppableBox() {
        return drop_box.getText();
    }

    public void doubleClickOn_doubleClickMeButton() {
        waitForElement(doubleCLickMe_button);
        actions.doubleClick(doubleCLickMe_button).build().perform();
    }

    public String getDoubleClickMeButtonColor() {
        return doubleCLickMe_button.getCssValue("background-color");
    }

    public void clickAndHoldOn_clickAndHoldButton() {
        waitForElement(clickAndHold_button);
        actions.clickAndHold(clickAndHold_button).build().perform();
    }

    public String getTextFromClickAndHoldButton() {
        return clickAndHold_button.getText();
    }

    public void release_clickAndHoldButton() {
        actions.release(clickAndHold_button).build().perform();
    }

}
