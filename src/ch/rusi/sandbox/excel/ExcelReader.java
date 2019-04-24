package ch.rusi.sandbox.excel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelReader {
	
	private File file;
	private FileInputStream fs;
	private Iterator<Row> rowIterator;
	private Workbook wb;
	private Sheet sheet;

	public ExcelReader(String fileName) {
		try {
			file = new File(fileName);
			fs = new FileInputStream(file);
			String type = getFileExtension(file);
			switch (type) {
			case "xls":
				wb = new HSSFWorkbook(fs);
				sheet = wb.getSheetAt(0);
				rowIterator = sheet.iterator();
				break;
			case "xlsx":
				wb = new XSSFWorkbook(fs);
				sheet = wb.getSheetAt(0);
				rowIterator = sheet.iterator();
				break;
			default:
				System.out.println("The type '" + type + "' of Excel in file '" + fileName + " is not supported!");
				break;
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file '" + fileName + "' you are trying to read does not exist!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getFileExtension(File file) {
	    String name = file.getName();
	    try {
	        return name.substring(name.lastIndexOf(".") + 1);
	    } catch (Exception e) {
	        return "";
	    }
	}
	
	@SuppressWarnings("unused")
	private void readCells() {
		System.out.println("Showing conetent of Excel file '" + file.getName() + "':");
		while ( rowIterator.hasNext() ) {
			Row row = rowIterator.next();
			System.out.println("Row #" + row.getRowNum());
			Iterator<Cell> cellIterator = row.iterator();
			while ( cellIterator.hasNext() ) {
				Cell cell = cellIterator.next();
				System.out.println("  - " + cell.getAddress().formatAsString() + " : " + getCellContent(cell));
			}
		}
	}
	
	public void readEmployees() {
		int rowNum = 3;
		while ( true ) {
			Row row = sheet.getRow(rowNum);
			if ( row == null ) {
				break;
			}
			System.out.println(row.getCell(0).getNumericCellValue() + " : " + row.getCell(1).getStringCellValue());
			rowNum += 1;
		}
	}
	
	private void addHistory() {
		int rowHist = 0;
		for ( Row row : sheet ) {
			if ( row.getCell(0).getCellType() == Cell.CELL_TYPE_STRING && row.getCell(0).getStringCellValue().equals("Access History")) {
				rowHist = row.getRowNum()+1;	// Number of the new history row
			}
		}
		if ( rowHist > 0 ) {
			sheet.shiftRows(rowHist, sheet.getLastRowNum(), 1);
			Row row = sheet.createRow(rowHist);
			Cell cell = row.createCell(0);
			CreationHelper ch = wb.getCreationHelper();
			CellStyle styleDate = wb.createCellStyle();
			styleDate.setDataFormat(ch.createDataFormat().getFormat("yyyy.MM.dd"));
			cell.setCellStyle(styleDate);
			cell.setCellValue(new Date());
			cell = row.createCell(1);
			CellStyle styleTime = wb.createCellStyle();
			styleTime.setDataFormat(ch.createDataFormat().getFormat("hh:mm:ss"));
			cell.setCellStyle(styleTime);
			cell.setCellValue(new Date());
			saveChanges();
		}
	}
	
	private void saveChanges() {
		try {
			FileOutputStream out = new FileOutputStream(file);
			wb.write(out);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getCellContent(Cell cell) {
		String value = null;
		switch(cell.getCellType()) {
			case Cell.CELL_TYPE_BOOLEAN:
				value = Boolean.toString(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				value = String.valueOf(cell.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_STRING:
				value = cell.getStringCellValue();
				break;
			default:
				value = null;
		}
		return value;
	}

	public static void main(String[] args) {
		String fileName = "files/test.xlsx";
		ExcelReader reader = new ExcelReader(fileName);
		//reader.readCells();
		reader.readEmployees();
		reader.addHistory();
	}

}
