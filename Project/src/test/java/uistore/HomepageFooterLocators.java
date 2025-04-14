package uistore;

import org.openqa.selenium.By;

public class HomepageFooterLocators {
   
    public static By Aboutus = By.cssSelector("a[href='https://m.reliancejewels.com/static/about_us2024.mobi']");
    // public static By Aboutus = By.xpath("//a[@href='https://m.reliancejewels.com/static/about_us2024.mobi']");
    public static By WhyReliance = By.xpath("(//a[@href='https://www.reliancejewels.com/s/why-reliancejewels'])[1]");
    // public static By Certification = By.cssSelector("a[href='https://www.reliancejewels.com/s/certification']");
    public static By Certification = By.xpath("(//a[@href='https://www.reliancejewels.com/s/certification'])[1]");
    public static By OurShowroom = By.xpath("(//a[@href='https://stores.reliancejewels.com/'])[1]");
    public static By Media = By.xpath("(//a[@href='https://m.reliancejewels.com/static/MediasecM2023.mobi'])[1]");
    public static By Blog = By.cssSelector("a[href='https://reliancejewels.com/blog/']");
    public static By FAQs = By.cssSelector("a[href='https://www.reliancejewels.com/s/faq']");
    public static By Trackorder = By.cssSelector("a[href='https://www.reliancejewels.com/track-your-order.html']");
    public static By Contactus = By.xpath("(//a[@href='https://m.reliancejewels.com/static/rjcallback.mobi?type=GSV'])[3]");

    //to verify the text
    public static By fastShipping = By.xpath("//a[text()='Fast Shipping']");



}
