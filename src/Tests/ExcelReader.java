package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class ExcelReader {

	File fajl;
	FileInputStream fis;	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	String value;
	
	public ExcelReader(String filePath) throws IOException {
		this.fajl = new File(filePath);
		this.fis = new FileInputStream(fajl);
		this.wb = new XSSFWorkbook(fis);
	}
	
	public String getData(String sheetNama, int rowNumber, int columnNumber) {
		sheet = wb.getSheet(sheetNama);
		row = sheet.getRow(rowNumber-1);
		cell = row.getCell(columnNumber-1);
		if(cell.getCellType() == CellType.NUMERIC) {
			value = String.valueOf((int) cell.getNumericCellValue());
		}
		else {
			value = cell.getStringCellValue();
			
		}
		return value;
	}
	
	public void checkWithAssert(String sheetName, int rowNumber, int columnNumber, String actualResult) {
		String expectedResult = getData(sheetName, rowNumber, columnNumber);
		Assert.assertEquals(actualResult, expectedResult);		
	}
}
