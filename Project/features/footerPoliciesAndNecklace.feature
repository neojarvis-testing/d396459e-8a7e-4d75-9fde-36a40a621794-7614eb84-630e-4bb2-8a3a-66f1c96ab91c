Feature: Necklace Purchase Journey And Footer Policies Validation

  @src1  
  Scenario: Complete Necklace Purchase and Cart Verification
    Given the user is on the website homepage
    Then the Reliance Jewels logo should be displayed
    
    When the user clicks on the search bar
    And the user enters "Necklace" in the search field
    And the user presses the enter key
    Then the user should see the necklace results
    
    When the user hovers over a necklace item
    And the user clicks on Quick View
    And the user closes the pop-up
    Then the user should be back on the results page
    
    And the user clicks on the first necklace product  
    And gets redirected to the correct product page
    
    When the user selects a specific weight from the dropdown
    And the user clicks on Buy Now
    Then the product should be added to the cart
    And a screenshot of the cart should be captured


  @src2
  Scenario: Validate footer policies links and titles with detailed checks
    Given the user lands on the homepage and observes the layout to ensure accessibility
    When the user interacts with each footer policy link by clicking the user will be directed to the associated URL for the policy
    Then the user should exit out of homepage.
