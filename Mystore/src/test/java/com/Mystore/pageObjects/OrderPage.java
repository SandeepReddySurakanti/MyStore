package com.Mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mystore.base.Action;
import com.Mystore.base.BaseClass;

public class OrderPage extends BaseClass
{
	public OrderPage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"product_price_1_1_0\"]/span")
	WebElement unitPrice;
	
	@FindBy(xpath = "  //span[@id='total_price']")
	WebElement totalPrice;
	@FindBy(xpath = "  //a[@title='Proceed to checkout' and @class='button btn btn-default standard-checkout button-medium'] /span")
	WebElement proceedToCheckOutButton;
	
	public LoginPage clickOnproceedToCheckOutButton() throws Exception
	{
		Action.fluentWait(driver, proceedToCheckOutButton, 10);
		Action.JSClick(driver, proceedToCheckOutButton);
		return new LoginPage(driver);
	}	
		
	
	public double getUnitPrice()
	{
		Action.fluentWait(driver, unitPrice, 10);
		driver.navigate().refresh();
		String priceString= unitPrice.getText();
		System.out.println("Unit price is : "+priceString);
		double unit= Double.parseDouble(priceString.replace("[^a-zA-Z0-9]","" ));
		return unit/100;
	}
	public double getTotalPrice()
	{
		String tpriceString= totalPrice.getText();
		System.out.println("total price is : "+tpriceString);
		double tot= Double.parseDouble(tpriceString.replace("[^a-zA-Z0-9]","" ));
		return tot/100;
		
	}
		
	

}
