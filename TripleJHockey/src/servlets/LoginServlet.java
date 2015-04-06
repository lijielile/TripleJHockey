package servlets;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.LoginWorkerBean;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
    
    /**Added the init() method.
	 * The init() method checks if the database connection is already created.
	 * If not, creates the database connection.
	 * @author jie
	 */
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
		ServletContext context = getServletContext ();
		if (context.getAttribute("DBConnection")==null){
			try {
	    		InitialContext initialContext = new InitialContext();
	    		DataSource dataSource = (DataSource) initialContext.lookup( "java:/comp/env/jdbc/TripleJHockey" );
	    		if (dataSource==null) throw new Exception("Data source not found!");
	    		context.setAttribute("DBConnection", dataSource);	
			} catch (Exception e) {
				throw new ServletException(e.getMessage());
			}
		}
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
		LoginWorkerBean workerBean=new LoginWorkerBean(request,response);
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = servletContext.getRequestDispatcher(workerBean.getReturnAddress());
        dispatcher.forward(request, response);
	}
}
