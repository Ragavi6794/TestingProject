package org.pomframework;

import org.baseclass.GenericMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomClass extends GenericMethods {
 
	public void pomClass() {   //constructor 
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(PomClass.driver, PomClass.class);
	}
	
	//locators for Login
	@FindBy(xpath="//*[@id=\"myModal\"]/div/div/div[1]/button")
	public static WebElement popClose;
	
	@FindBy(id="aadhaar")
	public static WebElement username;
	
	@FindBy(id="user_password")
	public static WebElement pass;
	
	@FindBy(id="loginBtn")
	public static WebElement login;
	
	//locators for Registration
	
	//popclose used

	@FindBy(xpath="//*[@id=\"form\"]/div[4]/div/div/div/div[1]/div[5]/a")
	public static WebElement registerlink;
	
	@FindBy(id="name")
	public static WebElement Name;
	
	@FindBy(id="mobNumber")
	public static WebElement mobile;
	
	@FindBy(id="emailAddress")
	public static WebElement emailAddress;

	@FindBy(id="address_l1")
	public static WebElement doorNo;
	
	@FindBy(id="address_l2")
	public static WebElement streetName;
	
	@FindBy(id="address_l3")
	public static WebElement placeName;
	
	@FindBy(id="city_town_vlg")
	public static WebElement cityName;
	
	//bootstrap dropdown
	@FindBy(xpath="//*[@id=\"district\"]/option[9]")
	public static WebElement district;
	
	@FindBy(xpath="//*[@id=\"mla_const\"]/option[5]")
	public static WebElement mla;
	
	@FindBy(xpath="//*[@id=\"mp_const\"]/option[3]")
	public static WebElement mp;
	
	@FindBy(xpath="//*[@id=\"taluk\"]/option[4]")
	public static WebElement taluk;
	
	@FindBy(id="landmark")
	public static WebElement land;
	
	@FindBy(id="pincode")
	public static WebElement pin;
	
	@FindBy(id="aadhaarNumber")
	public static WebElement aadhar;
	
	@FindBy(id="dob")  //action sendkey
	public static WebElement dateOfBirth;
	
	//radio button
	@FindBy(xpath="//*[@id=\"booking\"]/div/div/div/div/div[17]/div/div/div/label[2]/span")
	public static WebElement gender;
	
	@FindBy(xpath="//*[@id=\"booking\"]/div/div/div/div/div[18]/div/div/div/label[2]/span")
    public static WebElement student;
	
	@FindBy(xpath="//*[@id=\"category\"]/option[2]")
	public static WebElement category;
	
	@FindBy(xpath="//*[@id=\"booking\"]/div/div/div/div/div[24]/div/div/div/label[1]/span")
	public static WebElement tournament;
	
	@FindBy(xpath="//*[@id=\"booking\"]/div/div/div/div/div[25]/div/div/div/label[1]/span")
	public static WebElement volunteer;
	
	@FindBy(xpath="//*[@id=\"booking\"]/div/div/div/div/div[27]/div/div/div/label[1]/span")
	public static WebElement abled;
	
	@FindBy(xpath="//*[@id=\"interest_game\"]/option[3]")
	public static WebElement discipline;
	
	@FindBy(id="password")
	public static WebElement passWord;
	
	@FindBy(xpath="//*[@id=\"booking\"]/div/div/div/div/div[31]")
	public static WebElement outerPage;
	
	@FindBy(xpath="//*[@id=\"register\"]")
	public static WebElement register;
	
	
	@FindBy(id="aadhaar_no")
	public static WebElement aadharUpdate;
	
	@FindBy(xpath="/html/body/div/div[2]/div/div/div/div/div/div/div/div[4]/button")
	public static WebElement submit;
	
	//Multistep Details
	
	@FindBy(id="father_name")    //fathername
	public static WebElement fatherName;
	
	@FindBy(id="mother_name")    //mothername
	public static WebElement motherName;
	
	@FindBy(id="continue")
	public static WebElement save;
//2.Documents	
	//passport
	@FindBy(id="passport_no")
	public static WebElement passportNo;
	
	@FindBy(id="passport_atch")
	public static WebElement passport;
	
	@FindBy(xpath="/html/body/div[2]/div/div[4]/div/button")
	public static WebElement ok;  //reusable
	
	//aadhar attach
	@FindBy(id="aadhaar_atch")
	public static WebElement aadharattach;
	
	//proofno voterid
	@FindBy(id="proof_number")
	public static WebElement voterId;
	
	@FindBy(id="address_proof_atch")
	public static WebElement voterIdAttach;
	
	//birthcertificate
	@FindBy(id="birth_certificate_atch")
    public static WebElement birth;
	
	@FindBy(id="ssc_atch")
	public static WebElement ssc;

	@FindBy(id="bonafide_atch")
	public static WebElement bonafide;
	
	@FindBy(id="pancard_no")
	public static WebElement pancardNo;
	
	@FindBy(id="pancard_atch")
	public static WebElement pancard;
	
	@FindBy(id="bank_acc_no")
	public static WebElement bank;
	
	@FindBy(id="bank_name")
	public static WebElement bankName;
	
	@FindBy(id="ifsc")
	public static WebElement ifsc;
	
	@FindBy(id="cheque_atch")
	public static WebElement cheque;
	
	//svae&Continue button used here
	//ok reused
	
//3.Medical Info
	@FindBy(id="weight")
	public static WebElement weight;
	
	@FindBy(id="height")
	public static WebElement height;
	
	@FindBy(id="bmi")
	public static WebElement bmi; //readonly
	
	@FindBy(xpath="//*[@id=\"blood_group\"]/option[2]")
	public static WebElement bg;
	
	@FindBy(id="mole_identity")
	public static WebElement mole;
	
	@FindBy(id="scar_identity")
	public static WebElement scar;
	
	//$.Education Details
	@FindBy(xpath="//*[@id=\"institution_type\"]/option[2]")
	public static WebElement instituteType;
	
	@FindBy(id="insti_name")
	public static WebElement instituteName;
	
	@FindBy(id="class_year")
	public static WebElement year;
	
	@FindBy(id="section_semester")
	public static WebElement sem;
	
	@FindBy(id="insti_address_l1")
	public static WebElement address1;
	
	@FindBy(id="insti_address_l2")
	public static WebElement address2;
	
	@FindBy(id="city")
	public static WebElement city;
	
	
	@FindBy(id="pincode")
	public static WebElement pincode;
	
	@FindBy(id="insti_ph_no")
	public static WebElement insPhone;
	
	@FindBy(id="insti_mail_id")
	public static WebElement insMailId;
	
	@FindBy(id="employment")
	public static WebElement employment;
	
	//5.sports achievements
	//no inputd
//6.Health
	@FindBy(xpath="//*[@id=\"illness_no\"]")
	public static WebElement illness;
	
	@FindBy(xpath="//*[@id=\"medication_no\"]")
	public static WebElement injection;
	
	@FindBy(xpath="//*[@id=\"form\"]/div[4]/div[2]/div[6]/div[2]")
	public static WebElement select;
	
	
	@FindBy(xpath="//*[@id=\"submit\"]")
	public static WebElement submitted;
}
	
	
	
	
	
