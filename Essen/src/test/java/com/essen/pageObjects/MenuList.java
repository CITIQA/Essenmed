package com.essen.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuList 
{

		WebDriver ldriver;
		
		public MenuList(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(id="LI_315")
		@CacheLookup
		WebElement consentMenu;
		
		@FindBy(id="LI_314")
		@CacheLookup
		WebElement dce_AllPatients;
		
		@FindBy(id="LI_377")
		@CacheLookup
		WebElement hhEligiblePatients;
		
		@FindBy(id="LI_430")
		@CacheLookup
		WebElement rhioConsent;
		
		@FindBy(id="LI_316")
		@CacheLookup
		WebElement ChronicCareManagemnt;
		
		@FindBy(id="LI_310")
		@CacheLookup
		WebElement ccmAllPatients;
		
		
		public void clickConsentMenu()
		{
			consentMenu.click();
		}
		public void clickDce_AllPatients()
		{
			dce_AllPatients.click();
		}
		public void clickHhEligiblePatients()
		{
			hhEligiblePatients.click();
		}
		public void clickRHIOConsent()
		{
			rhioConsent.click();
		}
		
		public void clickCcmAllPatients()
		{
			ChronicCareManagemnt.click();
			ccmAllPatients.click();
		}

	
}
