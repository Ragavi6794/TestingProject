package org.pageobject;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomClass extends BaseClass {
	//pagefactory
      public static void pf() {
    	  PageFactory.initElements(driver, PomClass.class);
      }
      
     //login
      @FindBy(xpath="//*[@id=\"nav-link-accountList-nav-line-1\"]")
      public static WebElement signin;
      
      //phoneno
      @FindBy(id="ap_email")               //7402050943
      public static WebElement phoneNo;
      
      @FindBy(id="continue") 
      public static WebElement Continue;
      
      @FindBy(id="ap_password")           //lithi740
      public static WebElement password;
      
      @FindBy(id="signInSubmit")             
      public static WebElement signIn;
      
  //login OTP
      @FindBy(id="auth-login-via-otp-btn-announce")
      public static WebElement otp;
      
      @FindBy(id="auth-captcha-image")
      public static WebElement captcha;
      
      @FindBy(id="auth-captcha-guess")
      public static WebElement cap;
      
      
      //Addtocart
      @FindBy(id="twotabsearchtextbox")  //product name search
      public static WebElement search;

  	@FindBy(id="nav-search-submit-button") //click enter
  	public static WebElement icon;
  	
  	@FindBy(xpath="//*[@id=\"p_36/14674875011\"]/span/a/span")
  	public static WebElement price;

  	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/div/div/div[1]/span/a/div/img") //one that particular element click
  	public  static WebElement phone;

  	@FindBy(id="add-to-cart-button")  //click add to cart
  	public static WebElement addToCart;
  	
  	@FindBy(id="buy-now-button")
  	public static WebElement buyNow;
  	
  	@FindBy(xpath="//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/span")
  	public static WebElement success;
  	
  	@FindBy(id="attach-close_sideSheet-link")
     public static WebElement cart; 
  	
  	
  	//Buy Now
  	
//  	@FindBy(xpath="//*[@id=\"p_n_operating_system_browse-bin/23724789011\"]/span/a/span")
//  	public static WebElement windows;
  	
  	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div/div/div[1]/div/div[2]/div/span/a/div/img")
  	public static WebElement mouse;
  	
  	@FindBy(id="attach-sidesheet-checkout-button-announce")
  	public static WebElement navcart;
  	
  	@FindBy(id="sc-buy-box-ptc-button-announce")
  	public static WebElement proceed;
  	
  	@FindBy(id="shipToThisAddressButton-announce")
  	public static WebElement useAddress;
  	
  	@FindBy(id="pp-NBcR2L-114-announce")
  	public static WebElement usePayment;
  	
  	@FindBy(id="kyc_xborder_skip_section_label")
  	public static WebElement skip;
  	
  	@FindBy(id="kyc-xborder-continue-button-announce")
  	public static WebElement cont;
  	
  	@FindBy(id="bottomSubmitOrderButtonId-announce")
  	public static WebElement placeOrder;
}
