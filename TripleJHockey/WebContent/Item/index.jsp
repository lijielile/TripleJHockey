<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.LinkedList" %>

<%
String productName=request.getParameter("Product");
Connection conn = null;
Statement stmt = null;  
ResultSet rs = null;
HashMap<String, LinkedList<String>> map=new HashMap<String,LinkedList<String>>();
DataSource dataSource=(DataSource)request.getServletContext().getAttribute("DBConnection");
	conn=dataSource.getConnection();
	stmt=conn.createStatement();
	String st="select image,price,productName,details,name,value from "+ 
				"items,itemdescription,itemproperties where productName='"
				+productName+"'"+"AND iditems=items_iditems "+ 
				"AND iditemProperties=itemProperties_iditemProperties";
	rs=stmt.executeQuery(st);
	String image="";
	double price=0;
	String details="";
	if (rs.first()){
		image=rs.getString("image");
		price=rs.getDouble("price");
		details=rs.getString("details");
	}
	rs.beforeFirst();
	while (rs.next()) {
		if (!map.containsKey(rs.getString("name"))){
			LinkedList<String> list=new LinkedList<String>();
			list.add(rs.getString("value"));
			map.put(rs.getString("name"),list);
		}
		else map.get(rs.getString("name")).add(rs.getString("value"));
		
	}
	rs.close();
    rs = null;
	stmt.close();
    stmt = null;
    conn.close(); // Return to connection pool
    conn = null;  // Make sure we don't close it twice	
%>
<%@ include file="/WEB-INF/Format/header.jspf"%>
<div class="row">
<div class="col-xs-6">
<img src=<%="/TripleJHockey/image/FullSize/"+image %>>
</div>
<div class="col-xs-6">
<p><%=productName %></p>
<p>$<%=price %></p>
<form id="" action="" method="get">
<%
for (String key:map.keySet()){
%>
<p><%=key %></p>
<p>
<%
LinkedList<String> list=(LinkedList<String>)map.get(key);
for (String str:list){
%>
<label class="radio-inline">
<input type="radio" name="<%=key %>" value="<%=str%>"><%=str %>
</label> 
<%
}
%>
</p>
<%
}
%>
<p><%=details %></p>
<button type="submit" class="btn btn-primary">Add to cart</button>
</form>

</div>
</div>
<%@ include file="/WEB-INF/Format/footer.jspf" %>