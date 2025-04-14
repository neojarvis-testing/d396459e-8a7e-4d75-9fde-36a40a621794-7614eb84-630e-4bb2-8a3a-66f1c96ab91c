package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.HomepageFooterActions;

public class HomepageFooterSteps {

    HomepageFooterActions homepageFooter = new HomepageFooterActions();

    @Given("the user is on the homepagesss")
    public void the_user_is_on_the_homepagesss() {
        // Assuming the homepage is already loaded
    }

    @When("the user navigates to the About Us section")
    public void the_user_navigates_to_the_about_us_section() {
        homepageFooter.AboutUs();
    }

    @Then("the user should see the About Us page")
    public void the_user_should_see_the_about_us_page() {
        // Verification logic can be added here if needed
    }

    @When("the user proceeds to the Why Reliance section")
    public void the_user_proceeds_to_the_why_reliance_section() {
        homepageFooter.WhyReliance();
    }

    @Then("the user should see the Why Reliance page")
    public void the_user_should_see_the_why_reliance_page() {
        // Verification logic can be added here if needed
    }

    @When("the user verifies the Certifications section")
    public void the_user_verifies_the_certifications_section() {
        homepageFooter.Certifications();
    }

    @Then("the user should see the Certifications page")
    public void the_user_should_see_the_certifications_page() {
        // Verification logic can be added here if needed
    }

    @When("the user checks the Our Showrooms section")
    public void the_user_checks_the_our_showrooms_section() {
        homepageFooter.OurShowrooms();
    }

    @Then("the user should see the Our Showrooms page")
    public void the_user_should_see_the_our_showrooms_page() {
        // Verification logic can be added here if needed
    }

    @When("the user inspects the Media section")
    public void the_user_inspects_the_media_section() {
        homepageFooter.Media();
    }

    @Then("the user should see the Media page")
    public void the_user_should_see_the_media_page() {
        // Verification logic can be added here if needed
    }

    @When("the user explores the Blog section")
    public void the_user_explores_the_blog_section() {
        homepageFooter.Blog();
    }

    @Then("the user should see the Blog page")
    public void the_user_should_see_the_blog_page() {
        // Verification logic can be added here if needed
    }

    @When("the user reviews the FAQs section")
    public void the_user_reviews_the_faqs_section() {
        homepageFooter.FAQs();
    }

    @Then("the user should see the FAQs page")
    public void the_user_should_see_the_faqs_page() {
        // Verification logic can be added here if needed
    }

    @When("the user examines the Track Order section")
    public void the_user_examines_the_track_order_section() {
        homepageFooter.TrackOrder();
    }

    @Then("the user should see the Track Order page")
    public void the_user_should_see_the_track_order_page() {
        // Verification logic can be added here if needed
    }

    @When("the user confirms the Fast Shipping text")
    public void the_user_confirms_the_fast_shipping_text() {
        homepageFooter.VerifyFastShipping();
    }

    @Then("the user should see the correct Fast Shipping text")
    public void the_user_should_see_the_correct_fast_shipping_text() {
        // Verification logic can be added here if needed
    }

    @When("the user navigates to the Contact Us section")
    public void the_user_navigates_to_the_contact_us_section() {
        homepageFooter.Contactus();
    }

    @Then("the user should see the Contact Us page")
    public void the_user_should_see_the_contact_us_page() {
        // Verification logic can be added here if needed
    }
}
