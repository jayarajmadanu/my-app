

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.NoteBook;
import bean.User;
import business.Authentication;
import business.NoteBookOperation;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();
		
		User user=null;
		HttpSession session=request.getSession();
		Authentication au=new Authentication();
		user=au.auth(request, response);
		if(user!=null) {
			session.setAttribute("user", user);
			NoteBookOperation nb=new NoteBookOperation();
			ArrayList<NoteBook> a=nb.getNoteBook(request, response,user.getId());
			session.setAttribute("books", a);
			int count=nb.getNotificationCount(request, response,user.getId());
			session.setAttribute("count", count);
			response.sendRedirect("/my-app/dashboard.jsp");
		}
		else {
			
			request.getRequestDispatcher("index.jsp").include(request, response);
			out.print("<div align='center'><p  style=\'color:red;'>Incorrect Username/Password</p></div>");
		}    
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		doPost(request, response);
	}
}
