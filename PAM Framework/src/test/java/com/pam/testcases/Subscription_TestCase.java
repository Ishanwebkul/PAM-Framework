package com.pam.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pam.base.BaseClass;
import com.pam.pages.Dashboard;
import com.pam.pages.LoginPage;
import com.pam.pages.Subscription;
import com.pam.utilities.ExcelDataConfig;
import com.pam.utilities.TestUtil;

public class Subscription_TestCase extends BaseClass {
	
	LoginPage lp;
	Dashboard dashboard;
	Subscription sub;
	
	public Subscription_TestCase()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initilise();
		lp = new LoginPage();
		sub = new Subscription();
		dashboard = lp.login(pro.getProperty("username"), pro.getProperty("password"));
		sub = dashboard.clickonsubscription();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void CancelButton_Test()
	{
		sub.CancelButton();
	}
	
	@Test(priority = 2)
	public void paymentmethod_pagetitle_Test()
	{
		String title = sub.validatesubscriptionpagetitle();
		Assert.assertEquals(title, "Subscription");
	}
	
	@Test(priority = 3)
	public void verifyheading_Test()
	{
		Assert.assertTrue(sub.verifyheading());
	}
	
	@Test(priority = 4)
	public void ClearButton_Test()
	{
		sub.ClearButton();
	}
	
	// This is with the use of Excel
	@Test(priority = 5, dataProvider = "sub_details")
	public void filter_search(String ID) throws Exception
	{
		sub.filter_entry(ID);
		TestUtil.Report("Subscription_Page", "Subscription-Result");
	}
	
	@DataProvider(name = "sub_details")
	public Object[][] passdata()
	{
		ExcelDataConfig config = new ExcelDataConfig();
		// 1 is for sheet number
		int rows = config.getRowcount(2);
		// 7 is for number of columns
		Object[][] data = new Object[rows][1];
		for(int i=0; i<rows; i++)
		{
			data[i][0]= config.getdata(2, i, 0);

		}
		return data;
	}
	
	// This is for normal search while paramters
	@Test(priority = 6)
	public void filter_search() throws Exception
	{
		sub.filter_entry(" ");
	}
	
}
