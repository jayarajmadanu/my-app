package com.example.business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.bean.*;

public class NoteBookOperation {
	
	public ArrayList<NoteBook> getNoteBook(HttpServletRequest request, HttpServletResponse response,int userId) throws ServletException, IOException{
		ArrayList<NoteBook> books=new ArrayList<NoteBook>();
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
			ps=con.prepareStatement("select * from notebooks where userId=?");
			ps.setInt(1, userId);
			rs=ps.executeQuery();
			while(rs.next()) {
				NoteBook n=new NoteBook();
				n.setBookId(rs.getInt("bookId"));
				n.setUserId(rs.getInt("userId"));
				n.setBookName(rs.getString("bookName"));
				books.add(n);
			}
			return books;
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
	
	public void addNoteBook(HttpServletRequest request, HttpServletResponse response, String bookName)throws ServletException, IOException{
		
		//String bookName=(String) request.getAttribute("bookName");
		int userId=((User)request.getSession().getAttribute("user")).getId();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notifier","root", "AaBb33@@");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps=con.prepareStatement("insert into notifier.notebooks (userId,bookName)values(?,?)");
			ps.setInt(1, userId);
			ps.setString(2, bookName);
			int rs=ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteNoteBook(HttpServletRequest request, HttpServletResponse response ,int bookId)throws ServletException, IOException{
		int userId=((User)request.getSession().getAttribute("user")).getId();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notifier","root", "AaBb33@@");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps=con.prepareStatement("delete from notifier.notebooks where userId=? and bookId=?");
			ps.setInt(1, userId);
			ps.setInt(2, bookId);
			int rs=ps.executeUpdate();
			
			 ps=con.prepareStatement("delete from notifier.notes where  bookId=?");
			ps.setInt(1, bookId);
			 rs=ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void EditNoteBook(HttpServletRequest request, HttpServletResponse response ,int bookId)throws ServletException, IOException {
		String bookName=request.getParameter("bookName");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notifier","root", "AaBb33@@");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps=con.prepareStatement("update notifier.notebooks set bookName=? where bookId=?");
			ps.setString(1, bookName);
			ps.setInt(2, bookId);
			int rs=ps.executeUpdate();
			
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getNotificationCount(HttpServletRequest request, HttpServletResponse response, int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notifier","root", "AaBb33@@");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		String endDate=dtf.format(now);
		String query="select count(*) from notifier.notes n join notifier.notebooks nb on n.bookId=nb.bookId where nb.userId="+id+" and n.endDate='"+endDate+"';";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
