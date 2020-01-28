package com.computech.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.computech.factory.BrowserFactory;
import com.computech.factory.ConfigDataProvider;
import com.computech.factory.ExcelDataProvider;
import com.computech.pages.LoginPage;

public class DDFOrangHRMLoginTest {
	WebDriver driver;
	LoginPage lp;
	@BeforeClass
	public void setUp() {
		ConfigDataProvider config = new ConfigDataProvider();
		driver = BrowserFactory.startApplication(config.getStagingUrl(), config.getBrowser());
	}

	@Test
	public void login() {
		lp=PageFactory.initElements(driver, LoginPage.class);
		ExcelDataProvider excel = new ExcelDataProvider();
		lp.loginToApplication(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
	}
	
	@AfterClass
	public void tearDown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Exception message is : " + e.getMessage());
		}
		BrowserFactory.closeApp(driver);
	}
}
