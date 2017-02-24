package testPackahe;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class demo 

{
	Logger log=Logger.getLogger("devpinoyLogger");
	static String URL = "www.google.com";
	String[]  strArr;
	
 @Test
 public void demoTest()
  {
	 	 
	 
	 WebDriver driver=new FirefoxDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	
	 try{
	 driver.navigate().to(URL);
	 }catch(Exception e)
	 {
		 System.out.println("Exception: "+ e.toString());
	 }
	 
	 WebDriverWait wait=new WebDriverWait(driver, 10);
	 WebElement WebEle;
	 WebEle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));

	 driver.findElement(By.id(""));
	 
	 
	 
	 
	 
 }
	
	
}


