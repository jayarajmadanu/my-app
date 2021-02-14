<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bean.User"
		 import="bean.Notes"
		 import="java.util.*" 
		 import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remind me</title>
<style type="text/css">
	<%@ include file="/myStyles.css"%>
</style>
</head>
<body>
	<jsp:include page="/navBar.jsp"></jsp:include>
	<div class="header">
		<h1 align="center">REMIND ME</h1>
		<a  class="linkButton" href="/my-app/AddNotes.jsp">Add Notes</a>
	</div>
	
	<div style="margin-left:20%;height:100%;">
		<h2>Notes</h2>
 		<%
 			if(session.getAttribute("user")==null)
 			response.sendRedirect("index.jsp");
 			ArrayList<Notes> notes = (ArrayList<Notes>)request.getSession().getAttribute("notes");
 			if(notes!=null)
 			for(Notes note: notes){
 		%>
 			 <div class="n1">
 			 <a class="noteBook" href= <%= "/my-app/GetSingleNotesServlet?notesId="+note.getId() %>>
 					<%=note.getNotesName() %>
 					<div align="right"><a   class="linkButton"  href=<%="/my-app/EditNotes.jsp?notesId="+note.getId()+"&bookId="+note.getNoteBookId() %>>Edit Notes</a>
 					<a  class="linkButton"  href=<%="/my-app/DeleteNotes?notesId="+note.getId()+"&bookId="+note.getNoteBookId() %>>Delete Notes</a></div>
 					
 				</a>
 				</div>
 		<%	
 			}
 		%>
	</div>
</body>
</html>