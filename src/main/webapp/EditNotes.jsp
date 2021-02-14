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

		int bookId=Integer.parseInt(request.getParameter("bookId")),notesId=Integer.parseInt(request.getParameter("notesId"));
		session.setAttribute("bookId", bookId);
		session.setAttribute("notesId", notesId);
	%>
	<div align="center" style="padding-top: 100px">
	<div class="edit" align="center">
	<b><h1 style="font-family: monospace; font-size: 35px;">Edit Notes</h1></b>
	<form action="/my-app/EditNotesServlet" method="get">
		Name
		<br><input type="text" name="notesName" value="" />
		<br>Description
		<br><input type="text" name="description" value=""/>
		<br>End Date
		<br><input type="date" name="endDate" value="" placeholder="dd-mm-yyyy" value="" min="1997-01-01" max="2030-12-31"/>
		<br><input type="submit"  value="submit"/>
	</form>
	</div>
	</div>
</body>
</html>