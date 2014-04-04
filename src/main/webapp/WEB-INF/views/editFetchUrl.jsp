<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="header/header-bootstrap.jsp"/>

</head>
<body style="padding: 20px; font-size: 12px">
	<form role="form" method="post" id="form">
		<div class="form-group">
			<label for="id">来源编号</label> 
			<input type="text" class="form-control" name="id" id="id" value="${fetchUrl.id }" readonly>
		</div>
		<div class="form-group">
			<label for="sourceName">来源名</label> 
			<input type="text" class="form-control" name="sourceName" id="sourceName" value="${fetchUrl.sourceName }">
		</div>
  		<div class="form-group">
			<label for="fetchUrl">链接地址</label> 
			<input type="text" class="form-control" name="fetchUrl" id="fetchUrl" value="${fetchUrl.fetchUrl }">
		</div>	
		
		
		<div style="height:50px"></div>
		<button id="toSubmit" class="btn btn-primary btn-sm" style="margin-right:20px">保存</button>
		<button type="reset" class="btn btn-primary btn-sm">取消</button>
	</form>
	
<script type="text/javascript">
$(function(){
	$("#toSubmit").click(function(){
		$.post(window.location.href, {id:$('#id').val(), sourceName:$('#sourceName').val(), fetchUrl:$('#fetchUrl').val()}, function() {
			alert("success");
		});
	});
});

</script>
</body>
</html>