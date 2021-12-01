package com.openweather.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig()
	{
		try {
			File src = new File("./configuration/config.properties");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} 
		catch (Exception e) {
			System.out.println("Exception is"+ e.getMessage());
		}	
		
	}
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseUrl");
		return url;
	}
	
	
	
	public String getChromepath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	public String getFirefoxpath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}

	public String getEdgepath()
	{
		String firefoxpath=pro.getProperty("edgepath");
		return firefoxpath;
	}


}
