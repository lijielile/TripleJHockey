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

import beans.CategoryWorkerBean;
import beans.ItemBean;

public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataSource dataSource;
	
	/**Added the init() method.
	 * The database connection pool is initialized here
	 * @author jie
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
    		InitialContext initialContext = new InitialContext();
    		dataSource = (DataSource) initialContext.lookup( "java:/comp/env/jdbc/TripleJHockey" );
    		if (dataSource==null) throw new Exception("Data source not found!");
    			
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
	}

    public CategoryServlet() {
    	 super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * The constructor of the categoryWorkerBean has been modified. 
		 * All actual work will be done in the categoryWorkerBean. 
		 * In addition, all the items are attached to a request instead of session 
		 * since we only need them for this specific request and don't want them to exist for the entire session
		 * The servlet will pass the DB connection pool to the worker bean
		 * @author jie
		 */
		RequestDispatcher dispatcher;
		ServletContext servletContext = getServletContext();
		//Add the DB pool to the request attribute
        request.setAttribute("ItemDBConnection", dataSource);
   
        // call a separate worker bean which will handle the processing
        CategoryWorkerBean categoryWorkerBean = new CategoryWorkerBean(request,response); 
        ItemBean[] items = categoryWorkerBean.getItems();
        request.setAttribute("items", items);
        dispatcher = servletContext.getRequestDispatcher("/Product/index.jsp");
        dispatcher.forward(request, response);
	}

}
