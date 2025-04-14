package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NecklaceBuyAndMyCartVerifiedAction;

public class NecklaceBuyAndMyCartVerifiedStepdefinition {

    NecklaceBuyAndMyCartVerifiedAction action = new NecklaceBuyAndMyCartVerifiedAction(Hooks.test);

    @Given("the user is on the website homepage")
    public void the_user_is_on_the_website_homepage() {
        action.HomePage();
    }

    @Then("the Reliance Jewels logo should be displayed")
    public void the_reliance_jewels_logo_should_be_displayed() {
        action.VerifyLogoOfRelianceJewels();
    }

    @When("the user clicks on the search bar")
    public void the_user_clicks_on_the_search_bar() {
        action.clickOnSearchBar();
    }

    @When("the user enters {string} in the search field")
    public void the_user_enters_in_the_search_field(String string) {
        action.insertValueInSearchOperation(string);
    }

    @When("the user presses the enter key")
    public void the_user_presses_the_enter_key() {
        action.enterActionOnSearchBar();
    }

    @Then("the user should see the necklace results")
    public void the_user_should_see_the_necklace_results() {
        action.NecklaceResultPage();
    }

    @When("the user hovers over a necklace item")
    public void the_user_hovers_over_a_necklace_item() {
        action.hoverOverProduct();
    }

    @When("the user clicks on Quick View")
    public void the_user_clicks_on_quick_view() {
        action.clickOnPopUpActions();
    }

    @When("the user closes the pop-up")
    public void the_user_closes_the_pop_up() {
        action.closePopUp();
    }

    @Then("the user should be back on the results page")
    public void the_user_should_be_back_on_the_results_page() {
        action.NecklaceResultPage();
    }

    @Then("the user clicks on the first necklace product")
    public void the_user_clicks_on_the_first_necklace_product() {
        action.clickTheFirstProduct();
    }

    @Then("gets redirected to the correct product page")
    public void gets_redirected_to_the_correct_product_page() {
        action.VerifyTheFirstProduct();
    }

    @When("the user selects a specific weight from the dropdown")
    public void the_user_selects_a_specific_weight_from_the_dropdown() {
        action.FirstNecklaceDetailsPage();
    }

    @When("the user clicks on Buy Now")
    public void the_user_clicks_on_buy_now() {
        action.clickOnBuyNow();
    }

    @Then("the product should be added to the cart")
    public void the_product_should_be_added_to_the_cart() {
       action.verifyMyCart();
    }

    @Then("a screenshot of the cart should be captured")
    public void a_screenshot_of_the_cart_should_be_captured() {
       action.screenShotMyCart();
    }
}
