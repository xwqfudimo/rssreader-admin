<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/bootstrap/bootstrap.min.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/bootstrap/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/bootstrap/bootstrap.min.js"></script>

</head>
<body style="padding: 20px; font-size: 12px">
	<form role="form" method="post">
		<div class="form-group">
			<label for="id">文章编号</label> 
			<input type="text" class="form-control" name="id" id="id" value="${article.id }" readonly>
		</div>
		<div class="form-group">
			<label for="title">标题</label> 
			<input type="text" class="form-control" name="title" id="title" value="${article.title }">
		</div>
  		<div class="form-group">
			<label for="publishedDate">发布时间</label> 
			<input type="text" class="form-control" name="publishedDate" id="publishedDate" value="${article.publishedDate }" readonly>
		</div>	
		<div class="form-group">
			<label for="sourceName">来源</label> 
			<input type="text" class="form-control" name="sourceName" id="sourceName" value="${article.sourceName }" readonly>
		</div>	
		<div class="form-group">
			<label for="link">文章链接</label> 
			<input type="text" class="form-control" name="link" id="link" value="${article.link }">
		</div>	
		<div class="form-group">
			<label for="content">文章内容</label> 
			<textarea class="form-control" id="content" name="content" rows="15">${article.content }</textarea>
		</div>		
		
		
		<div style="height:50px"></div>
		<button type="submit" class="btn btn-primary btn-sm" style="margin-right:20px">保存</button>
		<button type="reset" class="btn btn-primary btn-sm">取消</button>
	</form>
</body>
</html>