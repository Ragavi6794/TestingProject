Feature: Book Bus Ticket from IRCTC with valid user

Scenario: User Enter valid username and password for Login
Given User open the link "https://www.bus.irctc.co.in/home" 
When Click on the login button
And User enter valid username "RagaviEswaran" and password as "Ragavi@6794"
Then click on login button user should be login successfully

Scenario Outline: Book Bus Ticket
Given Click on the Depart From as "<from>" Going To as "<to>"
When User select on the departure date and click search button
And User click on select seat button
And Select particular seats
When User click on Proceed to Book button
And User enter details for confirm booking
Then User click on Continue booking button and click payment 

Examples: 
      |from      | |to      |
      |Coimbatore| |Tirupathi|