package com.qa.lamda.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static String TEST_DATA_SHEET ="./src/test/resources/TestData/LamdaTestData.xlsx";
	private static Workbook book;   
	private static Sheet sheet;

	public static String TEST_DATA_SHEET1 ="./src/test/resources/TestData/RegisterData.xlsx";
	private static Workbook Book;   
	private static Sheet Sheet;


	public static Object[][] getTestData(String SheetName) {

		Object data[][]= null;

		try {
			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(SheetName);

			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];  

			for(int i = 0; i<sheet.getLastRowNum();i++) {
				for(int j = 0; j<sheet.getRow(0).getLastCellNum();j++) {
					data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				}
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

	public static Object[][] getRegisterExcelData(String sheetName) {

		Object data [][] = null;

		try {
			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET1);
			Book = WorkbookFactory.create(ip);
			Sheet = Book.getSheet(sheetName);

			data = new Object[Sheet.getLastRowNum()][Sheet.getRow(0).getLastCellNum()];

			for(int i= 0; i<Sheet.getLastRowNum(); i++) {
				for(int j = 0;j<Sheet.getRow(0).getLastCellNum();j++) {
					data[i][j] = Sheet.getRow(i+1).getCell(j).toString();

				}


			}



		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


		return data;


	}

}
