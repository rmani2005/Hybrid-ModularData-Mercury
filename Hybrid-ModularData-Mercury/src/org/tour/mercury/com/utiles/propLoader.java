package org.tour.mercury.com.utiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propLoader 
{

	
	static Properties globalProp=new Properties();
	static Properties orProp=new Properties();
	public void loadProperties() throws IOException
	{

		try 
		{
				globalProp.load(new FileInputStream("../Hybrid-ModularData-Mercury/src/org/tour/mercury/com/properties/global.properties"));
				orProp.load(new FileInputStream("../Hybrid-ModularData-Mercury/src/org/tour/mercury/com/properties/OR.properties"));
		}catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		}
	
	public String getGlobalProp(String property) 
	{
		return globalProp.getProperty(property);
	}
	public String getOrProp(String property) 
	{
		return orProp.getProperty(property);
	}
}
