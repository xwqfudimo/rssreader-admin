<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理主页</title>

<jsp:include page="header/header-easyui.jsp"/>

</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:50px;padding:0;margin:0">
		<div style="background: url(<%=request.getContextPath() %>/resources/img/header_bg.png) repeat-x;height:35px;color:#fff;font-size:16px;padding-top:15px;padding-left:10px;">
			<div>
				<div style="float:left">RSS管理后台</div>
				<div style="float:right">当前登录：${loginUser } <a href="logout" style="color:#fff;margin-left:30px;margin-right:30px">安全退出</a></div>
			</div>
		</div>
	</div>
	<div data-options="region:'west',split:true,title:'菜单'" style="width:180px;"  class="easyui-accordion">
		<div css="opt" title="RSS管理" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
			<ul>
					<li onclick="addTab('文章管理','articleManage')"><a href="#">文章管理</a></li>
					<li onclick="addTab('来源管理','sourceManage')"><a href="#">来源管理</a></li>
			</ul>
		</div>
		<div css="opt" title="用户管理" data-options="iconCls:'icon-ok'" style="padding:10px;">
				<p>User manage</p>
		</div>
	</div>
	<div data-options="region:'south',border:false" style="height:50px;background:#fff;padding:10px;">copyright</div>
	<div data-options="region:'center'" class="easyui-tabs" id="tabs">
		<div title="Welcome" style="padding:10px">
			Welcome!
		</div>
	</div>
	
	<div style="display:none" id="btn" onclick=""></div>
	
<script type="text/javascript">
function addTab(title, url) {
	if ($('#tabs').tabs('exists', title)) {
		$('#tabs').tabs('select', title);
	} else {
		var content = '<iframe scrolling="auto" frameborder="0"  src="' + url
				+ '" style="width:100%;height:100%;"></iframe>';
		
		$('#tabs').tabs('add', {
			title : title,
			content : content,
			closable : true
		});
	}
}

</script>
</body>
</html>
