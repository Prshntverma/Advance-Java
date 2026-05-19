package in.co.rays.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		//  step 1 : load the driver.......
		
		//step 2 : get the connections
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		
		//create statement.....
		Statement stmt = con.createStatement();
		int i = stmt.executeUpdate(
				"insert into st_student values(3, 'Akbar', 'Khan', 'akbar@gmail.com', 'akbar123', '2002-02-02'),(4, 'Akbar', 'Khan', 'akbar@gmail.com', 'akbar123', '2002-02-02')");

		System.out.println(i + " row affected..(records inserted)");

		con.close();
		
	
	
	}

}
