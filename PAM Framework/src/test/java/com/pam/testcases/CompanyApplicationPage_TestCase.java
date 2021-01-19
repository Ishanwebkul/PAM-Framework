package com.pam.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pam.base.BaseClass;
import com.pam.pages.CompanyApplicationPage;
import com.pam.pages.Dashboard;
import com.pam.pages.LoginPage;

public class CompanyApplicationPage_TestCase extends BaseClass {

	LoginPage lp;
	Dashboard dashboard;
	CompanyApplicationPage CAP;
	
	public CompanyApplicationPage_TestCase()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initilise();
		lp = new LoginPage();
		CAP = new CompanyApplicationPage();
		dashboard = lp.login(pro.getProperty("username"), pro.getProperty("password"));
		CAP = dashboard.clickoncompanyapplication();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void CancelButton_Test()
	{
		CAP.CancelButton();
	}
	
	@Test(priority = 2)
	public void paymentmethod_pagetitle_Test()
	{
		String title = CAP.validatecompanyapplicationpagetitle();
		Assert.assertEquals(title, "Company Application");
	}
	
	@Test(priority = 3)
	public void verifyheading_Test()
	{
		Assert.assertTrue(CAP.verifyheading());
	}
	
	@Test(priority = 4)
	public void ClearButton_Test()
	{
		CAP.ClearButton();
	}
	
	@Test(priority = 5)
	public void filter_search() throws Exception
	{
		CAP.filter_entry("Marketing Cloud");
	}
	
}
