package uistore;

import org.openqa.selenium.By;

/**
 * Creator: Akash Deep
 * Description: This class contains locators for elements on the Buy Now page.
 * It includes locators for the "Buy Now" button and the product name on the cart page.
 */
public class BuyNowPageLocator {

    public static By buyNow = By.cssSelector("div[id='btnBuyNowC'][class='btnaddbuynow buynow2']");
    public static By productname = By.cssSelector("a[id='productNameCartPage_1']");
}

