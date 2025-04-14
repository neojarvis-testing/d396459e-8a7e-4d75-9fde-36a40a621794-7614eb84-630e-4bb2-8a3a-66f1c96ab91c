package stepdefinition;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.Base;
import utils.Reporter;

/**
 * Creator: Akash Deep
 * Description: This class provides hooks for setting up and tearing down the test environment.
 * It initializes the ExtentReports, opens the browser before each scenario, and closes the browser after each scenario.
 */
public class Hooks extends Base {

    public static ExtentReports reports;
    public static ExtentTest test;

    @BeforeAll
    public static void config() {
        reports = Reporter.initializeExtentReport("Reliance Test");
    }

    @Before
    public void launch(Scenario sc) {
        openBrowser();
        test = reports.createTest(sc.getName());
    }

    @After
    public void closing() {
        driver.quit();
    }

    @AfterAll
    public static void flushing() {
        reports.flush();
    }
}
