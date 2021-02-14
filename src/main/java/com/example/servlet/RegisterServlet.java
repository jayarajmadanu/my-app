package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.bean.*;
import com.example.business.*;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Register reg=new Register();
		User user=reg.entry(request,response);
		PrintWriter out=response.getWriter();
		if(user!=null) {
			response.sendRedirect("dashboard.jsp");
		}
		else {
			out.print("<p>Unable to Register</p>");
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
		
		/*String userName=request.getParameter("userName");
		String email= request.getParameter("email");
		String phoneNumber=request.getParameter("phoneNumber");
		String password= request.getParameter("password");
		//String DBuserName="root",DBpassword="AaBb33@@";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notifier","root","AaBb33@@");
			//Statement st=con.createStatement();
			PreparedStatement ps=con.prepareStatement("insert into notifier.user (userName,email,phoneNumber,password) values(?,?,?,?)");
			ps.setString(1, userName);
			ps.setString(2, email);
			ps.setString(3, phoneNumber);
			ps.setString(4, password);
			int rs=ps.executeUpdate();
			//int rs=st.executeUpdate("INSERT INTO user(userName,email,phoneNumber,password) values('"+userName+"','"+email+"','"+phoneNumber+"','"+password+"')");
			if(rs>0) {
				response.sendRedirect("welcome.jsp");
			}
			else
				response.sendRedirect("index.jsp");
		} catch (Exception e) {
			
		}*/
		
				
	}

}
