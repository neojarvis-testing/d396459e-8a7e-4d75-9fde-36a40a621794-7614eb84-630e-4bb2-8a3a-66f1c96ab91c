package uistore;

import org.openqa.selenium.By;

public class RingPageLocators {

    /**
     * Description: Locator for the Gender filter section.
     */
    public static By Gender = By.cssSelector("div[class='head clearfix'][id='myDIV01']");

    /**
     * Description: Locator for the Men's filter option under Gender.
     */
    public static By Mens = By.cssSelector("a[href='/rings/search:Rings/filter_Gender:%28%22Men%22%29/']");

    /**
     * Description: Locator for the Metal filter section.
     */
    public static By Metal = By.xpath("//div[text()='Metal']");

    /**
     * Description: Locator for the Gold filter option under Metal.
     */
    public static By Gold = By.cssSelector("a[href='/rings/search:Rings/filter_Gender:%28%22Men%22%29/filter_Metal:%28%22Gold%22%29/']");

    /**
     * Description: Locator for the first product in the rings list.
     */
    public static By firstProduct = By.xpath("(//a[@class='tooltip_18'])[1]");

    /**
     * Description: Locator for the Add to Cart button.
     */
    public static By AddtoCart = By.cssSelector("div[id='btnBuyNowC'][class='btnaddtocart']");
}
