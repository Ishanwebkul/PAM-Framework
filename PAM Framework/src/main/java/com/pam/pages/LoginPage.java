package com.pam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pam.base.BaseClass;

public class LoginPage extends BaseClass{

	@FindBy(xpath = "//body/main[1]/section[2]/div[2]/form[1]/div[1]/input[1]")
	WebElement username;
	
	@FindBy(xpath = "//body/main[1]/section[2]/div[2]/form[1]/div[2]/input[1]")
	WebElement password;
	
	@FindBy(xpath = "//body/main[1]/section[2]/div[2]/form[1]/div[4]/button[1]")
	WebElement submitbutton;
	
	@FindBy(xpath = "//body/main[1]/section[2]/div[1]/img[1]")
	WebElement logo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateloginpagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean VerifyLogo()
	{
		return logo.isDisplayed();
	}
	
	public Dashboard login(String un, String pd)
	{
		username.sendKeys(un);
		password.sendKeys(pd);
		submitbutton.click();
		return new Dashboard();
	}
	
}
