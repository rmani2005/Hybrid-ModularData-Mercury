package org.tour.mercury.com.base;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tour.mercury.com.logs.Log;
import org.tour.mercury.com.utiles.keywords;
import org.tour.mercury.com.utiles.propLoader;

public class TestBase 
{
	
	public static WebDriver driver=null;
	public static Properties objProp=null;
	public static propLoader pro=null;
	public static keywords key=null;
	 
	public static boolean loggedin=false;
	public static boolean isInitialized=false;
	
	public static void isInitialized()
	{
		if(!isInitialized)
		{
			Log.info("Inalization of test is started by loading all the pre-requistes!");
			
			Log.info("Inalizing the Property files objects..");
			pro=new propLoader();
			Log.debug("Inalized the Property files successfully!");
			
			Log.debug("Loading all the excel with .XLSX ext files..!");
			
			
		}
		
	}
	
	public boolean isLogedin()
	{
		WebElement ele=TestBase.getElement(driver, pro.getOrProp("ln_signoff"));
		if(ele.isDisplayed()){
			Log.info("Page is logged in");
			return true;
		}else
			Log.info("Page is not logged in, Sign Off link is not available");
			return false;
	}
	
	
	public static WebElement getElement(WebDriver driver, String locator)
	{
		Log.info("GetElement function is started..!");
		String[] loc=locator.split(":");
		String locType=loc[0];
		String locValue=loc[1];
		Log.info("Spliting up the property by locator: " + locType + " and the value:" + locValue);
		
		WebElement webEle=null;
		By by=null;
		Log.info("WebElement and By objectes are initialized");
		
		if(loc[0].equals("id")){
			by=By.id(locValue);
			Log.info("Element is identified by ID attribute: " + by);}
		else if(loc[0].equals("name")){
			by=By.name(locValue);
			Log.info("Element is identified by name attribute: " + by);}
		else if(loc[0].equals("linked")){
			by=By.linkText(locValue);
			Log.info("Element is identified by linked Text attribute: " + by);}
		else if(loc[0].equals("xpath")){
			by=By.xpath(locValue);
			Log.info("Element is identified by xpath attribute: " + by);}
		else if(loc[0].equals("class")){
			by=By.className(locValue);
			Log.info("Element is identified by class attribute: " + by);}
		else if(loc[0].equals("partialLink")){
			by=By.partialLinkText(locValue);
			Log.info("Element is identified by partialLinkText attribute: " + by);}
		else if(loc[0].equals("tagName")){
			by=By.tagName(locValue);
			Log.info("Element is identified by tagName attribute: " + by);}
		else{
			Log.info("Element is not found in this page");
		}
		
		for(int i=0;i<10;i++)
		{
			if(driver.findElements(by).size() > 0){
			webEle=driver.findElement(by);
			}
		}

		return webEle;
		
	}
	
	public void stdLogin(String username, String password)
	{
	
		Log.info("Check the site is logged into the home page");
		if(!loggedin)
		{
			Log.info("Getting the Base URL from the Global Properties and Navigate to");
			driver.navigate().to(pro.getGlobalProp("base_url"));
			
			Log.info("Getting the Base URL from the Global Properties");
			
			WebElement userEle=TestBase.getElement(driver, pro.getGlobalProp("username"));
			WebElement passEle=TestBase.getElement(driver, pro.getGlobalProp("password"));
			String value=null;
			key.enterText(userEle, value);
			key.enterText(passEle, value);
			key.click_action(TestBase.getElement(driver, pro.getOrProp("ln_sign_in_submit")), value);
			
			//check the page is logged
			Log.info("Verifing the login page is logged in");
			setLoggedInState(isLogedin());
		}
	}
		public boolean getLoginState()
		{
			Log.info("Login page is logged in with valid user and password!");
			return loggedin;
		}
		public void setLoggedInState(Boolean state)
		{
			Log.info("Setting the Login state as: " + state);
			loggedin=state;
		}
		
}
