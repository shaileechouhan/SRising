package com.MyTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class D04ReadFromExcel {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\singh\\Desktop\\shailee_study\\Shailee_SeleniumDemos\\MyAutomationProject\\ExcelFiles\\FriendsData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int rows = sheet.getPhysicalNumberOfRows();
		int cells = sheet.getRow(0).getPhysicalNumberOfCells();
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cells; j++)
			{
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
		}
		
		wb.close();
		fis.close();
	}

}