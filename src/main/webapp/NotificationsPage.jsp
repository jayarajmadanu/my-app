<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bean.Notes"
		 import="java.util.*"
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remind me</title>
<style type="text/css">
	<%@ include file="/myStyles.css" %>
</style>
</head>
<body>
		<h2>Notifications</h2>
		<%
			if(session.getAttribute("user")==null)
			response.sendRedirect("index.jsp");
 			ArrayList<Notes> noti = (ArrayList<Notes>)request.getSession().getAttribute("notifications"); 			
 			if(noti!=null)
			for(Notes n: noti){
 		%>
 				<div class="n1" style="padding: 10px">
 					Name : <%=n.getNotesName() %>
 					<br>Description : <%=n.getDescription() %>
 					<br>
 				</div>
 		<%	
 			}
 		%>
</body>
</html>