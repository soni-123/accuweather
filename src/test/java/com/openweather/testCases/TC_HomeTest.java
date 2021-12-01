package com.openweather.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.openweather.pageObjects.HomePage;

public class TC_HomeTest extends BaseClass {
	@Test
	public void searchWeather() throws IOException, InterruptedException
	{
		
		
		logger.info("open URL");
		HomePage hp=new HomePage(driver);
	hp.searchLocation("Patna");
	logger.info("Click the searchBox");
	
	
	if(driver.getTitle().equals("Patna, Bihar, India Today, Tonight & Tomorrow's Weather Forecast | AccuWeather")) 
		{
			Assert.assertTrue(true);
			logger.info("SearchBox test passed");
		}
		else {
			captureScreen(driver,"SearchBox");
			Assert.assertTrue(false);
			logger.info("SearchBox test failed");
		}
			
	}
	
}
