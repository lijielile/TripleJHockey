package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: handle the register processing
		//		- extract register parameters
		//		- create a User bean using those parameters
		//		- use the contents of the User bean to create a query that checks for the provided username
		//		- if it exists
		//			- don't create the user, pass back an error string that "user name already exists"
		//		- if it doesn't exist
		//			- use the contents of that bean to create query to create a new user (insert ([fieldname1, fieldname2, etc]) into Users select [parameter1, parameter2, etc])
		//			- add User bean information to the session
		//			- go to the main page, with the "Account" instead of "Login" visible in the header now..... need to implement this somehow
		
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
	}

}
