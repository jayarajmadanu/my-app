package business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;

public class Register {
	
	public User entry(HttpServletRequest request, HttpServletResponse reponse ) throws ServletException, IOException{
		String userName=request.getParameter("userName");
		String email= request.getParameter("email");
		String phoneNumber=request.getParameter("phoneNumber");
		String password= request.getParameter("password");
		HttpSession session=request.getSession();
		User ur=(User) session.getAttribute("user");
		if(ur!=null)
			return ur;
			
		User u=new User();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notifier","root","AaBb33@@");
			PreparedStatement ps=con.prepareStatement("insert into notifier.user (userName,email,phoneNumber,password) values(?,?,?,?)");
			ps.setString(1, userName);
			ps.setString(2, email);
			ps.setString(3, phoneNumber);
			ps.setString(4, password);
			int rs=ps.executeUpdate();
			if(rs>0) {
				u.setUserName(userName);
				u.setEmail(email);
				u.setPhoneNumber(phoneNumber);
				u.setPassword(password);
				return u;
				//response.sendRedirect("welcome.jsp");
			}
			else
				return null;
				//response.sendRedirect("index.jsp");
		} catch (Exception e) {
			
		}
		return null;
	}

}
