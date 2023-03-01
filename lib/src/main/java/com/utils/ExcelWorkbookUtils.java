package com.utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWorkbookUtils {

	private XSSFSheet excelsheet;

	private XSSFWorkbook excelworkbook;

	/**
	 * @param Path
	 * @param SheetName
	 * Method used to call FileInputStream to identify Excel sheet and its contents from the location specified
	 */
	public ExcelWorkbookUtils(String Path, String SheetName) {

		try {
			FileInputStream ExcelFile = new FileInputStream(Path);
			excelworkbook = new XSSFWorkbook(ExcelFile);
			excelsheet = excelworkbook.getSheet(SheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param RowNum
	 * @param ColNum
	 * @return
	 * Method to return the Cell value as a String
	 */
	public String getCellDataValueAsaString(int RowNum, int ColNum) {

		try {
			String CellData = excelsheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
			return CellData;
		} catch (Exception e) {
			e.printStackTrace();
			return "Error in getting cell data";
		}

	}

	/**
	 * @param RowNum
	 * @param ColNum
	 * @return
	 * Method to return the Cell value as a Number
	 */
	public long getCellDataValueAsaNumber(int RowNum, int ColNum) {

		try {
			long CellData = (long) excelsheet.getRow(RowNum).getCell(ColNum).getNumericCellValue();
			return CellData;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
