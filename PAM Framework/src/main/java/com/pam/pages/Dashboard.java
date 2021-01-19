package com.pam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pam.base.BaseClass;

public class Dashboard extends BaseClass{
	
	@FindBy(xpath = "//header/a[1]/img[1]")
	WebElement wk_logo;
	
	@FindBy(className = "app-sidebar__user-name")
	WebElement wk_username;
	
	@FindBy(xpath = "//span[contains(text(),'Platforms')]")
	WebElement wk_platform;
	
	@FindBy(xpath = "//body/aside[1]/ul[1]/li[3]/a[1]/span[1]")
	WebElement wk_application;

	@FindBy(xpath = "//span[contains(text(),'Store')]")
	WebElement wk_store;
	
	@FindBy(xpath = "//span[contains(text(),'Company Application')]")
	WebElement wk_companyapplication;
	
	@FindBy(xpath = "//span[contains(text(),'Payment Method')]")
	WebElement wk_paymentmethod;
	
	@FindBy(xpath = "//span[contains(text(),'Plan')]")
	WebElement wk_plan;
	
	@FindBy(xpath = "//span[contains(text(),'Subscription')]")
	WebElement wk_subscription_main;
	
	@FindBy(xpath = "//body/aside[1]/ul[1]/li[8]/ul[1]/li[1]/a[1]")
	WebElement wk_subscription;
	
	@FindBy(xpath = "//body/aside[1]/ul[1]/li[8]/ul[1]/li[2]/a[1]")
	WebElement wk_subscription_transaction;
	
	@FindBy(xpath = "//span[contains(text(),'User')]")
	WebElement wk_user;
	
	@FindBy(xpath = "//body/aside[1]/ul[1]/li[9]/ul[1]/li[1]/a[1]")
	WebElement wk_administrator;
	
	@FindBy(xpath = "//body/aside[1]/ul[1]/li[9]/ul[1]/li[2]/a[1]")
	WebElement wk_storeadmin;
	
	@FindBy(xpath = "//span[contains(text(),'Setting')]")
	WebElement wk_setting;
	
	@FindBy(xpath = "//span[contains(text(),'Logout')]")
	WebElement wk_logout;
	
	public Dashboard()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validatedashboardpagetitle()
	{
		return driver.getTitle();
	}
	
	public Platform clickonplatform()
	{
		wk_platform.click();
		return new Platform();
	}
	
	public ApplicationPage clickonapplication()
	{
		wk_application.click();
		return new ApplicationPage();
	}
	
	public Store clickonstore()
	{
		wk_store.click();
		return new Store();
	}
	
	public CompanyApplicationPage clickoncompanyapplication()
	{
		wk_companyapplication.click();
		return new CompanyApplicationPage();
	}
	
	public PaymentMethod clickonpaymentmethod()
	{
		wk_paymentmethod.click();
		return new PaymentMethod();
	}
	
	public PlanPage clickonplan()
	{
		wk_plan.click();
		return new PlanPage();
	}
	
	public Subscription clickonsubscription()
	{
		wk_subscription_main.click();
		wk_subscription.click();
		return new Subscription();
	}
	
	public Transaction clickontransaction()
	{
		wk_subscription_main.click();
		wk_subscription_transaction.click();
		return new Transaction();
	}
	
	public Administrator clickonadministrator()
	{
		wk_user.click();
		wk_administrator.click();
		return new Administrator();
	}
	
	public StoreAdmin clickonstoreadmin()
	{
		wk_user.click();
		wk_storeadmin.click();
		return new StoreAdmin();
	}
		
	public SettingsPage clickonsetting()
	{
		wk_setting.click();
		return new SettingsPage();
	}
	
	public LogoutPage clickonlogout()
	{
		wk_logout.click();
		return new LogoutPage();
	}
	
	public boolean verifyusername()
	{
		return wk_username.isDisplayed();
	}
}
