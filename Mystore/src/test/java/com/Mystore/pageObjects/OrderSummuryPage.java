package com.Mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mystore.base.Action;
import com.Mystore.base.BaseClass;

public class OrderSummuryPage extends BaseClass 
{
	public OrderSummuryPage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']/span")
	WebElement confirmOrder;
	public OrderConfirmationPage clickOnConfirmOrder()
	{
		Action.click(driver, confirmOrder);
		return new OrderConfirmationPage();
	}
		
	

}
