package pages;

import uistore.HomePageLocatorsRingsAndPendent;
import uistore.RingPageLocators;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Screenshots;
import utils.WebDriverHelper;

public class BuyRingsAction {

    WebDriverHelper helper = new WebDriverHelper(Base.driver);

    /**
     * Creator: Gautam Rawat
     * Description: This method clicks on the search bar.
     */
    public void clickOnSerchBar() {
        try {
            helper.clickElement(HomePageLocatorsRingsAndPendent.searchBarLocator);
            LoggerHandler.info("Clicked on search bar");
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Creator: Gautam Rawat
     * Description: This method types the specified item into the search bar.
     */
    public void typeIntoSearchBar(String item) {
        try {
            helper.typeIntoElement(HomePageLocatorsRingsAndPendent.searchBarLocator, item);
            LoggerHandler.info("Typed into search bar: " + item);
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Creator: Gautam Rawat
     * Description: This method presses the Enter key in the search bar.
     */
    public void pressEnterKey() {
        try {
            helper.pressEnterKey(HomePageLocatorsRingsAndPendent.searchBarLocator);
            LoggerHandler.info("Pressed Enter key");
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Creator: Gautam Rawat
     * Description: This method clicks on the gender filter and selects the men's filter.
     */
    public void clickOnGender() {
        try {
            helper.clickElement(RingPageLocators.Gender);
            LoggerHandler.info("Clicked on Gender filter");

            helper.clickElement(RingPageLocators.Mens);
            LoggerHandler.info("Selected Mens filter");

            String title = Base.driver.getTitle();
            String actual = ExcelReader.readCellValue("RingsAndPendant","2","Actual");
            String description=ExcelReader.readCellValue("RingsAndPendant","2","Description");
            helper.verifyEquals(title, actual, description);

        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Creator: Gautam Rawat
     * Description: This method clicks on the metal filter and selects the gold filter.
     */
    public void clickOnMetals() {
        try {
            helper.clickElement(RingPageLocators.Metal);
            LoggerHandler.info("Clicked on Metal filter");

            helper.clickElement(RingPageLocators.Gold);
            LoggerHandler.info("Selected Gold filter");

            String title = Base.driver.getTitle();
            String actual = ExcelReader.readCellValue("RingsAndPendant","3","Actual");
            String description=ExcelReader.readCellValue("RingsAndPendant","3","Description");
            helper.verifyEquals(title, actual, description);
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Creator: Gautam Rawat
     * Description: This method clicks on the first product in the list.
     */
    public void clickOnFirstProduct() {
        try {
            helper.clickElement(RingPageLocators.firstProduct);
            LoggerHandler.info("Clicked on first product");
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
            helper.clickElement(RingPageLocators.AddtoCart);
            LoggerHandler.info("Clicked on Add to Cart");

            Screenshots.takePageScreenShot("FirstRingScreenshot");
            LoggerHandler.info("Screenshot taken: FirstRingScreenshot");
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            e.printStackTrace();
        }
    }  
}
