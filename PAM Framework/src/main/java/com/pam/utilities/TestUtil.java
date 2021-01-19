package com.pam.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.pam.base.BaseClass;

public class TestUtil extends BaseClass {
 public static long PAGE_LOAD_TIMEOUT = 20;
 public static long IMPLICIT_WAIT = 10;

 
 public static String TestData_Sheetpath= "C:\\Users\\Ish\\eclipse-workspace\\PAM\\src\\main\\java\\com\\pam\\testdata\\TestData.xlsx";
  static Workbook book;
  static Sheet sheet;
  
  public static Object[][] getTestData(String Sheetname)
  {
	  FileInputStream file = null;
	  try {
		file = new FileInputStream(TestData_Sheetpath);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	  try {
		book = WorkbookFactory.create(file);
	} catch (Exception e) {
		
		e.printStackTrace();
	} 
	  sheet=book.getSheet(Sheetname);
	  Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	  for(int i=0; i<sheet.getLastRowNum();i++)
	  {
		  for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++)
		  {
			  data[i][k] = sheet.getRow(i +1).getCell(k).toString();
			  System.out.println(data[i][k]);
		  }
	  }
	  return data;
  }
  
  public static String takeScreenshotAtEndOfTest() throws IOException {
//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String currentDir = System.getProperty("user.dir");
//		FileUtil.c
//		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath = System.getProperty("user.dir")+"/Screenshots/learn_"+ System.currentTimeMillis() +".png";
		try {
			FileHandler.copy(src, new File(screenshotpath));
			System.out.println("Screenshot Captured");
		} 
		catch (Exception e) 
		{
			System.out.println("Unable to Capture Screenshot >>" + e.getMessage());
		}
		return screenshotpath;
	}
  
  public static String getCurrentDateTime()
	{
		DateFormat dateformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss"); 
		Date date = new Date();
		return dateformat.format(date);
	}
  
  public static void Report(String content, String capture) throws Exception
  {
	  logger = report.createTest(content);
	  logger.pass(capture, MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.takeScreenshotAtEndOfTest()).build());
  }
  
}
