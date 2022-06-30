package com.essen.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.essen.pageObjects.LoginPage;
import com.essen.pageObjects.MenuList;

public class TC_PageChecker_005 extends BaseClass {

	@Test(description = "To validate the scenario of Home Page", priority = 1)
	public void Homepagechecker() throws IOException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.setSignin();
		logger.info("Login Successful");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SoftAssert softasserts = new SoftAssert();

		
		WebDriverWait homepagewait = new WebDriverWait(driver, 30);
		homepagewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/Content/assets/images/Cobalt/BANNER_1.jpg']")));
		if (driver.findElement(By.xpath("//img[@src='/Content/assets/images/Cobalt/BANNER_1.jpg']")).isDisplayed()) 
		{
			softasserts.assertTrue(true);
			logger.info("Home Page Successfully Validated!!! Home Page Test Case Passed");
			softasserts.assertAll();
		} 
		else 
		{
			softasserts.assertTrue(false);
			captureScreen(driver, "Homepagechecker");
			logger.info("Home Page Validation Failed");
			softasserts.assertAll();

		}
	}

	@Test(description = "To validate the scenario of My Worklist", priority = 2)
	public void myworklistpagechecker() throws IOException, InterruptedException 
	{
		driver.findElement(By.xpath("//li[@id='LI_246']")).click();
		SoftAssert softasserts = new SoftAssert();

		WebDriverWait worklistwait = new WebDriverWait(driver, 30);
		worklistwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(text(),' My Work List')]")));
		
		//Clicking on Hamburger for getting the Menus in the Left Panel
		driver.findElement(By.xpath("//i[@class='fas fa-bars']")).click();
		
		if (driver.findElement(By.xpath("//li[contains(text(),' My Work List')]")).getText().contains("My Work List")) 
		{
			softasserts.assertTrue(true);
			logger.info("My WorkList Page Successfully Validated!!! Login Test Passed");
			softasserts.assertAll();

		} 
		else 
		{
			softasserts.assertTrue(false);
			captureScreen(driver, "myworklistpagechecker");
			logger.info("My WorkList Validation Failed");
			softasserts.assertAll();
		}
	}

	@Test(description = "To validate the scenario of Medicare open Enrollment", priority = 3)
	public void medicalopenenrollpagechecker() throws IOException, InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@id='LI_58']")).click();
		driver.findElement(By.xpath("//li[@id='LI_329']")).click();
		SoftAssert softasserts = new SoftAssert();

		WebDriverWait medicarewait = new WebDriverWait(driver, 20);
		medicarewait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"k-loading-image\"]")));

		medicarewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Export to CSV']")));

		if (driver.findElement(By.cssSelector(".col-md-10.text-left")).getText().contains("Open Enrollment")) 
		{
			softasserts.assertTrue(true);
			logger.info("Medical Enrollment Page Successfully Validated!!! Login Test Passed");
			softasserts.assertAll();
		} 
		else 
		{
			softasserts.assertTrue(false);
			captureScreen(driver, "medicalopenenrollpagechecker");
			logger.info("Medical Enrollment Validation Failed");
			softasserts.assertAll();
		}

	}

	@Test(description = "To validate scenario of Consent>> DCE all patients", priority = 4)
	public void consent_DCEAllPatients() throws IOException, InterruptedException 
	{
		MenuList menu = new MenuList(driver);
		menu.clickConsentMenu();
		menu.clickDce_AllPatients();
		
		WebDriverWait dcewait = new WebDriverWait(driver, 15);
		dcewait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"k-loading-image\"]")));

		dcewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Eligible – Not Enrolled']")));
		
		SoftAssert softasserts = new SoftAssert();

		if (driver.findElement(By.xpath("//label[@for='DCEConsentStatus']")).getText().contains("DCE Consent")) 
		{
			softasserts.assertTrue(true);
			logger.info("Patient List - DCE All Patients Page Successfully Validated!!! Login Test Passed");
			softasserts.assertAll();
		} 
		else 
		{
			softasserts.assertTrue(false);
			captureScreen(driver, "consent_DCEAllPatients");
			logger.info("DCE all patient validation failed");
			softasserts.assertAll();
		}
	}

	@Test(description = "To validate scenario of Consent>>HH_EligiblePatients", priority = 5)
	public void HH_EligiblePatients() throws Exception 
	{
		MenuList menu = new MenuList(driver);
		menu.clickHhEligiblePatients();
		
		WebDriverWait hhwait = new WebDriverWait(driver, 15);
		hhwait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"k-loading-image\"]")));

		hhwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='HHConsentStatus']")));
		SoftAssert softasserts = new SoftAssert();
		
		if (driver.findElement(By.cssSelector(".col-md-8.text-left")).getText().contains("HH Eligible Patients")) 
		{
			softasserts.assertTrue(true);
			logger.info("Patient List - Health Home All Patients page Successfully Validated");
			softasserts.assertAll();
		} 
		else 
		{
			softasserts.assertTrue(false);
			captureScreen(driver, "HH_EligiblePatients");
			logger.info("Patient List - Health Home All Patients validation Failed");
			softasserts.assertAll();
		}

	}

	@Test(description = "To validate scenarion of RHIO consent", priority = 6)
	public void RhioConsent() throws Exception 
	{
		MenuList menu = new MenuList(driver);
		menu.clickRHIOConsent();
		
		WebDriverWait RHIOwait = new WebDriverWait(driver, 15);
		RHIOwait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"k-loading-image\"]")));
		
		RHIOwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='btnExportCSV']")));
		SoftAssert softasserts = new SoftAssert();

		if (driver.findElement(By.cssSelector(".col-md-8.text-left")).getText().contains("RHIO Consent")) 
		{
			softasserts.assertTrue(true);
			logger.info("Patient List - RHIO Consent page successfully validated");
			softasserts.assertAll();
		} 
		else 
		{
			softasserts.assertTrue(false);
			captureScreen(driver, "Patient List - RHIO Consent");
			logger.info("Patient List - RHIO Consent validation failed");
			softasserts.assertAll();
		}
	}

	@Test(description = "To test page validation of CCM - All Patients", priority = 7)
	public void CCMAllPatients() throws Exception 
	{
		MenuList menu = new MenuList(driver);
		menu.clickCcmAllPatients();

		WebDriverWait CCMwait = new WebDriverWait(driver, 15);
		CCMwait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"k-loading-image\"]")));
		
		CCMwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Eligible - Consented']")));
		SoftAssert softasserts = new SoftAssert();

		if (driver.findElement(By.xpath("//label[@for='CcmStatus']")).getText().contains("CCM Status")) 
		{
			softasserts.assertTrue(true);
			logger.info("CCM - All Patients page successfully validated");
			softasserts.assertAll();
		} 
		else 
		{
			softasserts.assertTrue(false);
			captureScreen(driver, "CCM-All Patients");
			logger.info("CCM - All Patients validation failed");
			softasserts.assertAll();
		}

	}

}
