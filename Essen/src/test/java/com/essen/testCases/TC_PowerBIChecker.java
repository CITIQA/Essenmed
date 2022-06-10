package com.essen.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.essen.pageObjects.MenuList;

public class TC_PowerBIChecker extends BaseClass
{

	@Test(description = "To check page validation of CCM Dashboard", priority = 1)
	public void CCHDashboard() throws Exception 
	{
		MenuList menu = new MenuList(driver);
		menu.clickCcmDashboard();
		
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"k-loading-image\"]")));
		SoftAssert softasserts= new SoftAssert();

		if(driver.findElement(By.xpath("//*[contains(text(),'CCM Consent Status')]")).getText().contains("CCM"))
		{
			softasserts.assertTrue(true);
			logger.info("CCM Dashboard page successfully validated");
			softasserts.assertAll();
		}
		else
		{
			softasserts.assertTrue(false);
			captureScreen(driver, "CCM Dashboard");
			logger.info("CCM Dashboard validation fail");
			softasserts.assertAll();
			
		}
	}
	
	
	
}
