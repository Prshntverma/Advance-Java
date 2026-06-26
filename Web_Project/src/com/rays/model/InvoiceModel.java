package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.InvoiceBean;
import com.rays.util.JDBCDataSource;

public class InvoiceModel {

    public int nextPk() throws Exception {

        int pk = 0;

        Connection con = JDBCDataSource.getConnection();

        PreparedStatement pstmt = con.prepareStatement("SELECT MAX(id) FROM invoice");

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            pk = rs.getInt(1);
        }

        rs.close();
        pstmt.close();
        con.close();

        return pk + 1;
    }

    public void add(InvoiceBean bean) throws Exception {

        int pk = nextPk();

        Connection con = JDBCDataSource.getConnection();

        PreparedStatement pstmt = con.prepareStatement("INSERT INTO invoice VALUES(?,?,?,?,?)");

        pstmt.setInt(1, pk);
        pstmt.setString(2, bean.getInvoiceNo());
        pstmt.setDouble(3, bean.getAmount());
        pstmt.setDate(4, new java.sql.Date(bean.getInvoiceDate().getTime()));
        pstmt.setString(5, bean.getStatus());

        pstmt.executeUpdate();

        pstmt.close();
        con.close();
    }

    public void update(InvoiceBean bean) throws Exception {

        Connection con = JDBCDataSource.getConnection();

        PreparedStatement pstmt = con.prepareStatement("UPDATE invoice SET invoiceNo=?,amount=?,invoiceDate=?,status=? WHERE id=?");

        pstmt.setString(1, bean.getInvoiceNo());
        pstmt.setDouble(2, bean.getAmount());
        pstmt.setDate(3, new java.sql.Date(bean.getInvoiceDate().getTime()));
        pstmt.setString(4, bean.getStatus());
        pstmt.setInt(5, bean.getId());

        pstmt.executeUpdate();

        pstmt.close();
        con.close();
    }

    public void delete(int id) throws Exception {

        Connection con = JDBCDataSource.getConnection();

        PreparedStatement pstmt = con.prepareStatement("DELETE FROM invoice WHERE id=?");

        pstmt.setInt(1, id);

        pstmt.executeUpdate();

        pstmt.close();
        con.close();
    }

    public InvoiceBean findById(int id) throws Exception {

        InvoiceBean bean = null;

        Connection con = JDBCDataSource.getConnection();

        PreparedStatement pstmt = con.prepareStatement( "SELECT * FROM invoice WHERE id=?");

        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {

            bean = new InvoiceBean();

            bean.setId(rs.getInt("id"));
            bean.setInvoiceNo(rs.getString("invoiceNo"));
            bean.setAmount(rs.getInt("amount"));
            bean.setInvoiceDate(rs.getDate("invoiceDate"));
            bean.setStatus(rs.getString("status"));
        }

        rs.close();
        pstmt.close();
        con.close();

        return bean;
    }

    public InvoiceBean findByInvoiceNo(String invoiceNo) throws Exception {

        InvoiceBean bean = null;

        Connection con = JDBCDataSource.getConnection();

        PreparedStatement pstmt = con.prepareStatement( "SELECT * FROM invoice WHERE invoiceNo=?");

        pstmt.setString(1, invoiceNo);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {

            bean = new InvoiceBean();

            bean.setId(rs.getInt("id"));
            bean.setInvoiceNo(rs.getString("invoiceNo"));
            bean.setAmount(rs.getInt("amount"));
            bean.setInvoiceDate(rs.getDate("invoiceDate"));
            bean.setStatus(rs.getString("status"));
        }

        rs.close();
        pstmt.close();
        con.close();

        return bean;
    }
    
    
    public List<InvoiceBean> list() throws Exception {

        List<InvoiceBean> list = new ArrayList<>();

        
        Connection con = JDBCDataSource.getConnection();

        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM invoice");

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            InvoiceBean bean = new InvoiceBean();

            bean.setId(rs.getInt("id"));
            bean.setInvoiceNo(rs.getString("invoiceNo"));
            bean.setAmount(rs.getInt("amount"));
            bean.setInvoiceDate(rs.getDate("invoiceDate"));
            bean.setStatus(rs.getString("status"));

            list.add(bean);
        }

        rs.close();
        pstmt.close();
        con.close();

        return list;
    }
    public List<InvoiceBean> search(InvoiceBean bean, int pageNo, int pageSize) throws Exception {

        List<InvoiceBean> list = new ArrayList<>();

        Connection con = JDBCDataSource.getConnection();

        String sql = "SELECT * FROM invoice WHERE 1=1";

        if (bean.getInvoiceNo() != null && bean.getInvoiceNo().length() > 0) {
            sql += " AND invoiceNo LIKE ?";
        }

        if (bean.getStatus() != null && bean.getStatus().length() > 0) {
            sql += " AND status LIKE ?";
        }

        if (pageSize > 0) {
            sql += " LIMIT " + (pageNo - 1) * pageSize + "," + pageSize;
        }

        PreparedStatement pstmt = con.prepareStatement(sql);

        int index = 1;

        if (bean.getInvoiceNo() != null && bean.getInvoiceNo().length() > 0) {
            pstmt.setString(index++, bean.getInvoiceNo() + "%");
        }

        if (bean.getStatus() != null && bean.getStatus().length() > 0) {
            pstmt.setString(index++, bean.getStatus() + "%");
        }

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            InvoiceBean b = new InvoiceBean();

            b.setId(rs.getInt("id"));
            b.setInvoiceNo(rs.getString("invoiceNo"));
            b.setAmount(rs.getInt("amount"));
            b.setInvoiceDate(rs.getDate("invoiceDate"));
            b.setStatus(rs.getString("status"));

            list.add(b);
        }

        rs.close();
        pstmt.close();
        con.close();

        return list;
    }
}