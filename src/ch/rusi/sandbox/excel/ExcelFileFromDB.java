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
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileFromDB {
	
	private String SQL_Query = "Your SQL Query goes here";
	private String DB_URL = "jdbc:mysql://localhost:3306/<your SQL database name goes here>";
	private Connection con = null;
	private PreparedStatement pr_stmt = null;
	private ResultSet rs = null;
	private ResultSetMetaData rsmd = null;
	private String[] column_names = null;

	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, "<db_user>", "<db_pass>");
			pr_stmt = con.prepareStatement(SQL_Query);
			rs = pr_stmt.executeQuery();
			rsmd = pr_stmt.getMetaData();
		} catch (Exception e) {
			System.out.println("Unable to establish connection!");
		}
	}

	private ExcelFileFromDB() throws SQLException, ClassNotFoundException, IOException {
		column_names = genColumnNames();
		getRowData();
	}

	private String[] genColumnNames() throws SQLException {
		column_names = new String[rsmd.getColumnCount() + 1];
		if (rsmd.getColumnCount() > 1) {
			for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
				column_names[i] = rsmd.getColumnName(i);
			}
		} else if (rsmd.getColumnCount() == 1) {
			column_names = new String[rsmd.getColumnCount()];
			column_names[rsmd.getColumnCount() - 1] = rsmd.getColumnName(rsmd.getColumnCount());
		}
		return column_names;
	}

	private void getRowData() throws SQLException, IOException {
		LinkedList<Object[]> lst = new LinkedList<Object[]>();
		if (column_names.length > 1) {
			while (rs.next()) {
				String[] p = null;
				StringBuffer row = new StringBuffer();
				for (int i = 0; i < column_names.length; i++) {
					if (column_names[i] != null) {
						String temp = rs.getString(column_names[i]) + ",";
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
					String[] p = null;
					String row = rs.getString(column_names[0]) + ",";
					p = row.substring(0, row.length() - 1).split(",");
					lst.add(p);
				}
			}
		}
		addtoList(lst);
	}

	private void addtoList(LinkedList<Object[]> lst) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("<Your EXCELSHEET NAME GOES HERE>");
		XSSFRow row;
		Map<String, Object[]> empinfo = new TreeMap<String, Object[]>();
		empinfo.put("1", new Object[] { column_names });
		for (int i = 0; i < lst.size(); i++) {
			Object[] objArr = lst.get(i);
			row = spreadsheet.createRow(i + 1);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
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

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		new ExcelFileFromDB();
	}
}
