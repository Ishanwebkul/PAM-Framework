package com.pam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pam.base.BaseClass;
import com.pam.utilities.TestUtil;

public class Administrator extends BaseClass {
	
	@FindBy(xpath ="//body/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]")
	WebElement filter_button;
	
	@FindBy(xpath ="//h1[contains(text(),'Administrator')]")
	WebElement heading;
	
	@FindBy(xpath ="//button[contains(text(),'Cancel')]")
	WebElement filter_cancel;
	
	@FindBy(xpath ="//button[contains(text(),'Clear')]")
	WebElement filter_clear;
	
	@FindBy(xpath ="//button[contains(text(),'Submit')]")
	WebElement filter_submit;
		
	@FindBy(xpath ="//input[@id='search_email']")
	WebElement filter_email;
	
	public Administrator()
	{
		PageFactory.initElements(driver, this);
	}

	public String validateadministartorpagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyheading()
	{
		return heading.isDisplayed();
	}
	
	public void CancelButton()
	{
		filter_button.click();
		filter_cancel.click();
	}
	
	public void ClearButton()
	{
		filter_button.click();
		filter_clear.click();
	}
	
	public void filter_entry(String email) throws Exception
	{
		filter_button.click();
		filter_email.sendKeys(email);
		filter_submit.click();
		TestUtil.Report("Administrator_Page", "Filter-Result");
	}


}
