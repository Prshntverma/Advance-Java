<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.bean.InvoiceBean"%>

<%
	List<InvoiceBean> list = (List<InvoiceBean>) request.getAttribute("list");

	String suc = (String) request.getAttribute("successMsg");
	String err = (String) request.getAttribute("errorMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invoice List</title>
</head>
<body>

	<%@ include file="Header.jsp"%>

	<div align="center">

		<h1>Invoice List</h1>

		<h3 style="color: green"><%=suc != null ? suc : ""%></h3>
		<h3 style="color: red"><%=err != null ? err : ""%></h3>

		<form action="InvoiceListCtl.do" method="post">

			<table>

				<tr>

					<th>Invoice No</th>

					<td><input type="text" name="invoiceNo"
						placeholder="Search Invoice No"></td>

					<td><input type="submit" name="operation" value="search">
					</td>

				</tr>

			</table>

			<br>

			<table border="1" width="100%">
			<tr bgcolor="skyblue">
			<th><input type="checkbox"
						onclick="document.querySelectorAll('input[name=ids]').forEach(c=>c.checked=this.checked)">
						Select All</th>

					<th>ID</th>
					<th>Invoice No</th>
					<th>Amount</th>
					<th>Invoice Date</th>
					<th>Status</th>
					<th>Edit</th>

				</tr>

				<%
					Iterator<InvoiceBean> it = list.iterator();
					while (it.hasNext()) {
						InvoiceBean bean = it.next();
				%>

				<tr align="center">

					<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>

					<td><%=bean.getId()%></td>

					<td><%=bean.getInvoiceNo()%></td>

					<td><%=bean.getAmount()%></td>

					<td><%=bean.getInvoiceDate()%></td>

					<td><%=bean.getStatus()%></td>

					<td><a href="InvoiceCtl.do?id=<%=bean.getId()%>"> Edit </a></td>

				</tr>

				<%
					}
				%>

			</table>

			<br> <input type="submit" name="operation" value="delete">

		</form>

	</div>

	<%@ include file="Footer.jsp"%>

</body>
</html>