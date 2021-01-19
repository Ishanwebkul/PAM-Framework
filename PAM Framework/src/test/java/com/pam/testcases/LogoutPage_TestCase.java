package com.pam.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pam.base.BaseClass;
import com.pam.pages.Dashboard;
import com.pam.pages.LoginPage;
import com.pam.pages.LogoutPage;
import com.pam.utilities.TestUtil;

public class LogoutPage_TestCase extends BaseClass{
	
	LoginPage lp;
	Dashboard dashboard;
	LogoutPage logout;
	
	public LogoutPage_TestCase()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initilise();
		lp = new LoginPage();
		logout = new LogoutPage();
		dashboard = lp.login(pro.getProperty("username"), pro.getProperty("password"));
		logout = dashboard.clickonlogout();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
		
	@Test(priority = 1)
	public void paymentmethod_pagetitle_Test() throws Exception
	{
		String title = logout.validatelogoutpagetitle();
		Assert.assertEquals(title, "Login");
		TestUtil.Report("LogoutPage", "Logout");
	}
	
	@Test(priority = 2)
	public void verifyheading_Test()
	{
		Assert.assertTrue(logout.verifyheading());
	}

}
