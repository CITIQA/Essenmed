package com.essen.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
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
	
	//KioskCheckInsReport
	@FindBy(id="LI_288")
	@CacheLookup
	WebElement KioskCheckInsReport;
	
	@FindBy(id="LI_385")
	@CacheLookup
	WebElement WowReport;
	
	@FindBy(id="LI_512")
	@CacheLookup
	WebElement NoShowBookedAppointmentsReport;

	@FindBy(how=How.ID, using="LI_323")
	WebElement Exception;
	
	@FindBy(how=How.ID, using="LI_284")
	WebElement PatientList_Exceptions;
	
	@FindBy(how=How.ID, using="LI_289")
	WebElement DuplicateChart;
	
	@FindBy(how=How.ID, using="LI_290")
	WebElement DuplicateSubscriberNumber;
	
	@FindBy(how=How.ID, using="LI_302")
	WebElement Opt_OutList;
	
	
	public void KioskCheckInsReportMenu()
	{
		ReportsMenu.click();
		Appointments.click();
		KioskCheckInsReport.click();
	}
	public void WowReportMenu()
	{
		//ReportsMenu.click();
		//Appointments.click();
		WowReport.click();
	}
	public void NoShowBookedAppointmentsReportMenu()
	{
		//ReportsMenu.click();
		//Appointments.click();
		NoShowBookedAppointmentsReport.click();
	} 
	public void clickExceptionMenu()
	{
		Exception.click();
	}
	public void clickPatientList_ExceptionsMenu()
	{
		PatientList_Exceptions.click();
	}
	public void clickDuplicateChartMenu()
	{
		DuplicateChart.click();
	}
	public void clickOpt_OutListMenu()
	{
		Opt_OutList.click();
	}
}
