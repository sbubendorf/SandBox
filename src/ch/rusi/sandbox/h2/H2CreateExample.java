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

    private static final String tableName = "users";

	private static final String createTableSQL =
    		"create table if not exists " + tableName + "\r\n"
    		+ "(\r\n"
    		+ "  id  			int(3) primary key,	\r\n"
    		+ "  last_name 		varchar(100),		\r\n"
    		+ "  first_name 	varchar(100),		\r\n"
    		+ "  email 			varchar(100),		\r\n"
    		+ "  birth_date		date,				\r\n"
    		+ "  street			varchar(100),		\r\n"
    		+ "  city 			varchar(100)		\r\n"
    		+ ");";

    public static void main(String[] argv) {
        H2CreateExample createTableExample = new H2CreateExample();
        createTableExample.createTable();
    }

    public void createTable() {

        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Establishing a Connection
            connection = H2JdbcUtils.getConnection();
            // Step 2:Create a statement using connection object
            statement = connection.createStatement();

            try {
                // Step 3: Drop existing table
                statement.execute("drop table " + tableName);
                System.out.println("Existing table " + tableName + " dropped!");
            } catch (Exception e) {
                System.out.println("Table " + tableName + " does not exists!");
            }

            // Step 4: Execute the query or update query
            statement.execute(createTableSQL);

        } catch (SQLException e) {
            // print SQL exception information
            H2JdbcUtils.printSQLException(e);
        } finally {
            try {
                if(statement != null) {
                    statement.close();
                }
                if(connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }
}