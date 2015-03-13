<%@ include file="/WEB-INF/Format/header.jspf"%>
<div class="row">
<div class="col-xs-6 col-xs-offset-3">
<form class="form" action="" method="get">
<div class="form-group">
<label>Your name:</label>
<input type="text" class="form-control" name="name"  />
</div>
<div class="form-group">
<label>Your email:</label>
<input type="email" class="form-control" name="email"  />
</div>
<div class="form-group">
<label>Message for us:</label>
<textarea class="form-control" name="message" style="height:200px" ></textarea>
</div>
<button type="submit" class="btn btn-primary">Submit</button>
<button type="reset" class="btn btn-default">Reset</button>
</form>
</div>
</div>
<%@ include file="/WEB-INF/Format/footer.jspf" %>