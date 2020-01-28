package com.computech.unittests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.computech.factory.ConfigDataProvider;

public class ConfigDataUnitTest {
  @Test
  public void configUnit() {
	  ConfigDataProvider config = new ConfigDataProvider();
	  String expKeyValue="TestConfig";
	  String actKeyValue = config.getKeyValue("conkey");
	  Assert.assertEquals(actKeyValue, expKeyValue);
  }
}
