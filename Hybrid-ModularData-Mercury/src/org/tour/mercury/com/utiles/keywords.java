package org.tour.mercury.com.utiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tour.mercury.com.logs.Log;

public class keywords 
{

	WebDriver driver;
	
	public void click_action(WebElement ele)
	{
		try {
			ele.click();
			Log.info("Click action has been performed on WebElement: ");
		} catch (Exception e) {
			e.printStackTrace();
			Log.error("Error while performing the click_action");
			Log.fatal(e.toString());
			}
		
	}
	
	public void sendKey(WebDriver driver, WebElement ele)
	{
		ele.click();
		Log.info("Click action has been performed on WebElement: ");
		
	}
	
}
