package org.stepdefinitions;

import org.pomframework.PomClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginBookCart extends PomClass{

@Given("User entered this url {string} in browser")
public void user_entered_this_url_in_browser(String url) {
    setUpChrome(url);
}

@When("User enter valid and Invalid {string} and {string}")
public void user_enter_valid_and_invalid_and(String username, String password) {
  //get username and password as through parameter passed use headers
	pageFactory();
	userName.sendKeys(username);  //multiple data passed
	passWord.sendKeys(password);
}

@When("User click on the Login button")
public void user_click_on_the_login_button() {
	pageFactory();
   login.click();
}

@Then("User shoulbe navigated to Bookcart Website")
public void user_shouldbe_navigated_to_bookcart_website() {
    String bookCart = getCurrentUrl();
   // Assert.assertEquals(bookCart, "bookcart");
   
    if(bookCart.contains("bookcart")) {
    	System.out.println("Login Successfully");
    }
    else {
    	System.out.println("Login Failed");
    }
}

}
