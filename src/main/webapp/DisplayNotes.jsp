<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "bean.Notes" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remind Me</title>
<style type="text/css">
	<%@ include file="/myStyles.css" %>
</style>
</head>
<body>
	<%
	if(session.getAttribute("user")==null)
		response.sendRedirect("index.jsp");
	Notes note=(Notes)session.getAttribute("note");
	%>
	<div align="center" style="padding-top: 100px">
	<div class="edit" style="font-family: monospace;font-size: 20px" >
		<b><span> <%=note.getNotesName() %></span><br></b>
		<span> Description : <%=note.getDescription() %></span><br>
		<span> Start Date : <%=note.getStartDate() %></span><br>
		<span> End Date : <%=note.getEndDate() %></span><br>
	</div>
	</div>
</body>
</html>