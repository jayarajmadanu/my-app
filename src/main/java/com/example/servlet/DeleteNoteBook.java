package com.example.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.business.*;

/**
 * Servlet implementation class DeleteNoteBook
 */
public class DeleteNoteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		NoteBookOperation nb=new NoteBookOperation();
		int bookId=Integer.parseInt(request.getParameter("bookId"));
		nb.deleteNoteBook(request, response, bookId);
		response.sendRedirect("/my-app/LoginServlet");
	}

}
