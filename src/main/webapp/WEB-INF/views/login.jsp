<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>后台登录</title>
<link href="<%=request.getContextPath() %>/resources/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/bootstrap/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/md5.js"></script>
<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>
<link href="<%=request.getContextPath() %>/resources/css/bootstrap-responsive.css" rel="stylesheet">
</head>

<body>

	<div class="container">

		<form class="form-signin" method="post">
			<h2 class="form-signin-heading">RSS管理后台</h2>
			<input type="text" class="input-block-level" placeholder="用户名" name="username">
			<input type="password" class="input-block-level" placeholder="密码" id="password" name="password">
			<button class="btn btn-large btn-primary" type="sumbit" id="submit">登录</button>
		</form>

	</div>

<script type="text/javascript">
$(function(){
	$("#submit").click(function(){
		var password = $('#password').val();
		var hash =  hex_md5(password);
		
		$('#password').val(hash);
	});
});
</script>

</body>
</html>