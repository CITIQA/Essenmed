package com.essen.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.essen.pageObjects.LoginPage;
import com.essen.pageObjects.PowerBI;

public class TC_PowerBIChecker extends BaseClass
{
	@Test(description = "To validate the scenario of Provider Panel Dashboard",priority = 1)
	public void ProviderPanelDashboard() throws InterruptedException, IOException
	{
		LoginPage login=new LoginPage(driver);
		login.setUsername(username);
		login.setPassword(password);
		login.setSignin();
		
		SoftAssert softasserts= new SoftAssert();
		
		PowerBI powerbi= new PowerBI(driver);
		powerbi.eCaresMainmenu();
		powerbi.providermainmenu();
		powerbi.providerpanel();
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='btnSaveviecheck']")));
		
		String BeforeXpath="//div[@id='ProviderPanelGrid']/table[@role='grid']/tbody/tr[";
		String AfterXpath="]/td[3]";
		String DashboardClickXpath="/preceding-sibling::td[2]/div/a[2]";
		
		
		for(int i=1;i<=10;i++)
		{
			if(driver.findElement(By.xpath(BeforeXpath+i+AfterXpath)).getText().contains("SUMIR SAHGAL"))
			{
				driver.findElement(By.xpath(BeforeXpath+i+AfterXpath+DashboardClickXpath)).click();	
				break;
			}
		}
		
		driver.switchTo().frame(0);
		
		WebDriverWait providerpanelwait=new WebDriverWait(driver,20);
		providerpanelwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Patient Count by CAP vs FFS']/parent::div")));
		
		if(driver.findElement(By.xpath("//h3[contains(text(),'Total Patients as Panel Provider')]")).getText().contains("Panel Provider"))
		{
			softasserts.assertTrue(true);
			logger.info("Provider Panel Dashboard page successfully validated");
			softasserts.assertAll();
		}
		else
		{
			softasserts.assertTrue(false);
			captureScreen(driver, "ProviderPanelDashboard");
			logger.info("Provider Panel Dashboard validation fail");
			softasserts.assertAll();
			
		}
		
	}
	
/*
	@Test(description = "To Validate the scenario of CCM Dashboard", priority = 2)
	public void CCMDashboard() throws Exception 
	{
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		PowerBI powerbi= new PowerBI(driver);
		powerbi.clickChronicCareManagementMainMenu();
		powerbi.ClickCCMDashboardMenu();
		
		SoftAssert softasserts= new SoftAssert();
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-id='graph1_1']")));
		

		if(driver.findElement(By.xpath("//div[contains(text(),'CCM Overview')]")).getText().contains("CCM Overview"))
		{
			softasserts.assertTrue(true);
			logger.info("CCM Dashboard page successfully validated");
			softasserts.assertAll();
		}
		else
		{
			softasserts.assertTrue(false);
			captureScreen(driver, "CCMDashboard");
			logger.info("CCM Dashboard validation fail");
			softasserts.assertAll();
			
		}
	}
	*/
	
	
	
}
