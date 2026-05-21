package in.co.rays.preparedastaement;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class ProductModel {
	
	
	public void delete(ProductBean bean) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		 
		PreparedStatement ps = con.prepareStatement("delete from Product where pro_id=?");
		
		ps.setInt(1,bean.getPro_id());
		
		int i = ps.executeUpdate();
		System.out.println("Data successfully insert " + i + " row affected");
		con.close();
		ps.close();
		
	}
	
	public void update(ProductBean Bean) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		 
		PreparedStatement ps = con.prepareStatement("update Product set product_name=?, prod_description=?, pro_prize=? where pro_id=?");
		
		ps.setString(1,Bean.getProduct_name());
		ps.setString(2,Bean.getProd_description());
		ps.setDouble(3,Bean.getPro_prize());
		ps.setInt(4, Bean.getPro_id());
		
		int i = ps.executeUpdate();
		System.out.println("Data successfully insert " + i + " row affected");
		con.close();
		ps.close();
		
	}
	 
	 public void add(ProductBean bean) throws SQLException, ClassNotFoundException {

		 Class.forName("com.mysql.cj.jdbc.Driver");
		 
		 
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		 
		 PreparedStatement  ps = con.prepareStatement("insert into Product values(?,?,?,?)");
		 
		 ps.setInt(1,bean.getPro_id());
		 ps.setString(2,bean.getProduct_name());
		 ps.setString(3,bean.getProd_description());
		 ps.setDouble(4, bean.getPro_prize());
		 
		 int i = ps.executeUpdate();
		 System.out.println("Data successfully insert " + i + " row affected");
			con.close();
			ps.close();
			 
	 }

}
