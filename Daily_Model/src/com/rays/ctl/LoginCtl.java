package com.rays.ctl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");

		if ("admin@gmail.com".equals(loginId) && "admin123".equals(password)) {
			response.sendRedirect("CricketListCtl");

		} else {

			request.setAttribute("error","Invalid Login");
			request.getRequestDispatcher("LoginView.jsp").forward(request, response);
		}
	}

}
