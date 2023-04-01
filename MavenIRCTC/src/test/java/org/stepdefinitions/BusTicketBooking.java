package org.stepdefinitions;

import org.pomframework.PomClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusTicketBooking extends PomClass{
	@Given("User open the link {string}")
	public void user_open_the_link(String url) {
	   setUpChrome(url);  
	}

	@When("Click on the login button")
	public void click_on_the_login_button() {
	   pf();
	   loginClick.click();
	}

	@When("User enter valid username {string} and password as {string}")
	public void user_enter_valid_username_and_password_as(String name, String pass) throws InterruptedException {
	    pf();
	    userName.sendKeys(name);
	    passWord.sendKeys(pass);
	    login.click();
	}

	@Then("click on login button user should be login successfully")
	public void click_on_login_button_user_should_be_login_successfully() throws InterruptedException {
		 pf();
		 threads();
		 user.click();
		 String userCheck = welcome.getText();
		 if(userCheck.contains("Welcome")) {
			 System.out.println("Login Successfully" +userCheck);
		 }
		 else {
			 System.out.println("Login Failed");
		 }
		 user.click();
	}

//Book Bus Ticket
	@Given("Click on the Depart From as {string} Going To as {string}")
	public void click_on_the_depart_from_as_going_to_as(String dept, String to) throws InterruptedException {
	  pf(); 
		//dept from coimbatore
		deptFrom.sendKeys(dept);
	   cbe.click();
	 //going to thirupathi
	   goingTo.sendKeys(to);
	   thiru.click();
	   
	   
	}

	@When("User select on the departure date and click search button")
	public void user_select_on_the_departure_date_and_click_search_button() throws InterruptedException {
	   pf();
		date.click();
	   clickDate.click();
	   search.click();    //click search
	   threads();
	}

	@When("User click on select seat button")
	public void user_click_on_select_seat_button() {
	  pf();
	  selectSeat.click();
	}

	@When("Select particular seats")
	public void select_particular_seats() {
	  pf();
	  seat.click();
	  droping.click();
	}

	@When("User click on Proceed to Book button")
	public void user_click_on_proceed_to_book_button() {
	   pf();
	   proceedBook.click();
	   
	}

	@When("User enter details for confirm booking")
	public void user_enter_details_for_confirm_booking() {
	   pf();
       selectText(dropDown,"TAMIL NADU");  //dropdown select
       travellerName.sendKeys("Ragavi");   //traveller name
       selectValue(gender,"F");            //gender
       age.sendKeys("23");                 //age
       
	}

	@Then("User click on Continue booking button and click payment")
	public void user_click_on_continue_booking_button_and_click_payment() throws InterruptedException {
	   pf();
	   agree.click();
	   continueBook.click();threads();
	   payment.click();
	   Thread.sleep(3000);
	}



}
