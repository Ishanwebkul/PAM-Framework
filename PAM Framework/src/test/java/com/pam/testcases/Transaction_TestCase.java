package com.pam.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pam.base.BaseClass;
import com.pam.pages.Dashboard;
import com.pam.pages.LoginPage;
import com.pam.pages.Transaction;

public class Transaction_TestCase extends BaseClass {
	
	LoginPage lp;
	Dashboard dashboard;
	Transaction tran;
	
	public Transaction_TestCase()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initilise();
		lp = new LoginPage();
		tran = new Transaction();
		dashboard = lp.login(pro.getProperty("username"), pro.getProperty("password"));
		tran = dashboard.clickontransaction();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void CancelButton_Test()
	{
		tran.CancelButton();
	}
	
	@Test(priority = 2)
	public void paymentmethod_pagetitle_Test()
	{
		String title = tran.validatetransactionpagetitle();
		Assert.assertEquals(title, "Transactions");
	}
	
	@Test(priority = 3)
	public void verifyheading_Test()
	{
		Assert.assertTrue(tran.verifyheading());
	}
	
	@Test(priority = 4)
	public void ClearButton_Test()
	{
		tran.ClearButton();
	}
	
	@Test(priority = 5)
	public void filter_search() throws Exception
	{
		tran.filter_entry("9652");
	}


}
