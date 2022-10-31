package com.Mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass
{
	public OrderConfirmationPage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath=" //p[@class='alert alert-success']")
	WebElement orderSuccess;
	
	public String getValidateOrderMsg()
	{
		//String string=orderSuccess.getText();
			return "";
	}
}
