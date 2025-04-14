package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import stepdefinition.Hooks;
import uistore.ChainLocators;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshots;
import utils.WebDriverHelper;

public class ChainAction {

    public ExtentTest test;
    WebDriverHelper helper;

    public ChainAction() {
        helper = new WebDriverHelper(Base.driver);
    }

    /**
     * Description: Verifies if the Reliance Jewels logo is displayed on the webpage.
     * Compares the logo's title attribute with the expected title from an Excel sheet.
     */
    public void VerifyLogo() {
        LoggerHandler.info("Verifying Reliance Jewels logo is displayed.");
        Hooks.test.log(Status.INFO, "Verifying Reliance Jewels logo is displayed.");

        String expectedtitle = ExcelReader.readCellValue("Diamond and Chain", "1", "data");
        helper.verifyEquals(Base.driver.findElement(ChainLocators.logo).getAttribute("title"),
                expectedtitle, "Verified logo");
    }

    /**
     * Description: Performs a hover action on the "Chain" element on the webpage.
     */
    public void hoverOnChain() {
        LoggerHandler.info("Hovering on Chain.");
        Hooks.test.log(Status.INFO, "Hovering on Chain.");
        helper.hoverOnElement(ChainLocators.ChainHover);
    }

    /**
     * Description: Waits until the "Silver" element is visible and then clicks on it.
     */
    public void clickOnSilver() {
        LoggerHandler.info("Clicking on Silver.");
        Hooks.test.log(Status.INFO, "Clicking on Silver.");
        helper.waitUntilElementIsVisible(ChainLocators.SilverClick, Integer.parseInt(Base.prop.getProperty("ewait")));
        helper.clickElement(ChainLocators.SilverClick);
    }

    /**
     * Description: Verifies if the keyword "Categories" is present on the webpage.
     * Compares it with the expected value from an Excel sheet.
     */
    public void verifyCategoriesKeyword() {
        LoggerHandler.info("Verifying the keyword 'Categories'.");
        Hooks.test.log(Status.INFO, "Verifying the keyword 'Categories'.");
        String CategoriesVerify = ExcelReader.readCellValue("Diamond and Chain", "2", "data");
        boolean condition = Base.driver.findElement(ChainLocators.CategoriesVerify).getText()
                .contains(CategoriesVerify);
        helper.verifyTrue(condition, "Keyword 'Categories' is verified.");
    }

    /**
     * Description: Clicks on the "Gender" filter and selects "Women" under the Gender filter.
     */
    public void selectGender() {
        LoggerHandler.info("Clicking on Gender filter.");
        Hooks.test.log(Status.INFO, "Clicking on Gender filter.");
        helper.clickElement(ChainLocators.Gender);
        LoggerHandler.info("Selecting Women under Gender filter.");
        Hooks.test.log(Status.INFO, "Selecting Women under Gender filter.");
        helper.clickElement(ChainLocators.women);
    }

    /**
     * Description: Clicks on the "More Filters" option on the webpage.
     */
    public void clickOnMoreFilters() {
        LoggerHandler.info("Clicking on More Filters.");
        Hooks.test.log(Status.INFO, "Clicking on More Filters.");
        helper.clickElement(ChainLocators.moreFilters);
    }

    /**
     * Description: Clicks on the "Try on Available" option on the webpage.
     */
    public void clickOnTryOnAvailable() {
        LoggerHandler.info("Clicking on Try on Available.");
        Hooks.test.log(Status.INFO, "Clicking on Try on Available.");
        helper.clickElement(ChainLocators.tryOnAvailable);
    }

    /**
     * Description: Clicks on the "Yes" button on the webpage.
     */
    public void clickOnYes() {
        LoggerHandler.info("Clicking on Yes.");
        Hooks.test.log(Status.INFO, "Clicking on Yes.");
        helper.clickElement(ChainLocators.yesButton);
    }

    /**
     * Description: Clicks on the first product listed on the webpage.
     */
    public void selectFirstProduct() {
        LoggerHandler.info("Clicking on the first product.");
        Hooks.test.log(Status.INFO, "Clicking on the first product.");
        helper.clickElement(ChainLocators.firstProductClick);
    }

    /**
     * Description: Selects a size for the product and clicks on the "Buy Now" button.
     */
    public void clickOnBuyNow() {
        LoggerHandler.info("Clicking on Buy Now.");
        Hooks.test.log(Status.INFO, "Clicking on Buy Now.");
        WebElement element = Base.driver.findElement(By.id("item-size"));
        Select select = new Select(element);
        select.selectByValue("46cm");
    }

    /**
     * Description: Verifies if the keyword "Product Code" is present on the webpage.
     * Compares it with the expected value from an Excel sheet and records logs.
     */
    public void verifyProductCodeAndRecordLogs() {
        LoggerHandler.info("Verifying the keyword 'Product Code' and recording logs.");
        Hooks.test.log(Status.INFO, "Verifying the keyword 'Product Code' and recording logs.");
        String Productcodeverify = ExcelReader.readCellValue("Diamond and Chain", "4", "data");
        boolean condition = Base.driver.findElement(ChainLocators.productCodeVerify).getText()
                .contains(Productcodeverify);
        helper.verifyTrue(condition, "Verified Product Code");
    }

    /**
     * Description: Selects a weight for the product and clicks on the "Buy Now" button.
     */
    public void clickonBuynowafterweight() {
        WebElement element = Base.driver.findElement(By.id("item-weight"));
        Select select = new Select(element);
        select.selectByValue("1570767");
        helper.clickElement(ChainLocators.buyNow);
    }

    /**
     * Description: Takes a screenshot of the product page and adds it to the report.
     * If it fails, logs an error message.
     */
    public void takeScreenshot() {
        try {
            LoggerHandler.info("Taking a screenshot of the product page.");
            Hooks.test.log(Status.INFO, "Taking a screenshot of the product page.");
            Screenshots.takePageScreenShot("Product Silver Chain screenshot");
            Reporter.addScreenshotToReport("Buy Now clicked ", Hooks.test, "Buy now clicked ");
        } catch (Exception e) {
            LoggerHandler.error("Failed to take screenshot: " + e.getMessage());
            Hooks.test.log(Status.FAIL, "Failed to take screenshot: " + e.getMessage());
        }
    }
}
