package com.pam.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pam.base.BaseClass;
import com.pam.pages.Dashboard;
import com.pam.pages.LoginPage;
import com.pam.pages.PaymentMethod;
import com.pam.utilities.TestUtil;
import com.pam.utilities.ExcelDataConfig;


public class PaymentMethod_TestCase extends BaseClass{

	LoginPage lp;
	Dashboard dashboard;
	PaymentMethod payment;
	
	public PaymentMethod_TestCase()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initilise();
		lp = new LoginPage();
		payment = new PaymentMethod();
		dashboard = lp.login(pro.getProperty("username"), pro.getProperty("password"));
		payment = dashboard.clickonpaymentmethod();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void CancelButton_Test()
	{
		String title = payment.CancelButton();
		Assert.assertEquals(title, "Payment Method");
	}
	
	@Test(priority = 2)
	public void paymentmethod_pagetitle_Test()
	{
		String title = payment.validatepaymentmethodpagetitle();
		Assert.assertEquals(title, "Payment Method");
	}
	
	@Test(priority = 3)
	public void verifyheading_Test()
	{
		Assert.assertTrue(payment.verifyheading());
	}
	
	// This method will be used when excel file is not working for creating
//	@Test(priority = 4)
//	public void create_paymentmethod() throws Exception
//	{
//		payment.newentry("Ishan", "40", "1", "Paypal Subscription", "Ishan Payment Method");
//		dashboard.clickonpaymentmethod();
//		TestUtil.Report("Payment_Page", "PaymentCreation-Result");
//		payment.newentry("Ishan_new", "50", "2", "Paypal Subscription", "Ishan Payment Method New");
//	}
	
	@Test(priority = 5)
	public void PaymentMethod_Delete() throws Exception
	{
		String paymentmethod_delete = "Ishan";
		//driver.findElement(By.xpath("//b[contains(text(),'Delete')]/following::td[5]/descendant::a[@class=\"btn btn-info wk-delete-row-js\"]")).click();
		driver.findElement(By.xpath("//b[contains(text(),'"+paymentmethod_delete+"')]/following::td[5]/descendant::a[@class=\"btn btn-info wk-delete-row-js\"]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		Thread.sleep(2000);
		TestUtil.Report("Payment_Page", "PaymentDelete-Result");
	}
	
	// This is used for creation using Excel 
	@Test(priority = 4, dataProvider = "details")
	public void plan_create(String Name, String Processor, String Description, String Position, String Platform) throws Exception
	{
		payment.newentry(Name, Processor, Description, Position, Platform);
		TestUtil.Report("Payment_Page", "PaymentCreate-Result");
	}
	
	@DataProvider(name = "details")
	public Object[][] passdata()
	{
		ExcelDataConfig config = new ExcelDataConfig();
		int rows = config.getRowcount(0);
		Object[][] data = new Object[rows][5];
		for(int i=0; i<rows; i++)
		{
			data[i][0]= config.getdata(0, i, 0);
			data[i][1]= config.getdata(0, i, 1);
			data[i][2]= config.getdata(0, i, 2);
			data[i][3]= config.getdata(0, i, 3);
			data[i][4]= config.getdata(0, i, 4);
			
			data[i][5]= config.getdata(0, i, 5);
			config.notify();
			
			int j = 0;
			data[j][5]= config;
		}
		return data;
	}
	
	
	
}
