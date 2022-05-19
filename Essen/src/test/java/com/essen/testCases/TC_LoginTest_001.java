package com.essen.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.essen.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	
	@Test(description="To check whether user was able to Login to the Page or Not with single User") 
	public void logintest1() throws IOException
	{
		LoginPage lp = new LoginPage(driver);
		
		lp.setUsername(username);
		logger.info("Username is entered");
		
		lp.setPassword(password);
		logger.info("Password is entered");
		
		lp.setSignin();
		logger.info("Clicked on Sign In after entering Username ("+username+") and Password ("+password+")");
		logger.info("Login Successful");
		
		logger.info("URL is Accessed with the defined Browser");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		SoftAssert softasserts= new SoftAssert();
		
	
		//checking the title is proper or not 
		if(driver.findElement(By.xpath("//form[@id='logoutForm']/button[@type='submit']")).getText().equals("Logout"))
		{
			lp.setLogout();
			logger.info("Login Test Passed");
			softasserts.assertTrue(true);
			softasserts.assertAll();
		}
		else
		{
			captureScreen(driver,"logintest1");
			lp.setLogout();
			logger.info("Login Test Failed");
			softasserts.assertTrue(false);
			softasserts.assertAll();
		}
		
	}
		
}
