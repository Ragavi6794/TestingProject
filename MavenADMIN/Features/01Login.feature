@Login
Feature: Login Scenario
@Smoke
Scenario Outline: Login credentials passed valid and invalid data

Given User go to the Login url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
When User enter username  "<username>" and password "<password>"
And User click on the login button 
Then User should be login and navigated to dashboard page

Examples:
 
 |username | password|
 |Admin    | admin123|
 |Admin    |admin    |
 |Admin1   |admin123 |
 |Admin1   |admin    |