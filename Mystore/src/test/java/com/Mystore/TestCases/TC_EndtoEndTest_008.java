package com.Mystore.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Mystore.base.BaseClass;
import com.Mystore.pageObjects.AddToCartPage;
import com.Mystore.pageObjects.AdressPage;
import com.Mystore.pageObjects.IndexPage;
import com.Mystore.pageObjects.LoginPage;
import com.Mystore.pageObjects.OrderConfirmationPage;
import com.Mystore.pageObjects.OrderPage;
import com.Mystore.pageObjects.OrderSummuryPage;
import com.Mystore.pageObjects.PaymentPage;
import com.Mystore.pageObjects.SearchResultPage;
import com.Mystore.pageObjects.ShippingPage;

public class TC_EndtoEndTest_008 extends BaseClass
{
	IndexPage indexPage;
	LoginPage loginPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	AdressPage adressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummuryPage orderSummuryPage;
	OrderConfirmationPage orderConfirmationPage;
	@Test
	public void verifyEndToEnd() throws Exception
	{
		indexPage=new IndexPage(driver);
		searchResultPage=indexPage.searchProduct("shirt");
		addToCartPage=searchResultPage.clickProduct();
		addToCartPage.selectSize("M");
		addToCartPage.enterQuantity("2");
		addToCartPage.clickAddToCartbutton();
		System.out.println("@@@hello1");
		orderPage=addToCartPage.clickOnProceedToCheckOut();
		Thread.sleep(3000);
		System.out.println("@@@hello2");
		loginPage=orderPage.clickOnproceedToCheckOutButton();
		System.out.println("@@@hello3");
		adressPage=loginPage.login1(properties.getProperty("username"),properties.getProperty("password"));
		System.out.println("@@@hello4");
		shippingPage=adressPage.clickProceedToCheckElement();
		shippingPage.clickOnTermsCond();
		paymentPage=shippingPage.clickProceedToCheckElement();
		orderSummuryPage=paymentPage.clickOnPayByWire();
		orderConfirmationPage=orderSummuryPage.clickOnConfirmOrder();
		String actualResult=orderConfirmationPage.getValidateOrderMsg();
		String expResult="Your order on My Store is complete.";
		//Assert.assertEquals(actualResult, expResult);
		Assert.assertTrue(driver.getPageSource().contains(expResult)	);
		
		
		
		
		
		
		
		
		
	}
	
	

}
