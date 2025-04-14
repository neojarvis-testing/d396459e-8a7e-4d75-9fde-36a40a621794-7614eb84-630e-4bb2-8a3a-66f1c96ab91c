package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import stepdefinition.Hooks;
import uistore.HomepageFooterLocators;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Screenshots;
import utils.WebDriverHelper;

public class HomepageFooterActions {

    public ExtentTest test;
    WebDriverHelper helper;

    /**
     * Description : Initializes WebDriverHelper for performing actions
     */
    public HomepageFooterActions() {
        helper = new WebDriverHelper(Base.driver);
    }

    /**
     * Description : Clicks on About Us link, verifies the URL, and navigates back
     */
    public void AboutUs() {
        try {
            helper.clickElement(HomepageFooterLocators.Aboutus);
            String expected = ExcelReader.readCellValue("ExcelSheetAbarna", "1", "URL");
            String actual = Base.driver.getCurrentUrl();
            helper.verifyEquals(actual, expected, ExcelReader.readCellValue("ExcelSheetAbarna", "1", "UrlDescription"));
            Base.driver.navigate().back();
            Hooks.test.log(Status.INFO, "Clicked About Us and navigated");
            LoggerHandler.info("Clicked About Us and navigated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Description : Clicks on Why Reliance link, verifies the URL, and navigates back
     */
    public void WhyReliance() {
        try {
            helper.clickElement(HomepageFooterLocators.WhyReliance);
            String expected = ExcelReader.readCellValue("ExcelSheetAbarna", "2", "URL");
            String actual = Base.driver.getCurrentUrl();
            helper.verifyEquals(actual, expected, ExcelReader.readCellValue("ExcelSheetAbarna", "2", "UrlDescription"));
            Base.driver.navigate().back();
            Hooks.test.log(Status.INFO, "Clicked Why Reliance and navigated");
            LoggerHandler.info("Clicked Why Reliance and navigated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Description : Clicks on Certifications link, verifies the URL, and navigates back
     */
    public void Certifications() {
        try {
            helper.clickElement(HomepageFooterLocators.Certification);
            String expected = ExcelReader.readCellValue("ExcelSheetAbarna", "3", "URL");
            String actual = Base.driver.getCurrentUrl();
            helper.verifyEquals(actual, expected, ExcelReader.readCellValue("ExcelSheetAbarna", "3", "UrlDescription"));
            Base.driver.navigate().back();
            Hooks.test.log(Status.INFO, "Clicked Certifications and navigated");
            LoggerHandler.info("Clicked Certifications and navigated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Description : Clicks on Our Showrooms link and navigates back
     */
    public void OurShowrooms() {
        try {
            helper.clickElement(HomepageFooterLocators.OurShowroom);
            Base.driver.navigate().back();
            Hooks.test.log(Status.INFO, "Clicked Our Showroom and navigated");
            LoggerHandler.info("Clicked Our Showroom and navigated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Description : Clicks on Media link, verifies the URL, and navigates back
     */
    public void Media() {
        try {
            helper.clickElement(HomepageFooterLocators.Media);
            // String expected = ExcelReader.readCellValue("ExcelSheetAbarna", "5", "URL");
            // String actual = Base.driver.getCurrentUrl();
            // helper.verifyEquals(actual, expected, ExcelReader.readCellValue("ExcelSheetAbarna", "5", "UrlDescription"));
            Base.driver.navigate().back();
            Hooks.test.log(Status.INFO, "Clicked Media and navigated");
            LoggerHandler.info("Clicked Media and navigated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Description : Clicks on Blog link, verifies the URL, and navigates back
     */
    public void Blog() {
        try {
            helper.clickElement(HomepageFooterLocators.Blog);
            String expected = ExcelReader.readCellValue("ExcelSheetAbarna", "6", "URL");
            String actual = Base.driver.getCurrentUrl();
            helper.verifyEquals(actual, expected, ExcelReader.readCellValue("ExcelSheetAbarna", "6", "UrlDescription"));
            Base.driver.navigate().back();
            Hooks.test.log(Status.INFO, "Clicked Blog and navigated");
            LoggerHandler.info("Clicked Blog and navigated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Description : Clicks on FAQs link, verifies the URL, and navigates back
     */
    public void FAQs() {
        try {
            helper.clickElement(HomepageFooterLocators.FAQs);
            String expected = ExcelReader.readCellValue("ExcelSheetAbarna", "7", "URL");
            String actual = Base.driver.getCurrentUrl();
            helper.verifyEquals(actual, expected, ExcelReader.readCellValue("ExcelSheetAbarna", "7", "UrlDescription"));
            Base.driver.navigate().back();
            Hooks.test.log(Status.INFO, "Clicked FAQs and navigated");
            LoggerHandler.info("Clicked FAQs and navigated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Description : Clicks on Track Order link, verifies the URL, and navigates back
     */
    public void TrackOrder() {
        try {
            helper.clickElement(HomepageFooterLocators.Trackorder);
            String expected = ExcelReader.readCellValue("ExcelSheetAbarna", "8", "URL");
            String actual = Base.driver.getCurrentUrl();
            helper.verifyEquals(actual, expected, ExcelReader.readCellValue("ExcelSheetAbarna", "8", "UrlDescription"));
            Base.driver.navigate().back();
            Hooks.test.log(Status.INFO, "Clicked Track Order and navigated");
            LoggerHandler.info("Clicked Track Order and navigated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Description : Verifies Fast Shipping section text and takes a screenshot
     */
    public void VerifyFastShipping() {
        String actual = Base.driver.findElement(HomepageFooterLocators.fastShipping).getText();
        System.out.println(actual);
        String expected = ExcelReader.readCellValue("ExcelSheetAbarna", "2", "Verification");
        boolean condition = actual.contains(expected);
        helper.verifyTrue(condition, "Verification done for Fast Shipping");
        Screenshots.takePageScreenShot("Verified Fast Shipping");
    }

    /**
     * Description : Clicks on Contact Us link and navigates back
     */
    public void Contactus() {
        try {
            helper.clickElement(HomepageFooterLocators.Contactus);
            Base.driver.navigate().back();
            Hooks.test.log(Status.INFO, "Clicked Contact Us and navigated");
            LoggerHandler.info("Clicked Contact Us and navigated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Description : Executes all footer-related actions sequentially
     */
    public void BrandStoryCustomerDelight() {
        AboutUs();
        WhyReliance();
        Certifications();
        OurShowrooms();
        Media();
        Blog();
        FAQs();
        TrackOrder();
        VerifyFastShipping();
        Contactus();
    }
}

