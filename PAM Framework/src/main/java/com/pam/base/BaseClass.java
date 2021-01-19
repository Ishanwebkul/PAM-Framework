package com.pam.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pam.utilities.TestUtil;
import com.pam.utilities.WebEventListener;

public class BaseClass {
public static WebDriver driver;
public static Properties pro;
public static EventFiringWebDriver e_driver;
public static WebEventListener eventListener;
public static ExtentReports report;
public static ExtentTest logger;

@BeforeSuite
public void setupSuite()
{
	 ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Report/"+TestUtil.getCurrentDateTime()+".html"));
	 report = new ExtentReports();
	 report.attachReporter(extent);
}

@AfterMethod
public void tearDownMethod() throws IOException
{
	//ITestResult result
//	if(result.getStatus()==ITestResult.FAILURE)
//	{
//		//Helper.capturescreenshot(driver);
//		TestUtil.takeScreenshotAtEndOfTest();
//	}
//	else if(result.getStatus()==ITestResult.SUCCESS)
//	{
//		//Helper.capturescreenshot(driver);
//		TestUtil.takeScreenshotAtEndOfTest();
//	}
	report.flush();
}

	public BaseClass() 
	{
		try 
		{
			File src = new File("C:\\Users\\Ish\\eclipse-workspace\\PAM\\src\\main\\java\\com\\pam\\config\\config.properties");
			pro = new Properties();
			FileInputStream fis = new FileInputStream(src);
			pro.load(fis);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
	}
	
	public static void initilise()
	{
		String browsername = pro.getProperty("browser");
		if(browsername.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ish\\Downloads\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsername.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Ish\\Downloads\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Browser doesn't support");
		}
		
//		e_driver = new EventFiringWebDriver(driver);
//		eventListener = new WebEventListener();
//		e_driver.register(eventListener);
//		driver=e_driver;
		
		driver.manage().window().maximize();
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(pro.getProperty("url"));
	}
}
