package com.pam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pam.base.BaseClass;

public class Platform extends BaseClass {

	public String validateplatformpagetitle()
	{
		return driver.getTitle();
	}

	@FindBy(xpath="//h1[contains(text(),'Platforms')]")
	WebElement heading;
	
	public Platform()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyheading()
	{
		return heading.isDisplayed();
	}
	
	
	
}
