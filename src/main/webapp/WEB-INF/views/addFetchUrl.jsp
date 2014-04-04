<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="header/header-bootstrap.jsp"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.json-2.4.min.js"></script>

</head>
<body style="padding: 20px; font-size: 12px">
	<form role="form" method="post" id="form">
		<div class="form-group">
			<label for="sourceName">来源名</label> 
			<input type="text" class="form-control" name="sourceName" id="sourceName">
		</div>
  		<div class="form-group">
			<label for="fetchUrl">链接地址</label> 
			<input type="text" class="form-control" name="fetchUrl" id="fetchUrl">
		</div>	
		
		<div style="height:50px"></div>
		<button id="toSubmit" class="btn btn-primary btn-sm" style="margin-right:20px">保存</button>
		<button type="reset" class="btn btn-primary btn-sm">取消</button>
	</form>
	
<script type="text/javascript">
$(function(){
	$.fn.serializeObject = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if(o[this.name]) {
				if(!o[this.name].push) {
					o[this.name] = [o[this.name]];
				}
				o[this.name].push(this.value || '');
			}
			else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};
	
	$("#toSubmit").click(function(){
		var formData = $.toJSON($("#form").serializeObject());
		
		$.ajax({
			type: 'POST',
			headers:{
			   'Content-Type':'application/json',
			   'Accept':'application/json'
			},
			url: window.location.href,
			data: JSON.stringify(formData),
			dataType: 'json',
			success: function(data) {
				if(data.success) {
					alert('success');
				}
			}
		});
	});
});

</script>
</body>
</html>