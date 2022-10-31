package com.Mystore.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Mystore.base.BaseClass;
import com.Mystore.pageObjects.IndexPage;

public class TC_IndexPage_001 extends BaseClass
{
	IndexPage indexPage;
	
	
	@Test
	public void verifyLogo()
	{
		indexPage=new IndexPage(driver);
		boolean result=indexPage.isLogoDisplayed();
		Assert.assertTrue(result);
		System.out.println("Hello@@@@@@@@@@@");
	}
	@Test
	public void verifyTitle()
	{
		indexPage=new IndexPage(driver);
		String titleString=indexPage.getPageTitle();
		Assert.assertEquals(titleString, "My Store");
		
	}

}
