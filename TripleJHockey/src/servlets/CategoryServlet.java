package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CategoryWorkerBean;
import beans.ItemBean;

public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CategoryServlet() {
    	 super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
        HttpSession session = request.getSession();
        String category = request.getParameter("Category");
        session.setAttribute("categoryName", category);
        RequestDispatcher dispatcher;
        
        // TODO: create a database connection
        
        // sample query - the actual database values may not match the category names (although it'd be easier if they did)
        // this query would return all data contained in the Items table with the correct category name.
        String query = "select * from Items where category = '" + category + "'";
        
        // call a separate worker bean which will handle the processing
        CategoryWorkerBean categoryWorkerBean = new CategoryWorkerBean(query); // , connection);
        ItemBean[] items = categoryWorkerBean.getItems();
        session.setAttribute("items", items);
        
        // call the appropriate page... the data
        switch(category) {
        case "compositeStick":
        	dispatcher = servletContext.getRequestDispatcher("/CompositeSticks/index.jsp");
            dispatcher.forward(request, response);
        	break;
        case "woodenStick":
        	dispatcher = servletContext.getRequestDispatcher("/WoodenSticks/index.jsp");
            dispatcher.forward(request, response);
        	break;
        case "goalieStick":
        	dispatcher = servletContext.getRequestDispatcher("/GoalieSticks/index.jsp");
            dispatcher.forward(request, response);
        	break;
        case "iceSkate":
        	dispatcher = servletContext.getRequestDispatcher("/IceSkates/index.jsp");
            dispatcher.forward(request, response);
        	break;
        case "inlineSkate":
        	dispatcher = servletContext.getRequestDispatcher("/InlineSkates/index.jsp");
            dispatcher.forward(request, response);
        	break;
        case "backpackBag":
        	dispatcher = servletContext.getRequestDispatcher("/BackpackBags/index.jsp");
            dispatcher.forward(request, response);
        	break;
        case "carryBag":
        	dispatcher = servletContext.getRequestDispatcher("/CarryBags/index.jsp");
            dispatcher.forward(request, response);
        	break;
        case "stickBag":
        	dispatcher = servletContext.getRequestDispatcher("/StickBags/index.jsp");
            dispatcher.forward(request, response);
        	break;
        default:
        	break;
        }

	}

}
