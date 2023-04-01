#PIM is an acronym for “Product Information Management” 
@PIM
Feature: Login Valid User and Product Information Management details
Scenario: Login Orange Admin Panel
Given User Open the Admin Url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
When User enter the valid username as "Admin" and Password as "admin123"
And user click on the login 
Then User should be navigated to dashboard page
  @Smoke
  Scenario: User select on PIM and Edit Employee details from PIM
  Given User select on the PIM from List 
  And then user view employee details
  When User search particular EmployeeName as "Charlie" and id as "0212"
  And User click on the search button
 Then click on delete button it deleted the employee

  @Smoke
  Scenario Outline: Add New Employee from PIM
  Given User click on AddEmployee buttton
  And It navigated to Add employee list page
  When user enterd details Employee name as "<empfirstname>" and "<emplastname>"
  Then click on the save button
  
  
  Examples: 
  |empfirstname||emplastname|
  |Vidya       ||s      |
  |Rooby       ||t      |
  |raja        ||r      |
  
  @Smoke
  Scenario: Apply Leave 
  Given User Click on Leave from List
  And user click on dashboard
  When user click on profile  
  Then click on logout button
  
  