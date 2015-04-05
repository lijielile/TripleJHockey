package beans;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class CategoryWorkerBean {
	private ItemBean[] items;
	
	public CategoryWorkerBean(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Connection conn = null;
		Statement stmt = null;  
		ResultSet rs = null;
		ArrayList<ItemBean> itemList=new ArrayList<ItemBean>();
		DataSource dataSource=(DataSource)request.getAttribute("ItemDBConnection");
		try {
			conn=dataSource.getConnection();
			stmt=conn.createStatement();
			String st="select image,price,productName from items where category='"
						+(String) request.getParameter("Category")+"'";
			rs=stmt.executeQuery(st);
			while (rs.next()) {
				ItemBean item=new ItemBean(rs.getString("productName"),rs.getDouble("price"),rs.getString("image"));
				itemList.add(item);
			}
			rs.close();
		    rs = null;
			stmt.close();
		    stmt = null;
		    conn.close(); // Return to connection pool
		    conn = null;  // Make sure we don't close it twice	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			// Always make sure result sets and statements are closed,
		    // and the connection is returned to the pool
			if (rs != null) {
			      try { rs.close(); } catch (SQLException e) { ; }
			      rs = null;
			    }
			    if (stmt != null) {
			      try { stmt.close(); } catch (SQLException e) { ; }
			      stmt = null;
			    }
			    if (conn != null) {
			      try { conn.close(); } catch (SQLException e) { ; }
			      conn = null;
			    }
		}
		items=new ItemBean[itemList.size()];
		itemList.toArray(items);
	}

	public ItemBean[] getItems() {
		return items;
	}		
}
