package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Ajax_PO;

public class Ajax_Steps {

    Ajax_PO ajax_po;

    public Ajax_Steps(Ajax_PO ajax_po) {
        this.ajax_po = ajax_po;
    }

    @Given("I land on Ajax page")
    public void i_land_on_ajax_page() {
        ajax_po.navigaTo_AjaxPage();
    }

    @When("I wait and click on the CLICK ME button")
    public void i_wait_and_click_on_the_click_me_button() {
        ajax_po.clickOn_ClickMeButton();
    }

    @Then("Well Done For Waiting modal appears")
    public void well_done_for_waiting_modal_appears() {
        ajax_po.verifyThatModalIsDisplayed();
    }
}
