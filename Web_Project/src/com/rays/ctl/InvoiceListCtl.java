package com.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.InvoiceBean;
import com.rays.bean.UserBean;
import com.rays.model.InvoiceModel;

@WebServlet("/InvoiceListCtl.do")
public class InvoiceListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");

		InvoiceBean bean = new InvoiceBean();
		InvoiceModel model = new InvoiceModel();

		int pageNo = 1;
		int pageSize = 5;

		// Search
		if (op != null && op.equalsIgnoreCase("search")) {
			bean.setInvoiceNo(request.getParameter("invoiceNo"));
		}

		// Delete
//		if (op != null && op.equalsIgnoreCase("delete")) {
//
//		    String[] ids = request.getParameterValues("ids");
//		    System.out.println(ids);
//
//		    if (ids != null && ids.length > 0) {
//
//		        for (String id : ids) {
//		            try {
//		            	model.delete(Integer.parseInt(id));
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//		        }
//		        request.setAttribute("successMsg","Record Deleted Successfully");
//
//		    } else {
//
//		        request.setAttribute("errorMsg", "Select at least one record");
//
//		    }
//		}
		if (op != null && op.equals("delete")) {
			String[] ids = request.getParameterValues("ids");
			if(ids != null && ids.length > 0) {
				for(String id : ids) {
					try {
						model.delete(Integer.parseInt(id));
					} catch (NumberFormatException e) {
	
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
					request.setAttribute("successMsg", "record deleted successfully");
				}
			} else {
				request.setAttribute("errorMsg", "select at least one record to delete..!");
			}
		}
		

		List<InvoiceBean> list;
		try {
			list = model.search(bean, pageNo, pageSize);
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("InvoiceViewList.jsp");
		rd.forward(request, response);
	}
	}
