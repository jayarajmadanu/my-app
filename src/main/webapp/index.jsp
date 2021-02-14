
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remind me</title>
        
    </head>
    <style type="text/css">
 		 <%@include file="myStyles.css" %>
	</style>
    <body >
   		<%
   			if(session.getAttribute("user")!=null)
   				response.sendRedirect("dashboard.jsp");
   		%>
    	<div align="center">
    	 <b><h1 style="font-family: monospace; font-size: 35px;">Remind Me</h1></b>
        <div class="card" align="center" >
        	<form id="loginFormId" name="loginForm" method="post" action="/my-app/LoginServlet">
            <h3>Login</h3>
            <br>
            <table border="0"  cellpadding="5">
                <tbody>
                    <tr>
                        <td>Mail</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    
               	 </tbody>
            	</table>
            	<br>
            	<input type="submit" value="Login" class="button"/>
            	<br>
            	<br>New User..! <a href="register.jsp">Register Here</a>
        	</form>
        </div>
        </div>
    </body>
</html>