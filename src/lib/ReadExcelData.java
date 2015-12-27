package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	XSSFWorkbook wb;
	XSSFSheet sheet;

	public ReadExcelData(String excelPath) {

		File file = new File(excelPath);
		try {
			FileInputStream fip = new FileInputStream(file);
			wb = new XSSFWorkbook(fip);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Object[][] readSheet(int sheetNo) {

		sheet = wb.getSheetAt(sheetNo);

		//getlastcellnum(): Gets the index of the last cell contained in this row PLUS ONE.
		int noOfRows = sheet.getLastRowNum()+1;
		int noOfColumns = sheet.getRow(0).getLastCellNum();

		//excluding the first row(the header)
		Object[][] excelData = new Object[noOfRows-1][noOfColumns];

		for (int i = 1; i < noOfRows; i++) {
			Row currentRow = sheet.getRow(i);
			for (int j = 0; j < noOfColumns; j++) {
				Cell currentCell = currentRow.getCell(j);
				switch (currentCell.getCellType()) {
				case Cell.CELL_TYPE_BOOLEAN:
					excelData[i-1][j] = currentCell.getBooleanCellValue();
				case Cell.CELL_TYPE_NUMERIC:
					excelData[i-1][j] = currentCell.getNumericCellValue();
				case Cell.CELL_TYPE_STRING:
					excelData[i-1][j] = currentCell.getStringCellValue();
					break;

				default:
					break;
				}
			}
			
			
		}
		
		return excelData;

		/*
		 * Iterator<Row> rows = sheet.iterator();
		 * 
		 * while(rows.hasNext()){ Row nextRow=rows.next(); Iterator<Cell> cells
		 * = nextRow.cellIterator();
		 * 
		 * while(cells.hasNext()){ Cell nextCell = cells.next(); switch
		 * (nextCell.getCellType(){ case Cell.CELL_TYPE_BOOLEAN Object[]
		 * default: break; } }
		 * 
		 * }
		 */
	}

	public static void main(String[] atf) {
		ReadExcelData excel =  new ReadExcelData("E:/Workspace/testing-all/Guru99-UsernamePassword.xlsx");
		System.out.println(excel.readSheet(0));
	}


}
