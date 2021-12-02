package com.openweather.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import com.openweather.pageObjects.HomePage;

public class TC_GetTempratureFromUIAndAPI extends BaseClass {
	String temprature;
	float temp;
	@Test
	public void getTempratureFromUI() throws IOException, InterruptedException
	{
		logger.info("open URL");
		HomePage hp=new HomePage(driver);
		hp.searchLocation("Patna");
		logger.info("Click the searchBox");
		 temprature=hp.getTemp();
		System.out.println("Get Temprature from UI"+ temprature);
		
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
	@Test
	public void getTempratureFromAPI() {
		float temp=given()
				.queryParam("q", "Patna")
				.queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea").  					
			when()
		    	.get("https://api.openweathermap.org/data/2.5/weather").    	
		    then()
		    	.extract().path("main.temp");
				System.out.println("Temprature "+temp);
	}

}
