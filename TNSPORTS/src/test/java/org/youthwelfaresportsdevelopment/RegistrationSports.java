package org.youthwelfaresportsdevelopment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.pomframework.PomClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


public class RegistrationSports extends PomClass {
	//DataProvider its login data return to the login method
	@DataProvider(name="Registration")
	public String[][] getData() throws IOException {
		//input datas get from Read ExcelFile Apachepoi methods
		String[][] input=getExcelData();
		return input;
		//return the values to  Login method as paramter Constructor
	}


	//read data from Excel using ApachePoi
	public String[][] getExcelData() throws IOException {
		String file="./Excel/Register.xlsx";
		//get workbook 
		XSSFWorkbook  wb=new XSSFWorkbook(file);
		//get sheet
		XSSFSheet sheet = wb.getSheet("sheet1");
		//get no of row in sheet
		int noOfRow = sheet.getLastRowNum();  //without Header
		System.out.println("No of Row:" +noOfRow );
		//get no of column
		short noOfColumn = sheet.getRow(0).getLastCellNum();
		System.out.println("No of Columns:" +noOfColumn );

		//data variable is declared array
		String[][]  data = new String[noOfRow][noOfColumn];
		//gat all rows and column values
		for(int i=1;i<=noOfRow;i++) {
			//get row
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<noOfColumn;j++) {
				//get cellvalue
				XSSFCell cell = row.getCell(j);
				//data convert into String
				DataFormatter dft=new DataFormatter();
				String value = dft.formatCellValue(cell);
				//print excel values
				System.out.println(cell);

				//now the value should be return to the dataprovider  =>i-1=>0-1=0  becuse array always accept 0 index and 1

				data[i-1][j]=value;  //[0][0],[0][1],[0][2],[0][3],  next row =>[1][0],[1][1],[1][2],[1][3],.....

			}
		}
		//return data out of from loop
		return data;

	}


	//Login Method datas are getting from dataprovider
	@Test(dataProvider="Registration")


	public void Login(String name,String mobileno,	String email,String doorno,String street,String place,String city,
			String landmark,String pincode,String Aadhar,String dob,String password) throws InterruptedException, IOException {
       //report
		extReport("./Report/RegisterReport.html");
		ExtentTest open=extent.createTest("TC-001-OpenBrowser");
		open.log(Status.INFO, "Launch Browser");

		setUpChrome("https://www.tnsports.org.in/webapp/login.aspx"); //chrome browser launched

		String title = getTitle();

		open.log(Status.PASS, "Open Browser Successfully");

		if(title.contains("TNSPORTS")) {
			open.log(Status.PASS, "Open Browser Successfully");

		}else {
			open.log(Status.FAIL, "Your Browser Failed!!");

		}


		PageFactory.initElements(PomClass.driver, PomClass.class);  //pom framework
		//report
		ExtentTest datas=extent.createTest("TC-002-Registration");
		datas.log(Status.INFO, "MulipleDatas are Entered through Apachepoi and DataProvider");

		popClose.click();       //close dialog box
		registerlink.click();  	//click registration link
		//sendkeys value are Entered through the Register constuctor as a Parameter values
		Name.sendKeys(name); 
		datas.log(Status.PASS, "Name data Entered Successfully");

		mobile.sendKeys(mobileno);
		datas.log(Status.PASS, "MobileNo data Entered Successfully");

		emailAddress.sendKeys(email);
		datas.log(Status.PASS, "Email data Entered Successfully");

		doorNo.sendKeys(doorno);
		datas.log(Status.PASS, "DoorNo  data Entered Successfully");

		streetName.sendKeys(street);
		datas.log(Status.PASS, "StreetNo data Entered Successfully");

		placeName.sendKeys(place);
		datas.log(Status.PASS, "PlaceName data Entered Successfully");

		cityName.sendKeys(city);
		datas.log(Status.PASS, "CityName data Entered Successfully");

		threads();
		//selenium selectors for dropdown                         
		district.click();
		datas.log(Status.PASS, "DistrictName data selected Successfully");

		mla.click();    //mla
		datas.log(Status.PASS, "MLA data selected Successfully");

		mp.click();  	//mp
		datas.log(Status.PASS, "MP data selected Successfully");

		taluk.click();  //taluk
		datas.log(Status.PASS, "Taluk data selected Successfully");


		land.sendKeys(landmark);
		datas.log(Status.PASS, "LandMarkName data Entered Successfully");

		pin.sendKeys(pincode);
		datas.log(Status.PASS, "Pincode data Entered Successfully");

		aadhar.sendKeys(Aadhar);
		datas.log(Status.PASS, "Aadhar data Entered Successfully");


		//actions to sendkeys
		WebElement date = dateOfBirth;
		actionSendKey(date,"20-04-1999");
		datas.log(Status.PASS, "DateofBirth data Entered Successfully");

		threads();

		//radio button
		gender.click();  //female or male
		datas.log(Status.PASS, "Gender data selected Successfully");

		threads();
		student.click();   
		datas.log(Status.PASS, "Student Details data selected Successfully");

		category.click();   threads();
		datas.log(Status.PASS, "Category data selected Successfully");

		tournament.click();  
		datas.log(Status.PASS, "Tournament data selected Successfully");

		volunteer.click();
		datas.log(Status.PASS, "Volunteer data selected Successfully");

		abled.click();
		datas.log(Status.PASS, "DisabledAbility data selected Successfully");

		discipline.click(); 
		datas.log(Status.PASS, "Discipline Successfully");

		passWord.sendKeys(password);  //Entered constructor
		datas.log(Status.PASS, "Password data Entered Successfully");

		outerPage.click();   
		register.click(); threads();  //click register button
		datas.log(Status.PASS, "Register Button has been CLicked Successfully");
		screenShot("./register.png");
		datas.pass("Registered Suucessfully");
		datas.addScreenCaptureFromPath("./register.png");
		
		flush();

	}



}


//WebElement date = driver.findE lement(By.id("dob"));
//Actions a=new Actions(driver);
//a.sendKeys(date,"22-3-2000").perform();
