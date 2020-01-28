package com.computech.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.computech.utility.Helper;

public class LogoutPage {
	
	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Admin')]") WebElement linkAdmin;
	@FindBy(how=How.XPATH, using="//a[text()='Logout']") WebElement linkLogout;
	
	public void logoutFromTheApp() {
		Helper.syncWebElement(driver, linkAdmin);
		linkAdmin.click();
		Helper.waitTo(3);
		Helper.syncWebElement(driver, linkLogout);
		linkLogout.click();
	}
	
	

}
