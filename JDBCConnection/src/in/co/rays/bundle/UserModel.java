package in.co.rays.bundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserModel {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app");
		
		String url = rb.getString("url");
		String driver = rb.getString("driver");
		String username = rb.getString("username");
		String password = rb.getString("password");
		Connection conn = null;

		
			Class.forName(driver);

			conn = DriverManager.getConnection(url, username, password);
			
			System.out.println("connection successfully ");
			
		
		
		
	}

}
