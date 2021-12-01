package com.openweather.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.openweather.utilities.ReadConfig;

import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;




public class BaseClass {
	ReadConfig readconfig= new ReadConfig();
	public String baseUrl=readconfig.getApplicationURL();
	
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
			driver= new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxpath());
			driver= new FirefoxDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver",readconfig.getEdgepath());
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
		
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
	}	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	public String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}
	public void captureScreen(WebDriver driver, String tname ) throws IOException{
		TakesScreenshot ts=(TakesScreenshot)driver;
		 
		File Source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(Source, target);
		System.out.println("Screenshot Taken");
	
				
	}
}
