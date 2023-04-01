package org.baseclass;
 //java packages
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


//apache packages
import org.apache.commons.io.FileUtils;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//selenium packaegs
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//aventstack packages
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//webdriver
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass  {

	public static WebDriver driver ;   //interface
	public static Alert a;             //class
	public static Actions ac;          //class
	public static Action act;          //class
	public static Robot r;             //class
	public static Select s;            //class
	public static JavascriptExecutor js; //interface
	public static TakesScreenshot tk;  //interface
	public static Wait wait;             //class
	public static ExtentSparkReporter report;  //HTML report
	public static ExtentReports extent;   //extent report


	static long timeOuts=2000;
	static long maxWaitTime=2000;

	//launchBrowser types
	//ChromeBrowser
	public static void chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		
	}
	//firefox
	public static void firefoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		
		
	}
	//edge browser
	public static void edgeBrowser() {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		
		
	}
	//launchBrowser types
		//ChromeBrowser
	public static void setUpChrome(String Url) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeOuts, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println("WebSite Title:" +title);
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Website CurrentUrl:" +currentUrl);
		wait=new WebDriverWait(driver,maxWaitTime);
	}

	//Firefox browser
	public static void setUpFirefox(String Url) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeOuts, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println("WebSite Title:" +title);
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Website CurrentUrl:" +currentUrl);
		wait = new WebDriverWait(driver,maxWaitTime);

	}

	//Internet Explorer
	public static void setUpIE(String Url) {
		WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeOuts, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println("WebSite Title:" +title);
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Website CurrentUrl:" +currentUrl);
	}

	//Edge
	public static void setUpEdge(String Url) {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeOuts, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println("WebSite Title:" +title);
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Website CurrentUrl:" +currentUrl);
	}
	
	//chrome http websocket problem is cleared
		public void Chrome(String Url) {
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver(co);
		 driver.get(Url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(timeOuts, TimeUnit.SECONDS);
			String title = driver.getTitle();
			System.out.println("WebSite Title:" +title);
			String currentUrl = driver.getCurrentUrl();
			System.out.println("Website CurrentUrl:" +currentUrl);
			wait=new WebDriverWait(driver,maxWaitTime);
		 }
		
		
		//multiple browsers 
		public void setUp(String browserName, String url) {
			switch (browserName) {  //chnage jre version ctrl +1
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
			default :
				System.out.println("Driver Not defined");
				break;
			}
			driver.manage().window().maximize(); 
			driver.manage().timeouts().implicitlyWait(timeOuts, TimeUnit.SECONDS);
			driver.get(url);
			wait=new WebDriverWait(driver,maxWaitTime);
		}

		
		
//		webdriver methods
		public static void getUrl(String Url) {
			driver.manage().window().maximize();
			String title = driver.getTitle();
			System.out.println("WebSite Title:" +title);
			String currentUrl = driver.getCurrentUrl();
			System.out.println("Website CurrentUrl:" +currentUrl);
			wait=new WebDriverWait(driver,maxWaitTime);
		}
		
		
		
		
	//webdriver methods
	//load Url passed arguments
	public static void loadUrl(String Url) {  
		driver.get(Url);
	}
	//maximize window
	public static void maximize() {
		driver.manage().window().maximize();
	}
	//getTitle()
	public static String getTitle() {
		String title = driver.getTitle();
		System.out.println("WebSite Title:" +title);
//		if(title.contains(text)) {
//			System.out.println("Browser Successfully launched");
//		
//		}
		return title;
	}
	//current page url
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Website CurrentUrl:" +currentUrl);
		return currentUrl;
	}
	//cookie
	public static String getCookie() {
		driver.manage().getCookies();
		return null;
	}
	public static String deleteAllCookie() {
		driver.manage().deleteAllCookies();
		return null;
	}
	//quit
	public static void quit() {  
		driver.quit();
	}
	//close
	public static void close() {  
		driver.close();
	}
	//navigateBack
	public static void navigateBack() {
		driver.navigate().back();
	}
	//navigateBack
	public static void navigateForward() {
		driver.navigate().forward();
	}
	//navigateBack
	public static void navigateRefresh() {
		driver.navigate().refresh();
	}
	//navigate url
	public static void navigateTo(String Url) {
		driver.navigate().to(Url);
	}

	//locators webelements
	//its return WebElement to get a Text of webelement 
	public static WebElement findBy(String type, String value) {
		try {
			switch(type) {
			//id Selector
			case "id":
				return driver.findElement(By.id(value));

				//name selector
			case "name":
				return driver.findElement(By.name(value));

				//xpath selector
			case "xpath":
				return driver.findElement(By.xpath(value));

				//link selector
			case "link":
				return driver.findElement(By.linkText(value));

				//partrial selector
			case "partiallink":
				return driver.findElement(By.partialLinkText(value));

				//classname selector
			case "classname":
				return driver.findElement(By.className(value));

				//CSS selector
			case "css":
				return driver.findElement(By.cssSelector(value));

			default:
				System.out.println("Loactors not correctly");
				break;
			}
		}catch (NoSuchElementException e) {
			System.err.println("Element not found => "+e.getMessage());
			throw new NoSuchElementException("Element not found");
		}catch(WebDriverException e) {
			System.err.println(e.getMessage());
			throw new WebDriverException("Some unknown webdriver error");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	//webelements methods
	//sendkeys
	public static void sendkeys(WebElement element,String text) {
		element.sendKeys(text);
		wait = new WebDriverWait(driver,maxWaitTime);
	}
	//click
	public static void click(WebElement element) {
		element.click();
		wait = new WebDriverWait(driver,maxWaitTime);
	}
	//submit
	public static void submit(WebElement element) {
		element.submit();
		wait = new WebDriverWait(driver,maxWaitTime);
	}

	//clear
	public static void clear(WebElement element) {
		element.clear();
		wait = new WebDriverWait(driver,maxWaitTime);
	}
	//webelements Methods
	//To getAttribute id ="pass"  =>o/p =>pass
	public static String getAttributeName(WebElement element,String name) {
		String attributeName = element.getAttribute(name);
		System.out.println("Attribute Name:" +attributeName);
		return attributeName;
	}
	//To getAttribute value = id="pass"  => Enter Password
	public static String getAttributeValue(WebElement element,String value) {
		String attValue = element.getAttribute(value);
		System.out.println("Attribute Value:" +attValue);
		return attValue;

	}
	//To getTagName => input
	public static String getTagName(WebElement element) {
		String tagName = element.getTagName();
		System.out.println("TagName:" +tagName);
		return tagName;
	}
	//To getText()
	public static String getText(WebElement element) {
		String getText = element.getText();
		System.out.println("Get Text" +getText);
		return getText;
	}
	//isDisplayed
	public static boolean displayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println("Displayed" +displayed);
		return displayed;

	}
	//isEnabled
	public static boolean enabled(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println("Enabled" +enabled);
		return enabled;
	}
	//isSelected
	public static boolean selected(WebElement element) {
		boolean selected = element.isSelected();
		System.out.println("Selected" +selected);
		return selected;
	}
	//getLocation
	public static Point getLoacation(WebElement element) {
		Point location = element.getLocation();
		System.out.println("Location" +location);
		return location;
	}

	//Alert Methods
	//Alert a=driver.switchTo().alert();

	public static void alert() {
		driver.switchTo().alert();
	}
	public static void accept() {   //accept
		driver.switchTo().alert();
		a.accept();
		wait = new WebDriverWait(driver,maxWaitTime);
	}

	public static void dismiss() { //dismiss
		driver.switchTo().alert();
		a.dismiss();
		wait = new WebDriverWait(driver,maxWaitTime);
	}
	public static void sendkeyAlert(WebElement element,String text) {
		driver.switchTo().alert();
		a.sendKeys(text);
		wait = new WebDriverWait(driver,maxWaitTime);
	}

	public static String getText() {
		String text1 = a.getText();
		System.out.println(text1);
		return text1;
	}

	//Actions class is used to perform mouse operations
	//Actions ac=new Actions(driver);    
	public static void action() {
		ac=new Actions(driver);
		wait = new WebDriverWait(driver,maxWaitTime);
	}

	//moveToElement
	public static void moveToElement(WebElement element) {

		ac=new Actions(driver);
		ac.moveToElement(element).perform();
		wait = new WebDriverWait(driver,maxWaitTime);
	}

	//dragAndDrop
	public static void dragAndDrop(WebElement src,WebElement des) {

		ac=new Actions(driver);
		ac.dragAndDrop(src, des).perform();
		wait = new WebDriverWait(driver,maxWaitTime);
	}

	//contextClick
	public static void rightClick(WebElement element) {

		ac=new Actions(driver);
		ac.contextClick(element).perform();
		wait = new WebDriverWait(driver,maxWaitTime);
	}
	//doubleClick
	public static void doubleClick(WebElement element) {

		ac=new Actions(driver);
		ac.doubleClick(element).perform();
		wait = new WebDriverWait(driver,maxWaitTime);
	}
	//clickAndHold
	public static void clickAndHold(WebElement element) {

		ac=new Actions(driver);
		ac.clickAndHold(element).perform();
		wait = new WebDriverWait(driver,maxWaitTime);
	}

	//sendKeys with element 
	public static void actionSendKey(WebElement element,String text) {
		ac=new Actions(driver);
		ac.sendKeys(element, text).perform();
		wait = new WebDriverWait(driver,maxWaitTime);
	}
	
	//WebElement date = driver.findElement(By.id("dob"));
//	   Actions a=new Actions(driver);
//	   a.sendKeys(date,"22-3-2000").perform();
	//Keyboard methods
	public static void ctrlA(){
		ac =new Actions(driver);
		//ac.sendKeys(Keys.ENTER).perform();
		//Ctrl+A 
		ac.keyDown(Keys.CONTROL); //keypress
		ac.sendKeys("a");
		ac.keyUp(Keys.CONTROL);  //keyrelease
		ac.perform();

	}

	//Ctrl+C
	public static void ctrlC(){
		ac.keyDown(Keys.CONTROL);
		ac.sendKeys("c");
		ac.keyUp(Keys.CONTROL);
		ac.perform();
	}	

	//Ctrl+V
	public static void ctrlV(){
		ac.keyDown(Keys.CONTROL);
		ac.sendKeys("v");
		ac.keyUp(Keys.CONTROL);
		ac.perform();
	}



	//Robot Class
	//Robot r=new Robot();  //handled window applications keyboard operations
	public static void robot() throws AWTException {
		r=new Robot();
	}

	//FileUploaded copy file path 
	public static void fileUpload(String path) {  //string file path
		StringSelection ss=new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		//Ctrl+v  it paste into system
		//Ctrl+enter
	}



	public static void fileUploaded(String path) throws AWTException {

		// creating object of Robot class
		Robot r = new Robot();

		// copying File path to Clipboard
		StringSelection ss=new StringSelection(path); //convert data transfer into plaintext
		//we have to get that plain text file then copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		//Robot class used to paste the copy value into file upload 
		// press Contol+V for pasting
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		// release Contol+V for pasting
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);

		// for pressing and releasing Enter
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		//now the file will be uploaded
	}


	//Download File
	public static void downloadFile(String value,String path, String text) {  //text is Test.png  =>file name text
		driver.findElement(By.xpath(value)).click();
		//check file is download ornot
		File location=new File(path);
		File[] listFiles = location.listFiles();
		for(File f:listFiles) {
			if(f.getName().equals(text)) {
				System.out.println("File is Downloaded Successfully");
				break;
			}
		}
	}


	//enter keyboard actions
	public static void enter() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		wait = new WebDriverWait(driver,maxWaitTime);
	}
	//up
	public static void up() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
		wait = new WebDriverWait(driver,maxWaitTime);
	}
	//down
	public static void down() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		wait = new WebDriverWait(driver,maxWaitTime);
	}
	//copy
	public static void copy() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
		wait = new WebDriverWait(driver,maxWaitTime);
	}
	//paste
	public static void paste() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		wait = new WebDriverWait(driver,maxWaitTime);
	}



	//Select class for Dropdown
	//Select s=new Select(element)

	public static void select(WebElement element) {
		s =new Select(element);
	}

	//selected by index
	public static void selectIndex(int index, WebElement element) {
		s =new Select(element);
		s.selectByIndex(index);
	}

	//selected by value
	public static void selectValue(WebElement element,String value) {
		s =new Select(element);
		s.selectByValue(value);
	}

	//selectedbyvisibletext
	public static void selectText(WebElement element,String text) {
		s =new Select(element);
		s.selectByVisibleText(text);
	}

	//if check is multiple or not
	public static boolean isMultiple() {
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
		return multiple;
	}

	//getalloptions in dropdown
	public static String getOptions(WebElement element) {
		s =new Select(element);
		List<WebElement> options = s.getOptions();
		for(WebElement opt:options) {
			System.out.println("List of WebElement"+opt.getText());
		}
		return null;
	}


	//get only selected options
	public static void getAllSelectedOptions(WebElement element) {
		s =new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		wait = new WebDriverWait(driver,maxWaitTime);
		for(WebElement select:allSelectedOptions) {
			System.out.println("AllSelectedOptions:" +select.getText());
		}
	}


	//get first selected option
	public static String getFirstSelectedOption(WebElement element) {
		s =new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		wait = new WebDriverWait(driver,maxWaitTime);
		System.out.println(firstSelectedOption);
		return null;
	}

	//deselected based on index
	public static void deselectByindex( WebElement element,int index) {
		s =new Select(element);
		s.deselectByIndex(index);
	}
	//deselect based on value
	public static void deselectByValue(WebElement element,String text ) {
		s =new Select(element);
		s.deselectByValue(text);
	}
	//deselect based on visibletext
	public static void deselectByVisibleText( WebElement element,String text) {
		s =new Select(element);
		s.deselectByVisibleText(text);
	}

	//deselect all
	public static void deselectAll(WebElement element) {
		s =new Select(element);
		s.deselectAll();
	}

	//TakesScreenshots tk=(TakesScreenshots)driver;

	public static void screenShot(String path) throws IOException {
		tk=(TakesScreenshot)driver;
		wait = new WebDriverWait(driver,maxWaitTime);
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des=new File(path);
		wait = new WebDriverWait(driver,maxWaitTime);
		FileUtils.copyFile(src, des);

		//FileHandler.copy(src, des);
	}

	//takescreenshot for particular element
	public static void screenShotElement(WebElement ele,String path) throws IOException {
		tk=(TakesScreenshot)driver;
		wait = new WebDriverWait(driver,maxWaitTime);
		File src = ele.getScreenshotAs(OutputType.FILE);
		File des=new File(path);
		wait = new WebDriverWait(driver,maxWaitTime);
		FileUtils.copyFile(src, des);

		//FileHandler.copy(src, des);
	}



	//JavascriptExecutor js=(JavaScriptExecutor)driver;

	public static void jsExecutor() {
		js=(JavascriptExecutor)driver;
	}
	//scrollup

	public static void scrollUp(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
		wait = new WebDriverWait(driver,maxWaitTime);

	}
	//scrolldown
	public static void scrollDown(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
		wait = new WebDriverWait(driver,maxWaitTime);
	}

	//scrolltop
	public static void scrollToTop() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,0)");
		wait = new WebDriverWait(driver,maxWaitTime);
	}
	//light scrolldown
	public static void scrollNext() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,1000)"); 
		wait = new WebDriverWait(driver,maxWaitTime);
	}
	//scrollToendscreenDown
	public static void scrollToDown() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		wait = new WebDriverWait(driver,maxWaitTime);
	}
	//getAttributes
	public static void getAttribute(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("return arguments[0].getAttribute('value')",element); 
		wait = new WebDriverWait(driver,maxWaitTime);
	}
	//sendkey replacement
	public static void setAttribute(WebElement element,String text) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].SetAttribute('value',text)",element); 
		wait = new WebDriverWait(driver,maxWaitTime);
	}

	//click replacement
	public static void jsClick(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",element);     
		wait = new WebDriverWait(driver,maxWaitTime);
	}

	//draw border injs
	public static void drawBorder(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'",element); 
		wait = new WebDriverWait(driver,maxWaitTime);
	}
	//refresh
	public static void jsRefresh() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("history.go(0)");  
		wait = new WebDriverWait(driver,maxWaitTime);
	}
	//reload
	public static void reload() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("location.reload()"); 
		wait = new WebDriverWait(driver,maxWaitTime);
	}
	//return website title js
	public static String title() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String sText =  js.executeScript("return document.title").toString();
		System.out.println(sText);
		wait = new WebDriverWait(driver,maxWaitTime);
		return sText;

	}

	//Frames
	//driver.switchTo().frames()
	//Index based
	public static void frameIndex(int index) {
		driver.switchTo().frame(index);
		wait = new WebDriverWait(driver,maxWaitTime);
	}
	//id based
	public static void frameId(String id) {
		driver.switchTo().frame(id);
		wait = new WebDriverWait(driver,maxWaitTime);
	}

	//frame name
	public static void frameName(String name) {
		driver.switchTo().frame(name);
		wait = new WebDriverWait(driver,maxWaitTime);
	}

	//frame webelement
	public static void frameWebElement(WebElement element) {
		driver.switchTo().frame(element);
		wait = new WebDriverWait(driver,maxWaitTime);
	}

	//swith to parent frame
	public static void frameParent() {
		driver.switchTo().parentFrame();
		wait = new WebDriverWait(driver,maxWaitTime);
	}

	//out from frame to Html default content
	public static void frameOut() {
		driver.switchTo().defaultContent();
		wait = new WebDriverWait(driver,maxWaitTime);
	}

	//frame size
	public static int frameSize() {
		List<WebElement> findElements = driver.findElements(By.tagName("iframe"));
		int size = findElements.size();
		System.out.println("No of Frames in Windows:" +size);
		return size;
	}

	//Window Handles
	//windowTitle

	public static void window(int i) {
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(windowHandles);
		wait = new WebDriverWait(driver,maxWaitTime);
		driver.switchTo().window(list.get(i));
		wait = new WebDriverWait(driver,maxWaitTime);
	}

	//windows 
	public static void switchWindows() {
		Set<String> windowHandles = driver.getWindowHandles();
		for(String w:windowHandles) {
			driver.switchTo().window(w);
		}
	}

	//parent 
	public static void parentWindow()
	{
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		wait = new WebDriverWait(driver,maxWaitTime);
		for(String w:windowHandles) {
			if(w.equals(windowHandle)) {
				driver.switchTo().window(w);
			}

		}
		wait = new WebDriverWait(driver,maxWaitTime);
	}


	//childwindow

	public static void childWindow()
	{
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		wait = new WebDriverWait(driver,maxWaitTime);
		for(String w:windowHandles) {
			if(!w.equals(windowHandle)) {
				driver.switchTo().window(w);
			}

		}
		wait = new WebDriverWait(driver,maxWaitTime);
	}
	public static String windowTitle(String title) {
		driver.switchTo().window(title);
		wait = new WebDriverWait(driver,maxWaitTime);
		return title;
	}
	//windows id
	public static String windowsId(String windowsid) {
		driver.switchTo().window(windowsid);
		return windowsid;
	}
	//parent window id
	public static String windowHandle() {
		String windowHandle = driver.getWindowHandle();
		System.out.println("Parent Window Id:" +windowHandle);
		return windowHandle;
	}
	//parent and child window id
	public static String windowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Parent+Child:" +windowHandles);
		return null;
	}

	//window size
	public static int windowSize() {
		int size = driver.getWindowHandles().size();
		System.out.println("Window Size"+size);
		return size;
	}



	//waits
	public static void wait(int num) throws InterruptedException {
		Thread.sleep(num);
	}
	public static void implicitWait(Integer num,TimeUnit text) {
		driver.manage().timeouts().implicitlyWait(num, text);
	}


	//authenticated popup
	public static void popAuth() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
	}

	//WebTable
	//How many rows in table
	public static int rows(String value) {
		List<WebElement> rows = driver.findElements(By.xpath(value));
		int rowsize = rows.size();  //no of rows in webtable
		System.out.println("No of Rows:" +rowsize);
		return rowsize;
	}

	//How many columns in table
	public static int columns(String value) {
		List<WebElement> columns = driver.findElements(By.xpath(value));
		int columnsize = columns.size();  //no of columns
		System.out.println("No of Columns:" +columnsize);
		return columnsize;
	}

	//how to retrieve specific data (RC)=>ROW-COLUMN xpath
	public static String specificData(String value) {
		WebElement specific = driver.findElement(By.xpath(value));
		String text = specific.getText();
		System.out.println("The Value is:" +text);
		return text;
	}

	//get all datas 
	public static void tableData(String value){
		List<WebElement> rows = driver.findElements(By.xpath(value));
		int rowsize = rows.size();  //no of rows in webtable
		for (int row = 0; row < rowsize; row++) {
			//To locate columns(cells) of that specific row.
			List < WebElement > Columns_row = rows.get(row).findElements(By.tagName("td"));

			//To calculate no of columns (cells). In that specific row.
			int columns_count = Columns_row.size();
			System.out.println("Number of cells In Row " + row + " are " + columns_count);

			//Loop will execute till the last cell of that specific row.
			for (int column = 0; column < columns_count; column++) {

				// To retrieve text from that specific cell.
				String celtext = Columns_row.get(column).getText();
				System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
			}
			System.out.println("-------------------------------------------------- ");
		}
	}



	//get all data
	public static void tableData2( String value) {
		//list of rows
		List<WebElement> rows = driver.findElements(By.xpath(value));
		for(WebElement alldata:rows) {
			List<WebElement> column=alldata.findElements(By.tagName("td"));
			for(WebElement c:column) {
				System.out.println(c.getText());   //get all text from rows
			}
		}
	}


	//get first index column data
	public static void tableFirst(String value) {
		List<WebElement> rows = driver.findElements(By.xpath(value));
		int rowsize = rows.size();  //no of rows in webtable

		for (WebElement first : rows) {
			List<WebElement> f = first.findElements(By.tagName("td"));
			String firstColumn = f.get(0).getText();
			System.out.println(firstColumn);
		}

	}


	//dynamic data get 
	//get 2nd raj data then click button

	public static void tableNext(String value, String next) {

		List<WebElement> rows = driver.findElements(By.xpath(value));
		int size = rows.size(); 
		for(int i=0;i<size;i++) {
			List<WebElement> r = rows.get(i).findElements(By.tagName("td"));
			String text = r.get(1).getText();
			System.out.println(text);
			if(text.equals(next)) {  
				WebElement input = r.get(3).findElement(By.tagName("input"));//3rd column
				input.click();
				break;
			}
		}
	}	


	//dropdown bootstrap
	public static void dropDown(String value, String text) {   //compare text is present its is clicked to it

		List<WebElement> list = driver.findElements(By.xpath(value));

		// We are using enhanced for loop to get the elements

		for (WebElement ele : list)

		{
			// for every elements it will print the name using innerHTML

			System.out.println("Values " + ele.getAttribute("innerHTML"));

			// Here we will verify if link (item) is equal to Java Script

			if (ele.getAttribute("innerHTML").contains(text)) {   //option

				// if yes then click on link (iteam)
				ele.click();
				// break the loop or come out of loop

				break;

			}

		}
	}

	//	ExtentSparkReporter report=new ExtentSparkReporter("./TestReport.html");
	//	//Actual Report
	//	ExtentReports extent =new ExtentReports();
	//	extent.attachReporter(report);
	//Extend Report
	public static void extReport(String path) {  //file path to save html format
		report=new ExtentSparkReporter(path);
		extent =new ExtentReports();
		extent.attachReporter(report);

	}

	//flush is used to create test report in html
	public static void flush() {
		extent.flush();
	}

	
	public static void thread(long seconds) throws InterruptedException {
		Thread.sleep(seconds);
	}
	
	public static void threads() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	
	//pagefactory
//	PageFactory.initElements(PomClass.driver, PomClass.class);

	//apache poi used to read data from excel .xlsx
	//public static String[][] getExcelData() throws IOException {
		
		
 //Assert
	//Assert.assertEquals(title, expected);






















}



