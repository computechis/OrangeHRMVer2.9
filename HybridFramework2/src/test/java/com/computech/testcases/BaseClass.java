package com.computech.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.computech.factory.BrowserFactory;
import com.computech.factory.ConfigDataProvider;
import com.computech.utility.Helper;

public class BaseClass {

	WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	String path;
	@BeforeSuite
	public void setupTestSuite() {
		//D:\Workspace5PM\HybridFramework\src\test\resources\com\computech\Reports
		path =System.getProperty("user.dir") +"\\src\\test\\resources\\com\\computech\\Reports\\OrangeHRM.html";
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
		report = new ExtentReports();
		report.attachReporter(htmlReporter);

	}
	@BeforeClass
	public void setUp() {
		ConfigDataProvider config = new ConfigDataProvider();
		driver = BrowserFactory.startApplication(config.getStagingUrl(), config.getBrowser());
	}
	@AfterMethod
	public void tearDownTest(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			logger.pass("Test Passed");
		}
		else if(result.getStatus() == ITestResult.FAILURE)
		{
			try {
				logger.fail("Test Failed " + result.getThrowable().getMessage(), 
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		report.flush();
	}
	@AfterClass
	public void tearDown() {
		Helper.waitTo(3);
		BrowserFactory.closeApp(driver);
		//driver.get(path);
	}
}
