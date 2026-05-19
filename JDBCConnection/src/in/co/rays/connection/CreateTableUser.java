package in.co.rays.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableUser {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		

		// Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver"); // load the Driver class in class loader

		// Make connection to the Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		System.out.println("java is connected with mysql successfully....");

		// Create Statement
		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
		    "create table st_user("
		    + "id int primary key, "
		    + "firstName varchar(50), "
		    + "lastName varchar(50), "
		    + "login varchar(50), "
		    + "password varchar(50), "
		    + "dob date)");

		System.out.println(i + " table created");
		// close the connection
		conn.close();
	}
}
