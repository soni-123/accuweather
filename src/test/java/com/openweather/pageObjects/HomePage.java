package com.openweather.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver Idriver;
	 public HomePage(WebDriver rdriver)
	 {
		 Idriver=rdriver;
		 PageFactory.initElements(rdriver, this);
	 }
	 
	 @FindBy(how=How.XPATH, using="//input[@class='search-input']") 
	 @CacheLookup 	
	 WebElement searchBox;
	 
	 @FindBy(how=How.XPATH, using="//a/div/div/div/div/div[@class='temp']") 
	 @CacheLookup 	
	 WebElement temp;
	 
		
		public void searchLocation(String loc) throws InterruptedException
		{ 
			searchBox.sendKeys(loc);
			Thread.sleep(5000);
			Actions act=new Actions(Idriver);
			act.sendKeys(Keys.DOWN).perform();
			act.sendKeys(Keys.ENTER).perform();
			Thread.sleep(5000);
			
		}
		
		public String getTemp() {
		
			return	temp.getText();
			
			
		}
		

		
		
		
	
}
