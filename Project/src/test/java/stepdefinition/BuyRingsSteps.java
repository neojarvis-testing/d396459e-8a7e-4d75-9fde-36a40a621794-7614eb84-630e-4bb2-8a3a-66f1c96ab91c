package stepdefinition;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.BuyRingsAction;
import utils.Base;

public class BuyRingsSteps {

    private BuyRingsAction buyRingsAction;

    public BuyRingsSteps() {
        buyRingsAction = new BuyRingsAction();
    }

    @Given("the user initiates the search functionality")
    public void theUserInitiatesTheSearchFunctionality() {
        
        buyRingsAction.clickOnSerchBar();
        Hooks.test.log(Status.INFO, "Search functionality initiated");
    }

    @When("the user inputs {string} into the designated search field")
    public void theUserInputsIntoTheDesignatedSearchField(String item) {
        
        buyRingsAction.typeIntoSearchBar(item);
        Hooks.test.log(Status.INFO, "Item input into the designated search field: " + item);
    }

    @When("the user confirms the search by pressing the Enter key")
    public void theUserConfirmsTheSearchByPressingTheEnterKey() {
        
        buyRingsAction.pressEnterKey();
        Hooks.test.log(Status.INFO, "Search confirmed by pressing the Enter key");
    }

    @Then("the user applies the gender-specific filter")
    public void theUserAppliesTheGenderSpecificFilter() {
       
        buyRingsAction.clickOnGender();
        Hooks.test.log(Status.INFO, "Gender-specific filter applied");
    }

    @Then("the user selects the preferred metal category")
    public void theUserSelectsThePreferredMetalCategory() {
        
        buyRingsAction.clickOnMetals();
        Hooks.test.log(Status.INFO, "Preferred metal category selected");
    }

    @Then("the user identifies and clicks on the first product displayed in the results")
    public void theUserIdentifiesAndClicksOnTheFirstProductDisplayedInTheResults() {
        
        buyRingsAction.clickOnFirstProduct();
        Hooks.test.log(Status.INFO, "First product identified and clicked");
    }

    @Then("the user proceeds to add the selected item to the shopping cart")
    public void theUserProceedsToAddTheSelectedItemToTheShoppingCart() {
        
        buyRingsAction.addToCart();
        Hooks.test.log(Status.INFO, "Selected item added to the shopping cart");
    }
}
