package com.rays.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.UserBean;
import com.rays.util.JDBCDataSource;

public class UserModel {

    // Next Primary Key
    public int nextPK() throws Exception {

        int pk = 0;
        Connection con = JDBCDataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement( "SELECT MAX(id) FROM user");
 ResultSet rs = pstmt.executeQuery();
  if (rs.next()) {
            pk = rs.getInt(1);
        }
  		rs.close();
        pstmt.close();
        con.close();

        return pk + 1;
    }

    // Add Method
    public int add(UserBean bean) throws Exception {
    	int pk = nextPK();
		Connection con = null;

		UserBean existBean = findByLogin(bean.getLoginId());

		if (existBean != null) {
			throw new RuntimeException("loginId already exist");
		}

		try {
			con = JDBCDataSource.getConnection();

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement("INSERT INTO user VALUES(?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLoginId());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));

			pstmt.executeUpdate();
			con.commit(); // database changes committed successfully
		} catch (Exception e) {
			try {
				con.rollback(); // database changes revert successfully
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		return pk;

	}

    // Update Method
    public void update(UserBean bean) throws Exception {

        Connection con = JDBCDataSource.getConnection();

        con.setAutoCommit(false);

        try {

            PreparedStatement pstmt = con.prepareStatement(
                    "UPDATE user SET firstName=?, lastName=?, login=?, password=?, dob=? WHERE id=?");

            pstmt.setString(1, bean.getFirstName());
            pstmt.setString(2, bean.getLastName());
            pstmt.setString(3, bean.getLoginId());
            pstmt.setString(4, bean.getPassword());
            pstmt.setDate(5,
                    new Date(bean.getDob().getTime()));
            pstmt.setInt(6, bean.getId());

            pstmt.executeUpdate();

            con.commit();

            pstmt.close();

        } catch (Exception e) {

            con.rollback();
            e.printStackTrace();
            throw e;

        } finally {
                   con.close();
        }
    }
    // Delete Method
    public void delete(int id) throws Exception {

        Connection con = JDBCDataSource.getConnection();

        PreparedStatement pstmt = con.prepareStatement("DELETE FROM user WHERE id=?");

        pstmt.setInt(1, id);

        pstmt.executeUpdate();

        pstmt.close();
        con.close();
    }

    // Find By PK
    public UserBean findByPK(int id) throws Exception {
    UserBean bean = null;
     Connection con = JDBCDataSource.getConnection();
  PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user WHERE id=?");

        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {

            bean = new UserBean();

            bean.setId(rs.getInt(1));
            bean.setFirstName(rs.getString(2));
            bean.setLastName(rs.getString(3));
            bean.setLoginId(rs.getString(4));
            bean.setPassword(rs.getString(5));
            bean.setDob(rs.getDate(6));
        }

        rs.close();
        pstmt.close();
        con.close();

        return bean;
    }

    // Find By Login
    public UserBean findByLogin(String loginId)
            throws Exception {

        UserBean bean = null;

        Connection con = JDBCDataSource.getConnection();

        PreparedStatement pstmt = con.prepareStatement(
                "SELECT * FROM user WHERE login=?");

        pstmt.setString(1, loginId);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {

            bean = new UserBean();

            bean.setId(rs.getInt(1));
            bean.setFirstName(rs.getString(2));
            bean.setLastName(rs.getString(3));
            bean.setLoginId(rs.getString(4));
            bean.setPassword(rs.getString(5));
            bean.setDob(rs.getDate(6));
        }

        rs.close();
        pstmt.close();
        con.close();

        return bean;
    }

    // Authenticate
    public UserBean authenticate(String loginId,String password) throws Exception {
    	
    	System.out.println("in auithente====================>");

        UserBean bean = null;

        Connection con = JDBCDataSource.getConnection();

        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user WHERE login=? AND password=?");

        pstmt.setString(1, loginId);
        pstmt.setString(2, password);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {

            bean = new UserBean();

            bean.setId(rs.getInt(1));
            bean.setFirstName(rs.getString(2));
            bean.setLastName(rs.getString(3));
            bean.setLoginId(rs.getString(4));
            bean.setPassword(rs.getString(5));
            bean.setDob(rs.getDate(6));
        }

        rs.close();
        pstmt.close();
        con.close();

        return bean;
    }

    // Search Method
    public List<UserBean> search(UserBean bean, int pageNo, int pageSize)throws Exception {

        StringBuffer sql = new StringBuffer("SELECT * FROM user WHERE 1=1");
        if (bean != null) {
        	if (bean.getId() > 0) {
                sql.append(" AND id="+ bean.getId());
            }

            if (bean.getFirstName() != null && bean.getFirstName().length() > 0)
            {
            	sql.append(" AND firstName LIKE '"+ bean.getFirstName() + "%'");
            }

            if (bean.getLastName() != null && bean.getLastName().length() > 0) {

                sql.append(" AND lastName LIKE '" + bean.getLastName()  + "%'");
            }

            if (bean.getLoginId() != null  && bean.getLoginId().length() > 0) {

                sql.append(" AND loginId LIKE '"  + bean.getLoginId() + "%'");
            }
            if (bean.getPassword() != null  && bean.getPassword().length() > 0) {
            	
            	sql.append("AND password LIKE '" + bean.getPassword() + "%'");
            }
            if (bean.getDob() != null && bean.getDob().getTime() > 0) {
				sql.append("AND dob = '" + new java.sql.Date(bean.getDob().getTime()) + "'");
			}
        }

        Connection con = JDBCDataSource.getConnection();

        PreparedStatement pstmt = con.prepareStatement(
                sql.toString());

        ResultSet rs = pstmt.executeQuery();

        List<UserBean> list =
                new ArrayList<UserBean>();

        while (rs.next()) {

            bean = new UserBean();

            bean.setId(rs.getInt(1));
            bean.setFirstName(rs.getString(2));
            bean.setLastName(rs.getString(3));
            bean.setLoginId(rs.getString(4));
            bean.setPassword(rs.getString(5));
            bean.setDob(rs.getDate(6));

            list.add(bean);
        }

        rs.close();
        pstmt.close();
        con.close();

        return list;
    }
}