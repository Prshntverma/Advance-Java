package in.co.rays.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataUser {

	public static void main(String[] args)
			throws ClassNotFoundException, SQLException {

		// Step 1 : Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2 : Create Connection
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/rays",
				"root",
				"root");

		System.out.println("Database Connected...");

		// Step 3 : Create Statement
		Statement stmt = con.createStatement();

		// Step 4 : Execute Query
		int i = stmt.executeUpdate(
				"INSERT INTO st_user VALUES "
				+ "(3, 'bar', 'Khan', 'bar@gmail.com', 'bar123', '2001-03-04'),"
				+ "(4, 'Akbar', 'Khan', 'akbar@gmail.com', 'akbar123', '2002-05-07')");

		System.out.println(i + " records inserted");

		// Step 5 : Close Connection
		con.close();
	}
}