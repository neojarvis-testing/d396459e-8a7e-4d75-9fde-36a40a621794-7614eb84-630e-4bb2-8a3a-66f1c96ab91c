package pages;

import com.aventstack.extentreports.Status;
import stepdefinition.Hooks;
import uistore.BuyNowPageLocator;
import uistore.HomepageEarringsLocator;
import uistore.DropsPageLocator;
import utils.Base;
import utils.LoggerHandler;
import utils.Screenshots;
import utils.WebDriverHelper;

/**
 * Creator: Akash Deep
 * Description: This class provides actions for interacting with the Homepage Earrings section
 * on the Reliance Jewels website, including verifying the logo, hovering on elements,
 * clicking on filters, and verifying URLs.
 */
public class HomepageEarringsAction {

    WebDriverHelper helper = new WebDriverHelper(Base.driver);

    /**
     * Description: Verifies the title of the Reliance Jewels logo.
     * 
     * @param expectedTitle - The expected title of the logo
     */
    public void verifyLogo(String expectedTitle) {
        Hooks.test.log(Status.INFO, "verifyingLogo test case");
        LoggerHandler.info("verifyingLogo test case");
        String actualTitle = Base.driver.findElement(HomepageEarringsLocator.Logo).getAttribute("title");
        LoggerHandler.info("Retrieved logo title: " + actualTitle);
        helper.verifyEquals(expectedTitle, actualTitle, "Verify logo");
        LoggerHandler.info("Logo title verification completed");
    }

    /**
     * Description: Hovers over the "Earrings" element on the homepage.
     */
    public void hoverOnEarrings() {
        Hooks.test.log(Status.INFO, "Starting hoverOnEarrings test case");
        LoggerHandler.info("Starting hoverOnEarrings test case");
        helper.waitUntilElementIsVisible(HomepageEarringsLocator.earrings, Integer.parseInt(Base.prop.getProperty("ewait")));
        LoggerHandler.info("Earrings element is visible");
        helper.hoverOnElement(HomepageEarringsLocator.earrings);
        LoggerHandler.info("Hovered on earrings");
    }

    /**
     * Description: Clicks on the "Drops" element under the "Earrings" section.
     */
    public void clicksOnDrops() {
        helper.waitUntilElementIsVisible(HomepageEarringsLocator.drops, Integer.parseInt(Base.prop.getProperty("ewait")));
        LoggerHandler.info("Drops element is visible");
        helper.clickElement(HomepageEarringsLocator.drops);
        LoggerHandler.info("Clicked on drops");
        Hooks.test.log(Status.PASS, "Successfully clicked on earrings and drops");
    }

    /**
     * Description: Verifies that the current URL contains the specified value.
     * 
     * @param value - The value to check in the URL
     */
    public void verifiesUrl(String value) {
        Hooks.test.log(Status.INFO, "Starting verifies Url test case");
        LoggerHandler.info("Starting verifies Url test case");
        String currentURL = Base.driver.getCurrentUrl();
        LoggerHandler.info("Current URL: " + currentURL);
        boolean condition = currentURL.contains(value);
        helper.verifyTrue(condition, "check verification");
        LoggerHandler.info("Verified URL contains 'Drops'");
    }

    /**
     * Description: Clicks on the "Categories" element and selects "Gold".
     */
    public void clicksOnCategories() {
        helper.waitUntilElementIsVisible(DropsPageLocator.categories, Integer.parseInt(Base.prop.getProperty("ewait")));
        helper.clickElement(DropsPageLocator.categories);
        LoggerHandler.info("Clicked on categories");
        helper.clickElement(DropsPageLocator.gold);
        LoggerHandler.info("Clicked on gold");
        Hooks.test.log(Status.PASS, "Successfully clicked on categories and gold");
    }

    /**
     * Description: Clicks on the "More Filters" element.
     */
    public void clicksOnMoreFilters() {
        Hooks.test.log(Status.INFO, "Starting clicksOnMoreFilters test case");
        LoggerHandler.info("Starting clicksOnMoreFilters test case");
        helper.clickElement(DropsPageLocator.morefilter);
        LoggerHandler.info("Clicked on more filters");
    }

    /**
     * Description: Clicks on the "Metal Purity" element and selects "22 Kt".
     */
    public void clicksOnMetalPurity() {
        helper.clickElement(DropsPageLocator.metalpurity);
        LoggerHandler.info("Clicked on metal purity");
        helper.waitUntilElementIsVisible(DropsPageLocator.twentytwokt, Integer.parseInt(Base.prop.getProperty("ewait")));
        LoggerHandler.info("22kt element is visible");
        helper.clickElement(DropsPageLocator.twentytwokt);
        LoggerHandler.info("Clicked on 22kt");
        Hooks.test.log(Status.PASS, "Successfully clicked on more filters and 22kt metal purity");
    }

    /**
     * Description: Clicks on the first product in the list.
     */
    public void clicksOnFirstProduct() {
        Hooks.test.log(Status.INFO, "Starting clicksOnProduct test case");
        LoggerHandler.info("Starting clicksOnProduct test case");
        helper.waitUntilElementIsVisible(DropsPageLocator.firstproduct, Integer.parseInt(Base.prop.getProperty("ewait")));
        LoggerHandler.info("First product element is visible");
        helper.clickElement(DropsPageLocator.firstproduct);
        LoggerHandler.info("Clicked on the first product");
        Hooks.test.log(Status.PASS, "Successfully clicked on the first product");
    }

    /**
     * Description: Clicks on the "Buy Now" button for the selected product.
     */
    public void buyNowProduct() {
        Hooks.test.log(Status.INFO, "Starting buyNowProduct test case");
        LoggerHandler.info("Starting buyNowProduct test case");
        helper.waitUntilElementIsVisible(BuyNowPageLocator.buyNow, Integer.parseInt(Base.prop.getProperty("ewait")));
        LoggerHandler.info("Buy Now element is visible");
        helper.clickElement(BuyNowPageLocator.buyNow);
        LoggerHandler.info("Clicked on Buy Now");
    }

    /**
     * Description: Verifies that the product name contains the specified value.
     * 
     * @param value - The value to check in the product name
     */
    public void verifiesFeatures(String value) {
        String keyfeature = Base.driver.findElement(BuyNowPageLocator.productname).getText();
        LoggerHandler.info("Product name: " + keyfeature);
        boolean condition = keyfeature.contains(value);
        helper.verifyTrue(condition, "keyfeature match");
        LoggerHandler.info("Verified product name contains 'Gold'");
        Hooks.test.log(Status.PASS, "Successfully verified product name contains 'Gold'");
        Hooks.test.log(Status.INFO, "Key feature: " + keyfeature);
        LoggerHandler.info("Key Features");
        Screenshots.takePageScreenShot("Buy Now Product");
    }
}