

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Notes;
import bean.User;
import business.NoteBookOperation;
import business.NotesOperation;

/**
 * Servlet implementation class GetNotesServlet
 */
public class GetNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		ArrayList<Notes> a=new ArrayList<Notes>();
		NotesOperation no=new NotesOperation();
		int bookId=Integer.parseInt(request.getParameter("bookId"));
		a=no.getNotes(request, response,bookId);
		session.setAttribute("notes", a);
		NoteBookOperation nb= new NoteBookOperation();
		User u=(User) session.getAttribute("user");
		int count=nb.getNotificationCount(request, response, u.getId());
		session.setAttribute("count", count);
		response.sendRedirect("/my-app/NotesPage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
