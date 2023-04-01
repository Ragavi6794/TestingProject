package org.youthwelfaresportsdevelopment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;


import org.pomframework.PomClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class MultistepDetails extends PomClass{
	//DataDriven framework using valid login details with multistep details

	@DataProvider(name="Login")
	//dataprovider have 2D Array
	public String[][] getData() {

		String[][] data=new String[1][2];
		data[0][0]="leka@gmail.com";
		//valid username
		data[0][1]="Leka@1234"; 
				
			 
		//valid password

		return data;
	}


	@Test(dataProvider="Login")
	public void Login(String email,String password) throws IOException, InterruptedException, AWTException {

		extReport("./Report/LoginReport.html");
		ExtentTest open=extent.createTest("TC-005-OpenBrowser");
		open.log(Status.INFO, "Launch Browser");

		setUpChrome("https://www.tnsports.org.in/webapp/login.aspx");  //Driver Methods from GeenricsMethod class
		open.log(Status.PASS, "Open Browser Successfully");

		pomClass();
		//PageFactory.initElements(PomClass.driver, PomClass.class);
		popClose.click();                               //selctors are passed by POMClass

		ExtentTest datas=extent.createTest("TC-006-Login");
		datas.log(Status.INFO, "Mulipledocument are passed through Apachepoi and DataProvider");

		username.sendKeys(email);                      //sendkeys value are passed through the login constuctor
		datas.log(Status.PASS, "Email Entered Successfully ");

		pass.sendKeys(password);
		datas.log(Status.PASS, "Passsword Entered Successfully");

		login.click();	
		datas.log(Status.PASS, " Login Button Clicked Successfully ");
		
		

//1.Personal Details

		//MultiStep Details
		//        fatherName.sendKeys("ArunPrasanth");
		//        document.log(Status.PASS, "Father Name Enterd Successfully");
		//        
		//        motherName.sendKeys("Monika");
		//        document.log(Status.PASS, "Mother Name Enterd Successfully");
//		aadharUpdate.sendKeys("7849934939292078");  //aadhar no updated
//		submit.click();   //submit button click
//		ok.click();       //ok click
        
		save.click();
		datas.log(Status.PASS, "Save And Continue Button Clicked Successfully");
		Thread.sleep(3000);

		//        ok.click();
//2.Documents Details
//passport
		ExtentTest document=extent.createTest("TC-007-Documents Uploaded");
		passportNo.sendKeys("769383290");

		passport.click();

		//      Robot class
		fileUpLoaded("C:\\Users\\splpt777\\Pictures\\noc2.jpg");
		Thread.sleep(3000);
		ok.click();
		document.log(Status.PASS, "Passport Attached Successfully");

//aadhar
		aadharattach.click();
		//      Robot class
		fileUpLoaded("C:\\Users\\splpt777\\Pictures\\noc2.jpg");
		Thread.sleep(3000);
		ok.click();
		document.log(Status.PASS, "AAdhar Attached Successfully");
//Voterid
		voterId.sendKeys("WHL00123");
		voterIdAttach.click();
		//      Robot class
		fileUpLoaded("C:\\Users\\splpt777\\Pictures\\noc2.jpg");
		Thread.sleep(3000);
		ok.click();
		document.log(Status.PASS, "VoterId Attached Successfully");
 //birth certificate
		birth.click();
		fileUpLoaded("C:\\Users\\splpt777\\Pictures\\noc2.jpg");
		Thread.sleep(3000);
		ok.click();
		document.log(Status.PASS, "BirthCertificate Attached Successfully");

//ssc 
		ssc.click();
		fileUpLoaded("C:\\Users\\splpt777\\Pictures\\noc2.jpg");
		Thread.sleep(3000);
		ok.click();
		document.log(Status.PASS, "SSC Certificate Uploaded Successfully");

 //bonafide
		bonafide.click();
		fileUpLoaded("C:\\Users\\splpt777\\Pictures\\noc2.jpg");
		Thread.sleep(3000);
		ok.click();
		document.log(Status.PASS, "Bonafide Certificate Attached Successfully");

//pancard
		pancardNo.sendKeys("EHP0092982");
		pancard.click();
		fileUpLoaded("C:\\Users\\splpt777\\Pictures\\noc2.jpg");
		Thread.sleep(3000);
		ok.click();
		document.log(Status.PASS, "PanCard Attached Successfully");

//bank no
		bank.sendKeys("10009384484");
		document.log(Status.PASS, "Bank No Entered Successfully");
	    bankName.sendKeys("IndianOverseasBank");
	    document.log(Status.PASS, "Bank Name Entered Successfully");
	    ifsc.sendKeys("IOBA00193");
	    document.log(Status.PASS, "IFSC No Entered Successfully");
	    
	    cheque.click();
	    fileUpLoaded("C:\\Users\\splpt777\\Pictures\\noc2.jpg");
	    Thread.sleep(3000);
		ok.click();
		  document.log(Status.PASS, "Cancelled Checque photo uploaded Successfully");
		    
		save.click();Thread.sleep(3000);
		ok.click(); Thread.sleep(3000);
		document.log(Status.PASS, "Documents Are Uploaded Successfully");
		
//3.Medical Information		
		//ExtentTest medical=extent.createTest("TC-008-Medical Information");
		weight.sendKeys("53");
		//medical.log(Status.PASS, "Weight data passed Successfully");
		height.sendKeys("600");
		//medical.log(Status.PASS, "Heigth data passed Successfully");
		bg.click();
		//medical.log(Status.PASS, "Blood group selected Successfully");
		mole.sendKeys("left side head");Thread.sleep(3000);
		//medical.log(Status.PASS, "Mole data passed Successfully");
		scar.sendKeys("left side Leg");Thread.sleep(3000);
		//medical.log(Status.PASS, "Scar data passed Successfully");
		
		save.click();
		ok.click();
		//medical.log(Status.PASS, "Medical Data Are passed Successfully");
		
//4.Education Details
		//ExtentTest educational=extent.createTest("TC-009-Educational Information");
//		instituteType.click();
//		//educational.log(Status.PASS, "Institute Type Successfully");
//		
//		instituteName.sendKeys("pashmi Institue");
//		//educational.log(Status.PASS, "Institute Name passed Successfully");
//		
//		year.sendKeys("2022");
//		//educational.log(Status.PASS, "Year passed Successfully");
//		
//		sem.sendKeys("6th sem");
//		//educational.log(Status.PASS, "Semester details passed Successfully");
//		
//		address1.sendKeys("Womens Polytechnic street");
//		//educational.log(Status.PASS, "Address1 passed Successfully");
//		
//		address2.sendKeys("Rajaji street");
//		///educational.log(Status.PASS, "Address2 passed Successfully");
//		
//		city.sendKeys("Coimbatore");
//		//educational.log(Status.PASS, "City name passed Successfully");
//		
//		pincode.sendKeys("638403");
//		//educational.log(Status.PASS, "pincode passed Successfully");
//		
//		insPhone.sendKeys("044-234568");
//		//educational.log(Status.PASS, "Institute PhoneNo passed Successfully");
//		
//		insMailId.sendKeys("pashmi@gmail.com");
//		//educational.log(Status.PASS, "Institue MailID passed Successfully");
//		
//		employment.sendKeys("yes");
//		//educational.log(Status.PASS, "Employment details passed Successfully");
//	
		save.click();
		ok.click();Thread.sleep(3000);
		//educational.log(Status.PASS, "Educational Details Are passed Successfully");
		
//5.Sports Achievements
		
		save.click();
		ok.click();Thread.sleep(3000);
		
//6.HealthIssues
		
		illness.click();
		injection.click();
		
		select.click();
		
		submitted.click();  //final click 
		ok.click();Thread.sleep(3000);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//screenshot
		Thread.sleep(2000);
		screenShot("./multistep.png");
		document.pass("Logged Suucessfully", MediaEntityBuilder.createScreenCaptureFromPath("./multistep.png").build());
		//document.addScreenCaptureFromPath("./instagram.png");

		flush();
		//		quit();
	}

}




//Robot r = new Robot();
//Thread.sleep(2000);
//// copying File path to Clipboard
//	StringSelection ss=new StringSelection("C:\\Users\\splpt777\\Pictures\\noc2.jpg"); //convert data transfer into plaintext
//	Thread.sleep(2000);
//	//we have to get that plain text file then copy to clipboard
//	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//	Thread.sleep(2000);
//	//Robot class used to paste the copy value into file upload 
//	// press Contol+V for pasting
//	Thread.sleep(2000);
//  r.keyPress(KeyEvent.VK_CONTROL);
//  r.keyPress(KeyEvent.VK_V);
//
// // release Contol+V for pasting
// r.keyRelease(KeyEvent.VK_CONTROL);
// r.keyRelease(KeyEvent.VK_V);
//Thread.sleep(2000);
// // for pressing and releasing Enter
// r.keyPress(KeyEvent.VK_ENTER);
// r.keyRelease(KeyEvent.VK_ENTER);
//	
