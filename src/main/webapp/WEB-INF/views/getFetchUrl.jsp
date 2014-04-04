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
  <tr><td width="100">来源编号</td><td>${fetchUrl.id }</td></tr>
  <tr><td>来源名</td><td>${fetchUrl.sourceName }</td></tr>
  <tr><td>链接地址</td><td>${fetchUrl.fetchUrl }</td></tr>
</table>
</body>
</html>