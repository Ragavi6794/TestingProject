@EndToEnd
Feature: Amazon User Login

Scenario: User Login with phoneno and password
Given User open browser with the url "https://www.amazon.com/"
When user click on the Signin button
And User enter the mobileno or Email id "7402050943" and click continue
And User enter the password "lithi740" and click signin button
Then User should be login successfully

Scenario Outline: User search product
Given User entered the "<mobile>" in search tab
When User click on search icon it navigated to product page
And User scroll down then select particular product and click
And User should have to handle the window and click scroll down 
When user click on AddToCart button 
Then User should be add to cart successfully

   Examples:
    |mobile|
    |OPPOA57|
 


  