package com.computech.unittests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.computech.factory.ExcelDataProvider;

public class ExcelDataUnitTest {
	
	@Test
	public void getExcel() {
		ExcelDataProvider excel = new ExcelDataProvider();
		String expData = "testing2Excel";
		Assert.assertEquals(excel.getStringData("Testing", 0, 0), expData);
	}

}
