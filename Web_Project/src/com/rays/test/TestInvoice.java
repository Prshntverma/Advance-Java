package com.rays.test;

import java.text.SimpleDateFormat;
import com.rays.bean.InvoiceBean;
import com.rays.model.InvoiceModel;
public class TestInvoice {
 public static void main(String[] args) throws Exception {

	        //add();
	        //update();
	       // delete();
	        //findById();
	       // findByInvoiceNo();
	        
	    }

	    private static void add() throws Exception {

	        InvoiceBean bean = new InvoiceBean();

	        bean.setInvoiceNo("INV003");
	        bean.setAmount(15000);
	        bean.setInvoiceDate(new SimpleDateFormat("dd-MM-yyyy").parse("12-01-2025"));
	        bean.setStatus("Paid");

	        InvoiceModel model = new InvoiceModel();
	        model.add(bean);

	        System.out.println("Data Added");
	    }

	    private static void update() throws Exception {

	        InvoiceBean bean = new InvoiceBean();

	        bean.setId(1);
	        bean.setInvoiceNo("INV101");
	        bean.setAmount(25000);
	        bean.setInvoiceDate(new SimpleDateFormat("dd-MM-yyyy").parse("26-06-2026"));
	        bean.setStatus("Pending");

	        InvoiceModel model = new InvoiceModel();
	        model.update(bean);

	        System.out.println("Data Updated");
	    }

	    private static void delete() throws Exception {

	        InvoiceBean bean = new InvoiceBean();
	        bean.setId(5);
	        InvoiceModel model = new InvoiceModel();
	       // model.delete(bean);

	        System.out.println("Data Deleted");
	    }

	    private static void findById() throws Exception {

	        InvoiceModel model = new InvoiceModel();

	        InvoiceBean bean = model.findById(1);

	        System.out.println(bean.getId());
	        System.out.println(bean.getInvoiceNo());
	        System.out.println(bean.getAmount());
	        System.out.println(bean.getInvoiceDate());
	        System.out.println(bean.getStatus());
	    }

	    private static void findByInvoiceNo() throws Exception {

	        InvoiceModel model = new InvoiceModel();

	        InvoiceBean bean = model.findByInvoiceNo("INV001");

	        System.out.println(bean.getId());
	        System.out.println(bean.getInvoiceNo());
	        System.out.println(bean.getAmount());
	        System.out.println(bean.getInvoiceDate());
	        System.out.println(bean.getStatus());
	    }
	}

