package com.idexcel.token;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author Shivaraj.Budeppa
 *
 */
public class MSExcelMethods {

	XSSFWorkbook xssfWorkbook = null;

	XSSFSheet xssfSheet = null;

	public String xssfcellToString(XSSFCell cell) {
		int type = cell.getCellType();
		Object result;
		switch (type) {
		case 0:
			result = cell.getNumericCellValue();
			break;
		case 1:
			result = cell.getStringCellValue();
			break;
		case 2:
			result = cell.getCellFormula();
			break;
		case 3:
			result = "";
			break;
		default:
			throw new RuntimeException("no support for this cell");
		}
		return result.toString();
	}

	public int getRowCount() {
		return xssfSheet.getLastRowNum() + 1;
	}

	public int getColumnCount() {
		return xssfSheet.getRow(0).getLastCellNum();
	}

	public String[][] readDataFromExcel(String filePath, String sheetName) throws IOException {
		String testdata[][] = new String[0][];
		if (filePath.endsWith(".xlsx")) {
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			xssfWorkbook = new XSSFWorkbook(fis);
			xssfSheet = xssfWorkbook.getSheet(sheetName);
			int numberOfColumns = getColumnCount();
			int numberOfRows = getRowCount();
			testdata = new String[numberOfRows - 1][numberOfColumns];
			for (int i = 1; i < numberOfRows; i++) {
				for (int j = 0; j < numberOfColumns; j++) {
					XSSFRow row = xssfSheet.getRow(i);
					XSSFCell cell = row.getCell(j);
					String value = xssfcellToString(cell);
					testdata[i - 1][j] = value;
					if (value == null) {
						System.out.println("data empty");
					}
				}

			}
		}
		// System.out.println(testdata);
		return testdata;
	}

	
	  public static void main(String[] args) throws IOException { MSExcelMethods
	  msex = new MSExcelMethods(); File file = new
	  File("src/test/resources/TestData/Staging/datafromexcel.xlsx"); String[][] str=
	  msex.readDataFromExcel(file.getAbsolutePath(), "Sheet5"); for (int
	  i = 0; i < str.length; i++) { System.out.print(i + 1 + " "); for (int j = 0;
	  j < str[i].length; j++) { System.out.print(str[i][j] + " "); } }
	 System.out.print("\n"); }
	 
}
