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

import beans.RegisterWorkerBean;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	/**
    	 * The init method checks if the database connection is already created.
    	 * If not, creates the database connection
    	 * @author jie
    	 */
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
		
		RegisterWorkerBean workerBean=new RegisterWorkerBean(request,response);
		String forwardPage=workerBean.getReturnAddress();
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = servletContext.getRequestDispatcher(forwardPage);
        dispatcher.forward(request, response);
	}

}
