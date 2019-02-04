package com.inetBanking.testCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddNewCustomer;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustTest_003 extends BaseClass 
{
	@Test
	public void addNewCustomerTest() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setUserPassword(password);
		lp.clickLoginBtn();
		
		Thread.sleep(3000);
		
		AddNewCustomer addcust=new AddNewCustomer(driver);
		addcust.clickAddNewCustomer();
		addcust.custName("Praveen");
		addcust.custgender("male");
		addcust.custdob("01","06","1990");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test case passed....");
			
		}
		else
		{
			logger.info("Test case failed....");
			captureScreen(driver,"addNewCustomerTest");
			Assert.assertTrue(false);
		}	
	}	
}
