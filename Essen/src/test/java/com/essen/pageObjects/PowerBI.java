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
	
	@FindBy(id="LI_58")
	@CacheLookup
	WebElement eCaresMainMenu;
	
	//************************* PROVIDER MENU STARTS HERE *************************//
	@FindBy(id="LI_151")
	@CacheLookup
	WebElement ProviderMainMenu;
	
	@FindBy(id="LI_147")
	@CacheLookup
	WebElement Providerpanel;
	//************************* PROVIDER MENU ENDS HERE  *************************//
	
	//************************* FACILITY MENU STARTS HERE *************************//
	@FindBy(id="LI_152")
	@CacheLookup
	WebElement FacilityMainMenu;
	
	@FindBy(id="LI_154")
	@CacheLookup
	WebElement Facilitypanel;
	//************************* FACILITY MENU ENDS HERE *************************//
	
	//************************* POST ACUTE CARE MENU STARTS HERE  ***************//
	@FindBy(id="LI_164")
	@CacheLookup
	WebElement PostAcuteCareMainMenu;
	
	@FindBy(id="LI_214")
	@CacheLookup
	WebElement PostAcuteCareDashboard;
	//************************* POST ACUTE CARE MENU ENDS HERE  ***************//
	
	
	
	
	@FindBy(id="LI_153")
	@CacheLookup
	WebElement PatientMainMenu;	
	
	@FindBy(id="LI_316")
	@CacheLookup
	WebElement CCMMainMenu;
	
	@FindBy(id="LI_337")
	@CacheLookup
	WebElement ccmDashboard;
	

	public void eCaresMainmenu()
	{
		eCaresMainMenu.click();
	}
	
	public void providermainmenu()
	{
		ProviderMainMenu.click();
	}
	
	public void providerpanel()
	{
		Providerpanel.click();
	}
	
	public void facilitymainmenu()
	{
		FacilityMainMenu.click();
	}
	
	public void facilitypanel()
	{
		Facilitypanel.click();
	}
	
	public void PostAcuteCareMainMenu()
	{
		PostAcuteCareMainMenu.click();
	}
	
	public void PostAcuteCareDashboard()
	{
		PostAcuteCareDashboard.click();
	}
	
	public void clickChronicCareManagementMainMenu()
	{
		CCMMainMenu.click();
	}
	
	public void ClickCCMDashboardMenu()
	{
		ccmDashboard.click();
	}
	

}
