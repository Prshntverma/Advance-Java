<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Login</h2>

<form action="LoginCtl" method="post">

<label>Login Id</label>
<input type="text" name="loginId">

<br><br>

<label>Password</label>
<input type="password" name="password">

<br><br>

<input type="submit" value="SignIn">

</form>

<font color="red">
${error}
</font>

</body>
</html>