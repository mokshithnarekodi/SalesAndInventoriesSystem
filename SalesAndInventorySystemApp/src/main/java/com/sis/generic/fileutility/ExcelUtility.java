package com.sis.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * CONTAINS METHODS TO PERFORM ACTION WITH RESPECT TO EXCEL
 * 
 * author : MOKSHITH
 */
public class ExcelUtility {
	/**
	 * 
	 * @param sheetname
	 * @param rowNum
	 * @param cellNum
	 * @return String
	 * @throws Throwable
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheetname,int rowNum, int cellNum) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rowNum).getCell(cellNum).toString();
		wb.close();
		return data;
	}
	/**
	 * 
	 * @param sheetname
	 * @return String
	 * @throws Throwable
	 * @throws IOException
	 */
	public int getRowCount(String sheetname) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheetname).getLastRowNum();
		wb.close();
		return rowcount;
	}
	/**
	 * 
	 * @param sheetname
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 * @throws IOException
	 */
	public void setDataIntoExcel(String sheetname, int rowNum, int cellNum,String data) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Cell cel = wb.getSheet(sheetname).getRow(rowNum).createCell(cellNum);
		cel.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./src/test/resources/Testdata.xlsx");
		wb.write(fos);
		wb.close();
	}
}
