package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PlatinumRingActions;

public class PlatinumRingStepDefinition {

    PlatinumRingActions platinumRingActions = new PlatinumRingActions();

    @Given("the user has successfully navigated to the homepage")
    public void user_lands_on_homepage() {
        // Add any necessary steps to ensure the user is on the homepage
    }

    @When("the user moves the cursor over the Rings section in the navigation bar")
    public void the_user_hovers_on_rings_in_the_navigation_bar() {
        platinumRingActions.hoverOnRings();
    }

    @When("the user selects the Casual Wear option under the Gender category")
    public void clicks_on_casual_wear_under_gender() {
        platinumRingActions.clickCasualWear();
    }

    @When("the user navigates to the Categories section")
    public void the_user_select_on_categories() {
        platinumRingActions.selectCategory();
    }

    @When("the user chooses the Platinum category")
    public void selects_platinum() {
        platinumRingActions.selectPlatinum();
    }

    @When("the user looks for additional filters")
    public void the_user_searches_for_more_filters() {
        platinumRingActions.chooseFilter();
    }

    @When("the user applies the Try on Available filter")
    public void the_user_applied_try_on_available_filter() {
        platinumRingActions.selectTryOnFilter();
    }

    @When("the user confirms the Try on Available option")
    public void selects_yes_for_try_on() {
        platinumRingActions.selectYes();
    }

    @When("the user picks the first product from the list")
    public void the_user_selects_the_first_product() {
        platinumRingActions.selectFirstProduct();
    }

    @Then("the user proceeds to click on the Buy Now button")
    public void the_user_clicks_on_buy_now() {
        platinumRingActions.clickBuyNow();
    }
}
