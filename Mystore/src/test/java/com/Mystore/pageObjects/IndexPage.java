package com.Mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mystore.base.Action;

public class IndexPage
{
	WebDriver ldriver;
	public IndexPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement singInElement;
	
	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement logoElement;
	
	@FindBy(xpath="//input[@id='search_query_top']")
	WebElement searchBox;
	
	@FindBy(xpath="//button[@name='submit_search']")
	WebElement searchButton ;
	
	public LoginPage clickSignIn()
	{
		Action.click(ldriver, singInElement);
		 return new LoginPage(ldriver);
	}
	public boolean isLogoDisplayed()
	{
		 return Action.isDisplayed(ldriver, logoElement);
	}
	public String getPageTitle()
	{
		String titleString=ldriver.getTitle();
		return titleString;
	}
	public SearchResultPage searchProduct(String productname)
	{
		Action.type(searchBox, productname);
		Action.click(ldriver, searchButton);
		return new SearchResultPage();
	}
	
	

}
