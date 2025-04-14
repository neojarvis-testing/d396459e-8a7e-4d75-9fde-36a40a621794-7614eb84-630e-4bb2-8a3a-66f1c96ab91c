package uistore;

import org.openqa.selenium.By;

/**
 * Creator: Akash Deep
 * Description: This class contains locators for elements on the homepage related to earrings.
 * It includes locators for the logo, earrings section, and drops filter.
 */
public class HomepageEarringsLocator {

    public static By Logo = By.cssSelector("img[title='Online Shopping in India']");
    public static By earrings = By.xpath("(//a[@href='https://www.reliancejewels.com/category:131/'])[1]");
    public static By drops = By.cssSelector("a[href='https://www.reliancejewels.com/earrings/category:131/filter_Earring_Type:%28%22Drops%22%29/']");
}

