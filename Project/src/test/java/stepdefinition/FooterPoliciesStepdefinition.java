package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FooterPoliciesAction;

public class FooterPoliciesStepdefinition {

    FooterPoliciesAction action = new FooterPoliciesAction(Hooks.test);

    @Given("the user lands on the homepage and observes the layout to ensure accessibility")
    public void the_user_lands_on_the_homepage_and_observes_the_layout_to_ensure_accessibility() {
        action.HomePage();
    }

    @When("the user interacts with each footer policy link by clicking the user will be directed to the associated URL for the policy")
    public void the_user_interacts_with_each_footer_policy_link_by_clicking_the_user_will_be_directed_to_the_associated_url_for_the_policy() {
        action.policies();
    }

    @Then("the user should exit out of homepage.")
    public void the_user_should_exit_out_of_homepage() {
        action.ExitHomePage();
    }
}
