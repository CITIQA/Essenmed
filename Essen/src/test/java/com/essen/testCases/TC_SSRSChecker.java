package com.essen.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.essen.pageObjects.LoginPage;
import com.essen.pageObjects.SSRS;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

public class TC_SSRSChecker extends BaseClass {

	@Test(description="To test KioskCheckInsReport validation")
	public void SSRSReportChecker() throws IOException, InterruptedException
	{
		LoginPage login=new LoginPage(driver);
		login.setUsername(username);
		login.setPassword(password);
		login.setSignin();
		
		SoftAssert softAssrt=new SoftAssert();
		SSRS ssrs=new SSRS(driver);
		ssrs.KioskCheckInsReport();
		WebDriverWait Explwait=new WebDriverWait(driver, 30);
		logger.info("Explicite wait");
		Thread.sleep(25000);
		logger.info("25sec wait done");
		//WebElement viewReportBtn=driver.findElement(By.id("rptViewerDetail_ctl04_ctl00"));
		
		logger.info("webelement done");
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@id='rptViewerDetail_ctl04_ctl00']")));
		
		//driver.findElement(By.id("rptViewerDetail_ctl04_ctl00")).click();
		//Explwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='rptViewerDetail_ctl04_ctl00']")));
		
		
		
		logger.info("until done");
		if(driver.findElement(By.xpath("//input[@id='rptViewerDetail_ctl04_ctl00']")).isEnabled())
		{
			logger.info("into IF condition");
			softAssrt.assertTrue(true);
			logger.info("Kiosk Check ins report has been verified");
			softAssrt.assertAll();
		}
		else
		{
			logger.info("into ELSE condition");
			softAssrt.assertTrue(false);
			captureScreen(driver, "KioskCheckInsReport");
			logger.info("Failed! Kiosk Check ins report validation has been Failed");
			softAssrt.assertAll();
			
		}
	}

}
