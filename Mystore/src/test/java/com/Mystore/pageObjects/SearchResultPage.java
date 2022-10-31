package com.Mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mystore.base.Action;
import com.Mystore.base.BaseClass;

public class SearchResultPage extends BaseClass
{

	public SearchResultPage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@id=\"center_column\"]//img")
	WebElement productresult;
	
	public boolean isProductAvailable()
	{
		return Action.isDisplayed(driver, productresult);
		
	}
	public AddToCartPage clickProduct()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Action.click(driver, productresult);
		return new AddToCartPage();
	}
	
}
