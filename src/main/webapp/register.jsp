<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remind me</title>
</head>
<style type="text/css">
	<%@ include file="myStyles.css"%>
</style>
<body>
	<%
		if(session.getAttribute("user")!=null)
			response.sendRedirect("dashboard.jsp");
	%>
	
	<div  align="center">
		<h1>Remind Me</h1>
		<div class="card" align="center" >
			<h3>Register</h3>
			<form  id="RegisterFormId" name="RegisterForm" method="post" action="/my-app/RegisterServlet">
				<table border="0" cellpadding="3">
					<tbody>
						<tr>
							<td>User Name</td>
							<td><input type="text" name="userName" value="" /></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><input type="email" name="email" value="" /></td>
						</tr>
						<tr>
							<td>Phone Number</td>
							<td><input type="text" name="phoneNumber" value="" /></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><input type="password" name="password" value="" /></td>
						</tr>
					</tbody>
				</table>
				<br>
				<input type="submit" value="Register" class="button" />
				<br>
				<br>
				Already Registered !! <a href="index.jsp">Login Here</a>
			</form>
		</div>
	</div>
</body>
</html>