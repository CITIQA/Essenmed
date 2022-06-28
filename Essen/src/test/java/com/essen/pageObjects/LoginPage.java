package com.essen.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(how = How.XPATH,using="//input[@id='UserName']")
	WebElement TxtUserName;
	
	@FindBy(how = How.XPATH,using="//input[@id='Password']")
	WebElement TxtPassword;
	
	@FindBy(how = How.XPATH,using="//input[@value='SIGN IN']")
	WebElement Btnsignin;
	
	@FindBy(how = How.XPATH,using="//a[@href='/Account/ForgotPassword']")
	WebElement Btnforgotpassword;
	
	@FindBy(how = How.XPATH,using="//form[@id='logoutForm']/button[@type='submit']")
	WebElement BtnLogout;
	
	
	
	public void setUsername(String uname)
	{
		TxtUserName.clear();
		TxtUserName.sendKeys(uname);
	}
	
	public void setPassword(String upass)
	{
		TxtPassword.clear();
		TxtPassword.sendKeys(upass);
	}
	
	public void setSignin()
	{
		Btnsignin.click();
	}
	
	public void setForgot()
	{
		Btnforgotpassword.click();
	}
	
	public void setLogout()
	{
		BtnLogout.click();
	}
}
