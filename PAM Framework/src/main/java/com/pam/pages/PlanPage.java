package com.pam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.pam.base.BaseClass;

public class PlanPage extends BaseClass{
	
	@FindBy(xpath ="//h1[normalize-space()='Plan']")
	WebElement plan_heading;
	
	@FindBy(xpath ="//input[@id='plan_form_name']")
	WebElement plan_name;
	
	@FindBy(xpath ="//input[@id='plan_form_code']")
	WebElement plan_code;
	
	@FindBy(xpath ="//input[@id='plan_form_price']")
	WebElement plan_price;
	
	@FindBy(xpath ="//select[@id='plan_form_intervalType']")
	WebElement plan_interval;
			
	@FindBy(xpath ="//a[@title='Add']")
	WebElement plan_add;
	
	@FindBy(xpath ="//input[@id='plan_form_intervalValue']")
	WebElement plan_interval_value;
	
	@FindBy(xpath ="//textarea[@id='plan_form_description']")
	WebElement plan_description;
	
	@FindBy(xpath ="//button[normalize-space()='Create']")
	WebElement plan_create;
	
	@FindBy(xpath ="//a[normalize-space()='Cancel']")
	WebElement plan_cancel;
	
	@FindBy(xpath ="//body/main[1]/div[2]/div[1]/div[1]/form[1]/div[3]/button[1]")
	WebElement plan_update;
	
	public PlanPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String validateplanpagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyheading()
	{
		return plan_heading.isDisplayed();
	}
	
	public String CancelButton()
	{
		plan_add.click();
		plan_cancel.click();
		return driver.getTitle();
	}
	
	

	public void newentry(String pln_nme, String pln_code, String pln_prce, String pln_intrvl, String pln_intrvl_value, String pln_dscrpton, String pltfrm) throws Exception
	{		
		plan_add.click();
		plan_name.sendKeys(pln_nme);
		plan_code.sendKeys(pln_code);
		plan_price.sendKeys(pln_prce);
		Select select = new Select(driver.findElement(By.xpath("//select[@id='plan_form_intervalType']")));
		select.selectByVisibleText(pln_intrvl);
		
		try {
			plan_interval_value.clear();
			plan_interval_value.sendKeys(pln_intrvl_value);
		} catch (Exception e) {
			
		}
		plan_description.sendKeys(pln_dscrpton);
		int inum = Integer.valueOf(pltfrm);
		driver.findElement(By.xpath("//input[@id='plan_form_platforms_"+inum+"']")).click();
		plan_create.click();
		
	}
	
	public void update(String pln_nme, String pln_code, String pln_prce, String pln_intrvl, String pln_intrvl_value, String pln_dscrpton, String pltfrm) throws Exception
	{		
		plan_name.clear();
		plan_name.sendKeys(pln_nme);
		plan_code.clear();
		plan_code.sendKeys(pln_code);
		plan_price.clear();
		plan_price.sendKeys(pln_prce);
		Select select = new Select(driver.findElement(By.xpath("//select[@id='plan_form_intervalType']")));
		select.selectByVisibleText(pln_intrvl);
		
		try {
			plan_interval_value.clear();
			plan_interval_value.sendKeys(pln_intrvl_value);
		} catch (Exception e) {
			
		}
		plan_description.clear();
		plan_description.sendKeys(pln_dscrpton);
		int inum = Integer.valueOf(pltfrm);
		driver.findElement(By.xpath("//input[@id='plan_form_platforms_"+inum+"']")).click();
		plan_update.click();
		
	}
	
}
