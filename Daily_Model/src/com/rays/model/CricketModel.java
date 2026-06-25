package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.CricketPlayerBean;
import com.rays.util.JDBCDataSource;

public class CricketModel {

	// Next PK
	public int nextPK() throws Exception {

		int pk = 0;

		Connection con = JDBCDataSource.getConnection();

		PreparedStatement pstmt = con.prepareStatement(
				"SELECT MAX(id) FROM cricketPlayer");

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			pk = rs.getInt(1);
		}

		rs.close();
		pstmt.close();
		con.close();

		return pk + 1;
	}

	// Add
	public int add(CricketPlayerBean bean) throws Exception {

		int pk = nextPK();

		Connection con = null;

		try {

			con = JDBCDataSource.getConnection();

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement("INSERT INTO cricketPlayer VALUES(?,?,?,?,?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getPlayerName());
			pstmt.setString(3, bean.getTeam());
			pstmt.setString(4, bean.getRole());
			pstmt.setInt(5, bean.getRuns());

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

	// Update
	public void update(CricketPlayerBean bean) throws Exception {

		Connection con = null;

		try {

			con = JDBCDataSource.getConnection();

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement(
					"UPDATE cricketPlayer SET playerName=?, team=?, role=?, runs=? WHERE id=?");

			pstmt.setString(1, bean.getPlayerName());
			pstmt.setString(2, bean.getTeam());
			pstmt.setString(3, bean.getRole());
			pstmt.setInt(4, bean.getRuns());
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

	// Delete
	public void delete(int id) throws Exception {

		Connection con = null;

		try {

			con = JDBCDataSource.getConnection();

			con.setAutoCommit(false);

			PreparedStatement pstmt = con.prepareStatement(
					"DELETE FROM cricketPlayer WHERE id=?");

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

	// Find By PK
	public CricketPlayerBean findByPK(int pk) throws Exception {

		Connection con = JDBCDataSource.getConnection();

		PreparedStatement pstmt = con.prepareStatement(
				"SELECT * FROM cricketPlayer WHERE id=?");

		pstmt.setInt(1, pk);

		ResultSet rs = pstmt.executeQuery();

		CricketPlayerBean bean = null;

		if (rs.next()) {

			bean = new CricketPlayerBean();

			bean.setId(rs.getInt("id"));
			bean.setPlayerName(rs.getString("playerName"));
			bean.setTeam(rs.getString("team"));
			bean.setRole(rs.getString("role"));
			bean.setRuns(rs.getInt("runs"));
		}

		rs.close();
		pstmt.close();
		con.close();

		return bean;
	}

	// List
	public List<CricketPlayerBean> list() throws Exception {

		Connection con = JDBCDataSource.getConnection();

		PreparedStatement pstmt = con.prepareStatement(
				"SELECT * FROM cricketPlayer");

		ResultSet rs = pstmt.executeQuery();

		List<CricketPlayerBean> list = new ArrayList<CricketPlayerBean>();

		while (rs.next()) {

			CricketPlayerBean bean = new CricketPlayerBean();

			bean.setId(rs.getInt("id"));
			bean.setPlayerName(rs.getString("playerName"));
			bean.setTeam(rs.getString("team"));
			bean.setRole(rs.getString("role"));
			bean.setRuns(rs.getInt("runs"));

			list.add(bean);
		}

		rs.close();
		pstmt.close();
		con.close();

		return list;
	}

	// Search
	public List<CricketPlayerBean> search(CricketPlayerBean bean) throws Exception {

		Connection con = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer(
				"SELECT * FROM cricketPlayer WHERE 1=1");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}

			if (bean.getPlayerName() != null
					&& bean.getPlayerName().length() > 0) {

				sql.append(" AND playerName LIKE '"+ bean.getPlayerName() + "%'");
			}

			if (bean.getTeam() != null && bean.getTeam().length() > 0) {

				sql.append(" AND team LIKE '"+ bean.getTeam() + "%'");
			}

			if (bean.getRole() != null && bean.getRole().length() > 0) {

				sql.append(" AND role LIKE '"+ bean.getRole() + "%'");
			}
		}

		PreparedStatement pstmt = con.prepareStatement(
				sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List<CricketPlayerBean> list =
				new ArrayList<CricketPlayerBean>();

		while (rs.next()) {

			CricketPlayerBean cp = new CricketPlayerBean();

			cp.setId(rs.getInt("id"));
			cp.setPlayerName(rs.getString("playerName"));
			cp.setTeam(rs.getString("team"));
			cp.setRole(rs.getString("role"));
			cp.setRuns(rs.getInt("runs"));

			list.add(cp);
		}

		rs.close();
		pstmt.close();
		con.close();

		return list;
	}
}