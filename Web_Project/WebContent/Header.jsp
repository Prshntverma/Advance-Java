<%@page import="com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		UserBean user = (UserBean) session.getAttribute("user");
	%>
	
	<%
		if (user != null) {
	%>
	<h3><%="hii, " + user.getFirstName()%></h3>
	<a href="Userctl.do">Add User</a> |
	<a href="UserListCtl.do">User List</a>
	<a href="InvoiceCtl.do">Add Invoice</a>
	<a href="InvoiceListCtl.do">Invoice List</a>
	 |
	<a href="Loginctl?operation=logout">Logout</a> |
	<%
		} else {
	%>
	<h3>Hii, Guest</h3>
	<a href="Loginctl">Login</a> |
	<a href="UserRegistration">SignUp</a> |
	<%
		}
	%>
	<a href="Welcomectl">Welcome</a>
	<hr>
</body>
</html>