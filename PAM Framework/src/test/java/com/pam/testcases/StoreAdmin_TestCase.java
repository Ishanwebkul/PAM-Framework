package com.pam.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pam.base.BaseClass;
import com.pam.pages.Dashboard;
import com.pam.pages.LoginPage;
import com.pam.pages.StoreAdmin;

public class StoreAdmin_TestCase extends BaseClass{
	
	LoginPage lp;
	Dashboard dashboard;
	StoreAdmin sd;
	
	public StoreAdmin_TestCase()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initilise();
		lp = new LoginPage();
		sd = new StoreAdmin();
		dashboard = lp.login(pro.getProperty("username"), pro.getProperty("password"));
		sd = dashboard.clickonstoreadmin();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void CancelButton_Test()
	{
		sd.CancelButton();
	}
	
	@Test(priority = 2)
	public void paymentmethod_pagetitle_Test()
	{
		String title = sd.validatestoreadminpagetitle();
		Assert.assertEquals(title, "Store Admin");
	}
	
	@Test(priority = 3)
	public void verifyheading_Test()
	{
		Assert.assertTrue(sd.verifyheading());
	}
	
	@Test(priority = 4)
	public void ClearButton_Test()
	{
		sd.ClearButton();
	}
	
	@Test(priority = 5)
	public void filter_search() throws Exception
	{
		sd.filter_entry("ishan.malhotra855@webkul.com");
	}


}
