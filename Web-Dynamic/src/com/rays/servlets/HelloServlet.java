package com.rays.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 @WebServlet("/HelloServlet") 
public class HelloServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in doGet() ==> method");
		
		RequestDispatcher rd = req.getRequestDispatcher("HelloView.jsp");

		rd.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in doPost() ==> method");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String loginId = req.getParameter("email");
		String password = req.getParameter("pass");
		String dob = req.getParameter("dob");

		System.out.println(firstName + "\n" + lastName + "\n" + loginId + "\n" + password + "\n" + dob);

		RequestDispatcher rd = req.getRequestDispatcher("HelloView.jsp");

		rd.forward(req, resp);
	}

}
