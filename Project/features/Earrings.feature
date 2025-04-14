Feature: Navigate and filter products on Reliance Jewels website

  Scenario: User navigates through the Earrings section and applies filters
    Given the user is on the homepagess
    When the Reliance Jewels logo title "Online Shopping in India" is visible
    
    And the user hovers on "Earrings" and clicks "Drops" under Occasion
    Then the user is redirected to "Drops" result page

    And the user clicks "Categories" and selects "Gold"
    Then the page is redirected to relevant content

    And the user clicks "More Filters" and selects "22 Kt" under "Metal Purity"
    Then the user is taken to the result page

    And the user clicks the first product and clicks "Buy Now"
    Then the user is redirected to the "Gold" product details page