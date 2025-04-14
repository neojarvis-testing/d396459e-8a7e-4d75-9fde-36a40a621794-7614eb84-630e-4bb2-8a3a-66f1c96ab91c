package pages;

import java.time.Duration;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import stepdefinition.Hooks;
import uistore.DiamondLocators;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshots;
import utils.WebDriverHelper;

public class DiamondAction {

    public ExtentTest test;
    WebDriverHelper helper;

    public DiamondAction() {
        helper = new WebDriverHelper(Base.driver);
    }

    /**
     * Description: Verifies if the Reliance Jewels logo is displayed on the webpage.
     * Compares the logo's title attribute with the expected title from an Excel sheet.
     * 
     * @return void
     */
    public void VerifyLogo() {
        LoggerHandler.info("Verifying Reliance Jewels logo is displayed.");
        Hooks.test.log(Status.INFO, "Verifying Reliance Jewels logo is displayed.");
        String expectedtitle = ExcelReader.readCellValue("Diamond and Chain", "1", "data");
        helper.verifyEquals(Base.driver.findElement(DiamondLocators.logo).getAttribute("title"), expectedtitle, "Verified logo");
    }

    /**
     * Description: Performs a hover action on the "Earrings" element on the webpage.
     * Waits until the element is visible before performing the hover action.
     * 
     * @return void
     */
    public void hoverOnEarrings() {
        LoggerHandler.info("Hovering on Earrings.");
        Hooks.test.log(Status.INFO, "Hovering on Earrings.");
        helper.waitUntilElementIsVisible(DiamondLocators.EarringHover, Integer.parseInt(Base.prop.getProperty("ewait")));
        helper.hoverOnElement(DiamondLocators.EarringHover);
    }

    /**
     * Description: Waits until the "Diamond" element is visible and then clicks on it.
     * 
     * @return void
     */
    public void clickOnDiamond() {
        LoggerHandler.info("Clicking on Diamond.");
        Hooks.test.log(Status.INFO, "Clicking on Diamond.");
        helper.waitUntilElementIsVisible(DiamondLocators.DiamondClick, Integer.parseInt(Base.prop.getProperty("ewait")));
        helper.clickElement(DiamondLocators.DiamondClick);
    }

    /**
     * Description: Verifies if the keyword "Diamond" is present on the webpage.
     * Compares it with the expected value from an Excel sheet.
     * 
     * @return void
     */
    public void verifyDiamondKeyword() {
        LoggerHandler.info("Verifying the keyword 'Diamond'.");
        Hooks.test.log(Status.INFO, "Verifying the keyword 'Diamond'.");
        String DiamondVerify = ExcelReader.readCellValue("Diamond and Chain", "3", "data");
        helper.verifyTrue(Base.driver.findElement(DiamondLocators.DiamondVerify).getText().contains(DiamondVerify), "diamond keyword verify");
    }

    /**
     * Description: Clicks on the "Gender" filter and selects "Women" under the Gender filter.
     * Waits until the "Women" element is visible before clicking on it.
     * 
     * @return void
     */
    public void selectGender() {
        LoggerHandler.info("Clicking on Gender filter.");
        Hooks.test.log(Status.INFO, "Clicking on Gender filter.");
        helper.clickElement(DiamondLocators.Gender);
        LoggerHandler.info("Selecting Women under Gender filter.");
        Hooks.test.log(Status.INFO, "Selecting Women under Gender filter.");
        helper.waitUntilElementIsVisible(DiamondLocators.women, Integer.parseInt(Base.prop.getProperty("ewait")));
        helper.clickElement(DiamondLocators.women);
    }

    /**
     * Description: Hovers on the "Popularity" filter and then clicks on "New Arrivals".
     * 
     * @return void
     */
    public void sortByNewArrivals() {
        LoggerHandler.info("Hovering on Popularity.");
        Hooks.test.log(Status.INFO, "Hovering on Popularity.");
        helper.hoverOnElement(DiamondLocators.popularity);
        LoggerHandler.info("Clicking on New Arrivals.");
        Hooks.test.log(Status.INFO, "Clicking on New Arrivals.");
        helper.hoverOnElement(DiamondLocators.newArrivals);
        helper.clickElement(DiamondLocators.newArrivals);
    }

    /**
     * Description: Clicks on the first product listed on the webpage.
     * 
     * @return void
     */
    public void selectFirstProduct() {
        LoggerHandler.info("Clicking on the first product.");
        Hooks.test.log(Status.INFO, "Clicking on the first product.");
        helper.clickElement(DiamondLocators.firstproductclick);
    }

    /**
     * Description: Clicks on the "Add to Cart" button for the selected product.
     * 
     * @return void
     */
    public void addToCart() {
        LoggerHandler.info("Clicking on Add to Cart.");
        Hooks.test.log(Status.INFO, "Clicking on Add to Cart.");
        helper.clickElement(DiamondLocators.addtocart);
    }

    /**
     * Description: Takes a screenshot of the product page and adds it to the report.
     * 
     * @return void
     */
    public void takeScreenshot() {
        LoggerHandler.info("Taking a screenshot of the product page.");
        Hooks.test.log(Status.INFO, "Taking a screenshot of the product page.");
        Screenshots.takePageScreenShot("Product Diamond screenshot");
        Reporter.addScreenshotToReport("productadded", test, "Product added to the cart");
    }
}
