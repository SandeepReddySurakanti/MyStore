package com.Mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.w3c.dom.DOMConfiguration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	public static WebDriver driver;
	 public  Properties properties;
	public Logger logger;
	@BeforeTest
	public void loadconfig()
	{
		
		logger=Logger.getLogger(this.getClass());
		PropertyConfigurator.configure("./Log4j.properties");
		properties=new Properties();
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream("./Configuration//config.properties");
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	@BeforeMethod
	public void luanchBrowser()
	{
		logger.info("Opening browser");
		loadBrowser();
		
	}
	@AfterMethod
	public void tearDown1()
	{ 
		
		logger.info("closing browser");
		driver.close();
	}
	
	public void loadBrowser()
	{
		String br=properties.getProperty("browser");
		if(br.contains("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (br.contains("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(properties.getProperty("baseurl"));
	}
	@AfterTest
	public void tearDown()
	{
		
	}

}
