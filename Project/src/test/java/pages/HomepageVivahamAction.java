package pages;

import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import stepdefinition.Hooks;
import uistore.HomepageVivahamLocators;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshots;
import utils.WebDriverHelper;

public class HomepageVivahamAction {

    public ExtentTest test;
    WebDriverHelper helper;

    /**
     * Description : Initializes WebDriverHelper for performing actions
     */
    public HomepageVivahamAction() {
        helper = new WebDriverHelper(Base.driver);
    }

    String parent = Base.driver.getWindowHandle();

    /**
     * Description : Hovers over the "What's Trending" section
     */
    public void Whatstrending() {
        try {     
            helper.hoverOnElement(HomepageVivahamLocators.Whatstrending);
            Hooks.test.log(Status.INFO, "Hovered on What's Trending");
            LoggerHandler.info("Hovered on What's Trending");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Description : Clicks on the Vivaham section
     */
    public void Vivaham() {
        try {
            helper.clickElement(HomepageVivahamLocators.Vivaham); 
            Hooks.test.log(Status.INFO, "Clicked on Vivaham section");        
            LoggerHandler.info("Clicked on Vivaham section");  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Description : Clicks on Locate Store section and captures a screenshot
     */
    public void locateStore() {
        try {
            helper.clickElement(HomepageVivahamLocators.Locatestore);   
            Hooks.test.log(Status.INFO, "Clicked on Locate Store");        
            LoggerHandler.info("Clicked on Locate Store");  
            Reporter.addScreenshotToReport("LocateStore", Hooks.test, "Captured screenshot");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Description : Switches to child window and selects a state from dropdown
     */
    public void selectState() {
        try {
            helper.switchToChildWindow();
            helper.waitUntilElementIsVisible(HomepageVivahamLocators.state, Integer.parseInt(Base.prop.getProperty("ewait")));
            Select select = new Select(Base.driver.findElement(HomepageVivahamLocators.state));
            select.selectByValue(ExcelReader.readCellValue("ExcelSheetAbarna", "2", "City"));
            Hooks.test.log(Status.INFO, "Selected state value");
            LoggerHandler.info("Selected state value");  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Description : Selects a city from dropdown
     */
    public void selectCity() {
        helper.waitUntilElementIsVisible(HomepageVivahamLocators.city, Integer.parseInt(Base.prop.getProperty("ewait")));
        Select select = new Select(Base.driver.findElement(HomepageVivahamLocators.city));
        select.selectByValue(ExcelReader.readCellValue("ExcelSheetAbarna", "1", "City"));
        Hooks.test.log(Status.INFO, "Selected city value");
        LoggerHandler.info("Selected city value");  
    }

    /**
     * Description : Clicks the search button and navigates back to parent window
     */
    public void clickSearch() {
        helper.clickElement(HomepageVivahamLocators.clickSearch);
        Base.driver.close();
        Base.driver.switchTo().window(parent);
        helper.waitUntilElementIsVisible(HomepageVivahamLocators.Locatestore, Integer.parseInt(Base.prop.getProperty("ewait")));
        helper.scrollInWebPageTillVisible(HomepageVivahamLocators.Delhi);
        helper.hoverOnElement(HomepageVivahamLocators.Delhi);
        helper.clickElement(HomepageVivahamLocators.Delhi);
        helper.switchToChildWindow();
        Screenshots.takePageScreenShot("Vivaham");
        Hooks.test.log(Status.INFO, "Navigated back to parent window and clicked Delhi");
        LoggerHandler.info("Navigated back to parent window and clicked Delhi");  
    }

    /**
     * Description : Verifies Sort By section text against expected value
     */
    public void verifySortBy() {
        String actual = Base.driver.findElement(HomepageVivahamLocators.SortBy).getText();
        System.out.println(actual);
        String expected = ExcelReader.readCellValue("ExcelSheetAbarna", "1", "Verification");
        boolean condition = actual.contains(expected);
        helper.verifyTrue(condition, "Verification done for Sort By");   
    }
}
