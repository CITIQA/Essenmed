package com.essen.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(name="UserName")
	WebElement TxtUserName;
	
	@FindBy(name="Password")
	WebElement TxtPassword;
	
	@FindBy(xpath="//input[@value='SIGN IN']")
	WebElement Btnsignin;
	
	@FindBy(xpath="//a[@href='/Account/ForgotPassword']")
	WebElement Btnforgotpassword;
	
	@FindBy(xpath="//form[@id='logoutForm']/button[@type='submit']")
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
