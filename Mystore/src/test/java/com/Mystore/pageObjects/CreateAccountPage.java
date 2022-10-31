package com.Mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mystore.base.Action;
import com.Mystore.base.BaseClass;

public class CreateAccountPage extends BaseClass
{
	public CreateAccountPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[@class='page-heading']")
	WebElement createAccounttext;
	
	public boolean validateCreateAccount()
	{
		return Action.isDisplayed(driver, createAccounttext);
		
	}
}
