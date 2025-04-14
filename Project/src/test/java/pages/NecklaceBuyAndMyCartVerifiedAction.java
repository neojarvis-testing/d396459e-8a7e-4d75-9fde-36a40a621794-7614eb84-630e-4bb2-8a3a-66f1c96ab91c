package pages;

import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.NecklaceBuyAndMyCartVerifiedLocator;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshots;
import utils.WebDriverHelper;

/**
 * Creator: Nakul J Gowda
 * Description: This class handles actions related to searching and adding necklaces to the cart.
 * It verifies various functionalities such as homepage navigation, search operations, 
 * necklace details page actions, and cart validation with ExtentReports logging.
 */
public class NecklaceBuyAndMyCartVerifiedAction {

    private String store;
    public ExtentTest test;
    WebDriverHelper helper;

    /**
     * Constructor: Initializes the NecklaceBuyAndMyCartVerifiedAction class with an ExtentTest 
     * instance for reporting and a WebDriverHelper for Selenium actions.
     *
     * @param test - ExtentTest instance for logging test status.
     */
    public NecklaceBuyAndMyCartVerifiedAction(ExtentTest test) {
        this.test = test;
        helper = new WebDriverHelper(Base.driver);
    }

    /**
     * Description: Logs entry into the Home Page and updates the Extent Report.
     */
    public void HomePage() {
        LoggerHandler.info("Inside browser Home Page");
        test.log(Status.INFO, "Inside browser Home Page");
    }

    /**
     * Description: Verifies the logo of Reliance Jewels by comparing the title attribute 
     * with the expected value from the Excel sheet.
     */
    public void VerifyLogoOfRelianceJewels() {
        helper.waitUntilElementIsVisible(NecklaceBuyAndMyCartVerifiedLocator.logo, Integer.parseInt(Base.prop.getProperty("ewait")));
        String title = ExcelReader.readCellValue("Necklace and Add Cart", "1", "value");
        helper.verifyEquals(title, Base.driver.findElement(NecklaceBuyAndMyCartVerifiedLocator.logo).getAttribute("Title"), "Verified Logo");
    }

    /**
     * Description: Clicks on the search bar to activate it and logs the action.
     */
    public void clickOnSearchBar() {
        helper.clickElement(NecklaceBuyAndMyCartVerifiedLocator.search);
        LoggerHandler.info("Clicked on search bar");
        test.log(Status.INFO, "Clicked on search bar");
    }

    /**
     * Description: Inputs the specified search string into the search bar and logs the action.
     *
     * @param string - The search keyword to be entered.
     */
    public void insertValueInSearchOperation(String string) {
        helper.typeIntoElement(NecklaceBuyAndMyCartVerifiedLocator.search, string);
        LoggerHandler.info("Entered text into search bar");
        test.log(Status.INFO, "Entered text into search bar");
    }

    /**
     * Description: Simulates pressing Enter on the search bar to execute the search.
     */
    public void enterActionOnSearchBar() {
        helper.pressEnterKey(NecklaceBuyAndMyCartVerifiedLocator.search);
        LoggerHandler.info("Enter action on search bar");
        test.log(Status.INFO, "Enter action on search bar");
    }

    /**
     * Description: Verifies the Necklace Result Page by comparing the title with the expected value.
     */
    public void NecklaceResultPage() {
        LoggerHandler.info("Necklace Result Page");
        test.log(Status.INFO, "Necklace Result Page");
        String actual = Base.driver.getTitle().toLowerCase();
        String expected = ExcelReader.readCellValue("Necklace and Add Cart", "2", "value").toLowerCase();
        helper.verifyTrue(actual.contains(expected), "Necklace Result page verified");
    }

    /**
     * Description: Performs a hover action on a product element and logs the action.
     */
    public void hoverOverProduct() {
        helper.hoverOnElement(NecklaceBuyAndMyCartVerifiedLocator.hover);
        LoggerHandler.info("Hover over the element");
        test.log(Status.INFO, "Hover over the element");
    }

    /**
     * Description: Clicks on the quick view pop-up and logs the action.
     */
    public void clickOnPopUpActions() {
        helper.clickElement(NecklaceBuyAndMyCartVerifiedLocator.quickView);
        LoggerHandler.info("View Quick start");
        test.log(Status.INFO, "View Quick start");
    }

    /**
     * Description: Closes the quick view pop-up and logs the action.
     */
    public void closePopUp() {
        helper.clickElement(NecklaceBuyAndMyCartVerifiedLocator.close);
        LoggerHandler.info("Closed pop-up");
        test.log(Status.INFO, "Closed pop-up");
    }

    /**
     * Description: Clicks on the first product from the result and stores the product name 
     * for verification purposes.
     */
    public void clickTheFirstProduct() {
        String first = helper.retrieveElementText(NecklaceBuyAndMyCartVerifiedLocator.firstProduct);
        store = first;
        helper.clickElement(NecklaceBuyAndMyCartVerifiedLocator.firstProduct);
        LoggerHandler.info("click on the first product");
        test.log(Status.INFO, "click on the first product");
    }

    /**
     * Description: Verifies that the page of the first product matches the stored product name.
     */
    public void VerifyTheFirstProduct() {
        String first = store;
        helper.verifyTrue(Base.driver.getTitle().contains(first), "Verified the redirected to first product page");
        test.log(Status.PASS, "Verified the redirected to first product page");
    }

    /**
     * Description: Selects a weight option from the product dropdown and logs the action.
     */
    public void FirstNecklaceDetailsPage() {
        helper.waitUntilElementIsVisible(NecklaceBuyAndMyCartVerifiedLocator.dropdown, Integer.parseInt(Base.prop.getProperty("ewait")));
        Select objSelect = new Select(Base.driver.findElement(NecklaceBuyAndMyCartVerifiedLocator.dropdown));
        objSelect.selectByIndex(1);
        LoggerHandler.info("First product weight selected");
        test.log(Status.INFO, "First product weight selected");
    }

    /**
     * Description: Clicks on the "Buy Now" button and logs the action.
     */
    public void clickOnBuyNow() {
        helper.clickElement(NecklaceBuyAndMyCartVerifiedLocator.buyNow);
        LoggerHandler.info("Click on Buy Now");
        test.log(Status.INFO, "Click on Buy Now");
    }

    /**
     * Description: Verifies the My Cart page by comparing cart details with expected values.
     */
    public void verifyMyCart() {
        helper.verifyEquals(helper.retrieveElementText(NecklaceBuyAndMyCartVerifiedLocator.Cart), ExcelReader.readCellValue("Necklace and Add Cart", "3", "value"), "Verified My Cart");
    }

    /**
     * Description: Captures a screenshot of the My Cart page and adds it to the Extent Report.
     */
    public void screenShotMyCart() {
        Screenshots.takePageScreenShot("My Cart");
        Reporter.addScreenshotToReport("My Cart", test, "Verified My Cart");
        LoggerHandler.info("Exit browser");
        test.log(Status.INFO, "Exit browser");
    }
}