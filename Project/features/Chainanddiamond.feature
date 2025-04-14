Feature: Chain And Diamond Actions

@TS1
Scenario: Diamond

Given User lands on the homepage and hovers over the earring

And User then selects Diamond from the options and gets redirected

Then User selectes Women as the gender and toggle the popularity options to new arrival

Then User get redirected to desired page and selects the first product out of it

And After redirection user clicks on add to cart

Then User captures screenshot and verifies it 


@TS2
Scenario: Chain

Given User lands on the homepage and hovers on the chain options

And User selects silver and gets redirected to the page

Then User selects the toggles the gender to women and more filter to clicks on try on available option to yes

Then User get redirected to the page and selects the first product 

And User verifies the product with code and clicks on buy now 

Then User verifies it with the screenshot