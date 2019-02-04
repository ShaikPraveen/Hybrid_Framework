package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	
	    @FindBy(name="uid")
	    @CacheLookup
	    WebElement userName;
	    
	    @FindBy(name="password")
	    @CacheLookup
	    WebElement userPassword;
	    
	    @FindBy(name="btnLogin")
	    @CacheLookup
	    WebElement loginBtn;
	    
	    @FindBy(xpath="//a[contains(text(),'Log out')]")
	    @CacheLookup
	    WebElement logout;
	    
	  
	    public void setUserName(String uname)
	    {
	    	userName.sendKeys(uname);
	    }
	    public void setUserPassword(String upassword)
	    {
	    	userPassword.sendKeys(upassword);
	    }
	    public void clickLoginBtn()
	    {
	    	loginBtn.click();
	    }
	    
	    public void clickLogout()
	    {
	    	logout.click();
	    }
	    

}
