package in.co.rays.preparedastaement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductModel {
	 
	 public void add(ProductBean bean) throws SQLException, ClassNotFoundException {

		 Class.forName("com.mysql.cj.jdbc.Driver");
		 
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		 
		 PreparedStatement  ps = con.prepareStatement("insert into Product values(?,?,?,?)");
		 
		 ps.setInt(1,bean.getPro_id());
		 ps.setString(2,bean.getProduct_name());
		 ps.setString(3,bean.getProduct_description());
		 ps.setDouble(4, bean.getPrize());
		 
		 int i = ps.executeUpdate();
		 System.out.println("Data successfully insert " + i + " row affected");
			con.close();
			ps.close();
		 
		 
	 }

}
