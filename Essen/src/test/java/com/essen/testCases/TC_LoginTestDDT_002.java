package com.essen.testCases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.essen.pageObjects.LoginPage;
import com.essen.utilities.XLUtils;

public class TC_LoginTestDDT_002 extends BaseClass
{

	@Test(dataProvider ="LoginData",description="Login with Multiple Users")
	public void LoginTestDDT(String user,String pwd) throws InterruptedException, IOException
	{
		LoginPage lp= new LoginPage(driver);
		
		lp.setUsername(user);
		lp.setPassword(pwd);
		lp.setSignin();
		
		Thread.sleep(1000);
		SoftAssert softasserts= new SoftAssert();
		
		if(isLogoutPresent()==true)
		{
			logger.info("Login Test Passed");
			softasserts.assertTrue(true);
			lp.setLogout();
			Thread.sleep(3000);
			softasserts.assertAll();
		}
		else
		{
			captureScreen(driver, "LoginTestDDT");
			logger.info("Login Test Failed");
			softasserts.assertTrue(false);
			softasserts.assertAll();
			
		}
	}
	

	public boolean isLogoutPresent()
	{
		try
		{
			driver.findElement(By.xpath("//form[@id='logoutForm']/button[@type='submit']")).isDisplayed();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
			String path=System.getProperty("user.dir")+"/src/test/java/com/essen/testData/LoginData.xlsx";
			
			int rownum=XLUtils.getRowCount(path, "Sheet1"); 
			int colcount=XLUtils.getCellCount(path,"Sheet1",1); 
			
			
			String logindata[][]=new String[rownum][colcount];
			
			for(int i=1;i<=rownum;i++) 
			{
				for(int j=0;j<colcount;j++)
				{
					logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
				}
					
			}
	return logindata;
	}
	
	
}
