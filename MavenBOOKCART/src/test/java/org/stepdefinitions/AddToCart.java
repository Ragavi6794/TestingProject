package org.stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.pomframework.PomClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCart extends PomClass {

	@Given("User entered url {string} in browser")
	public void user_entered_url_in_browser(String url) {
		setUpChrome(url);

	}

	@When("User enter valid {string} and {string}")
	public void user_enter_valid_and(String uname, String password) {
		pageFactory();
		userName.sendKeys(uname);
		passWord.sendKeys(password);
	}

	@When("User click on the login button and navigate into Bookcart site")
	public void user_click_on_the_login_button_and_navigate_into_bookcart_site() throws InterruptedException {
		pageFactory();
		login.click();
		Thread.sleep(2000);
	}

	@When("User search for a {string}")
	public void user_search_for_a_book(String book) throws InterruptedException {
		pageFactory();
		search.sendKeys(book);
		threads();
		sclick.click();
	}

	@When("User get that product and click on AddToCart")
	public void user_get_that_product_and_click_on_add_to_cart() throws IOException {
		//	driver.findElement(By.cssSelector("button[color='primary']")).click();
		pageFactory();
		addToCart.click();
		 screenShot("./Screenshots/AddcartIcon.png");  //screenshots
	}

	@Then("The cart badge should be get updated")
	public void the_cart_badge_should_be_get_updated() {
		String item = badge.getText();
		if(!item.isEmpty()) {
			System.out.println("Books is Added to cart Successfully!!! \t" +item );
		}
	}

	@Given("User select particular categories of books")
	public void user_select_particular_categories_of_books() {
		pageFactory();
		category.click();
	}

	@When("User scroll down for that particular book")
	public void user_scroll_down_for_that_particular_book() {
		pageFactory();
		WebElement story = loveStory;
		scrollDown(story);   //js element scroll down
		story.click();
	}

	@When("User click on AddToCart button")
	public void user_click_on_add_to_cart_button() {
		pageFactory();
		addToCart.click();
	    String pageText = getCurrentUrl();
	    if(pageText.contains("wishlist")) {
	    	System.out.println("Add to Cart is Successfully");
	    }
	}

	@Then("Again cart badge shouldbe incresed from that value")
	public void again_cart_badge_shouldbe_incresed_from_that_value() {
		String item = badge.getText();
		if(!item.isEmpty()) {
			System.out.println("Books is Added Again to cart Successfully!!! \t" +item );
		}
	}

	
	
	//Remove item From Cart
	
	@Given("User click on the shopping cart icon")
	public void user_click_on_the_shopping_cart_icon() throws IOException {
	   pageFactory();
	   cart.click();
	   screenShot("./Screenshots/cart.png");  //screenshots
	}
	@When("User remove some item from cart")
	public void user_remove_some_item_from_cart() {
		  pageFactory();
		  delete.click();
	}
	@When("Click on the checkout button")
	public void click_on_the_checkout_button() {
		pageFactory();
		checkout.click();
		  String pageText = getCurrentUrl();
		    if(pageText.contains("checkout")) {
		    	System.out.println("Check Out Page is Successfully!!");
		    }
		
	}
	@When("User enter the Shipping Address Details")
	public void user_enter_the_shipping_address_details(DataTable shipping) {
	    pageFactory();
	    reload();
	    List<String> shipAdd = shipping.asList(String.class); //shipping Address details are entered from Datatable
	    String name = shipAdd.get(0);
	    String add1 = shipAdd.get(1);
	    String add2 = shipAdd.get(2);
	    String pin = shipAdd.get(3);
	    String state = shipAdd.get(4);
	    Name.sendKeys(name);
	    AddressLine1.sendKeys(add1);
	    AddressLine2.sendKeys(add2);
	    pincode.sendKeys(pin);
	    State.sendKeys(state);
	    
	    
	}
	@Then("User click on the place order button")
	public void user_click_on_the_place_order_button() {
		pageFactory();
	    place.click();
	    
	  
	}


   //MY ORDER DETAILS
	
	@Given("User if check it is myorder page")
	public void user_if_check_it_is_myorder_page() throws IOException {
		String myorder = getCurrentUrl();
		if(myorder.contains("myorder")) {
			System.out.println("Order Placed SuccessFully!!!");
		}
		else {
			System.out.println("Your Order Placed Failed");
		}
		
		screenShot("./Screenshots/myorder.png");
	   
	}
	@When("User get MyOrder details from Table")
	public void user_get_my_order_details_from_table() {
		    	
		//get all datas 
	
		List<WebElement> rows = driver.findElements(By.xpath("/html/body/app-root/div/app-my-orders/div/div[2]/div/mat-card-content/div/table/tbody/tr[1]"));
		for(WebElement alldata:rows) {
			List<WebElement> column=alldata.findElements(By.tagName("td"));
			for(WebElement c:column) {
				System.out.println("Order Deatils:" +c.getText());   //get all text from rows
			}
		}

	  
	}
	@Then("User logout from the BookCart")
	public void user_logout_from_the_book_cart() {
	   account.click();
	   logout.click();
	    String logout = getCurrentUrl();
		if(logout.contains("myorder")) {
			System.out.println("LogOut SuccessFully!!!");
		}
		else {
			System.out.println("Your LogOut Failed");
		}
	 
	}


	
	
	
}
