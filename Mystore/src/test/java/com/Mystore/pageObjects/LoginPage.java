package com.Mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mystore.base.Action;

public class LoginPage
{
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement email;
	@FindBy(xpath = "//*[@id=\"passwd\"]")
	WebElement password;
	@FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/p[2]/button[1]/span[1]")
	WebElement signInButton;
	
	@FindBy(xpath = "//input[@id='email_create']")
	WebElement emailforCreate;
	
	@FindBy(xpath = "//div[@class='submit']")
	WebElement submitButton;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement email1;
	
	@FindBy(id = "passwd")
	WebElement password1;
	@FindBy(id="SubmitLogin")
	WebElement submit1;
	/*public void setUserName(String s)
	{
		email.clear();
		email.sendKeys(s);
		
	}
	public void setPassword(String s)
	{
		password.clear();
		password.sendKeys(s);
		
	}
	public void clickSignInButton()
	{
		signInButton.click();
	}
	*/
	public HomePage login(String uname,String pass)
	{
		Action.type(email, uname);
		Action.type(password, pass);
		Action.click(ldriver, signInButton);
		Action.implicitWait(ldriver, 10);
		return new HomePage();
	}
	public AdressPage login1(String uname,String pass)
	{
		System.out.println("entered into login1 of login Page");
		Action.fluentWait(ldriver, email1, 10);		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		email1.sendKeys(uname);
		password1.sendKeys(pass);
		//Action.type(email1, uname);
		
		//Action.type(password1, pass);
		Action.click(ldriver, submit1);
		Action.implicitWait(ldriver, 10);
		return new AdressPage();
	}
	public CreateAccountPage createNewAccoutn(String email)
	{
		Action.type(emailforCreate, email);
		Action.click(ldriver, submitButton);
		return new CreateAccountPage();
	}
	
	
}
