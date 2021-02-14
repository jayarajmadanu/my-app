

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.NoteBookOperation;

/**
 * Servlet implementation class AddNoteBookServlet
 */
public class AddNoteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoteBookOperation nb=new NoteBookOperation();
		String bookName=(String) request.getParameter("bookName");
		nb.addNoteBook(request,response,bookName);
		response.sendRedirect("/my-app/LoginServlet");
	}

}
