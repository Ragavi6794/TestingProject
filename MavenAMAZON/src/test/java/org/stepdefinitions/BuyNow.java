package org.stepdefinitions;



import org.openqa.selenium.WebElement;
import org.pageobject.PomClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuyNow extends PomClass{
	@Given("User entered this {string} in search tab")
	public void user_entered_this_in_search_tab(String product) throws InterruptedException {
		Thread.sleep(3000);
	  pf();
	  search.sendKeys(product);
	}

	@When("User click on the search icon it navigated to product page")
	public void user_click_on_the_search_icon_it_navigated_to_product_page() {
	   pf();
	   icon.click();
	}

	@When("User scroll down then select that particular product and click")
	public void user_scroll_down_then_select_thar_particular_product_and_click() {
	  pf();
	  WebElement lp = mouse;
	  scrollDown(lp);
	  lp.click();     //particular phone click
	}

	@When("User should have to handle that window and click scroll down")
	public void user_should_have_to_handle_that_window_and_click_scroll_down() {
		 childWindow();  //window handling 	
	}


	@When("User click on Buynow button")
	public void User_click_on_Buynow_button() {
		pf();
	    buyNow.click();
	    
	}

//	@When("User click on proceed to checkout button")
//	public void user_click_on_proceed_to_checkout_button() {
//	  pf();
//	  proceed.click();    //click proceed to buy
//	  childWindow();
//	}

	@When("Click on Use this Address and payment")
	public void click_on_use_this_address_and_payment() {
	    pf();

	    useAddress.click();     //use Address
	    usePayment.click();     //usepayment
	}

	@When("User skip on th proof and click continue button")
	public void user_skip_on_th_proof_and_click_continue_button() {
		pf();
	   skip.click(); 
	}

	@When("User click on place your Order button")
	public void user_click_on_place_your_order_button() throws InterruptedException {
	    pf();
	    cont.click();
	    Thread.sleep(5000);
	    scrollToDown();
		 //  placeOrder.click();
	    
	}

	@Then("Order placed successfully")
	public void order_placed_successfully() {
	 System.out.println("Place Order Successfully");
	}

}
