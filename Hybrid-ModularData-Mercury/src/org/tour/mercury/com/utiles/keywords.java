package org.tour.mercury.com.utiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tour.mercury.com.logs.Log;

public class keywords 
{

	WebDriver driver;
	
	public keywords(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void click_action(WebElement ele, String value)
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
	
	public void enterText(WebElement ele, String value)
	{
		try {
			ele.sendKeys(value);
			Log.info("Click action has been performed on WebElement: ");
		} catch (Exception e) {
			e.printStackTrace();
			Log.error("Error while performing the enter text");
			Log.fatal(e.toString());
			}
		
	}
	
}
