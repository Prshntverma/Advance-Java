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

    public void delete(InvoiceBean bean) throws Exception {

        Connection con = JDBCDataSource.getConnection();

        PreparedStatement pstmt = con.prepareStatement("DELETE FROM invoice WHERE id=?");

        pstmt.setInt(1, bean.getId());

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
            bean.setAmount(rs.getDouble("amount"));
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
            bean.setAmount(rs.getDouble("amount"));
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
            bean.setAmount(rs.getDouble("amount"));
            bean.setInvoiceDate(rs.getDate("invoiceDate"));
            bean.setStatus(rs.getString("status"));

            list.add(bean);
        }

        rs.close();
        pstmt.close();
        con.close();

        return list;
    }
}