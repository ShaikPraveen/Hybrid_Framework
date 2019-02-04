package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass
{
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	
	
	/*public String baseURL="https://demo.guru99.com/v4/";
	public String username="mngr176855";
	public String password="sEqAgUm";*/
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	  @Parameters("browser")
	  @BeforeClass
	  public void setUP(String br)
	  {
		  logger=Logger.getLogger("Banking");
		  PropertyConfigurator.configure("log4j.properties");//At RUN TIME log folder is Generated
		  
		  if (br.equals("chrome"))
		  {
			  //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "//Drivers//chromedriver.exe");
			  System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			  driver=new ChromeDriver();	
		} else
		{
			  System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			  driver=new FirefoxDriver();
		}
		  
		  
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  
		  driver.get(baseURL);
		  logger.info("BROWSER OPENED AND NAVIGATE TO URL");	  
	  }
      
	  @AfterClass
	  public void teatDown()
	  {
		  driver.quit();
		  logger.info("CLOSED BROWSER");
	  }
	  
	  public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
	  }
	  
	  
	  public String randomestring()
		 {
			 String generatedstring=RandomStringUtils.randomAlphabetic(8);
			 return(generatedstring);
		 }
		
		 
		 public static String randomeNumber()
		 {
			 String generatedstring2=RandomStringUtils.randomNumeric(5);
			 return(generatedstring2);
		 }
	  
	  
}
