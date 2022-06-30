package com.essen.pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TOCHospitalizationPage {

	WebDriver ldriver;
	String random5DigitText=RandomStringUtils.randomAlphabetic(5);

	
	public TOCHospitalizationPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//@FindBy(id="//li[@id='LI_58']//")
	@FindBy(xpath="//li[@id='LI_58']//span[contains(text(),'eCares  ')]")
	@CacheLookup
	WebElement eCaresMenu;
	
	@FindBy(xpath="//li[@id='LI_164']//span[contains(text(),'Post Acute Care  ')]")
	@CacheLookup
	WebElement postAcuteCareMenu;
	
	@FindBy(xpath="//li[@id='LI_165']")
	@CacheLookup
	WebElement TOCMenu;
	
	@FindBy(xpath="//a[@title='Create a new Hospitalization for the Patient']")
	@CacheLookup
	WebElement NewHospitalization;
	
	@FindBy(id="ddlPatientStatus")
	@CacheLookup
	WebElement PatientStatus;
	
	@FindBy(id="txtFirstName")
	@CacheLookup
	WebElement FirstName;
	
	@FindBy(id="txtLastName")
	@CacheLookup
	WebElement LastName;
	
	@FindBy(xpath="//input[@id='DOB']//following::span[1]//span[1]")
	@CacheLookup
	WebElement DOB;
	
	@FindBy(xpath="//a[@Class='k-link k-nav-fast' and @role='button']")
	@CacheLookup
	WebElement CalenderYear;
	
	@FindBy(xpath="//a[@class='k-link k-nav-prev' and @role='button']")
	@CacheLookup
	WebElement CalenderBackButton;
	
	@FindBy(xpath="//td[@class=\"k-other-month\"]//a[@data-value=\"1999/0/1\"]")
	@CacheLookup
	WebElement calenderYear1999;
	
	@FindBy(xpath="//a[@data-value='1999/2/1']")
	@CacheLookup
	WebElement selectMonth2_of1999;
	
	@FindBy(xpath="//a[@data-value='1999/2/16']")
	@CacheLookup
	WebElement selectDate_16Feb;
	
	@FindBy(id="txtPatientPhoneNumber")
	@CacheLookup
	WebElement PatientPhoneNumber;
	
	//@FindBy(id="txtSocialSecurityNumber")
	@FindBy(xpath="//input[@id='txtPatientPhoneNumber']")
	@CacheLookup
	WebElement SocialSecurityNumber;
	
	@FindBy(id="txtInsuranceID")
	@CacheLookup
	WebElement SubscriberNo;
	
	@FindBy(xpath="//select[@name='InsuranceID']")
	@CacheLookup
	WebElement SelectInsuranceName;
	
	@FindBy(id="txtAdmitFacility")
	@CacheLookup
	WebElement AdmitFacility;
	
	@FindBy(id="ddlAdmissionType")
	@CacheLookup
	WebElement admissionType;
	
	@FindBy(xpath="//span[@aria-controls=\"AdmitDate_dateview\"]//child::span[1]")
	@CacheLookup
	WebElement AdmitDate;
	
	@FindBy(xpath="//td[@class=\"k-today k-state-focused\"]//preceding::td[2]")
	@CacheLookup
	WebElement selectTodayDateMinus2Days;
	
	
	
	@FindBy(xpath="//span[@aria-controls=\"DischargeDate_dateview\"]//child::span[1]")
	@CacheLookup
	WebElement DischargeDate;
	
	@FindBy(xpath="//td[@Class=\"k-today k-state-focused\"]")
	@CacheLookup
	WebElement selectTodaysDateAsDischargeDate;
	
	
	@FindBy(xpath="//span[@aria-owns=\"ReferralSource_listbox\" and @role=\"listbox\"]")
	@CacheLookup
	WebElement referralSource;
	
	@FindBy(id="txtReferrerName")
	@CacheLookup
	WebElement referrerName;
	
	@FindBy(id="txtDiagnosisCode")
	@CacheLookup
	WebElement DiagnosisCode;
	
	@FindBy(id="txtDiagnosisDescription")
	@CacheLookup
	WebElement DiagnosisDescription;
	
	@FindBy(id="btnSubmit")
	@CacheLookup
	WebElement SubmitBtn;
	
	@FindBy(xpath="//div[@class=\"modal-dialog\"]")
	@CacheLookup
	WebElement popup_ModalDialog;
	
	@FindBy(xpath="//p[contains(text(),\"New Hospitalization record has been created successfully.\")]")
	@CacheLookup
	WebElement popup_Text;
	
	@FindBy(id="btnCloseAlertModal")
	@CacheLookup
	WebElement popup_CloseBtn;
	
	
	public void ClickeCaresMenu()
	{
		eCaresMenu.click();
	}
		
	public void clickPostAcuteCareMenu()
	{
		postAcuteCareMenu.click();
	}
	
	public void clickTOCMenu()
	{
		TOCMenu.click();
	}
	
	public void clickNewHospitalization()
	{
		NewHospitalization.click();
	}
	
	public void selectPatientStatus()
	{
		Select patientStatus=new Select(PatientStatus);
		patientStatus.selectByValue("New");
	}
	public void enterFirstNm()
	{
		FirstName.sendKeys(RandomStringUtils.randomAlphabetic(5));
	}
	public void enterLastNm()
	{
		LastName.sendKeys(RandomStringUtils.randomAlphabetic(5));
	}
	public void selectDOB() throws Exception
	{
		DOB.click();
		Thread.sleep(2000);		
		CalenderYear.click();
		Thread.sleep(1000);
		CalenderYear.click();
		CalenderBackButton.click();
		Thread.sleep(1000);
		CalenderBackButton.click();
		Thread.sleep(1000);
		calenderYear1999.click();
		Thread.sleep(1000);
		selectMonth2_of1999.click();
		Thread.sleep(2000);
		selectDate_16Feb.click();
	}
	
	public void EnterPatientPhoneNumber()
	{
		PatientPhoneNumber.click();
		PatientPhoneNumber.sendKeys(RandomStringUtils.randomNumeric(10));
		//PatientPhoneNumber.sendKeys("9"+RandomStringUtils.randomNumeric(9));
	}
	
	public void EnterSocialSecurityNo()
	{
		SocialSecurityNumber.sendKeys(RandomStringUtils.randomNumeric(5));
	}
	public void EnterSubscriberNo()
	{
		SubscriberNo.sendKeys(RandomStringUtils.randomNumeric(5));
	}
	public void selectInsuranceName()
	{
		Select insNm=new Select(SelectInsuranceName);
		
		insNm.selectByVisibleText("ElderPlan Medicare");
	}
	public void EnterAdmitFacility()
	{
		AdmitFacility.sendKeys(RandomStringUtils.randomAlphabetic(5));
	}
	public void enterAdmissionType()
	{
		Select admtype=new Select(admissionType);
		admtype.selectByValue("Inpatient Visit");
	}
	public void selectAdmitDate() throws Exception
	{
		AdmitDate.click();
		Thread.sleep(1000);
		selectTodayDateMinus2Days.click();
	}
	public void selectDischargeDate() throws Exception
	{
		DischargeDate.click();
		Thread.sleep(1000);
		selectTodaysDateAsDischargeDate.click();
	}
	
	public void selectReferralSource()
	{
		referralSource.click();
		referralSource.sendKeys(Keys.DOWN);
		referralSource.sendKeys(Keys.ENTER);
	}
	public void enterReferralName()
	{
		referrerName.sendKeys(RandomStringUtils.randomAlphabetic(5));
	}
	public void enterDiagnosisCode()
	{
		DiagnosisCode.sendKeys(RandomStringUtils.randomAlphanumeric(4));
	}
	public void enterDiagnosisDescription()
	{
		DiagnosisDescription.sendKeys(RandomStringUtils.randomAlphabetic(7));
	}
	
	public void clickSbumit()
	{
		SubmitBtn.click();
	}
	
	
	
}
