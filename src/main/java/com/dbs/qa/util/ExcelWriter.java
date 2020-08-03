package com.dbs.qa.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	private String fileName;
	private String sheetName;
	private String[][] dataSet;

	public ExcelWriter(String fileName, String sheetName, String[][] dataSet) {
		this.fileName = fileName;
		this.sheetName = sheetName;
		this.dataSet = dataSet;
	}

	public void write() {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(sheetName);

		int rowNum = 0;
		for (String[] dataRow : dataSet) {
			Row row = sheet.createRow(rowNum++);
			int colNum = 0;
			for (String cellData : dataRow) {
				Cell cell = row.createCell(colNum++);
				cell.setCellValue(cellData);
			}
		}

		try {
			FileOutputStream outputStream = new FileOutputStream(fileName);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
