package Practice.NewProject;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Readexcel {
	
	public WebDriver driver;
	ReadProperties obj = new ReadProperties();	
	
	static Actions actions;	

public ArrayList<String> Readexceldata (int colno) throws Exception{
		
		FileInputStream file = new FileInputStream("C:\\Users\\xbbltfy\\workspace\\LoginDetails.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet= wb.getSheet("Sheet1");
		Iterator<Row> iter = sheet.iterator();
		//iter.next();
		ArrayList<String> list = new ArrayList<String>();
		DataFormatter formatter = new DataFormatter();
		
		while(iter.hasNext()){
			
			//System.out.println(iter.next().getCell(colno));
			
			list.add(iter.next().getCell(colno).toString());
			
		}
		
		System.out.println("List :::"+ list);
		 return list;
	}
		
		
	public static void main(String[] args) throws Exception {
		Readexcel data = new Readexcel();
		data.testcase();
		data.Readexceldata(0);
		data.Readexceldata(1);
		
		
	}
	
		public void testcase() throws Exception{	
			
			//System.setProperty("webdriver.gecko.driver", "C:\\work\\geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(obj.URL());
		
			
		
			ArrayList<String> Userid = Readexceldata(0);
			ArrayList<String> Pwd = Readexceldata(1);
			
			
			 
			for(int i=0;i<Userid.size();i++){
				
				
			Thread.sleep(8000);	
			driver.findElement(By.xpath(obj.Login())).click();
			WebElement Name = driver.findElement(By.xpath(obj.UserName()));
			Highlight.color(driver, Name);
			Name.sendKeys(Userid.get(i));
			WebElement Password=driver.findElement(By.xpath(obj.pass()));
			Highlight.color(driver, Password);
			Password.sendKeys(Pwd.get(i));
			WebElement Login=driver.findElement(By.xpath(obj.singIn()));
			Highlight.color(driver, Login);
			Login.click();
			Thread.sleep(5000);
			WebElement Signout=driver.findElement(By.xpath(obj.Logout()));
			Highlight.color(driver, Signout);
			Signout.click();
			Thread.sleep(5000);
			WebElement Logo=driver.findElement(By.xpath(obj.Home()));
			Highlight.color(driver, Logo);
			Logo.click();
			
	
					
		}
			
			driver.close();
	
	
	}	
		
}
	
