package com.essen.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.model.ScreenCapture;
import com.essen.pageObjects.LoginPage;
import com.essen.pageObjects.SSRS;

public class TC_SSRSChecker extends BaseClass {

	SoftAssert softAssrt = new SoftAssert();
	//SSRS assrs = new SSRS(driver);

	@Test(priority = 1, description = "To test KioskCheckInsReport validation", groups = "Appointments")
	public void KioskCheckInsReport_PgChecker() throws IOException, InterruptedException {
		// Login with Valid Username and password
		LoginPage login = new LoginPage(driver);
		login.setUsername(username);
		login.setPassword(password);
		login.setSignin();

		SSRS ssrs = new SSRS(driver);
		ssrs.KioskCheckInsReportMenu();

		// Switching to Frames
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement frameelement = driver.findElement(By.xpath("//iframe[@id='Report']"));
		driver.switchTo().frame(frameelement);

		// Waiting for the Button to be Clickable
		WebDriverWait Kioskwait = new WebDriverWait(driver, 30);
		Kioskwait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='rptViewerDetail_ctl04_ctl00']")));

		// Checking whether the Report is Opened or Not
		if (driver.findElement(By.xpath("//div[contains(text(),'KIOSK REPORT')]")).getText().contains("KIOSK REPORT")) {
			softAssrt.assertTrue(true);
			logger.info("Kiosk Check ins report has been verified");
			softAssrt.assertAll();
		} else {
			softAssrt.assertTrue(false);
			captureScreen(driver, "KioskCheckInsReport");
			logger.info("Failed! Kiosk Check ins report validation has been Failed");
			softAssrt.assertAll();

		}
		driver.switchTo().parentFrame();
	}

	// TestingForWOWReport
	@Test(priority = 2, description = "To test KioskCheckInsReport validation", groups = "Appointments")
	public void WowReport_PgChecker() throws IOException {
		SSRS ssrs = new SSRS(driver);
		ssrs.WowReportMenu();
		WebElement WowReportiFrame = driver.findElement(By.id("Report"));
		driver.switchTo().frame(WowReportiFrame);

		WebDriverWait WoWRprtwait = new WebDriverWait(driver, 20);
		WebElement title = driver.findElement(By.xpath("//tr//div[contains(text(),'WOW Report')]"));
		WoWRprtwait.until(ExpectedConditions.visibilityOf(title));

		if (driver.findElement(By.xpath("//tr//div[contains(text(),'WOW Report')]")).getText().contains("WOW Report")) {
			softAssrt.assertTrue(true);
			logger.info("Wow Report has been verified");
			softAssrt.assertAll();
		} else {
			softAssrt.assertTrue(false);
			captureScreen(driver, "Wow Report");
			logger.info("Failed! Wow Report validation has been failed");
			softAssrt.assertAll();
		}
		driver.switchTo().parentFrame();
	}

	@Test(priority = 3, description = "To test NoShowBookedAppointments report validation", groups = "Appointments")
	public void NoShowBookedAppointmentsReport_PgChecker() throws IOException {
		SSRS ssrs = new SSRS(driver);
		ssrs.NoShowBookedAppointmentsReportMenu();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='Report']")));

		WebElement submitBtn = driver.findElement(By.xpath("//input[@id='rptViewerDetail_ctl04_ctl00']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		if (driver.findElement(By.xpath("//tr//div[contains(text(),'No Show Booked Appointments Report')]")).getText()
				.contains("No Show Booked Appointments Report")) {
			softAssrt.assertTrue(true);
			logger.info("No Show Booked Appointments Report has been validated successfully");
			softAssrt.assertAll();
		} else {
			softAssrt.assertTrue(false);
			captureScreen(driver, "NoShowBookedAppointments");
			logger.info("Failed! No Show Booked Appointments Report validation has been failed");
			softAssrt.assertAll();
		}
		driver.switchTo().parentFrame();
	}

	@Test(priority = 4, description = "To test PatientList_Exceptions report validation", groups = "Exception")
	public void PatientList_Exceptions_PgChecker() throws IOException, InterruptedException {
		SSRS ssrs = new SSRS(driver);
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("LI_323"))).build().perform();
		Thread.sleep(2000);
		ssrs.clickExceptionMenu();
		ssrs.clickPatientList_ExceptionsMenu();

		WebElement Reportiframe = driver.findElement(By.id("Report"));
		//driver.switchTo().frame(Reportiframe);
		driver.switchTo().frame(0);
		WebDriverWait expwait = new WebDriverWait(driver, 20);

		expwait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//input[@id='rptViewerDetail_ctl04_ctl00']"))));
		if (driver.findElement(By.xpath("//div[contains(text(),\"Duplicate Patient REPORT\")]")).getText()
				.contains("Duplicate Patient REPORT")) {
			softAssrt.assertTrue(true);
			logger.info("Passed! PatientList Exceptions has been validated successfully");
			softAssrt.assertAll();
		} else {
			logger.info("Failed! PatientList Exceptions validation has been failed");
			softAssrt.assertTrue(false);
			captureScreen(driver, "PatientList_Exceptions_PgChecker");
			softAssrt.assertAll();
		}
		driver.switchTo().defaultContent();
	}
@Test(priority=5, groups="Exception", description="To check Duplicate Chart report validation")
	public void DuplicateChartMenu_PgChecker() throws IOException
{
	SSRS ssrs=new SSRS(driver);
	Actions action=new Actions(driver);
	action.moveToElement(driver.findElement(By.id("LI_289"))).build().perform();
	ssrs.clickDuplicateChartMenu();
	driver.switchTo().frame(0);
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("rptViewerDetail_ctl04_ctl00"))));
	
	if(driver.findElement(By.xpath("//div[contains(text(),'Duplicate Charts Report')]")).getText().contains("Duplicate Charts Report"))
	{
		softAssrt.assertTrue(true);
		logger.info("Passed! Duplicate Chart report validated successfully");
		softAssrt.assertAll();
	}
	else
	{
		softAssrt.assertTrue(false);
		captureScreen(driver, "DuplicateChartReport");
		logger.info("Failed! Duplicate Chart report validation has been failed");
		softAssrt.assertAll();
	}
}
}
