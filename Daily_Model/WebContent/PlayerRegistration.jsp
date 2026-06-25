<%@page import="com.rays.bean.CricketPlayerBean"%>
<html>
<head>
<title>Cricket Player Form</title>
</head>
<body>
<%
CricketPlayerBean bean =
(CricketPlayerBean)request.getAttribute("bean");

if(bean == null){
	bean = new CricketPlayerBean();
}
%>

<h2>Cricket Player Registration</h2>

<form action="CricketCtl" method="post">

<input type="hidden" name="id"
value="<%=bean.getId()%>">

<div>
	<label for="playerName">Player Name :</label>
	<input type="text" id="playerName" name="playerName"
	value="<%=bean.getPlayerName()==null?"":bean.getPlayerName()%>">
</div>
<br>
<div>
	<label for="team">Team :</label>
	<input type="text" id="team" name="team"
	value="<%=bean.getTeam()==null?"":bean.getTeam()%>">
</div>
<br>
<div>
	<label for="role">Role :</label>
	<input type="text" id="role" name="role"
	value="<%=bean.getRole()==null?"":bean.getRole()%>">
</div>

<br>

<div>
	<label for="runs">Runs :</label>
	<input type="number" id="runs" name="runs"
	value="<%=bean.getRuns()%>">
</div>

<br>

<input type="submit" name="operation" value="Save">

<input type="reset" value="Reset">

<a href="CricketListCtl">Back</a>

<br><br>

<font color="green">
${success}
</font>

<font color="red">
${error}
</font>

</form>

</body>
</html>