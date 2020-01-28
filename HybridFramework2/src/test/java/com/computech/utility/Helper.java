package com.computech.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.time.Duration;
import java.util.Date;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Helper {

	public static String captureScreenshot(WebDriver driver) {
		//D:\Workspace5PM\HybridFramework\src\test\resources\com\computech\Screenshots
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\com\\computech\\Screenshots\\OrangeHRM"+System.currentTimeMillis()+".png";
		File src = ( (TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(path));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return path;
	}

	public  static String  getCurrentDateAndTime() {
		Date date = new Date();
		DateFormat dateFormatter = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		return dateFormatter.format(date);
	}
	public static void waitTo(long seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	public static String getTextFromAlert(WebDriver driver) {
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alt = wait.until(ExpectedConditions.alertIsPresent());
		return alt.getText();*/
		//return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent()).getText();
		
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		Alert alt = wait.until(ExpectedConditions.alertIsPresent());
		String alertMessage = alt.getText();
		return alertMessage;*/
		return new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent()).getText();
	}
	public static void acceptAlert(WebDriver driver) {
		//new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent()).accept();
		new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent()).accept();
	}
	public static void dismissAlert(WebDriver driver) {
		//new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent()).dismiss();
		new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent()).dismiss();
	}
	
	
	public static void switchToFramesUsingIndex(WebDriver driver, int index) {
		//  new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
		new WebDriverWait(driver,10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
		
	}

	public static void switchToFramesUsingIDAndName(WebDriver driver, String idOrName) {
		//new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOrName));
//		WebDriverWait wait = new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOrName));
		new WebDriverWait(driver,10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOrName));
	}
	
	public static WebElement waitForWebElement(WebDriver driver, WebElement element) {
		 //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		//System.out.println("Trying to find element before operation ");
		wait.until(ExpectedConditions.visibilityOf(element));
		//System.out.println("Element found and ready before operation ");
		return element;
	}
	
	public static WebElement syncWebElement(WebDriver driver, WebElement element) {
		waitForWebElement(driver, element);
		highLightElement(driver, element);
		return element;
	}
	public static void highLightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}
	public static void waitForCurentURL(WebDriver driver, String url) {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Assert.assertTrue(wait.until(ExpectedConditions.urlContains(url)));
	}
	
	
}
