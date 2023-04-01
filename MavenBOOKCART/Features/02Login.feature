@EndToEnd
Feature: Valid and Invalid Login Scenario
@Smoke
  Scenario Outline: Login Scenario
  Given User entered this url "https://bookcart.azurewebsites.net/login" in browser
  When User enter valid and Invalid "<username>" and "<password>"
  When User click on the Login button
  Then User shoulbe navigated to Bookcart Website 
  
    Examples:
    
     |username   ||password|   #header to pass the value 
     |LithikaDevi||Lithi123|   #valid Username and password
     |LithikaDevi||Lithi   |   #valid Username and invali password
     |Lithika    ||Lithi123|   #invalid username and valid password
     |Lithika    ||Lithi   |   #invalid username and password
     
     