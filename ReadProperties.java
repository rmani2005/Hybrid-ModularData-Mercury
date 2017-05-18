package Practice.NewProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	
	Properties pro;
	
  public ReadProperties(){
	  
 

	File src = new File("./Configurations/object.properties");
	try {
		FileInputStream str = new FileInputStream(src);
		pro = new Properties();
		try {
			pro.load(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	} catch (FileNotFoundException e) {
	
		e.printStackTrace();
	}
	
  }
   
  public String getchromedriver()
  
  {
	  
	  String path =pro.getProperty("ChromeDriver");
	  
	  return path;
	  	  	  
  }
  
  public String URL()
  
  {
	 return pro.getProperty("URL");
			 			 
  }
  
  public String UserName()
  
  {
	  return pro.getProperty("MobileNo");
	  
  }
  
  public String pass()
  
  {
	  return pro.getProperty("Password");
  }
  
  public String singIn()
  
  {
	  return pro.getProperty("SignIN");
  }
  
  public String Connectlink()
  {
	  return pro.getProperty("ConnectLink");
	  
  }
  
  
  public String Logout()
  {
	  return pro.getProperty("Logout");
	  
  }
  public String Login()
  {
	  return pro.getProperty("Login");
	  
  }
  public String Home()
  {
	  return pro.getProperty("Home");
	  
  }
  
  public String BookFlight()
  {
	  return pro.getProperty("bookFlight");
	  
  }
  public String Oneway()
  {
	  return pro.getProperty("oneway");
	  
  }
  
  public String popuponeway()
  {
	  return pro.getProperty("popuponeway");
	  
  }
}
