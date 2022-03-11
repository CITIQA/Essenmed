package com.essen.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	
	Properties pro=new Properties();
	
	public ReadConfig()
	{
		File src= new File("./Configuration/config.properties");
		
		try
		{
			FileInputStream fis= new FileInputStream(src);
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("The Exception is :" +e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String baseURL=pro.getProperty("baseURL");
		return baseURL;
	}
	
	public String getUsername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getBrowserName()
	{
		String BrowserName=pro.getProperty("BrowserName");
		return BrowserName;
	}

}
