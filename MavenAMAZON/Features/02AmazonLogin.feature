@Login
Feature: Amazon User Login



Scenario: User Login with phoneno and password
Given User open browser with the url "https://www.amazon.com/"
When user click on the Signin button
And User enter the mobileno or Email id "7402050943" and click continue
And User enter the password "lithi740" and click signin button
Then User should be login successfully


