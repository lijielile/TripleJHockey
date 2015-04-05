<%@ page import="beans.ItemBean" %>
<%
	ItemBean[] items=(ItemBean[])request.getAttribute("items");
	int size=items.length;
	int count=1;
%>
<%@ include file="/WEB-INF/Format/header.jspf"%>
<%
while (count<=size){
	if (count%4==1){
%>
<div class="row">
<%
	}
	String form="Form"+count;
%>
<div class="col-xs-3">
<form id="<%=form %>" action="/TripleJHockey/Item" method="get">
<input type="hidden" name="Product" id="Product"value="<%=items[count-1].getProductName() %>"/> 
<a href="#" onclick="document.getElementById('<%=form %>').submit();" >
<img src=<%="/TripleJHockey/image/Thumbnails/"+items[count-1].getImage() %>>
</a>
</form>
<p><%=items[count-1].getProductName() %></p>
<p>Price: <%=items[count-1].getPrice() %> </p>
</div>
<%
	if (count%4==0||count==size){
%>
</div>
<%
	}
	count++;
}
%>
<%@ include file="/WEB-INF/Format/footer.jspf" %>