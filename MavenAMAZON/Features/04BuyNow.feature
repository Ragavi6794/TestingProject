@BuyNow
Feature: Buy Now Product
Scenario: User Login with phoneno and password
Given User open browser with the url "https://www.amazon.com/"
When user click on the Signin button
And User enter the mobileno or Email id "7402050943" and click continue
And User enter the password "lithi740" and click signin button
Then User should be login successfully

Scenario Outline: User search product and BuyNow

Given User entered this "<product>" in search tab
When User click on the search icon it navigated to product page
And User scroll down then select that particular product and click
And User should have to handle that window and click scroll down 
When User click on Buynow button 
And Click on Use this Address and payment
And User skip on th proof and click continue button
And User click on place your Order button 
Then Order placed successfully

Examples:
    |product|
    |mouse|
 