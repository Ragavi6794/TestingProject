package org.pomframework;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PomClass extends BaseClass {
	//pagefactory
    public static void pf() {
  	  PageFactory.initElements(driver, PomClass.class);
    }
    
    //Login
    @FindBy(xpath="/html/body/app-root/app-header/header/nav[1]/div/div[2]/div[3]/ul/li[2]/a")
    public static WebElement loginClick;
    
    @FindBy(id="loginuserid")
    public static WebElement userName;
    
    @FindBy(id="pwd")
    public static WebElement passWord;
    
    @FindBy(xpath="//*[@id=\"home\"]/div/form/div[3]/button")
    public static WebElement login;
    
    //Profile
    @FindBy(xpath="/html/body/app-root/app-header/header/nav[1]/div/div[2]/div[3]/ul/li[2]")
    public static WebElement user;
    
    @FindBy(xpath="/html/body/app-root/app-header/header/nav[1]/div/div[2]/div[3]/ul/li[2]/div/a[1]")
    public static WebElement welcome;
    
    @FindBy(xpath="/html/body/app-root/app-header/header/nav[1]/div/div[2]/div[3]/ul/li[2]/div/a[3]")
    public static WebElement logout;
    
  //Booking Bus Ticket
    @FindBy(id="departFrom")
    public static WebElement deptFrom;
    
    @FindBy(xpath="//div[text()='Coimbatore']")
    public static WebElement cbe;
    
    
    @FindBy(id="goingTo")
    public static WebElement goingTo;
    
    @FindBy(xpath="//div[text()='Tirupathi']")
    public static WebElement thiru;

    //select date
    @FindBy(id="departDate")
    public static WebElement date;
    
    @FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[6]/a")
    public static WebElement clickDate;
    
    //search
    @FindBy(xpath="/html/body/app-root/ng-component/div[3]/div[2]/div[2]/form/div[4]/button")
    public static WebElement search;   
    
    @FindBy(xpath="(//*[@id=\"accordionExample\"]/div[1]/div[7]/button)[3]")
    public static WebElement selectSeat;
    
    @FindBy(xpath="//*[@id=\"seatLayout2\"]/div/div/div[1]/div/div[2]/div/div[2]/div[4]/span[9]")
    public static WebElement seat;
    
    @FindBy(xpath="//*[@id=\"myTabContent\"]/div/div/table/tbody/tr/td[1]/input")
    public static WebElement droping;
    
    @FindBy(xpath="//*[@id=\"seatLayout2\"]/div/div/div[2]/div[2]/div[4]/button")
    public static WebElement proceedBook;
    
    //User Details 
    
    @FindBy(xpath="/html/body/app-root/ng-component/div/form/div/div/div[1]/div[4]/div[1]/div[6]/select")
    public static WebElement dropDown;
    
    @FindBy(xpath="/html/body/app-root/ng-component/div/form/div/div/div[1]/div[4]/div[3]/div[2]/input")
    public static WebElement travellerName;
    
    @FindBy(xpath="/html/body/app-root/ng-component/div/form/div/div/div[1]/div[4]/div[3]/div[3]/select")
    public static WebElement gender;
    
    @FindBy(xpath="/html/body/app-root/ng-component/div/form/div/div/div[1]/div[4]/div[3]/div[4]/input")
    public static WebElement age;
    
    @FindBy(id="agree")
    public static WebElement agree;
    
    @FindBy(xpath="//*[@id=\"sticky\"]/div[2]/button")
    public static WebElement continueBook;
    
    @FindBy(xpath="//*[@id=\"fareModal\"]/div/div/div[2]/div/div[2]/div[6]/button[2]")
    public static WebElement payment;
} 
