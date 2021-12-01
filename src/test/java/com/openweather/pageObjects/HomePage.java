package com.openweather.pageObjects;

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
		
		public void custName()
		{ 
			Actions act=new Actions(Idriver);
			act.moveToElement(searchBox);
		}
		

		
		
		
	
}
