package com.computech.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.computech.pages.LoginPage;

public class OrangHRMLoginTest1 extends BaseClass{
	
	LoginPage lp;
	

	@Test
	public void login() {
		lp=PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApplication();
	}
	
	
}
