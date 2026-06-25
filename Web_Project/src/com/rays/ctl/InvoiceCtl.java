package com.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.InvoiceBean;
import com.rays.model.InvoiceModel;

@WebServlet("/InvoiceCtl.do")
public class InvoiceCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InvoiceModel model = new InvoiceModel();
		InvoiceBean bean = new InvoiceBean();

		String id = request.getParameter("id");

		try {

			if (id != null && id.length() > 0) {

				bean = model.findById(Integer.parseInt(id));

				request.setAttribute("bean", bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("InvoiceUser.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		InvoiceBean bean = new InvoiceBean();
		InvoiceModel model = new InvoiceModel();

		try {

			String id = request.getParameter("id");

			bean.setInvoiceNo(request.getParameter("invoiceNo"));
			bean.setAmount(Integer.parseInt(request.getParameter("amount")));
			bean.setInvoiceDate(sdf.parse(request.getParameter("invoiceDate")));
			bean.setStatus(request.getParameter("status"));

			if (id != null && !id.equals("") && !id.equals("0")) {

				bean.setId(Integer.parseInt(id));
				model.update(bean);

				request.setAttribute("successMsg", "Invoice Updated Successfully");

			} else {

				model.add(bean);

				request.setAttribute("successMsg", "Invoice Saved Successfully");
			}

			request.setAttribute("bean", bean);

		} catch (Exception e) {

			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("InvoiceUser.jsp");
		rd.forward(request, response);
	}
}