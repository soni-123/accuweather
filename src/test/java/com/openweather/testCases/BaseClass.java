package com.openweather.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.openweather.utilities.ReadConfig;

import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
public class BaseClass {
	ReadConfig readconfig= new ReadConfig();
	public String baseUrl=readconfig.getApplicationURL();

	public static WebDriver driver;
	public static Logger logger;
	public static final String AUTOMATE_USERNAME = "rohitsoni8";
	public static final String AUTOMATE_ACCESS_KEY = "dLZJnBKaXrpxVWXyJZx5";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	@Parameters({"browser", "browser_version", "os", "os_version"})
	@BeforeClass
	public void setup(String browserName, String browser_version, String os, String os_version,  Method name)
	{
		
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("os", os);
		caps.setCapability("os_version", os_version);
		caps.setCapability("browser_version", browser_version);
	
		if (browserName.equals("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
			driver= new ChromeDriver();
		}
		else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxpath());
			driver= new FirefoxDriver();
		}
		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);


		logger=Logger.getLogger("Openweather");
		PropertyConfigurator.configure("Log4j.properties");
	}	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname ) throws IOException{
		TakesScreenshot ts=(TakesScreenshot)driver;

		File Source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(Source, target);
		System.out.println("Screenshot Taken");


	}
}
