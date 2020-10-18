package ch.rusi.sandbox.h2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;

public class H2JdbcUtils {

    private static String jdbcURL = "jdbc:h2:./data/test";
    private static String jdbcUsername = "sa";
    private static String jdbcPassword = "";

    private static H2JdbcUtils instance = null;
    
    public static void main(String[] args) {
    	Connection connection = getConnection();
    	try {
			DatabaseMetaData md = connection.getMetaData();
			String[] types = { "TABLE", "SYSTEM TABLE" };
            ResultSet rs = md.getTables(null, null, "%", types);
            printResultset(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public static H2JdbcUtils getInstance() {
        if (instance == null) {
            instance = new H2JdbcUtils();
        }
        return instance;
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
        	Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return connection;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
    public static void printResultset(ResultSet rs) throws SQLException {
    	
    	final int MAX_COL_SIZE = 100;

    	ResultSetMetaData rsmd = rs.getMetaData();
    	int[] colSize = new int[rsmd.getColumnCount()+1];
    	Vector<String[]> rows = new Vector<String[]>();
    	String value;
        while (rs.next()) {
        	Vector<String> row = new Vector<String>();
            for ( int i = 1 ; i <= rsmd.getColumnCount() ; i++ ) {
            	value = rs.getString(i);
            	if(value != null) {
	            	value = value.replaceAll("\\r\\n|\\r|\\n", "|");
	            	if(value.length() > MAX_COL_SIZE) {
	            		value = value.substring(0, MAX_COL_SIZE-3) + "...";
	            	}
	            	if(value.length() > colSize[i]) {
	            		colSize[i] = value.length();
	            	}
            	}
            	row.add(value);
            }
            String[] v = new String[row.size()];
            row.copyInto(v);
            rows.addElement(v);
        }
    	
    	String sep = "+";
    	String row = "|";
        for ( int i = 1 ; i <= rsmd.getColumnCount() ; i++ ) {
        	if(rsmd.getColumnLabel(i).length() > colSize[i]) {
        		colSize[i] = rsmd.getColumnLabel(i).length();
        	}
        	sep += String.format("%-" + (colSize[i]+2) + "s", "-").replace(" ", "-") + "+";
        	row += " " + String.format("%-" + colSize[i] + "s", rsmd.getColumnLabel(i)) + " |";
        }
        
        System.out.println(sep);
        System.out.println(row);
        System.out.println(sep);
        
        Iterator<String[]> it = rows.iterator();
        while(it.hasNext()) {
        	String[] cols = it.next();
        	row = "|";
            for ( int i = 0 ; i < cols.length ; i++ ) {
            	row += " " + String.format("%-" + colSize[i+1] + "s", cols[i]) + " |";
            }
            System.out.println(row);
        }
        System.out.println(sep);
    }
    
    public static void showTableData(String tableName) {

    	Connection conn = getConnection();
    	Statement stmnt;
		try {
			stmnt = conn.createStatement();
			ResultSet rs = stmnt.executeQuery("select * from " + tableName);
			printResultset(rs);
		} catch (SQLException e) {
			printSQLException(e);
		}
    }

    public static void printConnectionInfo(Connection conn) throws SQLException {
        System.out.println("URL : " + conn.getMetaData().getURL());
        System.out.println("User : " + conn.getMetaData().getUserName());
    }
    
}