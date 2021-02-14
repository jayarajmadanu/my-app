package com.example.business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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


public class NotesOperation {
	
	public ArrayList<Notes> getNotes(HttpServletRequest request, HttpServletResponse response , int bookId) throws ServletException, IOException{
		ArrayList<Notes> notes=new ArrayList<Notes>();
		HttpSession session=request.getSession();
		
		session.setAttribute("bookId", bookId);
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
			PreparedStatement ps=con.prepareStatement("select * from notifier.notes where bookId=?");
			ps.setInt(1, bookId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Notes n=new Notes();
				n.setId(rs.getInt(1));
				n.setNoteBookId(rs.getInt(2));
				n.setStartDate(rs.getDate(3));
				n.setEndDate(rs.getDate(4));
				n.setDescription(rs.getString(5));
				n.setNotesName(rs.getString(6));
				notes.add(n);
			}
			return notes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void addNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int bookId=(Integer) session.getAttribute("bookId");
		String description=request.getParameter("description");
		String eD=request.getParameter("endDate");
		Date endDate = Date.valueOf(eD);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		String startDate=dtf.format(now);
		String notesName=request.getParameter("notesName");
		//System.out.println(notesName);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con=null;
		PreparedStatement ps=null;
		String query="insert into notifier.notes (bookId,startDate,endDate,description,notesName) values(?,?,?,?,?);";
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notifier","root", "AaBb33@@");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, bookId);
			ps.setString(2, startDate);
			ps.setDate(3, endDate);
			ps.setString(4, description);
			ps.setString(5, notesName);
			int rs=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void deleteNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int notesId=Integer.parseInt(request.getParameter("notesId"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con=null;
		PreparedStatement ps=null;
		
		String query="delete from notifier.notes where id=?";
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notifier","root", "AaBb33@@");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, notesId);
			int rs=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Notes getSingleNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		//int notesId=(int) (session.getAttribute("notesId"));
		int notesId=Integer.parseInt(request.getParameter("notesId"));
		Notes n=new Notes();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query="select * from notifier.notes where id=?;";
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notifier","root", "AaBb33@@");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, notesId);
			rs=ps.executeQuery();
			if(rs.next()) {
				n.setId(rs.getInt(1));
				n.setNoteBookId(rs.getInt(2));
				n.setStartDate(rs.getDate(3));
				n.setEndDate(rs.getDate(4));
				n.setDescription(rs.getString(5));
				n.setNotesName(rs.getString(6));
				return n;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void updateNotes(HttpServletRequest request, HttpServletResponse response,int notesId) throws ServletException, IOException {
		HttpSession session=request.getSession();
		//int notesId=Integer.parseInt(request.getParameter("notesId"));
		String description=request.getParameter("description");
		String eD=request.getParameter("endDate");
		//Date endDate = Date.valueOf(eD);
		String notesName=request.getParameter("notesName");
		Notes n=new Notes();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con=null;
		PreparedStatement ps=null;
		String query="update notifier.notes set endDate='"+eD+"', description='"+description+"',notesName='"+notesName+"' where id= "+notesId;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notifier","root", "AaBb33@@");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ps=con.prepareStatement(query);
			/*ps.setDate(1, endDate);
			ps.setString(2, description);
			ps.setString(3, notesName);
			ps.setInt(4, notesId);*/
			ps.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getNotifications(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User u=(User) session.getAttribute("user");
		int id=u.getId();
		ArrayList<Notes> notifications=new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		String endDate=dtf.format(now);
		String query= "select * from notifier.notes n join notifier.notebooks nb on n.bookId=nb.bookId where nb.userId="+id+" and n.endDate='"+endDate+"';";
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notifier","root", "AaBb33@@");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ps=con.prepareStatement(query);
			//ps.setInt(1, id);
			//ps.setString(2, endDate);
			rs=ps.executeQuery();
			while(rs.next()) {
				Notes n=new Notes();
				n.setId(rs.getInt(1));
				n.setNoteBookId(rs.getInt(2));
				n.setStartDate(rs.getDate(3));
				n.setEndDate(rs.getDate(4));
				n.setDescription(rs.getString(5));
				n.setNotesName(rs.getString(6));
				notifications.add(n);
			}
			session.setAttribute("notifications", notifications);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
