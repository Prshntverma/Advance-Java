package in.co.rays.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestAdd {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver"); // load the Driver class in class loader

		// Make connection to the Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		System.out.println("java is connected with mysql successfully....");

		// Create Statement
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate(
			    "insert into st_student values(1,'raman','st Paul')"
			);

			System.out.println(i + " Record Inserted");


		// close the connection
		conn.close();

	}


}
