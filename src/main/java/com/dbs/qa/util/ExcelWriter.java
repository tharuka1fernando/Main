package com.dbs.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	private String fileName;
	private String sheetName;
	private String[][] dataSet;
	private boolean isAppendFile;

	public ExcelWriter(String fileName, String sheetName, String[][] dataSet, boolean isAppendFile) {
		this.fileName = fileName;
		this.sheetName = sheetName;
		this.dataSet = dataSet;
		this.isAppendFile = isAppendFile;
	}

	public void write() {
		XSSFWorkbook workbook = null;
		File excelFile = new File(fileName);
		if (excelFile.exists() && isAppendFile) {
			System.out.println("Exists");
			InputStream is;
			try {
				is = new FileInputStream(excelFile);
				workbook = new XSSFWorkbook(is);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			workbook = new XSSFWorkbook();
		}

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
