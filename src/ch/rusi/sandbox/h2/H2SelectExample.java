package ch.rusi.sandbox.h2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 * Select PreparedStatement JDBC Example
 * 
 * @author Ramesh Fadatare
 *
 */
public class H2SelectExample {
    private static final String QUERY_USER = "select id,last_name,first_name,email,birth_date,street,city from users where id =?";
    private static final String QUERY_COUNT = "select count(*) from users";

    public static void main(String[] args) {

        // using try-with-resources to avoid closing resources (boiler plate code)

        try {
            // Step 1: Establishing a Connection
        	Connection connection = H2JdbcUtils.getConnection();
        	
        	Statement stmnt = connection.createStatement();
        	ResultSet cnt = stmnt.executeQuery(QUERY_COUNT);
        	cnt.next();
        	int numRows = cnt.getInt(1);
        	
        	Random rand = new Random();

        	// Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_USER);            
            preparedStatement.setInt(1, rand.nextInt(numRows)+1);
            System.out.println(preparedStatement);

            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            
            // Step 4: Process the ResultSet object.
            H2JdbcUtils.printResultset(rs);

        } catch (SQLException e) {
            H2JdbcUtils.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }
}