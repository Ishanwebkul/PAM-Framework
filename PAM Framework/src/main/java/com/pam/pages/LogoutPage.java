package com.pam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pam.base.BaseClass;

public class LogoutPage extends BaseClass{
	
	@FindBy(xpath ="//body/main[1]/section[2]/div[1]/img[1]")
	WebElement logout_heading;
		
	public LogoutPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String validatelogoutpagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyheading()
	{
		return logout_heading.isDisplayed();
	}

}
