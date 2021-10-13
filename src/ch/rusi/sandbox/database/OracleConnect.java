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

			String dbUrl = ph.getProperty("db.url");
			String dbUser = ph.getProperty("db.user");
			String dbPassword = ph.getProperty("db.password");

			// Overwrite config.propierties
			String dbName = "CM4I";
			dbUrl = "jdbc:oracle:thin:@ORA1" + dbName + ":12051:" + dbName;
			dbUser = "bsi";
			dbPassword = "bsipw";

			System.out.println("Connecting to " + dbUrl);
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			Statement stmt = conn.createStatement();

			@SuppressWarnings("SqlResolve")
			ResultSet rs = stmt.executeQuery("select * from v$version");
			System.out.println("Current Version on database '" + dbUrl + "' :");
			while (rs.next()) {
				System.out.println(rs.getString("banner"));
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
