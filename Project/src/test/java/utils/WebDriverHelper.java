package utils;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import stepdefinition.Hooks;

/**
 * Creator: Nakul J Gowda
 * Description: This class provides helper methods for interacting with
 * WebDriver,
 * such as clicking elements, handling windows, and performing actions on web
 * elements.
 */
public class WebDriverHelper {

    private WebDriver driver;

    /**
     * Description: Constructor to initialize the WebDriverHelper class with a
     * WebDriver instance.
     * 
     * @param driver - WebDriver instance
     */
    public WebDriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Description: Waits for a web element to be visible within the specified
     * timeout.
     * 
     * @param locator          - Locator of the element
     * @param timeoutInSeconds - Maximum time to wait in seconds
     */
    public void waitUntilElementIsVisible(By locator, int timeoutInSeconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to locate element", Hooks.test, e.getMessage());
        }
    }

    /**
     * // * Description: Clicks on a web element located by the given locator.
     * // * @param locator - Locator of the element
     * //
     */
    public void clickElement(By locator) {
        try {
            driver.findElement(locator)
                    .click();
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to locate element and hover", Hooks.test, e.getMessage());
        }
    }

    /**
     * // * Description: Sends keys (text) to a web element located by the given
     * locator.
     * // * @param locator - Locator of the element
     * // * @param data - Text to be sent
     * //
     */
    public void typeIntoElement(By locator, String data) {
        try {
            driver.findElement(locator)
                    .sendKeys(data);
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to write on element", Hooks.test, e.getMessage());
        }
    }

    /**
     * // * Description: Retrieves the text content of a web element located by the
     * given locator.
     * // * @param locator - Locator of the element
     * // * @return The text content of the element, or an empty string if an
     * exception occurs
     * //
     */
    public String retrieveElementText(By locator) {
        try {
            return driver.findElement(locator).getText();
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to retrieve text from element", Hooks.test, e.getMessage());
            return " ";
        }
    }

    /**
     * // * Description: Sends an ENTER key press to a web element located by the
     * given locator.
     * // * @param locator - Locator of the element
     * //
     */
    public void pressEnterKey(By locator) {
        try {
            driver.findElement(locator)
                    .sendKeys(Keys.ENTER);
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to perform ENTER action on element", Hooks.test, e.getMessage());
        }
    }

    /**
     * Description: Hovers over a web element located by the given locator.
     * 
     * @param locator - Locator of the element
     */
    public void hoverOnElement(By locator) {
        // String message="";
        try {
            WebElement webElement = driver.findElement(locator);
            Actions actions = new Actions(driver);
            actions.moveToElement(webElement).perform();
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            // message+=e.getMessage();
            Reporter.addScreenshotToReportfail("Unable to locate element and hover", Hooks.test, e.getMessage());
        }
    }

    /**
     * Description: Switches the WebDriver control to a new browser window.
     */
    public void switchToChildWindow() {
        try {
            String parentId = driver.getWindowHandle();
            Set<String> childIds = driver.getWindowHandles();

            for (String id : childIds) {
                if (!parentId.equals(id)) {
                    driver.switchTo().window(id);
                }
            }
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to switch to different a window", Hooks.test, e.getMessage());
        }
    }

    /**
     * Retries a failed test action for a specified number of attempts.
     *
     * @param action     - A lambda or functional interface representing the action
     *                   to retry.
     * @param maxRetries - The maximum number of retry attempts.
     */
    public void retryFailedTestCase(Runnable action, int maxRetries) {
        int attempt = 0;
        while (attempt < maxRetries) {
            try {
                attempt++;
                action.run(); // Executes the action
                LoggerHandler.info("Action succeeded on attempt " + attempt);
                break; // Exit the loop if the action succeeds
            } catch (Exception e) {
                LoggerHandler.error("Action failed on attempt " + attempt + ": " + e.getMessage());
                if (attempt == maxRetries) {
                    Reporter.addScreenshotToReportfail("Action failed after " + maxRetries + " attempts", Hooks.test,
                            e.getMessage());
                    throw e; // Rethrow the exception after exhausting all retries
                }
            }
        }
    }

    /**
     * Description: Retrieves a list of web elements located by the given XPath.
     * 
     * @param locator - XPath locator for the elements
     * @return List of web elements, or null if an exception occurs
     */
    public List<WebElement> findElementsByXpath(String locator) {
        try {
            List<WebElement> elements = driver.findElements(By.xpath(locator));
            return elements;
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to find the elements", Hooks.test, e.getMessage());
        }
        return null;
    }

    /**
     * Scrolls the web page by the specified number of pixels either vertically or
     * horizontally.
     * 
     * @param scroll - Determines the scroll direction: '0' for vertical scrolling
     *               and '1' for horizontal scrolling.
     * @param pixals - Number of pixels to scroll. Positive values scroll down or
     *               right, and negative values scroll up or left.
     * @throws IllegalArgumentException - Thrown when the 'scroll' parameter has an
     *                                  invalid value (not 0 or 1).
     */
    public void scrollInWebPage(int scroll, int pixals) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            if (scroll == 0) {
                js.executeScript("window.scrollBy(0," + pixals + ")", "");
            } else if (scroll == 1) {
                js.executeScript("window.scrollBy(" + pixals + ",0)", "");
            } else {
                throw new IllegalArgumentException(
                        "Invalid value for 'scroll'. Use '0' for vertical scrolling and '1' for horizontal scrolling.");
            }
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to scroll", Hooks.test, e.getMessage());
        }
    }

    /**
     * Scrolls the web page until the specified element is visible in the viewport.
     * 
     * @param locator - Locator of the element to bring into view.
     */
    public void scrollInWebPageTillVisible(By locator) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to scroll to a specific element", Hooks.test, e.getMessage());
        }
    }

    /**
     * Scrolls to the end of the web page by using JavaScript execution.
     */
    public void scrollInWebPageEnd() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to scroll to End", Hooks.test, e.getMessage());
        }
    }

    /**
     * Scrolls to the top of the web page by using JavaScript execution.
     */
    public void scrollInWebPageTop() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 0)"); // Correctly scrolls to the top of the page
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to scroll to the top", Hooks.test, e.getMessage());
        }
    }

    /**
     * Performs a click action on a web element using JavaScript execution.
     *
     * @param elementLocator - The locator of the web element to be clicked.
     */
    public void javascriptExecutorClick(By elementLocator) {
        try {
            WebElement element = driver.findElement(elementLocator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element); // Executes the click action
            LoggerHandler.info("Clicked on the element using JavaScript Executor");
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to perform click using JavaScript Executor", Hooks.test,
                    e.getMessage());
        }
    }

    /**
     * Verifies that two strings are equal and logs the result along with a
     * description.
     *
     * This method asserts that the actual value matches the expected value and logs
     * the provided description for better context. If the assertion fails, it
     * captures
     * the error message and attaches a screenshot to the report for debugging
     * purposes.
     *
     * @param actual      The actual value to compare.
     * @param expected    The expected value for comparison.
     * @param description A brief description of the validation being performed.
     */
    public void verifyEquals(String actual, String expected, String description) {
        try {
            Assert.assertEquals(actual, expected);
            LoggerHandler.info(description);
            Hooks.test.log(Status.PASS, description);
        } catch (AssertionError e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail(description, Hooks.test, e.getMessage());
        }
    }

    /**
     * Verifies that a condition is true and logs the result along with a
     * description.
     *
     * This method asserts that the given condition evaluates to true and logs
     * the provided description for context. If the assertion fails, it captures
     * the error message and attaches a screenshot to the report for debugging
     * purposes.
     *
     * @param condition   The condition to verify.
     * @param description A brief description of the verification being performed.
     */
    public void verifyTrue(boolean condition, String description) {
        try {
            Assert.assertTrue(condition);
            LoggerHandler.info(description);
            Hooks.test.log(Status.PASS, description);
        } catch (AssertionError e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail(description, Hooks.test, e.getMessage());
        }
    }

    /**
     * Verifies that a condition is false and logs the result along with a
     * description.
     *
     * This method asserts that the given condition evaluates to false and logs
     * the provided description for context. If the assertion fails, it captures
     * the error message and attaches a screenshot to the report for debugging
     * purposes.
     *
     * @param condition   The condition to verify.
     * @param description A brief description of the verification being performed.
     */
    public void verifyFalse(boolean condition, String description) {
        try {
            Assert.assertFalse(condition);
            LoggerHandler.info(description);
            Hooks.test.log(Status.PASS, description);
        } catch (AssertionError e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail(description, Hooks.test, e.getMessage());
        }
    }

    /**
     * Description: Clears the content of a text input field located by the given
     * locator.
     * 
     * @param locator - Locator of the element
     */
    public void clearTextInputField(By locator) {
        driver.findElement(locator).clear();
    }
}