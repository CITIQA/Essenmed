package com.essen.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.essen.pageObjects.LoginPage;
import com.essen.pageObjects.TOCHospitalizationPage;


public class TC_TOCHospitalization_004 extends BaseClass{
 
	@Test
	public void TOCTest() throws Exception
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		LoginPage login=new LoginPage(driver);
		login.setUsername(username);
		login.setPassword(password);
		login.setSignin();
		Thread.sleep(3000);
		SoftAssert softasserts= new SoftAssert();
		logger.info("login successfull");
		
		TOCHospitalizationPage toc=new TOCHospitalizationPage(driver);
		toc.ClickeCaresMenu();
		toc.clickPostAcuteCareMenu();
		toc.clickTOCMenu();
		
		WebDriverWait newhospitalizationwaits= new WebDriverWait(driver, 20);
		newhospitalizationwaits.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Create a new Hospitalization for the Patient']")));
		
		logger.info("Entered into TOC page");
		toc.clickNewHospitalization();
		toc.selectPatientStatus();

		toc.enterFirstNm();
		toc.enterLastNm();
		toc.selectDOB();
		logger.info("Clicked on DOB calender");		
		Thread.sleep(2000);
		toc.EnterPatientPhoneNumber();
		toc.EnterSocialSecurityNo();
		toc.EnterSubscriberNo();
		toc.selectInsuranceName();
		toc.EnterAdmitFacility();
		toc.enterAdmissionType();
		toc.selectAdmitDate();
		toc.selectDischargeDate();
		toc.selectReferralSource();
		toc.enterReferralName();
		toc.enterDiagnosisCode();
		toc.enterDiagnosisDescription();
		toc.clickSbumit();
		
		WebDriverWait popupWait=new WebDriverWait(driver, 30);
		popupWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("btnCloseAlertModal"))));
		
		//boolean bool=driver.findElement(By.xpath("//p[contains(text(),'New Hospitalization record has been created successfully.')]"));
		boolean popupText=driver.findElement(By.xpath("//div[@id='alertModal']")).getText().contains("New Hospitalization record has been created successfully.");
		

		if(popupText==true)
		{
		logger.info("Test Case Passed");
		softasserts.assertTrue(true);
		driver.findElement(By.id("btnCloseAlertModal")).click();
		softasserts.assertAll();
		}
		else
		{
		logger.info("Test Case Failed");
		captureScreen(driver,"TOCTest");
		logger.info("Screenshot taken");
		softasserts.assertTrue(false);
		softasserts.assertAll();
		
		}
		
	}
}
