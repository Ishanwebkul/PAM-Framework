package com.pam.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pam.base.BaseClass;
import com.pam.pages.Dashboard;
import com.pam.pages.LoginPage;

public class LoginPage_TestCase extends BaseClass{
	LoginPage lp;
	Dashboard dashboard;
	
	public LoginPage_TestCase()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		initilise();
		lp = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void loginpageTitle_Test()
	{
		String title = lp.validateloginpagetitle();
		Assert.assertEquals(title, "Login");
	}
	
	@Test(priority = 2)
	public void Logo_Test()
	{
		boolean flag = lp.VerifyLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest()
	{
		dashboard = lp.login(pro.getProperty("username"), pro.getProperty("password"));
	}
	
}
