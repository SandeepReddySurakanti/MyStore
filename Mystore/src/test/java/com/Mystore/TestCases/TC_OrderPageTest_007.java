package com.Mystore.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Mystore.base.BaseClass;
import com.Mystore.pageObjects.AddToCartPage;
import com.Mystore.pageObjects.IndexPage;
import com.Mystore.pageObjects.OrderPage;
import com.Mystore.pageObjects.OrderSummuryPage;
import com.Mystore.pageObjects.SearchResultPage;

public class TC_OrderPageTest_007 extends BaseClass
{
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderSummuryPage orderSummuryPage;
	OrderPage orderPage;
	
	@Test
	public void verifyOrderDetails() throws Exception
	{
		indexPage= new IndexPage(driver);
		searchResultPage=indexPage.searchProduct("shirt");
		addToCartPage=searchResultPage.clickProduct();
		String quantity="10";
		addToCartPage.enterQuantity(quantity);
		addToCartPage.selectSize("M");
		addToCartPage.clickAddToCartbutton();
		orderPage= addToCartPage.clickOnProceedToCheckOut();
		double unitprice=orderPage.getUnitPrice();
		double totPrice=orderPage.getTotalPrice();
		double exptotalValue=(unitprice*Integer.parseInt(quantity))+2;//here 2 is shipping charges
		Assert.assertEquals(totPrice, exptotalValue);
		
		
		
		
		
	}

}
