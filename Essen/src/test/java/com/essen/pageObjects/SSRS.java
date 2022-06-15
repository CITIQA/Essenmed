package com.essen.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSRS {

	WebDriver ldriver;
	
	public SSRS(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="LI_65")
	@CacheLookup
	WebElement ReportsMenu;
	
	@FindBy(id="LI_322")
	@CacheLookup
	WebElement Appointments;
	
	@FindBy(id="LI_288")
	@CacheLookup
	WebElement KioskCheckInsReport;
	
	@FindBy(id="LI_385")
	@CacheLookup
	WebElement WowReport;
	
	@FindBy(id="LI_512")
	@CacheLookup
	WebElement NoShowBookedAppointmentsReport;

	
	
	
	
	
	
	
	public void KioskCheckInsReport()
	{
		ReportsMenu.click();
		Appointments.click();
		KioskCheckInsReport.click();
	}
	public void WowReport()
	{
		//ReportsMenu.click();
		//Appointments.click();
		WowReport.click();
	}
	public void NoShowBookedAppointmentsReport()
	{
		//ReportsMenu.click();
		//Appointments.click();
		NoShowBookedAppointmentsReport.click();
	}
}
