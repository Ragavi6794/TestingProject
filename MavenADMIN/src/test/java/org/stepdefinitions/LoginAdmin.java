package org.stepdefinitions;

import org.pomframework.PomClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginAdmin extends PomClass {
	@Given("User go to the Login url {string}")
	public void user_go_to_the_login_url(String Url) {
		setUpChrome(Url);      //parameterized data passed 
	 
	}

	@When("User enter username  {string} and password {string}")
	public void user_enter_username_and_password(String name, String pass)
	//mulitple username,password  datas are passed through parameters in multiple scenarios
	{
	  pageFactory();
	  username.sendKeys(name);  
	  password.sendKeys(pass);
	}

	@When("User click on the login button")
	public void user_click_on_the_login_button() {
		pageFactory();
		login.click();
	}

	@Then("User should be login and navigated to dashboard page")
	public void user_should_be_login_and_navigated_to_dashboard_page() {
		String homePage = getCurrentUrl();
	    if(homePage.contains("dashboard")) {
	    	System.out.println("Admin Login Successfully");
	    }
	    else {
	    	System.out.println("Admin Login Failed ");
	    }
	    
	}



}
