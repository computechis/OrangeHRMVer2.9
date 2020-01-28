package com.computech.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.computech.factory.BrowserFactory;
import com.computech.factory.ConfigDataProvider;
import com.computech.factory.ExcelDataProvider;
import com.computech.pages.LoginPage;

public class DDFOrangHRMLoginTest2 {
	WebDriver driver;
	LoginPage lp;
	public static ExcelDataProvider excel;
	@BeforeMethod
	public void setUp() {
		ConfigDataProvider config = new ConfigDataProvider();
		driver = BrowserFactory.startApplication(config.getStagingUrl(), config.getBrowser());
	}

	@Test(dataProvider = "getData")
	public void login(String username, String pwd) {
		lp=PageFactory.initElements(driver, LoginPage.class);
		excel = new ExcelDataProvider();
		lp.loginToApplication(username, pwd);
	}
	
	@DataProvider
	public static Object[][] getData() {
		if(excel == null) {
			excel = new ExcelDataProvider();
		}
		String sheetName="Login";
		int rows = excel.getNoOfRows(sheetName);
		System.out.println("Total rows : " + rows);
		int cols =excel.getNoOfCols(sheetName, 0);
		System.out.println("Total cols : " + cols);
		Object[][] data = new Object[rows][cols];
		
		for(int rowNo = 0; rowNo < rows; rowNo++)
		{
			for(int colNo = 0; colNo < cols; colNo++)
			{
				data[rowNo][colNo]=excel.getStringData(sheetName, rowNo, colNo);
			}
		}

		return data;
	}
	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Exception message is : " + e.getMessage());
		}
		BrowserFactory.closeApp(driver);
	}
}
