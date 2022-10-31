/**
 * 
 */
package com.Mystore.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Mystore.base.BaseClass;
import com.Mystore.pageObjects.IndexPage;
import com.Mystore.pageObjects.SearchResultPage;

/**
 * @author HAI
 *
 */
public class TC_SearchResultPageTest_005 extends BaseClass
{
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	@Test
	public void verifySearchProduct()
	{
		indexPage=new IndexPage(driver);
		searchResultPage=indexPage.searchProduct("Shirt");
		boolean flag=searchResultPage.isProductAvailable();
		Assert.assertTrue(flag);
		
	}
	

}
