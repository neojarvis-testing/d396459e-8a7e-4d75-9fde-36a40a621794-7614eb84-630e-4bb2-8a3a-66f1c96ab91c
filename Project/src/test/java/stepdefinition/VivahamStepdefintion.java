package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomepageVivahamAction;

public class VivahamStepdefintion {

        HomepageVivahamAction vivahActions = new HomepageVivahamAction();
    
        @Given("the user is on the Reliance Jewels homepage")
        public void the_user_is_on_the_reliance_jewels_homepage() {
           
        }
    
        @When("they navigate to the Vivaham section")
        public void they_navigate_to_the_vivaham_section() {  
            vivahActions.Whatstrending();
        }
    
        @When("they open the store locator in a new tab")
        public void they_open_the_store_locator_in_a_new_tab() { 
           vivahActions.Vivaham();
        }
    
        @When("they select Andhra Pradesh and Guntur")
        public void they_select_andhra_pradesh_and_guntur() {       
           vivahActions.locateStore();
        }
    
        @When("they search for nearby stores")
        public void they_search_for_nearby_stores() {
           vivahActions.selectState();
        }
    
        @Then("they return to the Vivaham page")
        public void they_return_to_the_vivaham_page() {
           vivahActions.selectCity();
        }
    
        @Then("they explore the offerings for Delhi")
        public void they_explore_the_offerings_for_delhi() {
           vivahActions.clickSearch();
        }
    }
    
