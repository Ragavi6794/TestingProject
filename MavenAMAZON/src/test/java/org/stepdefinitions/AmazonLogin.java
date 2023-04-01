package org.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.pageobject.PomClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonLogin extends PomClass{
	@Given("User open browser with the url {string}")
	public void user_open_browser_with_the_url(String url) throws IOException, InterruptedException {
	  setUpChrome(url);  //launch amazon website 
		  
	}

	@When("user click on the Signin button")
	public void user_click_on_the_signin_button() {
		pf();
	  signin.click();
	}

	@When("User enter the mobileno or Email id {string} and click continue")
	public void user_enter_the_mobileno_or_email_id_and_click_continue(String phone) {
		pf();
		phoneNo.sendKeys(phone);
		Continue.click();
	}

	@When("User enter the password {string} and click signin button")
	public void user_enter_the_password_and_click_signin_button(String pass) {
	    pf();
	    password.sendKeys(pass);
	    signIn.click();
	    password.sendKeys(pass);
	    String text = captcha.getText();
	    cap.sendKeys(text);
	  
	}

	@Then("User should be login successfully")
	public void user_should_be_login_successfully() {
	  String home = getCurrentUrl();
	  if(home.contains("amazon")) {
		  System.out.println("Login Successfully");
		  
	  }
	  
	}

	



}
