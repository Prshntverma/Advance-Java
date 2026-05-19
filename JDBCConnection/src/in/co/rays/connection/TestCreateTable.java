package in.co.rays.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestCreateTable {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");   //1 load the driver................
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root"); //  get connection
		
		Statement stmt = con.createStatement(); // create statement
		
		int i = stmt.executeUpdate("create table st_student(id int primary key, name varchar(45), school varchar(45))");
		
		System.out.println(i + " table created");
		
		con.close();
		stmt.close();
		
	}

}

// student , emp , roll ,product user