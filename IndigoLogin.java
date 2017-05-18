package Practice.NewProject;

import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class IndigoLogin {

	WebDriver driver;
	ReadProperties obj;
	ExtentReports extent;
	ExtentTest test;

	@BeforeSuite
	public void Launch() throws Exception {
		obj = new ReadProperties();
		extent = new ExtentReports("C:\\work\\Reports\\Report.html", true);

		test = extent.startTest("Verify Indigo Login");
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		driver = new ChromeDriver();
		test.log(LogStatus.INFO, "Browser started ");
		driver.get(obj.URL());
		test.log(LogStatus.INFO, "Indigo Login Page launched Successfully");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

	}

	@Test(dataProvider = "IndigoLogin",priority=0) 
	public void Login(String Userid, String Pass) throws Exception {

		Thread.sleep(5000);
		driver.findElement(By.xpath(obj.Login())).click();
		WebElement Name = driver.findElement(By.xpath(obj.UserName()));
		Highlight.color(driver, Name);
		Name.sendKeys(Userid);
		WebElement Password = driver.findElement(By.xpath(obj.pass()));
		Highlight.color(driver, Password);
		Password.sendKeys(Pass);
		test.log(LogStatus.INFO, "Entered Valid Userid and Password");
		WebElement Login = driver.findElement(By.xpath(obj.singIn()));
		Highlight.color(driver, Login);
		Login.click();
		Thread.sleep(5000);
	/*	WebElement Bk_flight = driver.findElement(By.xpath(obj.BookFlight()));
		Highlight.color(driver, Bk_flight);
		Bk_flight.click();*/
		
	}
	
	@Test(priority=1)
	public void ticket(){
		
	
		
		WebElement Bk_flight = driver.findElement(By.xpath(obj.BookFlight()));
		Highlight.color(driver, Bk_flight);
		Bk_flight.click();
		WebElement Onewwaytrip = driver.findElement(By.xpath(obj.Oneway()));
		Highlight.color(driver, Onewwaytrip);
		Onewwaytrip.click();
		WebElement info_msg = driver.findElement(By.xpath(obj.popuponeway()));
		Highlight.color(driver, info_msg);
		info_msg.click();

		
	}

	
	@AfterSuite
	public void Logout() throws Exception {
		
		WebElement Signout = driver.findElement(By.xpath(obj.Logout()));
		Highlight.color(driver, Signout);
		Signout.click();
		test.log(LogStatus.INFO, "Logout Successfully");
		WebElement Logo = driver.findElement(By.xpath(obj.Home()));
		Highlight.color(driver, Logo);
		Logo.click();
		test.log(LogStatus.PASS, "Successfully Validated Indigo Login Functionality");
		extent.endTest(test);
		extent.flush();
		driver.close();
		driver.get("file:///C:/work/Reports/Report.html#!");

	}


@DataProvider(name = "IndigoLogin")
	public Object[][] loginData() {

		ExcelConfig config = new ExcelConfig("C:\\Users\\xbbltfy\\workspace\\LoginDetails.xlsx");
		int rows = config.getRowCount(0);

		Object[][] data = new Object[rows][2];

		for (int i = 0; i < rows; i++) {

			data[i][0] = config.getexceldata(0, i, 0);
			data[i][1] = config.getexceldata(0, i, 1);

		}

	
		return data;

	}

}
