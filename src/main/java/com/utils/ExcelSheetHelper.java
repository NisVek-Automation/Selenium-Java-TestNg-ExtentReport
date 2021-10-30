package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.constants.FrameworkConstant;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Represents a Excelsheet helper to read the Testing data from Excelsheet.
 * 
 * @author Nisha Vekariya
 * @version 1.0
 */
public class ExcelSheetHelper {
	/** WorkBook instance for ExcelSheet */
	public Workbook workbook = null;
	/** This variable represent the sheet inside the ExcelSheet. */
	public Sheet sheet;
	/** This variable represent the row inside the ExcelSheet. */
	public Row rows;
	/** This variable represent the cell inside the ExcelSheet. */
	public Cell cell;

	/**
	 * This method provides the workbook based on file extension.
	 * @return Workbook -> It represent the workBook object.
	 */
	public Workbook getWorkBook() throws Exception {
		try {
			workbook = WorkbookFactory.create(new File(FrameworkConstant.DataSheetFileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workbook;
	}

	/**
	 * This method reads each cell data from ExcelSheet and return 2D object
	 * Data.
	 * 
	 * @param sheetName -> sheetName from ExcelSheet.
	 * @return dataSets -> It returns each cell data in form of 2D string array.
	 */
	@SuppressWarnings({ "deprecation" })
	public String[][] getDataFromSheet(String sheetName) {
		String dataSets[][] = null;
		try {
			// get workbook based on ExcelSheet type
			getWorkBook();
			// get sheet from excel workbook
			sheet = workbook.getSheet(sheetName);
			// count number of active rows
			int totalRow = sheet.getPhysicalNumberOfRows();
			// count number of active columns in row
			int totalColumn = sheet.getRow(0).getLastCellNum();
			int actualRows = getRowCount(sheet, totalRow);
			// Create array of rows and column
			dataSets = new String[actualRows][totalColumn - 1];
			int iterateActualRow = 0;
			// This for loop will run on rows of excel
			for (int i = 1; i < totalRow; i++) {
				rows = sheet.getRow(i);
				if (rows.getCell(0).toString().equalsIgnoreCase("Y")) {
					// This for loop will run on columns of excel
					for (int j = 1; j < totalColumn; j++) {
						// get Cell method will get cell
						cell = rows.getCell(j);
						if (cell == null || cell.getCellType() == CellType.BLANK)
							dataSets[iterateActualRow][j - 1] = "";
						else
							dataSets[iterateActualRow][j - 1] = cell.getStringCellValue().toString();
					}
					iterateActualRow++;
				}
			}
			return dataSets;
		} catch (Exception e) {
			System.out.println("Exception in reading Xlxs file" + e.getMessage());
			e.printStackTrace();
		}
		
		return dataSets;
	}
	
	/**
	 * Count the rows which has execution status is 'y'.
	 * 
	 * @param sheet -> sheet object from where row needs to collect.
	 * @return rowCount -> row count which has status 'y'.
	 */
	private int getRowCount(Sheet sheet, int row){
		int rowCount = 0;
		for (int i = 0; i < row; i++) {
			rows = sheet.getRow(i);
			if (rows.getCell(0).toString().equalsIgnoreCase("Y")) {
				rowCount++;
			}
		}
		return rowCount;
	}
}
