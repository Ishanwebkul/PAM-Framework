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
import com.pam.pages.PlanPage;
import com.pam.utilities.ExcelDataConfig;
import com.pam.utilities.TestUtil;

public class PlanPage_TestCase extends BaseClass{
	
//	@FindBy(xpath ="a[contains(text(),'Delete')]/following::td[6]/descendant::a[@class=\"btn btn-info wk-delete-row-js\"]")
//	WebElement plan_delete;

	LoginPage lp;
	Dashboard dashboard;
	PlanPage plan;
	
	public PlanPage_TestCase()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initilise();
		lp = new LoginPage();
		plan = new PlanPage();
		dashboard = lp.login(pro.getProperty("username"), pro.getProperty("password"));
		plan = dashboard.clickonplan();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
		
	//This is for plan creation with parameters with method
//	@Test(priority = 1)
//	public void create_plan() throws Exception
//	{
//		plan.newentry("", "", "", "Monthly", "5", "Ishan Plan made for testing", "2");
//		TestUtil.Report("Plan Page", "PlanCreation-Result");
//		dashboard.clickonplan();
//		plan.newentry("", "Ish_Quarter", "190", "Quarterly", "2", "", "1");
//		TestUtil.Report("Plan Page", "PlanCreation-Result");
//		dashboard.clickonplan();
//		plan.newentry("Ishan_new_Plan_Days", "", "10", "Days", "", "Ishan Plan made for Days testing", "2");
//		TestUtil.Report("Plan Page", "PlanCreation-Result");
//		dashboard.clickonplan();
//		plan.newentry("Ishan_Webkul", "Ish_Days", "10", "Days", "3", "Ishan Plan made for Days testing", "1");
//		//Thread.sleep(8000);
//	}
	
	@Test(priority = 1)
	public void CancelButton_Test()
	{
		String title = plan.CancelButton();
		Assert.assertEquals(title, "Plan");
	}
	
	@Test(priority = 2)
	public void ValidatePlan_PageTitle_Test()
	{
		String title = plan.validateplanpagetitle();
		Assert.assertEquals(title, "Plan");
	}
	
	@Test(priority = 3)
	public void verifyheading_Test()
	{
		Assert.assertTrue(plan.verifyheading());
	}
	
	// This is for Excel file plan creation
		@Test(priority = 4, dataProvider = "plan_details")
		public void plan_create(String PlanName, String Plan_Code, String Plan_Price, String Plan_Interval, String Plan_Interval_Value, String Plan_Description, String Platform) throws Exception
		{
			// Platform entry is must in Excel for creating plan
			plan.newentry(PlanName, Plan_Code, Plan_Price, Plan_Interval, Plan_Interval_Value, Plan_Description, Platform);
			TestUtil.Report("Plan_Page", "PlanCreate-Result");
		}
		
		@DataProvider(name = "plan_details")
		public Object[][] passdata()
		{
			ExcelDataConfig config = new ExcelDataConfig();
			// 1 is for sheet number
			int rows = config.getRowcount(1);
			// 7 is for number of columns
			Object[][] data = new Object[rows][7];
			for(int i=0; i<rows; i++)
			{
				data[i][0]= config.getdata(1, i, 0);
				data[i][1]= config.getdata(1, i, 1);
				data[i][2]= config.getdata(1, i, 2);
				data[i][3]= config.getdata(1, i, 3);
				data[i][4]= config.getdata(1, i, 4);
				data[i][5]= config.getdata(1, i, 5);
				data[i][6]= config.getdata(1, i, 6);
			}
			return data;
		}
		
		@Test(priority = 5, dataProvider = "plan_update")
		public void Plan_Update(String PlanName, String Plan_Code, String Plan_Price, String Plan_Interval, String Plan_Interval_Value, String Plan_Description, String Platform) throws Exception
		{
			String planupdate = "noida456";
			driver.findElement(By.xpath("//a[contains(text(),'"+planupdate+"')]/following::td[6]/descendant::a[@class=\"btn btn-info\"]")).click();
			plan.update(PlanName, Plan_Code, Plan_Price, Plan_Interval, Plan_Interval_Value, Plan_Description, Platform);
			TestUtil.Report("Plan Page", "PlanUpdate-Result");
//			Thread.sleep(5000);
		}
		
		@DataProvider(name = "plan_update")
		public Object[][] passdata1()
		{
			ExcelDataConfig config = new ExcelDataConfig();
			// 1 is for sheet number
			int rows = config.getRowcount(3);
			// 7 is for number of columns
			Object[][] data = new Object[rows][7];
			for(int i=0; i<rows; i++)
			{
				data[i][0]= config.getdata(3, i, 0);
				data[i][1]= config.getdata(3, i, 1);
				data[i][2]= config.getdata(3, i, 2);
				data[i][3]= config.getdata(3, i, 3);
				data[i][4]= config.getdata(3, i, 4);
				data[i][5]= config.getdata(3, i, 5);
				data[i][6]= config.getdata(3, i, 6);
			}
			return data;
		}

	@Test(priority = 6)
	public void Plan_Delete() throws Exception
	{
		String plandelete = "Gurgaon";
		driver.findElement(By.xpath("//a[contains(text(),'"+plandelete+"')]/following::td[6]/descendant::a[@class=\"btn btn-info wk-delete-row-js\"]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		Thread.sleep(2000);
		TestUtil.Report("Plan Page", "PlanDelete-Result");
//		Thread.sleep(5000);
	}
	
}
