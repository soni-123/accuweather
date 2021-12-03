package com.openweather.testCases;

import org.testng.annotations.Test;

import com.openweather.pageObjects.HomePage;

public class TC_VarianceLogic extends BaseClass {
    String temprature, temprature1;
    @Test
	public void varianceLogic() throws InterruptedException {
    	int variance;
		logger.info("open URL");
		HomePage hp=new HomePage(driver);
		hp.searchLocation("Patna");
		logger.info("Click the searchBox");
		temprature=hp.getTemp();
		System.out.println("Get Temprature of patna  "+ temprature);
		String getNumber = temprature.replaceAll("[^0-9]", "");
		int getNumberInTemp=Integer.parseInt(getNumber);
		System.out.println(getNumberInTemp);
		driver.navigate().back();
		Thread.sleep(20000);
		System.out.println("driver back");
		hp=new HomePage(driver);
		hp.searchLocation("Delhi");
		logger.info("Click the searchBox");
		temprature1=hp.getTemp();
		System.out.println("Get Temprature of Delhi "+ temprature1);
		String getNumber1 = temprature1.replaceAll("[^0-9]", "");
		int getNumberInTemp1=Integer.parseInt(getNumber1);
		System.out.println(getNumberInTemp1);
		variance=getNumberInTemp1-getNumberInTemp;
		System.out.println("Variance of temp= "+variance);
		if(variance >0) {
			System.out.println("Temprature variance is +ve");
		}
		else {
			System.out.println("Temprature variance is -ve");
		}
	}
}
