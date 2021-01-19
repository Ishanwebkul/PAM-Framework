package com.pam.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pam.base.BaseClass;
import com.pam.pages.Administrator;
import com.pam.pages.Dashboard;
import com.pam.pages.LoginPage;

public class Administrator_TestCase extends BaseClass {
	
	LoginPage lp;
	Dashboard dashboard;
	Administrator admin;
	
	public Administrator_TestCase()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initilise();
		lp = new LoginPage();
		admin = new Administrator();
		dashboard = lp.login(pro.getProperty("username"), pro.getProperty("password"));
		admin = dashboard.clickonadministrator();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void CancelButton_Test()
	{
		admin.CancelButton();
	}
	
	@Test(priority = 2)
	public void Administrator_pagetitle_Test()
	{
		String title = admin.validateadministartorpagetitle();
		Assert.assertEquals(title, "Administrator");
	}
	
	@Test(priority = 3)
	public void verifyheading_Test()
	{
		Assert.assertTrue(admin.verifyheading());
	}
	
	@Test(priority = 4)
	public void ClearButton_Test()
	{
		admin.ClearButton();
	}
	
	@Test(priority = 5)
	public void filter_search() throws Exception
	{
		admin.filter_entry("shopify@webkul.com");
	}


}
