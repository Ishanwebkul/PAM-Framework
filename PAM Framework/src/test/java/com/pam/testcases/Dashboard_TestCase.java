package com.pam.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pam.base.BaseClass;
import com.pam.pages.Dashboard;
import com.pam.pages.LoginPage;
import com.pam.pages.Platform;
import com.pam.utilities.TestUtil;

public class Dashboard_TestCase extends BaseClass {
	LoginPage lp;
	Dashboard dashboard;
	Platform platform;

	public Dashboard_TestCase()
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
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void dashbaordpageTitle_Test() throws Exception
	{
		String dashboardtitle = dashboard.validatedashboardpagetitle();
		Assert.assertEquals(dashboardtitle, "Dashboard", "Dashboard title not matched");
		TestUtil.Report("Dashboard_Page", "Dashboard");
	}
	
	@Test(priority = 2)
	public void verifyusername_Test()
	{
		Assert.assertTrue(dashboard.verifyusername());
	}
	
	@Test(priority = 3)
	public void clickonplatforms()
	{
		platform = dashboard.clickonplatform();
	}
	
}
