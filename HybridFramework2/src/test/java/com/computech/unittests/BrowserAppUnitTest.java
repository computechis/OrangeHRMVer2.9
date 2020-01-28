package com.computech.unittests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.computech.factory.BrowserFactory;
import com.computech.factory.ConfigDataProvider;

public class BrowserAppUnitTest {
	WebDriver driver;
	@Test
	public void browser() {
		ConfigDataProvider config = new ConfigDataProvider();
		driver = BrowserFactory.startApplication(config.getStagingUrl(), config.getBrowser());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Exception message is : " + e.getMessage());
		}
		BrowserFactory.closeApp(driver);
	}
}
