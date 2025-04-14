package uistore;

import org.openqa.selenium.By;

public class PendentsPageLocators {

    /**
     * Description: Locator for the Gender filter section.
     */
    public static By Gender = By.cssSelector("div[class='head clearfix'][id='myDIV01']");

    /**
     * Description: Locator for the Kids filter option under Gender.
     */
    public static By kids = By.cssSelector("a[title='Pendant & Pendant Set - Kids']");

    /**
     * Description: Locator for the More filter button.
     */
    public static By moreFilter = By.cssSelector("button[id='myBtn']");

    /**
     * Description: Locator for the Type filter section.
     */
    public static By type = By.cssSelector("div[title='Pendant & Pendant Set - Type']");

    /**
     * Description: Locator for the Pendant option inside the Type filter.
     */
    public static By pendentInsideType = By.cssSelector("a[title='Pendant & Pendant Set - Pendant']");

    /**
     * Description: Locator for the first product in the pendents list.
     */
    public static By firstProductOnPendent = By.xpath("(//a[@class='tooltip_18'])[1]");

    /**
     * Description: Locator for the Add to Cart button.
     */
    public static By AddtoCart = By.cssSelector("div[id='btnBuyNowC'][class='btnaddtocart']");

    /**
     * Description: Locator for the Proceed to Pay button.
     */
    public static By proceedToPay = By.cssSelector("a[id='proceedToPayButton']");


    /**
     * Description: Locator for the table heading in the cart page
     */
    public static By tableHeadingPrice= By.xpath("//th[text()='Unit Price']");

}
