package stepdefinition;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.BuyPendentsAction;
import utils.Base;

public class BuyPendentsSteps {

    private BuyPendentsAction buyPendentsAction;

    public BuyPendentsSteps() {
        buyPendentsAction = new BuyPendentsAction();
    }

    @Given("the user hovers over pendents")
    public void theUserHoversOverPendents() {
        
        buyPendentsAction.hoverOverPendents();
        Hooks.test.log(Status.INFO, "Hovered over pendents");
    }

    @When("the user applies the gender filter")
    public void theUserAppliesGenderFilter() {
        
        buyPendentsAction.genderFilter();
        Hooks.test.log(Status.INFO, "Applied the gender filter");
    }

    @Then("the user selects additional filters")
    public void theUserAppliesMoreFilters() {
        
        buyPendentsAction.moreFilter();
        Hooks.test.log(Status.INFO, "Selected additional filters");
    }

    @Then("the user clicks on the first product displayed")
    public void theUserClicksOnTheFirstProduct() {
        
        buyPendentsAction.firstProductClick();
        Hooks.test.log(Status.INFO, "Clicked on the first product displayed");
    }

    @Then("the user adds the selected product to the cart")
    public void theUserAddsTheProductToTheCart() {
        
        buyPendentsAction.addToCart();
        Hooks.test.log(Status.INFO, "Added the selected product to the cart");
    }

    @Then("the user proceeds to the payment page")
    public void theUserProceedsToPay() {
        
        buyPendentsAction.proceetToPay();
        Hooks.test.log(Status.INFO, "Proceeded to the payment page");
    }
}
