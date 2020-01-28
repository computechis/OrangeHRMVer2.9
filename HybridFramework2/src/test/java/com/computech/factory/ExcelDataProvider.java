package com.computech.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell col;

	public ExcelDataProvider(String filePath) {

		try {
			wb = new XSSFWorkbook(new FileInputStream(new File(filePath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ExcelDataProvider() {

		try {
			wb = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\computech\\TestData\\ProjectData.xlsx")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getNoOfRows(String sheetName) {
		return wb.getSheet(sheetName).getPhysicalNumberOfRows();
	}

	public int getNoOfCols(String sheetName, int rowNum) {
		return wb.getSheet(sheetName).getRow(rowNum).getPhysicalNumberOfCells();
	}

	public String getStringData(String sheetName, int rowNum, int colNo) {
		return wb.getSheet(sheetName).getRow(rowNum).getCell(colNo).getStringCellValue();
	}

	public String getStringData(int sheetIndexNo, int rowNum, int colNo) {

		return wb.getSheetAt(sheetIndexNo).getRow(rowNum).getCell(colNo).getStringCellValue();
	}

	public double getDoubleData(String sheetName, int rowNum, int colNo) {
		return wb.getSheet(sheetName).getRow(rowNum).getCell(colNo).getNumericCellValue();
	}

	public int getIntegerData(String sheetName, int rowNum, int colNo) {
		return (int) wb.getSheet(sheetName).getRow(rowNum).getCell(colNo).getNumericCellValue();
	}

	public boolean getBooleanData(String sheetName, int rowNum, int colNo) {
		return wb.getSheet(sheetName).getRow(rowNum).getCell(colNo).getBooleanCellValue();
	}

}
