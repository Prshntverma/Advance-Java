package in.co.rays.transection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CollegeSystemModel {

    ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.transection.app");

    String driver = rb.getString("driver");
    String url = rb.getString("url");
    String username = rb.getString("username");
    String password = rb.getString("password");

    public int nextPK() throws ClassNotFoundException, SQLException {

        int pk = 0;

        Class.forName(driver);

        Connection con = DriverManager.getConnection(url, username, password);

        PreparedStatement pstmt = con.prepareStatement(
                "SELECT MAX(StudentId) FROM CollegeDB");

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            pk = rs.getInt(1);
        }

        rs.close();
        pstmt.close();
        con.close();

        return pk + 1;
    }

    // add operation...........
    
    public void add(CollegeSystemBean bean) throws Exception {

        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false);
            int pk = nextPK();

            pstmt = con.prepareStatement( "INSERT INTO CollegeDB VALUES (?, ?, ?, ?, ?)");
            pstmt.setInt(1, pk);
            pstmt.setString(2, bean.getStudentName());
            pstmt.setString(3, bean.getBranch());
            pstmt.setInt(4, bean.getSemester());
            pstmt.setDouble(5, bean.getCgpa());

            int i = pstmt.executeUpdate();

            if (i > 0) {
                con.commit();
                System.out.println("Student Added Successfully");
         }

            pstmt.close();
            con.close();

        } catch (Exception e) {

            if (con != null) {
                con.rollback();
                con.close();
            }
            System.out.println("Transaction Rolled Back");
            throw e;
        }
    }
    //delete 
    public void delete(CollegeSystemBean bean) throws Exception {
    	// delete operation...........
    	    Connection con = null;
    	    PreparedStatement pstmt = null;

    	    try {

    	        Class.forName(driver);

    	        con = DriverManager.getConnection(url, username, password);

    	        con.setAutoCommit(false);

    	        pstmt = con.prepareStatement(
    	                "DELETE FROM CollegeDB WHERE StudentId = ?");

    	        pstmt.setInt(1, bean.getStudentId());

    	        int i = pstmt.executeUpdate();

    	        if (i > 0) {

    	            con.commit();
    	            System.out.println("Student Deleted Successfully");

    	        } else {

    	            con.rollback();
    	            System.out.println("Record Not Found");
    	        }

    	        pstmt.close();
    	        con.close();

    	    } catch (Exception e) {

    	        if (con != null) {
    	            con.rollback();
    	            con.close();
    	        }

    	        System.out.println("Transaction Rolled Back");

    	        throw e;
    	    }
    	}
    	
    
    
    //update 
    public void update(CollegeSystemBean bean) throws Exception {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName(driver);

            con = DriverManager.getConnection(url, username, password);

            con.setAutoCommit(false);

            pstmt = con.prepareStatement(
            	    "UPDATE CollegeDB SET StudentName = ?, Branch = ?, Semester = ?, CGPA = ? WHERE StudentId = ?");

            pstmt.setString(1, bean.getStudentName());
            pstmt.setString(2, bean.getBranch());
            pstmt.setInt(3, bean.getSemester());
            pstmt.setDouble(4, bean.getCgpa());
            pstmt.setInt(5, bean.getStudentId());

            int i = pstmt.executeUpdate();

            if (i > 0) {
                con.commit();
                System.out.println("Student Updated Successfully");
            } else {
                con.rollback();
                System.out.println("Record Not Found");
            }

            pstmt.close();
            con.close();

        } catch (Exception e) {

            if (con != null) {
                con.rollback();
                con.close();
            }

            System.out.println("Transaction Rolled Back");

            throw e;
        }
    }
    	

}