package com.Mystore.pageObjects;

import org.apache.commons.lang3.Validate;
import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mystore.base.Action;
import com.Mystore.base.BaseClass;


public class HomePage  extends BaseClass
{
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='My wishlists']")
	WebElement myWishlist;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement orderHistory;
	
	public boolean validateWishlist()
	{
		 return Action.isDisplayed(driver, myWishlist);
	}
	
	public boolean ValidateOrderHistory()
	{
		return Action.isDisplayed(driver,orderHistory);
	}
	public String getHomePageURL()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String string=driver.getCurrentUrl();
		return string;
	}
	
}
