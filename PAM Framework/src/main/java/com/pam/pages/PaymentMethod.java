package com.pam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.pam.base.BaseClass;

public class PaymentMethod extends BaseClass{
	
	@FindBy(xpath ="//h1[contains(text(),'Payment Method')]")
	WebElement heading;
	
	@FindBy(xpath ="//input[@id='payment_form_name']")
	WebElement payment_name;
	
	@FindBy(xpath ="//input[@id='payment_form_position']")
	WebElement payment_position;
	
	@FindBy(xpath ="//input[@id='payment_form_description']")
	WebElement payment_description;
	
	@FindBy(xpath ="//button[contains(text(),'Create')]")
	WebElement payment_create;
		
	@FindBy(xpath ="//body/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]")
	WebElement payment_add;
	
	@FindBy(xpath ="//a[contains(text(),'Cancel')]")
	WebElement payment_cancel;
	
	public PaymentMethod()
	{
		PageFactory.initElements(driver, this);
	}

	public String validatepaymentmethodpagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyheading()
	{
		return heading.isDisplayed();
	}
	
	public String CancelButton()
	{
		payment_add.click();
		payment_cancel.click();
		return driver.getTitle();
	}
	
	public void newentry(String pymnt_name, String pymnt_position, String pltfm, String processor, String pymnt_description)
	{
		payment_add.click();
		payment_name.sendKeys(pymnt_name);
		payment_position.sendKeys(pymnt_position);
		//int wk= pltfm;
		int inum = Integer.valueOf(pltfm);
		driver.findElement(By.xpath("//input[@id='payment_form_platform_"+inum+"']")).click();
		Select select = new Select(driver.findElement(By.xpath("//select[@id='payment_form_processor']")));
		select.selectByVisibleText(processor);
		payment_description.sendKeys(pymnt_description);
		payment_create.click();
	}
	
}
