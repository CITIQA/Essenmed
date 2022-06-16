package com.essen.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PowerBI 
{
WebDriver ldriver;
	
	public PowerBI(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="LI_316")
	@CacheLookup
	WebElement CCMMainMenu;
	
	@FindBy(id="LI_337")
	@CacheLookup
	WebElement ccmDashboard;
	
	
	public void clickCCMMainMenu()
	{
		CCMMainMenu.click();
	}
	
	public void clickCcmDashboard()
	{
		ccmDashboard.click();
	}
}
