package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Page_Object_PO;

public class Page_Object_Steps extends Base_PO {

    Page_Object_PO page_object_po;

    public Page_Object_Steps(Page_Object_PO page_object_po) {
        this.page_object_po = page_object_po;
    }

    @Given("I land on the WebDriver University Page Object page")
    public void i_land_on_the_web_driver_university_page_object_page() {
        page_object_po.navigateTo_PageObjectPage();
    }

    @When("I click on promo link {string}")
    public void i_click_on_promo_link(String string) {
        page_object_po.clickOnPromoLink(string);
    }

    @Then("I am redirected to the url {string}")
    public void i_am_redirected_to_the_url(String url) {
        Assert.assertEquals(getCurrentURL(), url);
    }

    @When("I click on right banner arrow")
    public void i_click_on_right_banner_arrow() {
        page_object_po.clickOnRightBannerArrow();
    }

    @Then("Next banner is shown")
    public void next_banner_is_shwn() {
        page_object_po.verifyThatNextBannerIsShown();
    }

    @When("I click on left banner arrow")
    public void i_click_on_left_banner_arrow() {
        page_object_po.clickOnLeftBannerArrow();
    }

    @Then("Previous banner is shown")
    public void previous_banner_is_shown() {
        page_object_po.verifyThatPreviousBannerIsShown();
    }

    @When("I click on Find Out More button")
    public void i_click_on_find_out_more_button() {
        page_object_po.clickOnFindOutMoreButton();
    }

    @Then("Find Out More modal is shown")
    public void find_out_more_modal_is_shown() {
        page_object_po.verifyThatFindOutMoreModalAppears();
    }

}
