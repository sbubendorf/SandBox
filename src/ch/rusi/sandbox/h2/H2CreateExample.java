package ch.rusi.sandbox.h2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Create Statement JDBC Example
 * @author Ramesh Fadatare
 *
 */
public class H2CreateExample {

	private static final String dropTableSQL =
			"drop table users;";
	
	private static final String createTableSQL = 
    		"create table users "
    		+ "(\r\n"
    		+ "  id  			int(3) primary key,	\r\n"
    		+ "  last_name 		varchar(100),		\r\n"
    		+ "  first_name 	varchar(100),		\r\n"
    		+ "  email 			varchar(100),		\r\n"
    		+ "  birth_date		date,				\r\n"
    		+ "  street			varchar(100),		\r\n"
    		+ "  city 			varchar(100)		\r\n"
    		+ ");";

    public static void main(String[] argv) throws SQLException {
        H2CreateExample createTableExample = new H2CreateExample();
        createTableExample.createTable();
    }

    public void createTable() throws SQLException {

        System.out.println(createTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JdbcUtils.getConnection();
            // Step 2:Create a statement using connection object
            Statement statement = connection.createStatement();) {

            // Step 3: Drop existing table
            statement.execute(dropTableSQL);

            // Step 4: Execute the query or update query
            statement.execute(createTableSQL);

        } catch (SQLException e) {
            // print SQL exception information
            H2JdbcUtils.printSQLException(e);
        }
    }
}