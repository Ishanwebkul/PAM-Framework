package com.pam.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pam.base.BaseClass;
import com.pam.pages.Dashboard;
import com.pam.pages.LoginPage;
import com.pam.pages.Platform;

public class Platform_TestCase extends BaseClass {

	LoginPage lp;
	Dashboard dashboard;
	Platform platform;
	
	public Platform_TestCase()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initilise();
		lp = new LoginPage();
		platform = new Platform();
		dashboard = lp.login(pro.getProperty("username"), pro.getProperty("password"));
		platform = dashboard.clickonplatform();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void platformpagetitle_Test()
	{
		String title = platform.validateplatformpagetitle();
		Assert.assertEquals(title, "Platforms");
	}
	
	@Test(priority = 2)
	public void verifyheading_Test()
	{
		Assert.assertTrue(platform.verifyheading());
	}
	
}
