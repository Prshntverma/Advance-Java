package in.co.rays.preparedastaement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpModel {
	
	public void add(EmpBean bean) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		PreparedStatement pst = con.prepareStatement("insert into emp values(?,?,?)");
		
		pst.setInt(1,bean.getId());
		pst.setString(2,bean.getName());
		pst.setDouble(3,bean.getSalary());
		
		int i = pst.executeUpdate();

		System.out.println("Data successfully insert " + i + " row affected");
		
		con.close();
	}

}
