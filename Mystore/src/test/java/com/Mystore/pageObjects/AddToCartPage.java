package com.Mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mystore.base.Action;
import com.Mystore.base.BaseClass;
import com.google.common.collect.Ordering;

public class AddToCartPage extends BaseClass 
{
	public AddToCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='quantity_wanted']")
	WebElement quantityWanted;
	@FindBy(xpath = "//select[@id='group_1']")
	WebElement selectSize;
	
	@FindBy(xpath="//button[@name='Submit']")
	WebElement addToCartButton;
	
	@FindBy(xpath = "//*[@id='layer_cart']//h2/i")
	WebElement productAddedSuccess;
	
	@FindBy (xpath = " //a[@title='Proceed to checkout']/span")
	WebElement proceedToCheckoutButton;
	
	public void clickAddToCartbutton() 
	{
		Action.click(driver, addToCartButton);
		
	}
	public void enterQuantity(String quantity)
	{
		Action.type(quantityWanted, quantity);
		
	}
	public void selectSize(String size)
	{
		Action.selectByVisibleText(size, selectSize);
		
	}
	public boolean isProductAddedToCart()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return Action.isDisplayed(driver, productAddedSuccess);
		
	}
	public OrderPage clickOnProceedToCheckOut() throws Exception
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Action.JSClick(driver, proceedToCheckoutButton);
		return new OrderPage();
		
	}
	
}
