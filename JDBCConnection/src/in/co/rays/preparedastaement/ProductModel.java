package in.co.rays.preparedastaement;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
public class ProductModel {
	
	
	public List<ProductBean> search() throws ClassNotFoundException, SQLException {

		List<ProductBean> list = new ArrayList<ProductBean>();

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/rays",
				"root",
				"root");

		PreparedStatement pstmt = con.prepareStatement("select * from Product");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			ProductBean bean = new ProductBean();

			bean.setPro_id(rs.getInt(1));
			bean.setProduct_name(rs.getString(2));
			bean.setProd_description(rs.getString(3));
			bean.setPro_prize(rs.getDouble(4));

			list.add(bean);
		}

		con.close();

		return list;
	}

	// ================= NEXT PK =================

	
	public int nextPK() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		int pk = 0;
		PreparedStatement pstmt = con.prepareStatement("select max(id) from Product");
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}

		return pk + 1;
		
	}
	
	
	
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
