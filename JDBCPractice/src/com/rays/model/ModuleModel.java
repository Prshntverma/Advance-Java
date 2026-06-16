package com.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.rays.bean.ModuleBean;

public class ModuleModel{
	
	ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.system");

	String driver = rb.getString("driver");
	String url = rb.getString("url");
	String username = rb.getString("username");
	String password = rb.getString("password");
	
	public int nextPK() throws ClassNotFoundException,SQLException{
		int pk = 0;
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = con.prepareStatement("SELECT MAX(module_Id) FROM module ");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}
		

		return pk + 1;
	
	}
	 // Add Method
    public void add(ModuleBean bean) throws Exception {
     
    	ModuleBean existBean = findByName(bean.getModuleName());

        if (existBean != null) {
            throw new Exception("Module Name Already Exists");
        }
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, username, password);

        PreparedStatement pstmt = con.prepareStatement("INSERT INTO module VALUES(?,?,?,?,?)");

        pstmt.setInt(1, nextPK());
        pstmt.setString(2, bean.getModuleName());
        pstmt.setString(3, bean.getTechnology());
        pstmt.setString(4, bean.getDeveloperName());
        pstmt.setString(5, bean.getStatus());

        pstmt.executeUpdate();

        pstmt.close();
        con.close();

        System.out.println("Module Added Successfully");	
}
 // Update Method
    public void update(ModuleBean bean) throws Exception {

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, username, password);

        PreparedStatement pstmt = con.prepareStatement(
        "UPDATE module SET module_name=?, technology=?, developer_name=?, status=? WHERE module_Id=?");

        pstmt.setString(1, bean.getModuleName());
        pstmt.setString(2, bean.getTechnology());
        pstmt.setString(3, bean.getDeveloperName());
        pstmt.setString(4, bean.getStatus());
        pstmt.setInt(5, bean.getModuleId());

        int i = pstmt.executeUpdate();

        if (i > 0) {
            System.out.println("Module Updated Successfully");
        } else {
            System.out.println("Module ID not found");
        }

        pstmt.close();
        con.close();
    }
    // delete
    public void delete(int moduleId) throws Exception {

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, username, password);

        PreparedStatement pstmt = con.prepareStatement(
                "DELETE FROM module WHERE moduleId=?");

        pstmt.setInt(1, moduleId);

        int i = pstmt.executeUpdate();

        if (i > 0) {
            System.out.println("Module Deleted Successfully");
        } else {
            System.out.println("Module ID not found");
        }

        pstmt.close();
        con.close();
    }
 // Find By PK
    public ModuleBean findByPK(int moduleId) throws Exception {

        ModuleBean bean = null;

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, username, password);

        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM module where module_Id=?");

        pstmt.setInt(1, moduleId);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            bean = new ModuleBean();

            bean.setModuleId(rs.getInt(1));
            bean.setModuleName(rs.getString(2));
            bean.setTechnology(rs.getString(3));
            bean.setDeveloperName(rs.getString(4));
            bean.setStatus(rs.getString(5));
        }

        rs.close();
        pstmt.close();
        con.close();

        return bean;
    }
    // Search Method
    public ArrayList<ModuleBean> search() throws Exception {

        ArrayList<ModuleBean> list = new ArrayList<>();

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, username, password);

        PreparedStatement pstmt = con.prepareStatement(
                "SELECT * FROM module");

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            ModuleBean bean = new ModuleBean();

            bean.setModuleId(rs.getInt(1));
            bean.setModuleName(rs.getString(2));
            bean.setTechnology(rs.getString(3));
            bean.setDeveloperName(rs.getString(4));
            bean.setStatus(rs.getString(5));

            list.add(bean);
        }

        rs.close();
        pstmt.close();
        con.close();

        return list;
    }
 // Find By Module Name
    public ModuleBean findByName(String moduleName) throws Exception {

        ModuleBean bean = null;

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, username, password);

        PreparedStatement pstmt = con.prepareStatement(
                "SELECT * FROM module WHERE module_name=?");

        pstmt.setString(1, moduleName);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            bean = new ModuleBean();

            bean.setModuleId(rs.getInt(1));
            bean.setModuleName(rs.getString(2));
            bean.setTechnology(rs.getString(3));
            bean.setDeveloperName(rs.getString(4));
            bean.setStatus(rs.getString(5));
        }

        rs.close();
        pstmt.close();
        con.close();

        return bean;
    }

    
    }
