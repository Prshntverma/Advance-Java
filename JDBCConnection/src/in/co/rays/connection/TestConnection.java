package in.co.rays.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



 public class TestConnection {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver"); // load the Driver class in class loader

		// Make connection to the Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		System.out.println("java is connected with mysql successfully....");

		// Create Statement
		Statement stmt = conn.createStatement();

		// Execute query and get ResultSet
		ResultSet rs = stmt.executeQuery("select * from employee");

		while (rs.next()) {
			System.out.println("id: " + rs.getInt(1));
			System.out.println("name" +rs.getString(2));
		

		// close the connection
		conn.close();
		stmt.close();
		
		

	}



	}}
