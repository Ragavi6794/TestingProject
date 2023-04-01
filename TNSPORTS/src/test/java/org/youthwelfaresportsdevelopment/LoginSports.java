package org.youthwelfaresportsdevelopment;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.pomframework.PomClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


public class LoginSports extends PomClass {
	
	@DataProvider(name="Login")                 //DataProvider its login data return to the login method
	public String[][] getData() throws IOException {
		String[][] input=getExcelData();      //input datas get from Read ExcelFile Apachepoi methods
	
		return input;
	
		//return the values to  Login method as paramter Constructor
	}

	//read data from Excel using ApachePoi
	
	public String[][] getExcelData() throws IOException {
		String file="./Excel/Login.xlsx";
		XSSFWorkbook  wb=new XSSFWorkbook(file);  //get workbook 
		XSSFSheet sheet = wb.getSheet("sheet1"); //get sheet
		int noOfRow = sheet.getLastRowNum(); //get no of row in sheet //without Header
		System.out.println("No of Columns:" +noOfRow );
		//get no of column
		short noOfColumn = sheet.getRow(0).getLastCellNum();
		System.out.println("No of Columns:" +noOfColumn );
		//data variable is declared array
		String[][]  data = new String[noOfRow][noOfColumn];
		//gat all rows and column values
		for(int i=1;i<=noOfRow;i++) {
			XSSFRow row = sheet.getRow(i);//get row
			for(int j=0;j<noOfColumn;j++) {
				XSSFCell cell = row.getCell(j); 	//get cellvalue
				DataFormatter dft=new DataFormatter();  //data convert into String
				String value = dft.formatCellValue(cell);
				System.out.println(cell); //print excel values
				//now the value should be return to the dataprovider  =>i-1=>0-1=0  becuse array always accept 0 index and 1
				
				data[i-1][j]=value;  //[0][0],[0][1],[0][2],[0][3],  next row =>[1][0],[1][1],[1][2],[1][3],.....

			}
		}
		return data;                    //return data out of from loop

	}
	
	//create Excel 
	@BeforeClass
	public void createExcel() throws IOException {
		File f=new File("./Excel/Login.xlsx");
		 Workbook book=new XSSFWorkbook(); //downcasting
		 Sheet sh=book.createSheet("sheet1");
		 Row row = sh.createRow(0);
		 Row row1 = sh.createRow(1);
		 Row row2 = sh.createRow(2);
		 Row row3 = sh.createRow(3);
		 Row row4 = sh.createRow(4);
		 Cell c1 = row.createCell(0);
		 Cell c2 = row.createCell(1);
		c1.setCellValue("EmailId");
		 c2.setCellValue("Password");
		 
		 //row1  //email password correct
		 Cell c3 = row1.createCell(0);
		 Cell c4 = row1.createCell(1);
		 c3.setCellValue("divya123@gmail.com");
		 c4.setCellValue("divya&12D");
		 
		//row2 //valid email invalid password 
		 Cell c5= row2.createCell(0);
		 Cell c6 = row2.createCell(1);
		 c5.setCellValue("divya123@gmail.com");
		 c6.setCellValue("divya2D");
		 
		//row3  //invalid email valid password 
		 Cell c7 = row3.createCell(0);
		 Cell c8 = row3.createCell(1);
		 c7.setCellValue("divya@gmail.com");
		  c8.setCellValue("divya&12D");
		 
		//row4  //email password incorrect
		 Cell c9 = row4.createCell(0);
		 Cell c10 = row4.createCell(1);
		 c9.setCellValue("divya@gmail.com");
		 c10.setCellValue("divya");
		  
		 //output file
		 FileOutputStream fout=new FileOutputStream(f);
		 book.write(fout);
		 System.out.println("Excel Created Successfully");
		
	}

	//Login Method datas are getting from dataprovider
	@Test(dataProvider="Login")
	public void Login(String email,String password) throws IOException, InterruptedException {
		
		extReport("./Report/LoginReport.html");
		ExtentTest open=extent.createTest("TC-003-OpenBrowser");
		open.log(Status.INFO, "Launch Browser");

		setUpChrome("https://www.tnsports.org.in/webapp/login.aspx");  //Driver Methods from GeenricsMethod class
		open.log(Status.PASS, "Open Browser Successfully");
		
		pomClass();
		//PageFactory.initElements(PomClass.driver, PomClass.class);
		popClose.click();                               //selctors are passed by POMClass
		
		ExtentTest datas=extent.createTest("TC-004-Login");
		datas.log(Status.INFO, "MulipleDatas are passed through Apachepoi and DataProvider");

		username.sendKeys(email);                      //sendkeys value are passed through the login constuctor
		datas.log(Status.PASS, "Email Entered Successfully ");
		
		pass.sendKeys(password);
		datas.log(Status.PASS, "Passsword Entered Successfully");

		login.click();	
		datas.log(Status.PASS, " Login Button Clicked Successfully ");
		
		
		//screenshot
		Thread.sleep(2000);
		screenShot("./login.png");
		datas.pass("Logged Suucessfully", MediaEntityBuilder.createScreenCaptureFromPath("./login.png").build());
		//datas.addScreenCaptureFromPath("./instagram.png");
		
		flush();
//		quit();
	}
	
	
	

}


