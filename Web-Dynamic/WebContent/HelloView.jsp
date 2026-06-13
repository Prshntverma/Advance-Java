<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align= "center">
  <h2>Hello View !</h2>
  <form action= "HelloServlet" method = "post">
   <table>
   
   <tr>
       <th>First Name </th>
        <td>
        <input type = "text" name = "firstName" value = "" placeholder = "Enter First Name">
        </td>
   </tr>
   <tr>
       <th>Last Name </th>
        <td>
        <input type = "text" name = "lastName" value = "" placeholder = "Enter Last Name">
        </td>
   </tr>
   <tr>
       <th>User Id </th>
        <td>
        <input type = "email" name = "email" value = "" placeholder = "Enter Email">
        </td>
   </tr>
   <tr>
       <th>Password </th>
        <td>
        <input type = "password" name = "Pass" value = "" placeholder = "Enter Password">
        </td>
   </tr>
   <tr>
					<th>DOB</th>
					<td><input type="date" name="dob" value="" style="width:170px;"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="save"></td>
				</tr>
   
   
   </table>
  
  
  
  </form>
  
  




</div>

</body>
</html>