package com.essen.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.essen.pageObjects.LoginPage;
import com.essen.pageObjects.SSRS;


public class TC_SSRSChecker extends BaseClass {

	@Test(description="To test KioskCheckInsReport validation")
	public void SSRSReportChecker() throws IOException, InterruptedException
	{
		//Login with Valid Username and password
		LoginPage login=new LoginPage(driver);
		login.setUsername(username);
		login.setPassword(password);
		login.setSignin();
		
		//Navigating to the Report
		SoftAssert softAssrt=new SoftAssert();
		SSRS ssrs=new SSRS(driver);
		ssrs.KioskCheckInsReport();
		
		//Switching to Frames
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement frameelement=driver.findElement(By.xpath("//iframe[@id='Report']"));
		driver.switchTo().frame(frameelement);
		
		//Waiting for the Button to be Clickable
		WebDriverWait Kioskwait=new WebDriverWait(driver, 30);
		Kioskwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='rptViewerDetail_ctl04_ctl00']")));
		
		//Checking whether the Report is Opened or Not
		if(driver.findElement(By.xpath("//div[contains(text(),'KIOSK REPORT')]")).getText().contains("KIOSK REPORT"))
		{
			softAssrt.assertTrue(true);
			logger.info("Kiosk Check ins report has been verified");
			softAssrt.assertAll();
		}
		else
		{
			softAssrt.assertTrue(false);
			captureScreen(driver, "KioskCheckInsReport");
			logger.info("Failed! Kiosk Check ins report validation has been Failed");
			softAssrt.assertAll();
			
		}
		
		//Switching back to Parent Frames
		driver.switchTo().parentFrame();
	    driver.switchTo().defaultContent();
	}

}
