package com.pam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.pam.base.BaseClass;
import com.pam.utilities.TestUtil;

public class CompanyApplicationPage extends BaseClass {

	@FindBy(xpath ="//body/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]")
	WebElement Filter;
	
	@FindBy(xpath ="//h1[contains(text(),'Company Application')]")
	WebElement heading;
	
	@FindBy(xpath ="//button[contains(text(),'Cancel')]")
	WebElement filter_cancel;
	
	@FindBy(xpath ="//button[contains(text(),'Clear')]")
	WebElement filter_clear;
	
	@FindBy(xpath ="//button[contains(text(),'Submit')]")
	WebElement filter_submit;
	
	@FindBy(xpath ="//body/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/span[1]/span[1]/span[1]/ul[1]/li[1]/input[1]")
	WebElement filter_platform;
	
	@FindBy(xpath ="//body/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/span[1]/span[1]/span[1]/span[1]")
	WebElement filter_company;
	
	@FindBy(xpath ="//select[@name=\"application_id\"]")
	String filter_application;
	
	
	public CompanyApplicationPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String validatecompanyapplicationpagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyheading()
	{
		return heading.isDisplayed();
	}
	
	public void CancelButton()
	{
		Filter.click();
		filter_cancel.click();
	}
	
	public void ClearButton()
	{
		Filter.click();
		filter_clear.click();
	}
	
	public void filter_entry(String application) throws Exception
	{
		Filter.click();
		Select select = new Select(driver.findElement(By.xpath("//select[@name=\"application_id\"]")));
		select.selectByVisibleText(application);
		filter_submit.click();
		TestUtil.Report("CompanyApplication_Page", "Filter-Result");
//		Thread.sleep(5000);
	}
	
}
