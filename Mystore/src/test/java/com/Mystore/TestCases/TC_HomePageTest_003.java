package com.Mystore.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Mystore.base.BaseClass;
import com.Mystore.pageObjects.HomePage;
import com.Mystore.pageObjects.IndexPage;
import com.Mystore.pageObjects.LoginPage;

public class TC_HomePageTest_003 extends BaseClass
{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	@Test
	public void verifyWishList()
	{
		indexPage=new IndexPage(driver);
		loginPage=indexPage.clickSignIn();
		HomePage homePage= loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		boolean flag=homePage.validateWishlist();
		Assert.assertTrue(flag);
		
	}
	@Test
	public void verifyOrderHistory()
	{
		indexPage=new IndexPage(driver);
		loginPage=indexPage.clickSignIn();
		HomePage homePage= loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		boolean flag=homePage.ValidateOrderHistory();
		Assert.assertTrue(flag);

	}
	

}
