<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="header/header-bootstrap.jsp"/>

</head>
<body style="padding:20px;font-size:12px">
<table class="table">
  <tr><td width="100">文章编号</td><td>${article.id }</td></tr>
  <tr><td>标题</td><td>${article.title }</td></tr>
  <tr><td>发布时间</td><td>${article.publishedDate }</td></tr>
  <tr><td>来源</td><td>${article.sourceName }</td></tr>
  <tr><td>文章链接</td><td>${article.link }</td></tr>
  <tr><td>文章内容</td><td>${article.content }</td></tr>
</table>
</body>
</html>