package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.FooterPoliciesLocator;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.WebDriverHelper;

/**
 * Creator: Nakul J Gowda
 * Description: This class handles actions related to the Footer Policies of the application.
 * It includes methods for navigating the Home Page, validating footer policy links and titles 
 * against expected values, and exiting the browser.
 */
public class FooterPoliciesAction {
    public ExtentTest test;
    WebDriverHelper helper;

    /**
     * Constructor: Initializes the FooterPoliciesAction class with an ExtentTest instance 
     * for reporting and a WebDriverHelper instance for Selenium actions.
     *
     * @param test - ExtentTest instance for logging test status.
     */
    public FooterPoliciesAction(ExtentTest test) {
        this.test = test;
        helper = new WebDriverHelper(Base.driver);
    }

    /**
     * Description: Logs the user into the Home Page of the browser and updates the Extent Report.
     */
    public void HomePage() {
        LoggerHandler.info("Inside browser Home Page");
        test.log(Status.INFO, "Inside browser Home Page");
    }

    /**
     * Description: Validates the URLs and titles of footer policy elements by:
     * 1. Iterating through each footer policy element.
     * 2. Clicking on the element and retrieving the current URL and title.
     * 3. Comparing the actual values with expected values from an Excel sheet.
     * 4. Navigating back to the previous page for the next iteration.
     */
    public void policies() {
        List<WebElement> policies = helper.findElementsByXpath(FooterPoliciesLocator.policies.toString().split(":")[1].trim());

        for (int i = 1; i <= policies.size(); i++) {
            helper.clickElement(By.xpath("(" + FooterPoliciesLocator.policies.toString().split(":")[1].trim() + ")[" + i + "]"));
            String urlActual = Base.driver.getCurrentUrl();
            String urlExpected = ExcelReader.readCellValue("Footer Policies Elements", "" + i + "", "URL");
            helper.verifyEquals(urlActual, urlExpected, urlExpected + " Verified");
            String titleActual = Base.driver.getTitle(); // helper.retrieveElementText(FooterPoliciesLocator.heading);
            String titleExpected = ExcelReader.readCellValue("Footer Policies Elements", "" + 1 + "", "Title");
            helper.verifyEquals(titleActual, titleExpected, titleExpected + " Verified");
            Base.driver.navigate().back();
        }
    }

    /**
     * Description: Logs the exit from the browser and updates the Extent Report.
     */
    public void ExitHomePage() {
        LoggerHandler.info("Exit browser");
        test.log(Status.INFO, "Exit browser");
    }
}