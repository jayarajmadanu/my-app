<%@ page import="bean.User" %>
	
	<%
		User u=(User)request.getSession().getAttribute("user");
		String dash="";
		if(u!=null){
			int userId=u.getId();
		}
		else response.sendRedirect("/my-app/index.jsp");
	%>
	
	<ul>
		<li class="helloUser" > <b>Hi <%= ((u!=null)?u.getUserName():"") %></b></li>
		<li><a href="/my-app/LoginServlet">Note Books</a></li>
		<li><a href= <%= "/my-app/EditUser.jsp?userId="+((u!=null)?u.getId():"")%>>Edit User</a></li>
		<li><a href="/my-app/Logout">Logout</a></li>
	</ul>