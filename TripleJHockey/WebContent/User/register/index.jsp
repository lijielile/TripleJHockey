<%@ include file="/WEB-INF/Format/staticHeader.jspf"%>
<div class="row">
<div class="col-xs-6 col-xs-offset-3">
<%
String errorMessage=(String)request.getAttribute("errorMessage");
if (errorMessage!=null){
%>
<p><%=errorMessage %></p>
<%
}
%>
<form class="form" action="/TripleJHockey/Register" method="post">
<div class="form-group">
<label>UserId</label>
<input type="text" class="form-control" name="userId"  />
</div>
<div class="form-group">
<label>Password</label>
<input type="password" class="form-control" name="password"  />
</div>
<div class="form-group">
<label>Password again</label>
<input type="password" class="form-control" name="passwordCheck"  />
</div>
<div class="row">
<div class="col-xs-6">
<div class="form-group">
<label>First Name</label>
<input type="text" class="form-control" name="firstName"  />
</div>
</div>
<div class="col-xs-6">
<div class="form-group">
<label>Last Name</label>
<input type="text" class="form-control" name="lastName"  />
</div>
</div>
</div>
<div class="form-group">
<label>Email</label>
<input type="email" class="form-control" name="email"  />
</div>
<div class="form-group">
<label>Address</label>
<input type="text" class="form-control" name="address"  />
</div>
<div class="row">
<div class="col-xs-4">
<div class="form-group">
<label>City</label>
<input type="text" class="form-control" name="city"  />
</div>
</div>
<div class="col-xs-4">
<div class="form-group">
<label>State</label>
<input type="text" class="form-control" name="state"  />
</div>
</div>
<div class="col-xs-4">
<div class="form-group">
<label>Zip Code</label>
<input type="text" class="form-control" name="zipcode"  />
</div>
</div>
</div>
<button type="submit" class="btn btn-primary">Register</button>
<button type="reset" class="btn btn-default">Reset</button>
</form>
</div>
</div>
<%@ include file="/WEB-INF/Format/footer.jspf" %>