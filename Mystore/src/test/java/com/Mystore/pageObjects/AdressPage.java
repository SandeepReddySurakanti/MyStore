package com.Mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mystore.base.Action;
import com.Mystore.base.BaseClass;

public class AdressPage extends BaseClass
{
	public AdressPage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedToCheckElement;
	
	public ShippingPage clickProceedToCheckElement() 
	{
		Action.click(driver, proceedToCheckElement);
		return new ShippingPage();
		
	}

}
