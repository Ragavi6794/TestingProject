package org.pomframework;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomClass extends BaseClass{
	//Page Object Model FrameWork is used to maintain the locators
	//It helps reduce code duplication and improves test case maintenance.
	// to create an Object Repository

	public static void  pageFactory() {                       
		PageFactory.initElements(driver, PomClass.class);     
	}

	//REGISTRATION SCENARIO
	//Register button on Login Page
	@FindBy(xpath="//div[@class='docs-example-viewer-title-spacer']//button[1]")
	public static WebElement Register;

	//firstname
	@FindBy(id="mat-input-0")
	public static WebElement fName;

	//lastname
	@FindBy(id="mat-input-1")
	public static WebElement lName;

	//username
	@FindBy(id="mat-input-2")
	public static WebElement uName;

	//password
	@FindBy(id="mat-input-3")
	public static WebElement password;

	//confirmPassword
	@FindBy(id="mat-input-4")
	public static WebElement cpassword;

	//gender
	@FindBy(xpath="//*[@id=\"mat-radio-3\"]/label/span[1]/span[2]")
	public static WebElement gender;

	//Click Register button
	@FindBy(xpath="/html/body/app-root/div/app-user-registration/div/div[2]/div/mat-card/mat-card-content/form/mat-card-actions/button")
	public static WebElement RegisterClick;


	//LOGIN SCENARIO
	//username
	@FindBy(id="mat-input-0")
	public static WebElement userName;

	//password
	@FindBy(id="mat-input-1")
	public static WebElement passWord;

	//login button
	@FindBy(xpath="/html/body/app-root/div/app-login/div/div[2]/div/mat-card/mat-card-content/form/mat-card-actions/button")
	public static WebElement login;


	//ADD TO CART
	//search
	@FindBy(xpath="/html/body/app-root/app-nav-bar/mat-toolbar/mat-toolbar-row/div[2]/app-search/form/input")
	public static WebElement search;

	//search click
	@FindBy(xpath="//mat-option[@role='option']")
	public static WebElement sclick;

	//Add To cart button
	@FindBy(css="button[color='primary']")
	public static WebElement addToCart;

	//badge
	@FindBy(id="mat-badge-content-0")
	public static WebElement badge;

	//select categories
	@FindBy(xpath="//a[contains(text(),'Romance')]")
	public static WebElement category;

	//like love story book
	@FindBy(xpath="//body/app-root[1]/div[1]/app-home[1]/div[1]/div[2]/div[1]/div[9]/app-book-card[1]/mat-card[1]/mat-card-content[1]/a[1]/img[1]")
	public static WebElement loveStory;


	//Remove Item from Cart
	@FindBy(xpath="/html/body/app-root/app-nav-bar/mat-toolbar/mat-toolbar-row/div[3]/button[2]")
	public static WebElement cart;

	@FindBy(xpath="/html/body/app-root/div/app-shoppingcart/div/mat-card/table/tbody/tr/mat-card-content/td[6]/button/span[1]/mat-icon\r\n")
	public static WebElement delete;

	//checkout
	@FindBy(xpath="/html/body/app-root/div/app-shoppingcart/div/mat-card/table/tfoot/tr/mat-card-content/th[5]/button")
	public static WebElement checkout;

	//Shipping Address
	//Name
	@FindBy(id="mat-input-0")
	public static WebElement Name;

	//Address Line1
	@FindBy(id="mat-input-1")
	public static WebElement AddressLine1;

	//Address Line2
	@FindBy(id="mat-input-2")
	public static WebElement AddressLine2;

	//pincode
	@FindBy(id="mat-input-3")
	public static WebElement pincode;
	
	//state
	@FindBy(id="mat-input-4")
	public static WebElement State;
	
	//click on PlaceOrder button
	@FindBy(xpath="/html/body/app-root/div/app-checkout/div/div[2]/div[1]/mat-card/mat-card-content/form/mat-card-actions/button[1]/span[1]")
	public static WebElement place;
	
	//MyAccount
	@FindBy(xpath="/html/body/app-root/app-nav-bar/mat-toolbar/mat-toolbar-row/div[3]/button[3]")
	public static WebElement account;
	
	//logout
	@FindBy(xpath="//*[@id=\"mat-menu-panel-1\"]/div/button[2]")
	public static WebElement logout;
	
	
}
