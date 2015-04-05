<%@ page import="beans.ItemBean" %>
<%
	ItemBean[] items=(ItemBean[])request.getAttribute("items");
	int size=items.length;
	int count=1;
%>
<%@ include file="/WEB-INF/Format/header.jspf"%>
<div class="row">
<table class="table">
<%
while (count<=size){
	if (count%3==1){
%>
<tr>
<%
	}
%>
<td>
<img src=<%="/TripleJHockey/image/Thumbnails/"+items[count-1].getImage() %>>
<p><%=items[count-1].getProductName() %></p>
<p>Price: <%=items[count-1].getPrice() %> </p>
</td>
<%
	if (count%3==0){
%>
</tr>
<%
	}
	count++;
}
%>
</table>
</div>
<%@ include file="/WEB-INF/Format/footer.jspf" %>