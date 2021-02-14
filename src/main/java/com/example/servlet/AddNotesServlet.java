package com.example.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.business.*;

/**
 * Servlet implementation class AddNotesServlet
 */
public class AddNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NotesOperation no=new NotesOperation();
		no.addNotes(request, response);
		/*int bookId=(int) request.getSession().getAttribute("bookId");
		no.getNotes(request, response, bookId);
		response.sendRedirect("/my-app/NotesPage.jsp");*/
		response.sendRedirect("/my-app/GetNotesServlet?bookId="+request.getSession().getAttribute("bookId"));
	}

}
