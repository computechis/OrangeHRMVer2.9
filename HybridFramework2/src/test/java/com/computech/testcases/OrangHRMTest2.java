package com.computech.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.computech.pages.LoginPage;
import com.computech.pages.LogoutPage;

public class OrangHRMTest2 extends BaseClass{
	LoginPage lp;
	LogoutPage lout;
	@Test
	public void logout() {
		logger = report.createTest("OrangeHRM LoginTest");
		lp=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Browser and Application is up and running..");
		lp.loginToApplication();
		logger.pass("Login done successfully..");
		lout=PageFactory.initElements(driver, LogoutPage.class);
		lout.logoutFromTheApp();
		logger.pass("Logout done successfully..");
	}
	
}
