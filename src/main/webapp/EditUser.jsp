<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remind Me</title>
<style type="text/css">
 		 <%@include file="myStyles.css" %>
</style>
</head>
<body>
	<%
	if(session.getAttribute("user")==null)
		response.sendRedirect("index.jsp");
	%>
	<div align="center" style="padding-top: 100px">
	<div class="edit" align="center">
	<b><h1 style="font-family: monospace; font-size: 35px;">Edit User</h1></b>
	<form action="/my-app/EditUserServlet">
		User Name :
		<br><input type="text" name="userName" value=""/>
		<br>Phone Number :
		<br><input type="text" name="phoneNumber" value=""/>
		<br>Password :
		<br><input type="password" name="password" value=""/><input type="text" name="userId" value="<%= request.getParameter("userId")%>" hidden/>
		<br><input type="submit" value="submit"/>
	</form>
	</div>
	</div>
</body>
</html>