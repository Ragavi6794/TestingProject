@EndToEnd
Feature: BookCart Application Add To Cart for particular searched product

@Regression 
Scenario Outline: Add To Cart Using Search 
  Given User entered url "https://bookcart.azurewebsites.net/login" in browser
  When User enter valid "<userName>" and "<passWord>"
  And User click on the login button and navigate into Bookcart site
  When User search for a "<book>"
  And User get that product and click on AddToCart
  Then The cart badge should be get updated
 
   Examples:
  |userName      ||passWord| |book|
  |LithikaDevi   ||Lithi123| |HP1 |
 
  
  
 @Smoke
  Scenario Outline: Add To Cart Using select categories
    Given User select particular categories of books
    When User scroll down for that particular book 
    And User click on AddToCart button
    And User search for a "<book>"
    And User click on AddToCart button
    Then Again cart badge shouldbe incresed from that value
    
   Examples:
   |book |
   |Robbie|
   
   
  @Smoke
  Scenario: Delete some item from Cart
  Given User click on the shopping cart icon
  When User remove some item from cart
  And Click on the checkout button
  When User enter the Shipping Address Details
      |Lithika   |
      |Ondipudhur|
      |Coimbatore|
      |638402    |
      |Tamilnadu |
  Then User click on the place order button
  
  @Smoke
  Scenario: Get My Order Details
  Given User if check it is myorder page
  When  User get MyOrder details from Table
  Then  User logout from the BookCart
   
    
 
                            