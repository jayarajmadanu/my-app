<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.bean.*"
		 import="java.util.*" 
		 import="java.io.*"%>
		 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remind me</title>
<style type="text/css">
	<%@ include file="myStyles.css"%>
</style>
</head>

<body>
	<%
	
	if(session.getAttribute("user")==null)
		response.sendRedirect("index.jsp");
	%>
	<jsp:include page="/navBar.jsp"></jsp:include>
	<div class="header">
		<h1 align="center">REMIND ME</h1>
		<div>
		<a  class="linkButton" href="/my-app/AddNoteBook.jsp">Add NoteBook</a>
		<a  class="linkButton" href="/my-app/GetNotificationsServlet"><%=session.getAttribute("count") %> Notifications</a>
		</div>
	</div>
	<div style="margin-left:20%;height:100%;">
 		<%
 			ArrayList<NoteBook> books = (ArrayList<NoteBook>)request.getSession().getAttribute("books"); 			
 			if(books!=null)
 			for(NoteBook book: books){
 		%>
 				<div class="n1">
 				<a class="noteBook" href= <%= "/my-app/GetNotesServlet?bookId="+book.getBookId() %>>
 					<%=book.getBookName() %>
 					<div align="right">
 					<a  class="linkButton"  href=<%="/my-app/EditNoteBook.jsp?bookId="+book.getBookId() %>>Edit Book</a>
 					<a  class="linkButton"  href=<%="/my-app/DeleteNoteBook?bookId="+book.getBookId() %>>Delete Book</a>
 					</div>
 				</a>
 				</div>
 		<%	
 			}
 		%>
	</div>
</body>
</html>