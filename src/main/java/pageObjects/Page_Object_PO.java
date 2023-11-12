package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class Page_Object_PO extends Base_PO {

    public Page_Object_PO() {
        super();
    }

    @FindBy (xpath = "//ul[@class='nav navbar-nav']/li/a")
    private List<WebElement> promoLinks;

    @FindBy (xpath = "//a[@class='left carousel-control']")
    private WebElement leftBannerArrow;

    @FindBy (xpath = "//a[@class='right carousel-control']")
    private WebElement rightBannerArrow;

    @FindBy (css = ".carousel-inner div")
    private List<WebElement> banners;

    @FindBy (id = "button-find-out-more")
    private WebElement findOutMore_button;

    @FindBy (css = "div.modal-content")
    private WebElement findOutMore_modal;

    public void navigateTo_PageObjectPage() {
        navigateTo_URL("https://webdriveruniversity.com/Page-Object-Model/index.html");
    }

    public void clickOnPromoLink(String name) {
        for(WebElement promoLink : promoLinks) {
            if(promoLink.getText().equals(name)) {
                promoLink.click();
                break;
            }
        }
    }

    public void clickOnRightBannerArrow() {
        waitForElementAndClick(rightBannerArrow);
    }

    public void clickOnLeftBannerArrow() {
        waitForElementAndClick(leftBannerArrow);
    }

    public void verifyThatNextBannerIsShown() {
        Assert.assertTrue(banners.get(1).isDisplayed());
    }

    public void verifyThatPreviousBannerIsShown() {
        Assert.assertTrue(banners.get(banners.size()-1).isDisplayed());
    }

    public void clickOnFindOutMoreButton() {
        waitForElementAndClick(findOutMore_button);
    }

    public void verifyThatFindOutMoreModalAppears() {
        waitForElement(findOutMore_modal);
        Assert.assertTrue(findOutMore_modal.isDisplayed());
    }

}
