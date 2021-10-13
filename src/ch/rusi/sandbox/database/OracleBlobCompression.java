package ch.rusi.sandbox.database;

import ch.rusi.sandbox.properties.PropertiesHandler;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Properties;

public class OracleBlobCompression {

	public static void main(String[] args) {
		
		try {

			if ( args.length != 2 ) {
				System.out.println("Wrong number of parameters!");
				System.out.println("#1 : Compression Flag (on/off)");
			}

			String paramCompressionFlag = args[0];
			String paramCompressionThreshold = args[1];
			
			String dbName = "CM2T";
			String dbUrl = "jdbc:oracle:thin:@ORA1" + dbName + ":12051/" + dbName + ".balgroupit.com";
			String dbUser = "bsi";
			String dbPassword = "bsipw";

			System.out.println("Connecting to " + dbUrl);

			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			OracleDataSource dataSource = new OracleDataSource();

			Properties prop = new Properties();
			prop.setProperty("user", dbUser);
			prop.setProperty("password", dbPassword);
			prop.setProperty("oracle.net.networkCompression", "on");
			prop.setProperty("oracle.net.networkCompressionThreshold", "1024");
			dataSource.setConnectionProperties(prop);
			dataSource.setURL(dbUrl);
			Connection conn = dataSource.getConnection();

			Statement stmt = conn.createStatement();

			LocalDateTime timeStart = LocalDateTime.now();
			long blobSize = 0;
			long count = 0;
			long len = 0;

			@SuppressWarnings("SqlResolve")
			ResultSet rs = stmt.executeQuery("select * from bsi_customer_change where formdata_ser is not null");
			while (rs.next() && count < 20000) {
				count += 1;
				Blob blob = rs.getBlob("formdata_ser");
				if ( blob == null ) {
					len = 0;
				} else {
					len = blob.length();
				}
				blobSize += len;
				System.out.println(count + " : " + len + " --> " + blobSize);
			}

			long duration = ChronoUnit.SECONDS.between(timeStart, LocalDateTime.now());
			System.out.println("Read " + blobSize + " bytes in " + duration + " seconds!");

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
