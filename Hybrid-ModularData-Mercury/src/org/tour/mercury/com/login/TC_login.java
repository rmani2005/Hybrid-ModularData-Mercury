package org.tour.mercury.com.login;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tour.mercury.com.base.TestBase;
import org.tour.mercury.com.logs.*;
import org.tour.mercury.com.utiles.propLoader;
import org.tour.mercury.com.utiles.keywords;

public class TC_login extends TestBase
{
	WebDriver driver;
	public static boolean loggedin=false;
	public static Properties objProp=null;
	public static propLoader pro;
	keywords key=null;
	public TC_login()
	{
		 
	}
	
	public boolean getLoginState()
	{
		
		Log.info("Login page is logged in with valid user and password!");
		return loggedin;
	}
	
	public void stdLogin(String username, String password)
	{
		pro=new propLoader();
		key=new keywords();
		Log.info("Check the site is logged into the home page");
		if(!loggedin)
		{
			Log.info("Getting the Base URL from the Global Properties and Navigate to");
			driver.navigate().to(pro.getGlobalProp("base_url"));
			
			Log.info("Getting the Base URL from the Global Properties");
			
			WebElement userEle=TestBase.getElement(driver, pro.getGlobalProp("username"));
			WebElement passEle=TestBase.getElement(driver, pro.getGlobalProp("password"));
			
			
			//
			//keyclick_Action();
		}
		
		
	}
	
}
