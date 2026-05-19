package in.co.rays.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddMultipleValues {

	public static void main(String[] args)
			throws ClassNotFoundException, SQLException {

		// Step 1: Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: Create Connection
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/rays",
				"root",
				"root");

		System.out.println("Java is connected with MySQL successfully....");

		// Step 3: Create Statement
		Statement stmt = con.createStatement();

		// Step 4: Execute Query
		int i = stmt.executeUpdate(
				"INSERT INTO st_user VALUES "
				+ "(1, 'Prashant', 'Verma', 'prashant@gmail.com', '123', '2001-05-10'),"
				+ "(2, 'Ram', 'Sharma', 'ram@gmail.com', '456', '2000-08-20')");

		System.out.println(i + " records inserted");

		// Step 5: Close Connection
		con.close();
	}
}