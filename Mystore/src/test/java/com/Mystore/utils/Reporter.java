package com.Mystore.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Mystore.base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporter implements ITestListener
{
	ExtentSparkReporter htmlReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;
	
	public void onTestStart(ITestResult result) {  
		String timeunit= new SimpleDateFormat("dd.MM.yyyy.hh.mm").format(new Date());
		File f= new File("./ExtentReports"+timeunit+".html");
		htmlReporter=new ExtentSparkReporter(f);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setReportName("MY Reporter");
		htmlReporter.config().setDocumentTitle("Test Report");
		extentReports=new ExtentReports();
    	extentReports.attachReporter(htmlReporter);
    	extentReports.setSystemInfo("Tester", "Sandeep reddy");
    	extentReports.setSystemInfo("OS", "Windows");
    	extentReports.setSystemInfo("Framework", "TestNG");
    	extentReports.setSystemInfo("Browser", "Chrome");
    	
		
	}  
	  
	 
	public void onTestSuccess(ITestResult result) {  
	
	System.out.println("Success of test cases and its details are : "+result.getName());  
	extentTest=extentReports.createTest(result.getMethod().getMethodName());
	extentTest.log(Status.PASS, "The test passed is "+result.getMethod().getMethodName());
	
	}  
	  
	 
	public void onTestFailure(ITestResult result) {  
	
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	extentTest=extentReports.createTest(result.getMethod().getMethodName());
	extentTest.log(Status.FAIL, "The test failed is "+result.getMethod().getMethodName());
	extentTest.log(Status.FAIL, "The Reason for test failure is : "+result.getThrowable());
	String screenshotPath=getScreenShotPath(result);
	extentTest.addScreenCaptureFromPath(screenshotPath);
	}  
	  
	 
	public void onTestSkipped(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Skip of test cases and its details are : "+result.getName());  
	}  
	  
	 
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	  
	
	public void onStart(ITestContext context) {  
	// TODO Auto-generated method stub  
	}  
	  
	 
	public void onFinish(ITestContext context) {  
		extentReports.flush();
	}  
	 public String getScreenShotPath(ITestResult result)
	    {
	    	TakesScreenshot takesScreenshot=(TakesScreenshot) BaseClass.driver;
	    	File srcFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
	    	String destFilepathString="./ScreenShots//"+result.getMethod().getMethodName()+".png";
	    	File destFile =new File(destFilepathString);
	    	try {
				FileUtils.copyFile(srcFile, destFile);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	return destFilepathString;
	    }
	

}
