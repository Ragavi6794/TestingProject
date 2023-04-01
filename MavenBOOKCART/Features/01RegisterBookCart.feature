#BookCart website opened
@EndToEnd
Feature: BookCart Site Launched

@Regression
Scenario: User launched the Bookcart Website using Url
Given User entered the url "https://bookcart.azurewebsites.net/login" in browser
When If you new user Click on the Register button on login
Then It navigated to User Register page 


#User Registeration
@Smoke
   Scenario Outline: User enter details for Register in site
   Given User entered the given details
   #dataTable passes as List in stepdefinitions as parameter
     |Lithika       |
     |E             |
     |LithikaDevi   |
     |Lithi123      |
     |Lithi123       |
    When User click on the Register button
    Then User should be successfully Registered 
 

 
     
    
  