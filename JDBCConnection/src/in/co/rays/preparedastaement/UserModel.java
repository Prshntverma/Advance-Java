// UserModel.java

package in.co.rays.preparedastaement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserModel {

	public void add(UserBean bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/jdbc/root/root");

		PreparedStatement pstmt = con.prepareStatement("Insert into st_user values (?,?,?,?,?,?)");

		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setString(4, bean.getEmail());
		pstmt.setString(5, bean.getPassword());
		pstmt.setDate(6, bean.getDob());
		

		int i = pstmt.executeUpdate();
		
		System.out.println("Data successfully insert " + i + " row affected");
		
		con.close();

		pstmt.close();
		
	}
}