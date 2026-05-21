package in.co.rays.preparedastaement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpModel {
	
	public void delete(EmpBean bean) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		PreparedStatement pst = con.prepareStatement("delete from emp where id = ?");
		
		pst.setInt(1,bean.getId());

		int i = pst.executeUpdate();

		System.out.println("Data successfully insert " + i + " row affected");
		
		con.close();
		
	}
	
	
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
	
	public static void update(EmpBean bean) throws SQLException, ClassNotFoundException {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		PreparedStatement pst = con.prepareStatement("update emp set name = ?, salary = ? where id = ?");
		pst .setString(1,bean.getName());
		pst.setDouble(2,bean.getSalary());
		pst.setInt(3,bean.getId());
		
		int i  = pst.executeUpdate();
    	 System.out.println("Data successfully insert " + i + " row affected");
		
		con.close();
		
		
		
	}

}
