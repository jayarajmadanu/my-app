

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.NotesOperation;

/**
 * Servlet implementation class DeleteNotes
 */
public class DeleteNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NotesOperation no=new NotesOperation();
		no.deleteNotes(request, response);
		response.sendRedirect("/my-app/GetNotesServlet?bookId="+request.getParameter("bookId"));
	}

}
