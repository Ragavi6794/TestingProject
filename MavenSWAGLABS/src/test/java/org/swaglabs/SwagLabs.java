package org.swaglabs;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;


public class SwagLabs{

	//Xml file only run
	WebDriver driver;
	@BeforeSuite
	public void swag() {
		System.out.println("This is E-Commerce Website");
	}

//Cross Browser run with Multiple Browser
	@Parameters({"browser","username","password"})  //paramter passed value from xml file
	@Test(groups= {"smoke"},description="Multi Browser is Launched Successfully")
	public void browser(String browser,String name,String pass) throws IOException, InterruptedException {
		//extend report
				ExtentSparkReporter report=new ExtentSparkReporter("./Report/SwagLabs.html");
				ExtentReports extent=new ExtentReports();
				extent.attachReporter(report);
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		default:
			System.out.println("Browser Not Launched");
			break;
		}
		
		ExtentTest open=extent.createTest("TC-001-OpenBrowser");
		open.log(Status.INFO, "Launch Browser");
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		open.log(Status.PASS, "Open MultipleBrowser Successfully");

		//login
		ExtentTest datas=extent.createTest("TC-002-Login");
		datas.log(Status.INFO, "datas are passed through parameter");
		
		driver.findElement(By.id("user-name")).sendKeys(name);
		
		datas.log(Status.PASS, "UserName Passed Successfully ");
		driver.findElement(By.id("password")).sendKeys(pass);
		
		datas.log(Status.PASS, "Passsword Passed Successfully");
		driver.findElement(By.id("login-button")).click();
		
		datas.log(Status.PASS, " Login Successfully ");
		datas.addScreenCaptureFromPath("./login.png");
		
		//scrolled down
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement tShirt = driver.findElement(By.xpath("//*[@id=\"item_3_title_link\"]/div"));
		js.executeScript("arguments[0].scrollIntoView(true)",tShirt);

		//click add to cart button
		ExtentTest addtocart=extent.createTest("TC-003-addtocart");
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		addtocart.log(Status.PASS, " Add to cart button click successfully ");

		driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click(); 

		//check cart icon
		WebElement cartIcon = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
		String value = cartIcon.getText();
		if(!value.isEmpty()) {
			System.out.println("Add To cart Successfully");
		}

		//click cart button
		WebElement cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
		addtocart.log(Status.PASS, "Click Cart icon button successfully ");

		//draw border for cart and take screen shot that
		js.executeScript("arguments[0].style.border='3px solid red'",cart); 
		Thread.sleep(2000);

		//takescreenshot for particular element
		TakesScreenshot tk=(TakesScreenshot) driver;
		File src1=cart.getScreenshotAs(OutputType.FILE);
		File des1=new File("./Screenshot/Addcart.png");
		FileUtils.copyFile(src1, des1);
		
		//cartIcon click
		cart.click();
		addtocart.log(Status.PASS, "Click Cart button successfully ");
		//takecreenshot for items in cart
		File src2=tk.getScreenshotAs(OutputType.FILE);
		File des2=new File("./Screenshot/Itemscart.png");
		FileUtils.copyFile(src2, des2);

		
		//remove one item from cart
		driver.findElement(By.xpath("//*[@id=\"remove-test.allthethings()-t-shirt-(red)\"]")).click();
		Thread.sleep(2000);

		//click continue shopping button
		driver.findElement(By.id("continue-shopping")).click();
		addtocart.log(Status.PASS, " Click continue button successfully ");


		//again click one more product
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		Thread.sleep(2000);


		//Again click cart button
		driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
		Thread.sleep(2000);


		//checkout button click
		driver.findElement(By.id("checkout")).click();
		addtocart.log(Status.PASS, "Checkout button click successfully ");
		
		//send values address
		driver.findElement(By.id("first-name")).sendKeys("Ragavi");
		driver.findElement(By.id("last-name")).sendKeys("M");
		driver.findElement(By.id("postal-code")).sendKeys("638451");
		driver.findElement(By.id("continue")).click();
		addtocart.log(Status.PASS, " Address passed Successfully ");

		//scrolled down to Finish Button

		WebElement finish = driver.findElement(By.xpath("//*[@id=\"finish\"]"));
		js.executeScript("arguments[0].scrollIntoView(true)",finish);
		finish.click();  //clicked finish button
		addtocart.log(Status.PASS, " Click finish button Successfully ");

		//takescreenshot
		File src=tk.getScreenshotAs(OutputType.FILE);
		File des=new File("./Screenshot/PlacedOrder.png");
		FileUtils.copyFile(src, des);

		//Logout
		driver.findElement(By.id("react-burger-menu-btn")).click();  //click toggle button
		driver.findElement(By.id("logout_sidebar_link")).click();    //click logout button
		addtocart.log(Status.PASS, " Logout Successfully ");


	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}



}
