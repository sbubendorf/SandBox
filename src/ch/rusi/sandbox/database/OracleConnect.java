package ch.rusi.sandbox.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import ch.rusi.sandbox.properties.PropertiesHandler;

public class OracleConnect {

	public static void main(String[] args) {
		
		try {
			
			PropertiesHandler ph = PropertiesHandler.getInstance("config/config.properties");
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(ph.getProperty("db.url"), ph.getProperty("db.user"), ph.getProperty("db.password"));
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from dual");
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
