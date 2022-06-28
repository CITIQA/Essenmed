package com.essen.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UsersPage 
{
	
	WebDriver ldriver;
	
	public UsersPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH,using="//li[@id='LI_16']")
	@CacheLookup
	WebElement AdminMainMenu;
	
	@FindBy(how= How.XPATH,using="//li[@id='LI_20']")
	@CacheLookup
	WebElement UsersMainMenu;
	
	@FindBy(how= How.CSS,using=".fas.fa-plus")
	@CacheLookup
	WebElement ExpandtheSearch;
	
	@FindBy(how= How.ID_OR_NAME,using="Name")
	@CacheLookup
	WebElement NametxtfieldSearch;
	
	@FindBy(how= How.XPATH,using="//*[@innertext='Select User Type'][2]")
	@CacheLookup
	WebElement UsertypeSearch;
	
	@FindBy(how= How.XPATH,using="//button[@title='None selected'][1]")
	@CacheLookup
	WebElement RolesSearchcreate;
	
	@FindBy(how= How.XPATH,using="//span[@innertext='Select Is Active Status']")
	@CacheLookup
	WebElement IsactivestatusSearch;
	
	@FindBy(how= How.XPATH,using="//span[@innertext='Select User Group']")
	@CacheLookup
	WebElement UsergroupSearch;
	
	@FindBy(how= How.XPATH,using="//button[@innertext='Clear']")
	@CacheLookup
	WebElement clearbuttonsearch;
	
	@FindBy(how= How.CSS,using="button[value='Submit']")
	@CacheLookup
	WebElement searchbuttonsearch;
	
	@FindBy(how= How.XPATH,using="//a[@href='/Admin/CreateUser/20']")
	@CacheLookup
	WebElement CreateUserBtn;
	
	@FindBy(how= How.XPATH,using="//span[@title='Select User Type']")
	@CacheLookup
	WebElement UsertypeCreate;
	
	@FindBy(how= How.ID_OR_NAME,using="UserName")
	@CacheLookup
	WebElement usernameCreate;
	
	@FindBy(how= How.ID_OR_NAME,using="FirstName")
	@CacheLookup
	WebElement firstnamecreate;
	
	@FindBy(how= How.ID_OR_NAME,using="LastName")
	@CacheLookup
	WebElement lastnamecreate;
	
	@FindBy(how= How.CSS,using="button[title='None selected']")
	@CacheLookup
	WebElement Rolecreate;
	
	@FindBy(how= How.ID_OR_NAME,using="Email")
	@CacheLookup
	WebElement emailcreate;
	
	@FindBy(how= How.ID_OR_NAME,using="Password")
	@CacheLookup
	WebElement passcreate;
	
	@FindBy(how= How.ID_OR_NAME,using="ConfirmPassword")
	@CacheLookup
	WebElement confirmpasscreate;
	
	@FindBy(how= How.XPATH,using="//button[@id='btnSave']/parent::div/input")
	@CacheLookup
	WebElement cancelbtn;
	
	@FindBy(how= How.XPATH,using="//button[@id='btnSave']")
	@CacheLookup
	WebElement savebtn;
	
	
	public void setAdminMenu()
	{
		AdminMainMenu.click();
	}
	
	public void setUsersMainMenu()
	{
		UsersMainMenu.click();
	}
	
	public void setCreateUserBtn()
	{
		CreateUserBtn.click();
	}
	
	public void setUsertypeCreateADAuth()
	{
		UsertypeCreate.click();
	}
	
	public void setUsertypeCreateformAuth()
	{
		UsertypeCreate.sendKeys(Keys.DOWN);
		UsertypeCreate.sendKeys(Keys.ENTER);
	}
	
	public void setUsername(String uname)
	{
		usernameCreate.clear();
		usernameCreate.sendKeys(uname);
	}
	
	public void setfirstnamecreate(String fname)
	{
		firstnamecreate.sendKeys(fname);
	}
	
	public void setlastnamecreate(String lname)
	{
		lastnamecreate.sendKeys(lname);
	}
	
	public void setRolecreate()
	{
		Rolecreate.click();
	}
	
	public void setemailcreate(String email)
	{
		emailcreate.sendKeys(email);
	}
	
	public void setpasscreate(String pass)
	{
		passcreate.sendKeys(pass);
	}
	
	public void setconfirmpasscreate(String conpass)
	{
		confirmpasscreate.sendKeys(conpass);
	}
	
	public void setcancelcreatebtn()
	{
		cancelbtn.click();
	}
		
	public void setsavebtn()
	{
		savebtn.click();
	}
	
}
