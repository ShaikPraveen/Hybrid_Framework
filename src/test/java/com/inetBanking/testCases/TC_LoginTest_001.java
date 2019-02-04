package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	
	@Test
	public void loginTest() throws IOException
	{
		//driver.get(baseURL);
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("ENTERED USERNAME");
		  
		lp.setUserPassword(password);
		logger.info("ENTERED PASSWORD");
		  
		lp.clickLoginBtn();
		logger.info("CLICKED LOGIN BUTTON");
		  
		if(driver.getCurrentUrl().equals("https://demo.guru99.com/v4/manager/Managerhomepage.php"))
		{
			
			Assert.assertTrue(true);
			logger.info("TITLE MATCHED, TEST PASS");
		}else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("TITLE NOT MATCHED, TEST FAIL");
		}	
	}
}
