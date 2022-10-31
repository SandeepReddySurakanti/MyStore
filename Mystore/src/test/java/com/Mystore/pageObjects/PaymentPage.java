package com.Mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mystore.base.Action;
import com.Mystore.base.BaseClass;

public class PaymentPage extends BaseClass 
{
	public PaymentPage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@class='bankwire']")
	WebElement payByBankWire;
	@FindBy(xpath = "//a[@class='cheque']")
	WebElement payByCheque;
	public OrderSummuryPage clickOnPayByWire()
	{
		Action.click(driver, payByBankWire);
		return new OrderSummuryPage();
		
	}
	public OrderSummuryPage clickOnPayByCheque()
	{
		Action.click(driver, payByCheque);
		return new OrderSummuryPage();
	}

}
