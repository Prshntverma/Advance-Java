package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.SchlorshipBean;
import com.rays.bean.UserBean;
import com.rays.util.JDBCDataSource;

public class SchlorshipModel {
  //next pk
	 public int nextPK() throws Exception {

	        int pk = 0;
	        Connection con = JDBCDataSource.getConnection();
	        PreparedStatement pstmt = con.prepareStatement( "Select MAX(id) FROM schlorship");
	 ResultSet rs = pstmt.executeQuery();
	  if (rs.next()) {
	            pk = rs.getInt(1);
	        }
	  		rs.close();
	        pstmt.close();
	        con.close();

	        return pk + 1;
	    }
	public int add(SchlorshipBean bean) throws Exception {

		
		
		int pk = nextPK();
		Connection con = null;

		SchlorshipBean existBean = findByPK(bean.getId());

		if (existBean != null) {
			throw new RuntimeException("loginId already exist");
		}
		try {

			con = JDBCDataSource.getConnection();

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO schlorship VALUES(?,?,?,?,?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getStudentName());
			pstmt.setDouble(3, bean.getAmount());
			pstmt.setString(4, bean.getYear());
			pstmt.setString(5, bean.getStatus());

			pstmt.executeUpdate();

			con.commit();

			pstmt.close();
			con.close();

		} catch (Exception e) {

			if (con != null) {
				con.rollback();
			}

			throw e;
		}

		return pk;
	}
	
	public void update(SchlorshipBean bean) throws Exception {

		Connection con = null;

		try {

			con = JDBCDataSource.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement("UPDATE schlorship SET studentName=?, amount=?, year=?, status=? WHERE id=?");

			pstmt.setString(1, bean.getStudentName());
			pstmt.setDouble(2, bean.getAmount());
			pstmt.setString(3, bean.getYear());
			pstmt.setString(4, bean.getStatus());
			pstmt.setInt(5, bean.getId());

			pstmt.executeUpdate();

			con.commit();
			pstmt.close();
			con.close();

		} catch (Exception e) {

			if (con != null) {
			con.rollback();
		}

			throw e;
		}
	}
	public void delete(int id) throws Exception {

		Connection con = null;
		try {

			con = JDBCDataSource.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM schlorship WHERE id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
			con.commit();
			pstmt.close();
			con.close();

		} catch (Exception e) {

			if (con != null) {
				con.rollback();
			}

			throw e;
		}
	}
	public SchlorshipBean findByPK(int pk) throws Exception {

		Connection con = JDBCDataSource.getConnection();//SELECT * FROM schlorship WHERE id=?

		PreparedStatement pstmt = con.prepareStatement("select * from schlorship where id = ?");

		pstmt.setInt(1, pk);

		ResultSet rs = pstmt.executeQuery();

		SchlorshipBean bean = null;

		if (rs.next()) {

			bean = new SchlorshipBean();

			bean.setId(rs.getInt(1));
			bean.setStudentName(rs.getString(2));
			bean.setAmount(rs.getDouble(3));
			bean.setYear(rs.getString(4));
			bean.setStatus(rs.getString(5));
		}

		rs.close();
		pstmt.close();
		con.close();

		return bean;
	}
	public List<SchlorshipBean> list() throws Exception {

		Connection con = JDBCDataSource.getConnection();

		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM schlorship");

		ResultSet rs = pstmt.executeQuery();
		List<SchlorshipBean> list = new ArrayList<SchlorshipBean>();

		while (rs.next()) {

			SchlorshipBean bean = new SchlorshipBean();

			bean.setId(rs.getInt(1));
			bean.setStudentName(rs.getString(2));
			bean.setAmount(rs.getDouble(3));
			bean.setYear(rs.getString(4));
			bean.setStatus(rs.getString(5));

			list.add(bean);
		}

		rs.close();
		pstmt.close();
		con.close();

		return list;
	}
	public List<SchlorshipBean> search(SchlorshipBean bean) throws Exception {

		Connection con = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("SELECT * FROM schlorship WHERE 1=1");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}

			if (bean.getStudentName() != null && bean.getStudentName().length() > 0) {

				sql.append(" AND studentName LIKE '"+ bean.getStudentName() + "%'");
			}

			if (bean.getStatus() != null && bean.getStatus().length() > 0) {

				sql.append(" AND status LIKE '"	+ bean.getStatus() + "%'");
			}
		}

		PreparedStatement pstmt = con.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List<SchlorshipBean> list = new ArrayList<SchlorshipBean>();

		while (rs.next()) {

			bean = new SchlorshipBean();

			bean.setId(rs.getInt(1));
			bean.setStudentName(rs.getString(2));
			bean.setAmount(rs.getDouble(3));
			bean.setYear(rs.getString(4));
			bean.setStatus(rs.getString(5));

			list.add(bean);
		}

		rs.close();
		pstmt.close();
		con.close();

		return list;
	}

}
