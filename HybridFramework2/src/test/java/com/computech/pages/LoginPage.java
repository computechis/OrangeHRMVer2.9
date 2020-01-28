package com.computech.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.computech.utility.Helper;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how=How.ID, using="txtUsername") WebElement txtBoxUsername;
	@FindBy(how=How.NAME, using="txtPassword") WebElement txtBoxPasswd;
	@FindBy(how=How.XPATH, using="//input[@id='btnLogin']") WebElement btnLogin;
	
	
	// Action Methods
	public void typeUserName() {
		
		txtBoxUsername.sendKeys("Admin");
	}
	public void typePassword() {
	
		txtBoxPasswd.sendKeys("admin123");
	}
	public void clickOnLoginBtn() {
		btnLogin.click();
	}

	public void loginToApplication() {
		Helper.syncWebElement(driver, txtBoxUsername);
		txtBoxUsername.sendKeys("Admin");
		Helper.syncWebElement(driver, txtBoxPasswd);
		txtBoxPasswd.sendKeys("admin123");
		Helper.syncWebElement(driver, btnLogin);
		btnLogin.click();
	}
	public void loginToApplication(String uName, String pwd) {
		Helper.syncWebElement(driver, txtBoxUsername);
		txtBoxUsername.sendKeys(uName);
		txtBoxPasswd.sendKeys(pwd);
		btnLogin.click();
	}
}
