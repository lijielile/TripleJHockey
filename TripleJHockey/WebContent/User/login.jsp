<%@ include file="/WEB-INF/Format/staticHeader.jspf"%>
<div class="row">
<div class="col-xs-6 col-xs-offset-3">
<form class="form" action="" method="get">
<div class="form-group">
<label>User Name</label>
<input type="text" class="form-control" name="userId"  />
</div>
<div class="form-group">
<label>Password</label>
<input type="password" class="form-control" name="password"  />
</div>
<button type="submit" class="btn btn-primary">Login</button>
<button type="reset" class="btn btn-default">Reset</button>
</form>
<p></p>
<p><a href="/TripleJHockey/User/register.jsp">New user? Create an account</a></p>
</div>
</div>
<%@ include file="/WEB-INF/Format/footer.jspf" %>