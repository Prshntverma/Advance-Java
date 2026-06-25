<%@page import="com.rays.bean.InvoiceBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	InvoiceBean bean = (InvoiceBean) request.getAttribute("bean");

	if (bean == null) {
		bean = new InvoiceBean();
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invoice Registration</title>
</head>
<body>

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

</body>
</html>