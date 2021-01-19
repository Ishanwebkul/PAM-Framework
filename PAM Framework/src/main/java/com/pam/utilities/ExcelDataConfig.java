package com.pam.utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	Cell cell_neew;
	String value;
	Cell data;
	
	public ExcelDataConfig()
	{
		try {
			// This working fine when we load the excel from package
//			File src= new File("./src/main/java/com/pam/testdata/TestData_PAM.xlsx");
			File src= new File("C:\\Users\\Ish\\Desktop\\TestData_PAM.xlsx");
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getdata(int sheetnumber, int row, int column) 
	{
		sheet = wb.getSheetAt(sheetnumber);
		DataFormatter formatter = new DataFormatter();
		String data = formatter.formatCellValue(sheet.getRow(row).getCell(column));
//		String data = sheet.getRow(row).getCell(column).getStringCellValue().toString();
		System.out.println(data);
		return data;
	}
//	
	public int getRowcount(int sheetindex)
	{
		int row = wb.getSheetAt(sheetindex).getLastRowNum();
		row = row+1;
		return row;
	}
	
}
