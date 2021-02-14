package business;

import bean.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Authentication {
	
	public User auth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		User ur=(User) session.getAttribute("user");
	    if(ur!=null)
	    	return ur;
			String email = (String)request.getParameter("email");   
		    String password = (String) request.getParameter("password");
		   
		    
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
				Connection con = null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notifier","root", "AaBb33@@");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			    
				try {
					ps=con.prepareStatement("select * from notifier.user where email=?  and password=?");
					ps.setString(1, email);
					ps.setString(2, password);
					rs=ps.executeQuery();
					if(rs.next()) {
						User u= new User();
						u.setUserName(rs.getString(1));
						u.setEmail(rs.getString(2));
						u.setPhoneNumber(rs.getString(3));
						u.setId(rs.getInt(4));
						u.setPassword(rs.getString(5));
						session.setAttribute("user",u);
						return u;
					}
					else {
						return null;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				finally {
					if (rs != null) {
				        try {
				            rs.close();
				        } catch (SQLException e) { /* Ignored */}
				    }
				    if (ps != null) {
				        try {
				            ps.close();
				        } catch (SQLException e) { /* Ignored */}
				    }
				    if (con != null) {
				        try {
				            con.close();
				        } catch (SQLException e) { /* Ignored */}
				    }
				}
		return null;
	}

}
