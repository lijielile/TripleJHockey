package beans;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class RegisterWorkerBean {
	private boolean result;
	
	public boolean GetResult() {
		return result;
	}

	public RegisterWorkerBean(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null; 
		PreparedStatement insertUser=null;
		String userId=request.getParameter("userId");
		DataSource dataSource=(DataSource)request.getServletContext().getAttribute("DBConnection");
		ResultSet rs = null;
		try {
			conn=dataSource.getConnection();
			stmt=conn.createStatement();
			String st="select userId from users where userId='"
						+userId+"'";
			rs=stmt.executeQuery(st);
			if(rs.next()){
				request.setAttribute("errorMessage", "Error: The userId has already been registered");
			}
			else{
				String passWord=request.getParameter("password");
				String firstName=request.getParameter("firstName");
				String lastName=request.getParameter("lastName");
				String email=request.getParameter("email");
				String address=request.getParameter("address");
				String city=request.getParameter("city");
				String state=request.getParameter("state");
				String zipcode=request.getParameter("zipcode");
				String userInfo="insert into users(userId, password, name, billingAddress, shippingAddress,"
						+ "email) values (?,?,?,?,?,?)";
				insertUser=conn.prepareStatement(userInfo);
				insertUser.setString(1, userId);
				insertUser.setString(2, passWord);
				insertUser.setString(3, firstName+" "+lastName);
				insertUser.setString(4, address+" "+city+" "+state+" "+zipcode);
				insertUser.setString(5, address+" "+city+" "+state+" "+zipcode);
				insertUser.setString(6, email);
				insertUser.executeUpdate();
				result=true;
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
			    if (insertUser!=null){
			    	try{ insertUser.close();} catch (SQLException e) { ; }
			    	insertUser=null;
			    }
			    if (conn != null) {
			      try { conn.close(); } catch (SQLException e) { ; }
			      conn = null;
			    }
		}
	}
}
