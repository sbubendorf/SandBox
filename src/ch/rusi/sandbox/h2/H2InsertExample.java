package ch.rusi.sandbox.h2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import org.fluttercode.datafactory.impl.DataFactory;

/**
 * Insert PrepareStatement JDBC Example
 * 
 * @author Ramesh Fadatare
 *
 */
public class H2InsertExample {
    private static final String INSERT_USERS_SQL = "INSERT INTO users" +
        "  (id, last_name, first_name, email, birth_date, street, city) VALUES " +
        " (?, ?, ?, ?, ?, ?, ?);";

    public static void main(String[] argv) throws SQLException {
        H2InsertExample createTableExample = new H2InsertExample();
        createTableExample.insertRecord();
        H2JdbcUtils.showTableData("users");
    }

    public void insertRecord() throws SQLException {
        System.out.println(INSERT_USERS_SQL);

        DataFactory df = new DataFactory();
		Random rand = new Random();
		
		df.randomize(rand.nextInt(1000000));
		

        // Step 1: Establishing a Connection
        try (
        		Connection connection = H2JdbcUtils.getConnection();
        		// Step 2:Create a statement using connection object
        		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
    		
        	System.out.println(preparedStatement);
        	
    		for (int i = 0; i < 10; i++) {
    			
    			preparedStatement.setInt(1, i);
    			preparedStatement.setString(2, df.getLastName());
    			preparedStatement.setString(3, df.getFirstName());
    			preparedStatement.setString(4, df.getEmailAddress());
    			preparedStatement.setDate(5, (Date) new java.sql.Date(df.getBirthDate().getTime()));
    			preparedStatement.setString(6, df.getStreetName() + " " + df.getStreetSuffix());
    			preparedStatement.setString(7, df.getCity());
    			
    			// Step 3: Execute the query or update query
    			preparedStatement.executeUpdate();
    		}

        } catch (SQLException e) {

            // print SQL exception information
            H2JdbcUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }
}