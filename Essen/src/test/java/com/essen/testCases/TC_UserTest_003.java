package com.essen.testCases;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.essen.pageObjects.LoginPage;
import com.essen.pageObjects.UsersPage;

import junit.framework.Assert;

public class TC_UserTest_003 extends BaseClass
{
		@Test(description="Creation of New Users Randomly")
		public void UserTest() throws InterruptedException, IOException
		{
			LoginPage lp= new LoginPage(driver);
			lp.setUsername(username);
			lp.setPassword(password);
			lp.setSignin();
			logger.info("Login Successful");
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			UsersPage up= new UsersPage(driver);
			up.setAdminMenu();
			up.setUsersMainMenu();
			Thread.sleep(2000L);
			up.setCreateUserBtn();
			logger.info("Providing Users Details");
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			up.setUsertypeCreateADAuth();
			up.setUsertypeCreateformAuth();
			
			String text1=RandomString();
			
			
			String emailtxt=text1+"@gmail.com";
			up.setUsername(emailtxt);
			up.setfirstnamecreate(text1);
			up.setlastnamecreate(text1);
			
			up.setRolecreate();
			driver.findElement(By.xpath("//input[@value=26]")).click();
			driver.findElement(By.xpath("//input[@value=13]")).click();
			
			up.setemailcreate(emailtxt);
			up.setpasscreate("Pass$123");
			up.setconfirmpasscreate("Pass$123");
			
			up.setsavebtn();
			
			WebDriverWait wait= new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='btnCloseAlertModal']")));
			
			boolean bool=driver.findElement(By.xpath("//div[@class='modal-content'][1]")).getText().contains("Success");
			
			if(bool==true)
			{
				logger.info("Test Case Passed");
				Assert.assertTrue(true);
				driver.findElement(By.xpath("//button[@id='btnCloseAlertModal']")).click();	
			}
			else
			{
				logger.info("Test Case Failed");
				Assert.assertTrue(false);
				captureScreen(driver,"UserTest");
			}
			
			
			
		}
	
	

}
