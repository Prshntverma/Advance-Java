package com.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/Userctl.do")
public class Userctl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		String id = request.getParameter("id");
		
		RequestDispatcher rd = request.getRequestDispatcher("User.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, 
	IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();
		UserModel model = new UserModel();
			try {
				bean.setFirstName(req.getParameter("firstName"));
				bean.setLastName(req.getParameter("lastName"));
				bean.setLoginId(req.getParameter("loginId"));
				bean.setPassword(req.getParameter("password"));
				bean.setDob(sdf.parse(req.getParameter("dob")));

				model.add(bean);
				req.setAttribute("successMsg", "user saved successfully");
				req.setAttribute("bean", bean);
				
				System.out.println("user saved successfully");
			} catch (Exception e) {
				
				req.setAttribute("errorMsg", e.getMessage());
				System.out.println("somthing wrong in saved user");
				e.printStackTrace();
			}

			RequestDispatcher rd = req.getRequestDispatcher("UserRegistration.jsp");
			rd.forward(req, response);
		

		
		
		
	}
}

