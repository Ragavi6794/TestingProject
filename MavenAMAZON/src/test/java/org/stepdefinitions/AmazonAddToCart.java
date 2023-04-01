package org.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.pageobject.PomClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonAddToCart extends PomClass{
	@Given("User entered the {string} in search tab")
	public void user_entered_the_in_search_tab(String product) {
	  pf();
	  search.sendKeys(product);
	}

	@When("User click on search icon it navigated to product page")
	public void user_click_on_search_icon_it_navigated_to_product_page() {
	   pf();
	   icon.click();
	}

	@When("User scroll down then select particular product and click")
	public void user_scroll_down_then_select_particular_product_and_click() {
	  pf();
	  WebElement pr = price;  //particular price
	  scrollDown(pr);   //js executor
	  pr.click();
	  childWindow(); 
	  
	  WebElement ph = phone;
	  scrollDown(ph);
	  ph.click();     //particular phone click
	}

	@When("User should have to handle the window and click scroll down")
	public void user_should_have_to_handle_the_window_and_click_scroll_down() {
		 childWindow();  //window handling 
		
	}

	@When("user click on AddToCart button")
	public void user_click_on_add_to_cart_button() {
		pf();
		WebElement add = addToCart;
		 scrollDown(add);
		 add.click();
		 
	}

	@Then("User should be add to cart successfully")
	public void user_should_be_add_to_cart_successfully() throws IOException {
	   pf();
	   String text = success.getText();
	   System.out.println(text);
	   if(text.contains("Added to Cart"))
	   {
		   System.out.println("Add TO Cart Successfully");
	   }
	   cart.click();
	   screenShot("./screenshot/addtocart.png");
	}
	
	
	

}
