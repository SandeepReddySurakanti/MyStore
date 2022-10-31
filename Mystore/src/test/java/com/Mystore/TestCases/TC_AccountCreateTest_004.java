package com.Mystore.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Mystore.base.BaseClass;
import com.Mystore.pageObjects.CreateAccountPage;
import com.Mystore.pageObjects.IndexPage;
import com.Mystore.pageObjects.LoginPage;

public class TC_AccountCreateTest_004 extends BaseClass
{
	IndexPage indexPage;
	LoginPage loginPage;
	CreateAccountPage createAccountPage;
	@Test
	public void verifyCreateAccount()
	{
		indexPage=new IndexPage(driver);
		loginPage=indexPage.clickSignIn();
		createAccountPage=loginPage.createNewAccoutn("qwerty@ac.com");
		boolean flag=createAccountPage.validateCreateAccount();
		Assert.assertTrue(flag);
		
		
	}

}
