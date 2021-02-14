<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remind me</title>
<style type="text/css">
 		 <%@include file="myStyles.css" %>
</style>
</head>
<body>
	<%
	if(session.getAttribute("user")==null)
		response.sendRedirect("index.jsp");
	%>
	<div>
		<div align="center" style="padding-top: 100px">
	<div class="edit" align="center">
	<b><h1 style="font-family: monospace; font-size: 35px;">Add Note Book</h1></b>
		<form id="formId" method="post" action="/my-app/AddNoteBookServlet" >
			Book Name..!!
			<br><input type="text" name="bookName"  value=""/> 
			<br><input type="submit" value="submit" />
		</form>
		</div>
		</div>
	</div>
</body>
</html>