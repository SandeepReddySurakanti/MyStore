package com.Mystore.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Mystore.base.BaseClass;
import com.Mystore.pageObjects.AddToCartPage;
import com.Mystore.pageObjects.IndexPage;
import com.Mystore.pageObjects.SearchResultPage;

public class TC_AddTOCartTest_006 extends BaseClass
{
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	
	
	@Test
	public void verifyAddTOCart()
	{
		indexPage=new IndexPage(driver);
		searchResultPage=	indexPage.searchProduct("shirt");
		addToCartPage=searchResultPage.clickProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("S");
		addToCartPage.clickAddToCartbutton();
		boolean flag=addToCartPage.isProductAddedToCart();
		Assert.assertTrue(flag);
		
		
	}

}
