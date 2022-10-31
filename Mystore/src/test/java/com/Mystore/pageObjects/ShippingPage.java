package com.Mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mystore.base.Action;
import com.Mystore.base.BaseClass;

public class ShippingPage extends BaseClass 
{
	public ShippingPage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//button[@name='processCarrier']/span")
	WebElement proceedToCheckElement;
	
	@FindBy(id="cgv")
	WebElement termCheckbox;
	
	public PaymentPage clickProceedToCheckElement() 
	{
		Action.click(driver, proceedToCheckElement);
		return new PaymentPage();
		
	}
	public void clickOnTermsCond() 
	{
		Action.click(driver, termCheckbox);
		
	}
	

}
