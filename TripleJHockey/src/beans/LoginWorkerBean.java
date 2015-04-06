package beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class LoginWorkerBean {
	String returnAddress;

	public String getReturnAddress() {
		return returnAddress;
	}

	public LoginWorkerBean(HttpServletRequest request, HttpServletResponse response) {
		Connection conn = null;
		Statement stmt = null;
		DataSource dataSource=(DataSource)request.getServletContext().getAttribute("DBConnection");
		ResultSet rs = null;
		try {
			conn=dataSource.getConnection();
			stmt=conn.createStatement();
			String userId=request.getParameter("userId");
			String password=request.getParameter("password");
			String st="select userId,password from users where userId='"
						+userId+"' and password='"+password+"'";
			rs=stmt.executeQuery(st);
			if(!rs.next()){
				request.setAttribute("errorMessage", "Error: Your username/password is incorrect");
				returnAddress="/User/login/";
			}
			else{
				
				returnAddress="/";
			}
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
	}

}
