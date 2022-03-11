package com.essen.testCases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.essen.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	
	@Test(description="To check whether user was able to Login to the Page or Not with single User") 
	public void logintest1() throws IOException
	{
		logger.info("URL is Accessed with the defined Browser");
		
		LoginPage lp= new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username is entered");
		
		lp.setPassword(password);
		logger.info("Password is entered");
		
		lp.setSignin();
		logger.info("Clicked on Sign In after entering Username ("+username+") and Password ("+password+")");
		
	
		//checking the title is proper or not 
		if(driver.findElement(By.xpath("//form[@id='logoutForm']/button[@type='submit']")).getText().equals("Logout"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
			lp.setLogout();
		}
		else
		{
			captureScreen(driver,"logintest1");
			lp.setLogout();
			logger.info("Login Test Failed");
			Assert.assertTrue(false);
		}
		
	}
		
}
