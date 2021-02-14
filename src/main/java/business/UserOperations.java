package business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;

public class UserOperations {
	public void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id= Integer.parseInt(request.getParameter("userId"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notifier","root", "AaBb33@@");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String query="update notifier.user set userName='"+request.getParameter("userName")+"', phoneNumber='"+request.getParameter("phoneNumber")+"',password='"+request.getParameter("password")+"' where id="+id;
		try {
			ps=con.prepareStatement(query);
			boolean rs=ps.execute();
			HttpSession session=request.getSession();
			User user=(User) session.getAttribute("user");
			
				User u=new User();
				u.setUserName(request.getParameter("userName"));
				u.setId(id);
				u.setEmail(user.getEmail());
				u.setPassword(request.getParameter("password"));
				u.setPhoneNumber(request.getParameter("phoneNumber"));
				session.setAttribute("user", u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
