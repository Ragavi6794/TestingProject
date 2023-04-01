package org.stepdefinitions;

import java.util.List;

import org.pomframework.PomClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterBookCart extends PomClass{

	@Given("User entered the url {string} in browser")
	public void user_entered_the_url_in_browser(String url) {        //url is BookCart link is Passed as parameter 
		setUpChrome(url);
	}


	@When("If you new user Click on the Register button on login")
	public void if_you_new_user_click_on_the_register_button_on_login() throws InterruptedException {
		pageFactory(); 
		Register.click();   //Register bUtton Click
	}
	

	@Then("It navigated to User Register page")
	public void it_navigated_to_user_register_page() {
		String registerUrl = getCurrentUrl();       //get current url of Register Page
		if(registerUrl.contains("register")) {
			System.out.println("Registeration Page is Lauched Successfully");
		}
		else {
			System.out.println("Registration page is Launched Failed");
		}

	}
	


	@Given("User entered the given details")
	public void user_entered_the_given_details(DataTable register)  {
		reload();
		List<String> data = register.asList(String.class);
		String fname = data.get(0);    //get 0 index value from datatable from feature file  Lithika
		String lname = data.get(1);    //get 1 index value from datatable from feature file    E
		String uname = data.get(2);
		String pass  = data.get(3);
		String cpass = data.get(4);

		pageFactory(); 
		fName.sendKeys(fname);    //pass the fname value through firstName locators from POM
		lName.sendKeys(lname);    //lastName
		uName.sendKeys(uname);    //UserName
		password.sendKeys(pass);      //password
		cpassword.sendKeys(cpass);    //confirm password
		gender.click();           //click female radio button
     

	}
	

	@When("User click on the Register button")
	public void user_click_on_the_register_button() {
		pageFactory(); 
		RegisterClick.click();        //click on register button
	}

	@Then("User should be successfully Registered")
	public void user_should_be_successfully_registered() {
		String loginUrl = getCurrentUrl();       //get current url of Register Page
		if(loginUrl.contains("login")) {
			System.out.println("Your Details Register is Successfully");
		}
		else {
			System.out.println("Your Details Register Failed");
		}
	}

	
	

}
