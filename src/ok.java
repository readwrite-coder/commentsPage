

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ok
 */
@WebServlet("/ok")
public class ok extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ok() {
        super();
        System.out.println("in constructor");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter(); 
		
		help myhelp = new help();
		myhelp.databaseconnection();
		String comment = request.getParameter("comment");
		myhelp.addComment(comment);
		myhelp.prepareComments();
		ArrayList<String> theComments = myhelp.copyComments();
		
		out.println("<!DOCTYPE html>"); 
		out.println("<html>");
		out.println("<head>");
		out.println("<title>"+comment+"</title>"); 
		out.println("</head>");
		out.println("<body>"); 
		out.println("<form name='myform' method='get' action='ok'>");
		out.println("comment: <input type=\"text\" name=\"comment\" /> <br>");
		out.println("<input type=\"submit\" name=\"submit\" value=\"Submit\" />");
		out.println("</form>");
		
		out.println("Thread: ");
		
		for(int i = 0; i < theComments.size(); i++) {
			out.println("<h6>Comment: " + theComments.get(i) + "</h6>");
		}
		
		
		out.println("<h1>Hello World!</h1>"); 
		out.println("</body>"); 
		out.println("</html>");

		System.out.println("serving");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
