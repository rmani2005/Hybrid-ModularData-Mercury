package org.tour.mercury.com.login;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.tour.mercury.com.logs.*;
import org.tour.mercury.com.utiles.propLoader;

public class TC_login 
{
	WebDriver driver;
	public static boolean loggedin=false;
	public static Properties objProp=null;
	public static propLoader pro;
	
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
		Log.info("Check the site is logged into the home page");
		if(!loggedin)
		{
			Log.info("Getting the Base URL from the Global Properties and Navigate to");
			driver.navigate().to(pro.getGlobalProp("base_url"));
			
			Log.info("Getting the Base URL from the Global Properties");
			
			WebElement userEle=driver.findElement(pro.getOrProp("base_url"))
		}
		
		
	}
	
}
