package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.Actions_PO;

public class Actions_Steps {
    Actions_PO actions_po;

    public Actions_Steps(Actions_PO actions_po) {
        this.actions_po = actions_po;
    }

    @Given("I land on Actions page")
    public void i_land_on_actions_page() {
        actions_po.navigateToActionPAge();
    }

    @When("I drag and drop first box to the second box")
    public void i_drag_and_drop_first_box_to_the_second_box() {
        actions_po.dragAndDropAction();
    }

    @Then("I get message from the second box with text {word}")
    public void i_get_message_from_the_second_box_with_text_dropped(String message) {
        Assert.assertEquals(message, actions_po.getTextFromDroppableBox());
    }
    String initialColor;
    String finalColor;
    @When("I double click on Double Click Me! button")
    public void i_double_click_on_double_click_me_button() {
        initialColor = actions_po.getDoubleClickMeButtonColor();
        actions_po.doubleClickOn_doubleClickMeButton();
        finalColor = actions_po.getDoubleClickMeButtonColor();
    }

    @Then("The button changes the color")
    public void the_button_changes_the_color() {
        Assert.assertNotEquals(initialColor,finalColor);
    }

    @When("I click and hold on Click and Hold! button")
    public void i_click_and_hold_on_click_and_hold_button() {
        actions_po.clickAndHoldOn_clickAndHoldButton();
    }


    @And("I release button click")
    public void i_release_button_click() {
        actions_po.release_clickAndHoldButton();
    }

    @Then("I get message from the button with text {string}")
    public void i_get_message_from_the_button_with_text(String message) {
        String actualMessage = actions_po.getTextFromClickAndHoldButton();
        Assert.assertEquals(message, actualMessage);
    }

}
