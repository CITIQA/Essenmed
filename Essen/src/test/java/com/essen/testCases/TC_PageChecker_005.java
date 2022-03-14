package com.essen.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.essen.pageObjects.LoginPage;

public class TC_PageChecker_005 extends BaseClass
{
	
	@Test(description="To validate the scenario of Home Page")
	public void Homepagechecker() throws IOException 
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.setSignin();
		logger.info("Login Successful");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		if(driver.findElement(By.xpath("//div[@class='carousel-inner mt-3']/div/img[@src='/Content/assets/images/BANNER_1.jpg']")).isDisplayed())
		{
			Assert.assertTrue(true);
			logger.info("Home Page Successfully Validated!!! Login Test Passed");
		}
		else
		{
			captureScreen(driver,"logintest1");
			logger.info("Login Test Failed");
			Assert.assertTrue(false);
		}
	}
	
	@Test(description="To validate the scenario of My Worklist")
	public void myworklistpagechecker() throws IOException, InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String myworklist=driver.findElement(By.xpath("//a[@href='/RulesEngine/SmartSchedulingRules?menuID=246']")).getText();
		driver.findElement(By.xpath("//a[@href='/RulesEngine/SmartSchedulingRules?menuID=246']")).click();
		
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'My Work List')]")));
		
		if(driver.findElement(By.xpath("//h4[contains(text(),'My Work List')]")).getText().contains(myworklist))
		{
			Assert.assertTrue(true);
			logger.info("My WorkList Page Successfully Validated!!! Login Test Passed");
		}
		else
		{
			captureScreen(driver,"logintest1");
			logger.info("Login Test Failed");
			Assert.assertTrue(false);
		}
	}
	
	@Test(description="To validate the scenario of Test page")
	public void testpagechecker() throws IOException, InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@id='LI_58']")).click();
		String testpage=driver.findElement(By.xpath("//a[@href='/Report/EmbedReport?menuID=442']")).getText();
		driver.findElement(By.xpath("//a[@href='/Report/EmbedReport?menuID=442']")).click();
		
		if(driver.findElement(By.xpath("//div[@id='navbarSupportedContent']")).getText().contains(testpage))
		{
			Assert.assertTrue(true);
			logger.info("test Page Successfully Validated!!! Login Test Passed");
		}
		else
		{
			captureScreen(driver,"logintest1");
			logger.info("Login Test Failed");
			Assert.assertTrue(false);
		}
	}
	
	@Test(description="To validate the scenario of Medical open Enrollment")
	public void medicalopenenrollpagechecker() throws IOException, InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@id='LI_58']")).click();
		driver.findElement(By.xpath("//a[@href='/RulesEngine/ViewPatientsForOpenEnrollment?menuID=329']")).click();
		
		if(driver.findElement(By.xpath("//h4[contains(text(),'Open Enrollment')]")).getText().contains("Open Enrollment"))
		{
			Assert.assertTrue(true);
			logger.info("Medical Enrollment Page Successfully Validated!!! Login Test Passed");
		}
		else
		{
			captureScreen(driver,"logintest1");
			logger.info("Login Test Failed");
			Assert.assertTrue(false);
		}
	}
	
	
	
	
	
	//Added by Prashant
	@Test(description="To validate scenario of Consent>> DCE all patients")
	public void consent()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("LI_315")).click();
		driver.findElement(By.id("LI_314")).click();
		
		
	}
	
}
