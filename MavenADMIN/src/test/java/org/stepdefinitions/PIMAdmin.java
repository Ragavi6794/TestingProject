package org.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.pomframework.PomClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PIMAdmin extends PomClass{
	@Given("User Open the Admin Url {string}")
	public void user_open_the_admin_url(String loginurl) {
		setUpChrome(loginurl);
	}

	@When("User enter the valid username as {string} and Password as {string}")
	public void user_enter_the_valid_username_as_and_password_as(String name, String pass) {
		pageFactory();
		username.sendKeys(name);  
		password.sendKeys(pass);
	}

	@When("user click on the login")
	public void user_click_on_the_login() throws IOException, InterruptedException {
		pageFactory();
		login.click();threads();
		screenShot("./Screenshots/login.png");
	}

	@Then("User should be navigated to dashboard page")
	public void user_should_be_navigated_to_dashboard_page() {
		String homePage = getCurrentUrl();
		if(homePage.contains("dashboard")) {
			System.out.println("Admin Login Successfully");
		}
		else {
			System.out.println("Admin Login Failed ");
		}
	}

	@Given("User select on the PIM from List")
	public void user_select_on_the_pim_from_list() {
		//alert handle
		//	accept();  //ok
		pageFactory();
		PIM.click();

	}

	@Given("then user view employee details")
	public void then_user_view_employee_details() {
		String employeePage = getCurrentUrl();
		if(employeePage.contains("viewEmployeeList")) {
			System.out.println("Employee details showed Successfully");
		}

	}

	@When("User search particular EmployeeName as {string} and id as {string}")
	public void user_search_particular_employee_name_as_and_id_as(String empname, String id) {
		pageFactory();
		empName.sendKeys(empname);  //employeename
		empId.sendKeys(id);         //employee id
	}

	@When("User click on the search button")
	public void user_click_on_the_search_button() {
		pageFactory();
		search.click();          //search employee details

	}

	@When("click on delete button it deleted the employee")
	public void click_on_delete_button_it_deleted_the_employee() throws InterruptedException, IOException {
		scrollToDown();//js scroll down
		pageFactory();
		reload();
		select.click();             //select particular employee
		deleted.click();            //deleted button click
		yes.click();  threads();              //click on yes in alert
		 screenShot("./Screenshots/deleteEmployee.png");  //screenshots

	}


	@Given("User click on AddEmployee buttton")
	public void user_click_on_add_employee_buttton() {
		pageFactory();
		addEmp.click();   //click on add employee 
	}

	@Given("It navigated to Add employee list page")
	public void it_navigated_to_add_employee_list_page() {
		String addEmp = getCurrentUrl();
		if(addEmp.contains("addEmployee")) {
			System.out.println("AddEmployee Details navigated Successfully");
		}
	}

	@When("user enterd details Employee name as {string} and {string}")
	public void user_enterd_details_employee_name_as_and(String newname, String lastname) throws InterruptedException, IOException {
		pageFactory();
		newName.sendKeys(newname);   //AddNew Employee
		lastName.sendKeys(lastname);  //Add last Name
		save.click();                  //save click
		threads();
		 screenShot("./Screenshots/NewEmployee.png");  //screenshots

	}

	@Then("click on the save button")
	public void click_on_the_save_button() {
		pageFactory();
		nickname.sendKeys("Lakshmi");
		gender.click();
		saved.click();
	}

	//3.Leave
	@Given("User Click on Leave from List")
	public void user_click_on_leave_from_list() throws InterruptedException {
		pageFactory();
		leave.click();
		String leavePage = getCurrentUrl();
		if(leavePage.contains("viewLeaveList"))
		{
			System.out.println("View List Page is Navigated Successfully");
		}
		else {
			System.out.println("Failed");
		}



	}


	@Given("user click on dashboard")
	public void user_click_on_dashboard() throws IOException {
		pageFactory();
		dashboard.click();
		 screenShot("./Screenshots/dash.png");  //screenshots
	}

	@When("user click on profile")
	public void user_click_on_profile() {
		pageFactory();
		admin.click();
	}

	@Then("click on logout button")
	public void click_on_logout_button() throws IOException {
		pageFactory();
		logout.click();
		 screenShot("./Screenshots/logout.png");  //screenshots
	}



}
