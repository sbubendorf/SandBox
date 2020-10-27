package ch.rusi.sandbox.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileFromDB {

	private ResultSet rs = null;
	private ResultSetMetaData rsMetaData = null;
	private String[] column_names;

	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String DB_URL = "jdbc:mysql://localhost:3306/<your SQL database name goes here>";
			Connection connection = DriverManager.getConnection(DB_URL, "<db_user>", "<db_pass>");
			String SQL_QUERY = "select * from dual";
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);
			rs = preparedStatement.executeQuery();
			rsMetaData = preparedStatement.getMetaData();
		} catch (Exception e) {
			System.out.println("Unable to establish connection!");
		}
	}

	private ExcelFileFromDB() throws SQLException, IOException {
		column_names = genColumnNames();
		getRowData();
	}

	private String[] genColumnNames() throws SQLException {
		column_names = new String[rsMetaData.getColumnCount() + 1];
		if (rsMetaData.getColumnCount() > 1) {
			for (int i = 1; i < rsMetaData.getColumnCount() + 1; i++) {
				column_names[i] = rsMetaData.getColumnName(i);
			}
		} else if (rsMetaData.getColumnCount() == 1) {
			column_names = new String[rsMetaData.getColumnCount()];
			column_names[rsMetaData.getColumnCount() - 1] = rsMetaData.getColumnName(rsMetaData.getColumnCount());
		}
		return column_names;
	}

	private void getRowData() throws SQLException, IOException {
		LinkedList<Object[]> lst = new LinkedList<>();
		if (column_names.length > 1) {
			while (rs.next()) {
				String[] p;
				StringBuilder row = new StringBuilder();
				for (String column_name : column_names) {
					if (column_name != null) {
						String temp = rs.getString(column_name) + ",";
						row.append(temp);
					}
				}
				p = row.substring(0, row.length() - 1).split(",");
				lst.add(p);
			}
		} else if (column_names.length == 1) {
			System.out.println("invoked value =1 " + column_names[0]);
			while (rs.next()) {
				if (column_names[0] != null) {
					String[] p;
					String row = rs.getString(column_names[0]) + ",";
					p = row.substring(0, row.length() - 1).split(",");
					lst.add(p);
				}
			}
		}
		addToList(lst);
	}

	private void addToList(LinkedList<Object[]> lst) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("sheet");
		XSSFRow row;
		for (int i = 0; i < lst.size(); i++) {
			Object[] objArr = lst.get(i);
			row = spreadsheet.createRow(i + 1);
			int cellNum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellNum++);
				if (obj instanceof Date) {
					cell.setCellValue((Date) obj);
				} else if (obj instanceof Boolean) {
					cell.setCellValue((Boolean) obj);
				} else if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Double) {
					cell.setCellValue((Double) obj);
				}
			}
		}
		FileOutputStream out = new FileOutputStream(new File("<EXEL FILE NAME PATH.xlsx>"));
		workbook.write(out);
		workbook.close();
		out.close();
	}

	public static void main(String[] args) throws SQLException, IOException {
		new ExcelFileFromDB();
	}
}
