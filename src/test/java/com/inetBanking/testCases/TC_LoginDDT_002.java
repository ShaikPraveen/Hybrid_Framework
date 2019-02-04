package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	
	@Test(dataProvider="getData")
	public void loginDDT(String userid, String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(userid);
		logger.info("userid entered");
		lp.setUserPassword(pwd);
		logger.info("password entered");
		lp.clickLoginBtn();
		
		Thread.sleep(2000);
		
		if (isAlertPresent()==true) 
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed With Invaild Credentails");
		} else 
		{
			Assert.assertTrue(true);
			logger.info("Login Passed With vaild Credentials");
			lp.clickLogout();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
        }
	}
	
	
	public  boolean isAlertPresent()//User defined method created to check Alert ir Present or not
	{
		try
		{
			driver.switchTo().alert();
			return true;
			
		}catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"//src//test//java//com//inetBanking//testData//TestData.xlsx";
		
		int rowcount=XLUtils.getRowCount(path, "Login_Data");
		int cellcount=XLUtils.getCellCount(path, "Login_Data", 1);
		
		Object[][] data = new Object[rowcount][cellcount];
		
		for (int i = 1; i<=rowcount; i++)
		{
			for (int j = 0; j<cellcount ; j++) 
			{
				data[i-1][j]=XLUtils.getCellData(path, "Login_Data", i, j);
			}	
		}
		return data;	
	}
}
