<%@page import="com.rays.bean.InvoiceBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	InvoiceBean bean = (InvoiceBean) request.getAttribute("bean");
    String _suc = (String) request.getAttribute("successMsg");
    String _err = (String) request.getAttribute("errorMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invoice Registration</title>
</head>
<body>
<%@ include file="Header.jsp"%>
    <h3 style="color: green"><%=_suc != null ? _suc : ""%></h3>
	<h3 style="color: red"><%=_err != null ? _err : ""%></h3>
  <div align = "center">
	<center>
     <h1>Invoice Registration</h1>
			<form action="InvoiceCtl.do" method="post">

			<input type="hidden" name="id"
				value="<%=bean != null ? bean.getId() : ""%>">

			<table>

				<tr>
					<td>Invoice No</td>
					<td><input type="text" name="invoiceNo"
						value="<%=bean != null ? bean.getInvoiceNo() : ""%>"></td>
				</tr>

				<tr>
					<td>Amount</td>
					<td><input type="text" name="amount"
						value="<%=bean != null ? bean.getAmount() : ""%>"></td>
				</tr>

				<tr>
					<td>Invoice Date</td>
					<td><input type="date" name="invoiceDate"></td>
				</tr>

				<tr>
					<td>Status</td>
					<td><input type="text" name="status"
						value="<%=bean != null ?bean.getStatus() : " "%>"></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" name="operation" value="Submit">
					</td>
				</tr>

			</table>

		</form>

	</center>
	</div>
 <%@ include file="Footer.jsp"%>
</body>
</html>