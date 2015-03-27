package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: handle the login processing
		//		- extract login parameters
		//		- create a User bean
		//		- use the contents of the User bean to create a query that checks for that username
		//		- if it exists
		//			- add User bean information to the session
		//			- return to the main index page
		//			- in main page, "Account" instead of "Login" visible in the header now..... need to implement this somehow
		//		- if it doesn't exist
		//			- pass back an error string that "that user name does not exist"
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
	}

}
