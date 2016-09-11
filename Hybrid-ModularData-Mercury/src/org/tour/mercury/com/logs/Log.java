package org.tour.mercury.com.logs;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log
{
	private static Logger log=Logger.getLogger(Log.class.getName());
	private Log()
	{
	  DOMConfigurator.configure("Log4j.xml");
	}

	public static void info(String msg) 
	{
		log.info(msg);
	}
	
	public static void warn(String msg) 
	{
		log.warn(msg);
	}
	
	public static void debug(String msg) 
	{
		log.debug(msg);
	}
	
	public static void fatal(String msg) 
	{
		log.fatal(msg);
	}
	
	public static void error(String msg) 
	{
		log.error(msg);
	}


}
