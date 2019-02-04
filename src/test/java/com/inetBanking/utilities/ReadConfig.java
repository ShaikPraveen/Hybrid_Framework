package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig
{
	Properties prop;
	
	public ReadConfig()
	{
		File src=new File("./Configuration/Config.properties");
		
		try 
		{
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);	
		} catch (Exception e) {
			System.out.println("EXCEPTION IS "+e.getMessage());
		}
	}
	
	
	  public String getApplicationURL()
	   {
		String url=prop.getProperty("baseURL");
		return url;
	   }
	  
	  public String getUserName()
	   {
		String username=prop.getProperty("username");
		return username;
	   }
	  
	  public String getPassword()
	   {
		String password=prop.getProperty("password");
		return password;
	   }
	  
	  public String getChromePath()
	   {
		String chpath=prop.getProperty("chromepath");
		return chpath;
	   }
	  
	  public String getFirefoxPath()
	   {
		String ffpath=prop.getProperty("firefoxpath");
		return ffpath;
	   }

}
