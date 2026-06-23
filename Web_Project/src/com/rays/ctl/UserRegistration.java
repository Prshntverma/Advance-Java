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

@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("UserRegistration.jsp");
		rd.forward(req, response);
	}
	protected void doPost(HttpServletRequest req,
            HttpServletResponse response)
            throws ServletException, IOException {

//        System.out.println("Inside doPost()");
//
//        String firstName =req.getParameter("firstName");
//
//        String lastName = req.getParameter("lastName");
//
//        String loginId = req.getParameter("loginId");
//
//        String password =req.getParameter("password");
//
//        String dob =req.getParameter("dob");
//
//        System.out.println("First Name : " + firstName);
//        System.out.println("Last Name  : " + lastName);
//        System.out.println("Login Id   : " + loginId);
//        System.out.println("Password   : " + password);
//        System.out.println("DOB        : " + dob);
//
//        RequestDispatcher rd = req.getRequestDispatcher("UserRegistration.jsp");
//        rd.forward(req, response);
 // }
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

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
