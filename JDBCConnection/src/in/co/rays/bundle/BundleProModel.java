package in.co.rays.bundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BundleProModel {

    ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app");

    String driver = rb.getString("driver");
    String url = rb.getString("url");
    String username = rb.getString("username");
    String password = rb.getString("password");

    // Next Primary Key Method
    public int nextPK() throws ClassNotFoundException, SQLException {

        int pk = 0;

        Class.forName(driver);

        Connection con = DriverManager.getConnection(url, username, password);

        PreparedStatement pstmt = con.prepareStatement("SELECT MAX(pro_id) FROM product");

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            pk = rs.getInt(1);
        }

        rs.close();
        pstmt.close();
        con.close();

        return pk + 1;
    }

    // Add Method
    public void add(BundleProductBean bean) throws SQLException, ClassNotFoundException {
            Class.forName(driver);

          Connection  con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false);

            PreparedStatement pstmt = con.prepareStatement(
                    "INSERT INTO product VALUES (?, ?, ?, ?)");

            pstmt.setInt(1, nextPK());
            pstmt.setString(2, bean.getProduct_name());
            pstmt.setString(3, bean.getProd_description());
            pstmt.setDouble(4, bean.getPro_prize());

            int i = pstmt.executeUpdate();

            System.out.println(i + " Record Inserted Successfully");

            con.commit();

            pstmt.close();
            con.close();     
    }
    // update method 
    
    public void update(BundleProductBean bean) throws SQLException, ClassNotFoundException {
    	Class.forName(driver);
    Connection con = DriverManager.getConnection(url, username, password);

         con.setAutoCommit(false);

         PreparedStatement pstmt = con.prepareStatement(
                 "UPDATE product SET product_name = ?, "
                         + "prod_description = ?, "
                         + "pro_prize = ? "
                         + "WHERE pro_id = ?");

         pstmt.setString(1, bean.getProduct_name());
         pstmt.setString(2, bean.getProd_description());
         pstmt.setDouble(3, bean.getPro_prize());
         pstmt.setInt(4, bean.getPro_id());

         int i = pstmt.executeUpdate();

         con.commit();

         System.out.println(i + " Record Updated Successfully");

         pstmt.close();


		System.out.println(i + "row affected(records inserted...)");
		con.commit();
		con.close();
		
    }
    // delete
    public void delete(BundleProductBean bean) throws SQLException, ClassNotFoundException {

        Class.forName(driver);

        Connection con = DriverManager.getConnection(url, username, password);

        con.setAutoCommit(false);

        PreparedStatement pstmt = con.prepareStatement(
                "DELETE FROM product WHERE pro_id = ?");

        pstmt.setInt(1, bean.getPro_id());

        int i = pstmt.executeUpdate();

        if (i > 0) {
            con.commit();
            System.out.println(i + " Record Deleted Successfully");
        } else {
            con.rollback();
            System.out.println("Record Not Found");
        }

        pstmt.close();
        con.close();
    }
    
    
    
    
   
    
    
    
    
}
