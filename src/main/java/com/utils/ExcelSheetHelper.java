package com.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import com.constants.FrameworkConstant;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Represents a Excelsheet helper to read the Testing data from Excelsheet.
 * @author Nisha Vekariya
 * @version 1.0
 */
public class ExcelSheetHelper {
	/** WorkBook instance for ExcelSheet */
	public Workbook workbook = null;
	/** This variable represent the sheet inside the ExcelSheet. */
	public Sheet sheet;
	/** This variable represent the row inside the ExcelSheet. */
	public Row excelRows;
	/** This variable represent the cell inside the ExcelSheet. */
	public Cell cell;

	/**
	 * This method provides the workbook based on file extension.
	 * @return Workbook -> It represent the workBook object.
	 */
	public Workbook getWorkBook() {
		try (FileInputStream fileStream = new FileInputStream(FrameworkConstant.DATASHEETFILE_PATH)) {
			workbook = WorkbookFactory.create(fileStream);
		} catch (FileNotFoundException e) {
			throw new ExceptionHelper("Excel file not found to read the data.");
		} catch (Exception e) {
			throw new ExceptionHelper("Exception while working with Excel file.");
		}

		return workbook;
	}

	/**
	 * This method reads each cell data from ExcelSheet and return 2D object
	 * Data.
	 * @param sheetName
	 *            -> sheetName from ExcelSheet.
	 * @return result -> It returns each cell data in form of 2D string array.
	 */
	public String[][] getDataFromSheet(String sheetName) {
		String result[][] = null;
		getWorkBook();
		sheet = workbook.getSheet(sheetName);
		int totalRow = sheet.getPhysicalNumberOfRows();
		int totalColumn = sheet.getRow(0).getLastCellNum();
		int selectedRowCount = getExecutionRowCount(sheet, totalRow);
		result = new String[selectedRowCount][totalColumn - 1];
		int iterateOutputRow = 0;
		// This for loop will run on rows of excel
		for (int row = 1; row < totalRow; row++) {
			excelRows = sheet.getRow(row);
			if (excelRows.getCell(0).toString().equalsIgnoreCase("Y")) {
				// This for loop will run on columns of excel
				for (int col = 1; col < totalColumn; col++) {
					cell = excelRows.getCell(col);
					if (cell == null || cell.getCellType() == CellType.BLANK)
						result[iterateOutputRow][col - 1] = "";
					else
						result[iterateOutputRow][col - 1] = cell.getStringCellValue().toString();
				}
				iterateOutputRow++;
			}
		}
		return result;
	}

	/**
	 * Count the rows which has execution status is 'y'.
	 * 
	 * @param sheet
	 *            -> sheet object from where row needs to collect.
	 * @return rowCount -> row count which has status 'y'.
	 */
	private int getExecutionRowCount(Sheet sheet, int rows) {
		int rowCount = 0;
		for (int row = 0; row < rows; row++) {
			excelRows = sheet.getRow(row);
			if (excelRows.getCell(0).toString().equalsIgnoreCase("Y")) {
				rowCount++;
			}
		}
		return rowCount;
	}
}
