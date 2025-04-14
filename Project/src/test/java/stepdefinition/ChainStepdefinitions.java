package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ChainAction;

public class ChainStepdefinitions {

    ChainAction c1 = new ChainAction();

    @Given("User lands on the homepage and hovers on the chain options")
    public void user_lands_on_the_homepage_and_hovers_on_the_chain_options() {
        c1.VerifyLogo();
        c1.hoverOnChain();

    }

    @Given("User selects silver and gets redirected to the page")
    public void user_selects_silver_and_gets_redirected_to_the_page() {
        c1.clickOnSilver();

    }

    @Then("User selects the toggles the gender to women and more filter to clicks on try on available option to yes")
    public void user_selects_the_toggles_the_gender_to_women_and_more_filter_to_clicks_on_try_on_available_option_to_yes() {
        c1.verifyCategoriesKeyword();
        c1.selectGender();
        c1.clickOnMoreFilters();
        c1.clickOnTryOnAvailable();
        c1.clickOnYes();
    }
    
    @Then("User get redirected to the page and selects the first product")
    public void user_get_redirected_to_the_page_and_selects_the_first_product() {
        c1.selectFirstProduct();
        c1.clickOnBuyNow();

    }

    @Then("User verifies the product with code and clicks on buy now")
    public void user_verifies_the_product_with_code_and_clicks_on_buy_now() {
        c1.verifyProductCodeAndRecordLogs();
        c1.clickonBuynowafterweight();
    }

    @Then("User verifies it with the screenshot")
    public void user_verifies_it_with_the_screenshot() {
        c1.takeScreenshot();

    }

}
