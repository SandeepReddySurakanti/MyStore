package com.Mystore.TestCases;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Mystore.base.BaseClass;
import com.Mystore.pageObjects.HomePage;
import com.Mystore.pageObjects.IndexPage;
import com.Mystore.pageObjects.LoginPage;

public class TC_VerifyLogin_002 extends BaseClass 
{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	@Test
	public void verifyLogin()
	{
		indexPage=new IndexPage(driver);
		loginPage=indexPage.clickSignIn();
		HomePage homePage= loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		String expURLString=homePage.getHomePageURL();
		String actURLString="http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(expURLString, actURLString);
		
	}

}
