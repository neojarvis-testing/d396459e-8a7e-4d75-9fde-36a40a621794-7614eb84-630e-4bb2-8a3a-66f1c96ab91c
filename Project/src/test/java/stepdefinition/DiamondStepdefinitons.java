package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.DiamondAction;

public class DiamondStepdefinitons {
    DiamondAction d1 = new DiamondAction();

    @Given("User lands on the homepage and hovers over the earring")
    public void user_lands_on_the_homepage_and_hovers_over_the_earring() {

        d1.VerifyLogo();
        d1.hoverOnEarrings();
    }

    @Given("User then selects Diamond from the options and gets redirected")
    public void user_then_selects_diamond_from_the_options_and_gets_redirected() {
        d1.clickOnDiamond();
        d1.verifyDiamondKeyword();

    }

    @Then("User selectes Women as the gender and toggle the popularity options to new arrival")
    public void user_selectes_women_as_the_gender_and_toggle_the_popularity_options_to_new_arrival() {
        d1.selectGender();
        d1.sortByNewArrivals();
        
    }
    
    @Then("User get redirected to desired page and selects the first product out of it")
    public void user_get_redirected_to_desired_page_and_selects_the_first_product_out_of_it() {
        d1.selectFirstProduct();

    }

    @Then("After redirection user clicks on add to cart")
    public void after_redirection_user_clicks_on_add_to_cart() {
        d1.addToCart();
    }

    @Then("User captures screenshot and verifies it")
    public void user_captures_screenshot_and_verifies_it() {
        d1.takeScreenshot();
    }

}
