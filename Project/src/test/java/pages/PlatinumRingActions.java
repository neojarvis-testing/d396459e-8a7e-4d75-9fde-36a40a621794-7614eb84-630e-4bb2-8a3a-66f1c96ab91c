package pages;

import com.aventstack.extentreports.Status;

import stepdefinition.Hooks;
import uistore.PlatinumRingLocators;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Screenshots;
import utils.Screenshots;
import utils.WebDriverHelper;

/**
 * This class contains actions related to the Platinum Ring page.
 * Creator: Sahla Ambrein
 */
public class PlatinumRingActions {

    WebDriverHelper helper = new WebDriverHelper(Base.driver);

    /**
     * Hovers over the Rings section in the navigation bar.
     * 
     * @return void
     * Creator: Sahla Ambrein
     */
    public void hoverOnRings() {
        try {
            helper.hoverOnElement(PlatinumRingLocators.hoverRings);
            String data = ExcelReader.readCellValue("Platinum Ring details", "1", "title");
            LoggerHandler.info(data);

            String data1 = ExcelReader.readCellValue("Platinum Ring details", "1", "actual");

            LoggerHandler.info("Clicked on " + helper.retrieveElementText(PlatinumRingLocators.hoverRings));
            Hooks.test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(PlatinumRingLocators.hoverRings));
        } catch (Exception e) {
            LoggerHandler.error("Error in hoverOnRings: " + e.getMessage());
        }
    }

    /**
     * Clicks on the Casual Wear option under the Gender category.
     * 
     * @return void
     * Creator: Sahla Ambrein
     */
    public void clickCasualWear() {
        try {
            LoggerHandler.info("Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickCasualWear));
            Hooks.test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickCasualWear));

            helper.clickElement(PlatinumRingLocators.clickCasualWear);

            String currentUrl = Base.driver.getCurrentUrl();
            String actualUrl = ExcelReader.readCellValue("Platinum Ring details", "5", "actual");

            boolean condition = currentUrl.contains(actualUrl);
            helper.verifyTrue(condition, "current Url");

        } catch (Exception e) {
            LoggerHandler.error("Error in clickCasualWear: " + e.getMessage());
        }
    }

    /**
     * Selects the Categories section.
     * 
     * @return void
     * Creator: Sahla Ambrein
     */
    public void selectCategory() {
        try {
            LoggerHandler.info("Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickCategory));
            Hooks.test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickCategory));

            helper.clickElement(PlatinumRingLocators.clickCategory);
            helper.waitUntilElementIsVisible(PlatinumRingLocators.clickCategory,
                    Integer.parseInt(Base.prop.getProperty("ewait")));

        } catch (Exception e) {
            LoggerHandler.error("Error in selectCategory: " + e.getMessage());
        }
    }

    /**
     * Selects the Platinum category.
     * 
     * @return void
     * Creator: Sahla Ambrein
     */
    public void selectPlatinum() {
        try {
            helper.waitUntilElementIsVisible(PlatinumRingLocators.clickCategory,
                    Integer.parseInt(Base.prop.getProperty("ewait")));
            LoggerHandler.info("Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickPlatinum));
            Hooks.test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickPlatinum));
            helper.clickElement(PlatinumRingLocators.clickPlatinum);

            Thread.sleep(3000);

            String platinum = Base.driver.findElement(PlatinumRingLocators.verifyPlatinum).getText();
            String actualPlatinum = ExcelReader.readCellValue("Platinum Ring details", "2", "actual");
            boolean condition = platinum.contains(actualPlatinum);
            helper.verifyTrue(condition, "platinum products");
        } catch (Exception e) {
            LoggerHandler.error("Error in selectPlatinum: " + e.getMessage());
        }
    }

    /**
     * Chooses the More Filters option.
     * 
     * @return void
     * Creator: Sahla Ambrein
     */
    public void chooseFilter() {
        try {
            LoggerHandler.info("Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickMorefilters));
            Hooks.test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickMorefilters));
            helper.clickElement(PlatinumRingLocators.clickMorefilters);

        } catch (Exception e) {
            LoggerHandler.error("Error in chooseFilter: " + e.getMessage());
        }
    }

    /**
     * Selects the Try On Available filter.
     * 
     * @return void
     * Creator: Sahla Ambrein
     */
    public void selectTryOnFilter() {
        try {
            LoggerHandler.info("Clicked on" + helper.retrieveElementText(PlatinumRingLocators.clickTryOn));
            Hooks.test.log(Status.INFO, "Clicked on" + helper.retrieveElementText(PlatinumRingLocators.clickTryOn));
            helper.clickElement(PlatinumRingLocators.clickTryOn);

        } catch (Exception e) {
            LoggerHandler.error("Error in selectTryOnFilter: " + e.getMessage());
        }
    }

    /**
     * Selects Yes for the Try On Available option.
     * 
     * @return void
     * Creator: Sahla Ambrein
     */
    public void selectYes() {
        try {
            LoggerHandler.info("Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickYes));
            Hooks.test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickYes));
            helper.clickElement(PlatinumRingLocators.clickYes);

            String tryOn = Base.driver.findElement(PlatinumRingLocators.verifyTryOn).getText();
            String actualYes = ExcelReader.readCellValue("Platinum Ring details", "3", "actual");
            boolean condition = tryOn.contains(actualYes);
            helper.verifyTrue(condition, "Try on available");
        } catch (Exception e) {
            LoggerHandler.error("Error in selectYes: " + e.getMessage());
        }
    }

    /**
     * Selects the first product from the list.
     * 
     * @return void
     * Creator: Sahla Ambrein
     */
    public void selectFirstProduct() {
        try {
            helper.clickElement(PlatinumRingLocators.clickFirstProduct);
            LoggerHandler.info("Clicked on First Product");
            Hooks.test.log(Status.INFO, "Clicked on First Product");
        } catch (Exception e) {
            LoggerHandler.error("Error in selectFirstProduct: " + e.getMessage());
        }
    }

    /**
     * Clicks on the Buy Now button.
     * 
     * @return void
     * Creator: Sahla Ambrein
     */
    public void clickBuyNow() {
        try {
            LoggerHandler.info("Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickBuyNow));
            Hooks.test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickBuyNow));
            String productCode = Base.driver.findElement(PlatinumRingLocators.verifyProductCode).getText();
            String actualProductCode = ExcelReader.readCellValue("Platinum Ring details", "4", "actual");
            boolean condition = productCode.contains(actualProductCode);
            helper.verifyTrue(condition, "Product code");
            helper.clickElement(PlatinumRingLocators.clickBuyNow);

            Screenshots.takePageScreenShot("Platinum Ring added to cart");

        } catch (Exception e) {
            e.getMessage();
        }
    }
}
