package com.computech.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	public ConfigDataProvider() {
		try {
			FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\computech\\Config\\Configuration.properties"));
			pro = new Properties();
			pro.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Exception message is : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Exception message is : " + e.getMessage());
		}
	}
	public String getBrowser()
	{
		return pro.getProperty("browser");
	}
	public String getStagingUrl()
	{
		return pro.getProperty("stagingUrl");
	}
	public String getKeyValue(String keyName) {
		return pro.getProperty(keyName);
		
	}
}
