package org.tour.mercury.com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tour.mercury.com.logs.Log;

public class TestBase 
{

	WebDriver driver;
	
	
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
	
	
	
	
}
