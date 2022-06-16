package com.essen.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.essen.pageObjects.LoginPage;
import com.essen.pageObjects.PowerBI;

public class TC_PowerBIChecker extends BaseClass
{

	@Test(description = "To check page validation of CCM Dashboard", priority = 1)
	public void CCMDashboard() throws Exception 
	{
		LoginPage login=new LoginPage(driver);
		login.setUsername(username);
		login.setPassword(password);
		login.setSignin();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		PowerBI powerbi= new PowerBI(driver);
		powerbi.clickCCMMainMenu();
		powerbi.clickCcmDashboard();
		
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"k-loading-image\"]")));
		SoftAssert softasserts= new SoftAssert();

		if(driver.findElement(By.xpath("//div[contains(text(),'CCM Overview')]")).getText().contains("CCM Overview"))
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
