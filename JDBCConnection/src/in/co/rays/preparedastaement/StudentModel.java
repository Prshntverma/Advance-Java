package in.co.rays.preparedastaement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentModel {
	
	public void delete(StudentBean bean) throws SQLException, ClassNotFoundException {
		
Class.forName("com.mysql.cj.jdbc.Driver");// step 1 load the driver
		
		// step 2 : get the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		PreparedStatement pst = con.prepareStatement("delete from st_student where id=?");
		pst.setInt(1,bean.getId());
		int i = pst.executeUpdate();
		System.out.println("Data successfully insert " + i + " row affected");
		con.close();
		pst.close();
		
		
	}
	
	public void update(StudentBean bean) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");// step 1 load the driver
		
		// step 2 : get the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		PreparedStatement pst = con.prepareStatement("update st_student set name=?,percentage=? where id=?");
		pst.setInt(1,bean.getId());
		pst.setString(2,bean.getName());
		pst.setDouble(3,bean.getPercentage());
		
		int i = pst.executeUpdate();
		System.out.println("Data successfully insert " + i + " row affected");
		con.close();
		pst.close();
		
	}
	
	public void add(StudentBean bean) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");// step 1 load the driver

		// step 2 : get the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		PreparedStatement pst = con.prepareStatement("insert into st_student values(?,?,?)");
		
		pst.setInt(1,bean.getId());
		pst.setString(2,bean.getName());
		pst.setDouble(3,bean.getPercentage());
		
		int i = pst.executeUpdate();
		System.out.println("Data successfully insert " + i + " row affected");
		con.close();
		pst.close();
	}
	

}
