package pages;

import org.openqa.selenium.By;

import stepdefinition.Hooks;
import uistore.HomePageLocatorsRingsAndPendent;
import uistore.PendentsPageLocators;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.WebDriverHelper;

public class BuyPendentsAction {

    WebDriverHelper helper = new WebDriverHelper(Base.driver);

    
    /**
     * Creator: Gautam Rawat
     * Description: This method hovers over the pendents section and verifies the URL.
     */
    public void hoverOverPendents() {
        try {
            helper.hoverOnElement(HomePageLocatorsRingsAndPendent.pendent);
            LoggerHandler.info("hover on " + helper.retrieveElementText(HomePageLocatorsRingsAndPendent.pendent).toLowerCase());

            helper.clickElement(HomePageLocatorsRingsAndPendent.gift);
            LoggerHandler.info("Clicked on: " + helper.retrieveElementText(HomePageLocatorsRingsAndPendent.gift));

            String data = ExcelReader.readCellValue("RingsAndPendant", "4", "Items");
            String url = Base.driver.getCurrentUrl();
            String keyword = data.toLowerCase();
            String description = ExcelReader.readCellValue("RingsAndPendant", "4", "Description");
            boolean condition = url.contains(keyword);
            helper.verifyTrue(condition, description);

        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Creator: Gautam Rawat
     * Description: This method applies the gender filter and verifies the page title.
     */
    public void genderFilter() {
        try {
            LoggerHandler.info("Clicked on Gender filter: " + helper.retrieveElementText(PendentsPageLocators.Gender));
            helper.clickElement(PendentsPageLocators.Gender);

            helper.waitUntilElementIsVisible(PendentsPageLocators.kids, 10);
            LoggerHandler.info("Selected Kids filter: " + helper.retrieveElementText(PendentsPageLocators.kids));
            helper.clickElement(PendentsPageLocators.kids);

            String title = Base.driver.getTitle();
            String actual = ExcelReader.readCellValue("RingsAndPendant", "5", "Actual");
            String description = ExcelReader.readCellValue("RingsAndPendant", "5", "Description");
            helper.verifyEquals(title, actual, description);

        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Creator: Gautam Rawat
     * Description: This method applies the 'More' filter and selects a specific type.
     */
    public void moreFilter() {
        try {
            helper.clickElement(PendentsPageLocators.moreFilter);
            LoggerHandler.info("Clicked on More filter: " + helper.retrieveElementText(PendentsPageLocators.moreFilter));

            helper.clickElement(PendentsPageLocators.type);
            LoggerHandler.info("Selected Type filter: " + helper.retrieveElementText(PendentsPageLocators.type));
            helper.waitUntilElementIsVisible(PendentsPageLocators.pendentInsideType, 10);
            LoggerHandler.info("Selected Pendent inside Type: " + helper.retrieveElementText(PendentsPageLocators.pendentInsideType));
            helper.clickElement(PendentsPageLocators.pendentInsideType);

        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Creator: Gautam Rawat
     * Description: This method clicks on the first product and verifies the page title.
     */
    public void firstProductClick() {
        try {
            String title = Base.driver.getTitle();
            String actual = ExcelReader.readCellValue("RingsAndPendant", "6", "Actual");
            String description = ExcelReader.readCellValue("RingsAndPendant", "6", "Description");
            helper.verifyEquals(title, actual, description);

            LoggerHandler.info("Clicked on first product: " + helper.retrieveElementText(PendentsPageLocators.firstProductOnPendent));
            helper.clickElement(PendentsPageLocators.firstProductOnPendent);

        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Creator: Gautam Rawat
     * Description: This method adds the selected product to the cart.
     */
    public void addToCart() {
        try {
            LoggerHandler.info("Clicked on Add to Cart: " + helper.retrieveElementText(PendentsPageLocators.AddtoCart));
            helper.clickElement(PendentsPageLocators.AddtoCart);

            Reporter.addScreenshotToReport("reliancejewels", Hooks.test,"reliancejewels");
            LoggerHandler.info("Screenshot added to report");

        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Creator: Gautam Rawat
     * Description: This method proceeds to the payment page.
     */
    public void proceetToPay() {
        try {
            String keyword = ExcelReader.readCellValue("RingsAndPendant", "7", "actual");
            String expected = helper.retrieveElementText(PendentsPageLocators.tableHeadingPrice);
            String description = ExcelReader.readCellValue("RingsAndPendant", "7", "Description");
            boolean condition = expected.contains(keyword);
            helper.verifyTrue(condition, description);
            LoggerHandler.info("Clicked on " + helper.retrieveElementText(PendentsPageLocators.proceedToPay));
            helper.clickElement(PendentsPageLocators.proceedToPay);
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            e.printStackTrace();
        }
    }

    
}
