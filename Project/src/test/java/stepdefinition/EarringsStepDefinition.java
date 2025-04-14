package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomepageEarringsAction;

/**
 * Creator: Akash Deep
 * Description: This class defines the step definitions for the Cucumber tests related to the Reliance Jewels website.
 * It includes steps for verifying the logo, hovering over earrings, clicking on drops, verifying the URL, and interacting with various elements on the page.
 */
public class EarringsStepDefinition {

    HomepageEarringsAction home = new HomepageEarringsAction();

    @Given("the user is on the homepagess")
    public void the_user_is_on_the_homepagess() {
        System.out.println("HomePage of Aplication");
    }

    @When("the Reliance Jewels logo title {string} is visible")
    public void the_reliance_jewels_logo_is_visible(String string) {
        home.verifyLogo(string);
    }

    @When("the user hovers on {string} and clicks {string} under Occasion")
    public void the_user_hovers_on_and_clicks_under_occasion(String string, String string2) {
        home.hoverOnEarrings();
        home.clicksOnDrops();
    }

    @Then("the user is redirected to {string} result page")
    public void the_user_is_redirected_to_the_respective_result_page(String string) {
        home.verifiesUrl(string);
    }

    @Then("the user clicks {string} and selects {string}")
    public void the_user_clicks_and_selects(String string, String string2) {
        home.clicksOnCategories();
    }

    @Then("the page is redirected to relevant content")
    public void the_page_is_redirected_to_relevant_content() {

    }

    @Then("the user clicks {string} and selects {string} under {string}")
    public void the_user_clicks_and_selects_under(String string, String string2, String string3) {
        home.clicksOnMoreFilters();
        home.clicksOnMetalPurity();
    }

    @Then("the user is taken to the result page")
    public void the_user_is_taken_to_the_result_page() {
        
    }

    @Then("the user clicks the first product and clicks {string}")
    public void the_user_clicks_the_first_product_and_clicks(String string) {
        home.clicksOnFirstProduct();
        home.buyNowProduct();
    }

    @Then("the user is redirected to the {string} product details page")
    public void the_user_is_redirected_to_the_selected_product_details_page(String string) {
        home.verifiesFeatures(string);
    }
}
