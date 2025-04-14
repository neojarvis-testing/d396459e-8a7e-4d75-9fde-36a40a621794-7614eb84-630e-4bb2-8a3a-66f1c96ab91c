package uistore;

import org.openqa.selenium.By;

public class HomePageLocatorsRingsAndPendent {

    /**
     * Description: Locator for the search bar on the home page.
     */
    public static By searchBarLocator = By.cssSelector("input[placeholder='What are you searching for?']");

    /**
     * Description: Locator for the Pendants section link.
     */
    public static By pendent = By.xpath("//a[text()='PENDANTS']");

    /**
     * Description: Locator for the Gifting filter link under Pendants.
     */
    public static By gift = By.cssSelector("a[href='https://www.reliancejewels.com/pendant-26-pendant-set/category:158/filter_Occasion:%28%22Gifting%22%29/']");
}
