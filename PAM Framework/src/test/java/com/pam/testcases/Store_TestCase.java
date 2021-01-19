package com.pam.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pam.base.BaseClass;
import com.pam.pages.Dashboard;
import com.pam.pages.LoginPage;
import com.pam.pages.Store;

public class Store_TestCase extends BaseClass {

	LoginPage lp;
	Dashboard dashboard;
	Store store;
	
	public Store_TestCase()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initilise();
		lp = new LoginPage();
		store = new Store();
		dashboard = lp.login(pro.getProperty("username"), pro.getProperty("password"));
		store = dashboard.clickonstore();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void CancelButton_Test() throws Exception
	{
		logger = report.createTest("Cancel Button");
		store.CancelButton();
	}
	
	@Test(priority = 2)
	public void store_pagetitle_Test()
	{
		logger = report.createTest("Page Title");
		String title = store.validatestorepagetitle();
		Assert.assertEquals(title, "Store");
		
	}
	
	@Test(priority = 3)
	public void verifyheading_Test()
	{
		Assert.assertTrue(store.verifyheading());
	}
	
	@Test(priority = 4)
	public void ClearButton_Test()
	{
		store.ClearButton();
	}
	
	@Test(priority = 5)
	public void filter_search() throws Exception
	{
		store.filter_entry("webkul");
	}

	
}
