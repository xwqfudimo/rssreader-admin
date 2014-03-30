<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/easyui/demo.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/easyui/jquery.easyui.min.js"></script>

<body style="margin:0;padding:0;height:100%,width:100%">

<div id="tb" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="refreshData()">刷新</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="queryRow()">查看</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editRow()">编辑</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="$.messager.confirm('删除确认','您确定要删除该行数据吗?',deleteRow)">删除</a>
       	<span style="margin-left:50px;"></span> 
                      标题：<input class="easyui-textbox" style="width:250px;margin-right:10px" id="atitle">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="searchRow()">搜索</a>
    </div>
</div>

<table id="tt" class="easyui-datagrid"
        url="articles"
        title="文章列表" fit="true"
        rownumbers="true" pagination="true" fitColumns="true"
        toolbar="#tb" singleSelect="true" pageSize="15" pageList="[15,20,30,40]">
    <thead>
        <tr>
            <th field="id" width="16%">文章编号</th>
            <th field="title" width="39%">标题</th>
            <th field="publishedDate" width="12%" align="right">发布时间</th>
            <th field="sourceName" width="10%" align="right">来源</th>
            <th field="link" width="23%">文章链接</th>
        </tr>
    </thead>
</table>
<script type="text/javascript">
function refreshData() {
	$('#tt').datagrid('reload');
}

function deleteRow() {
	var row = $('#tt').datagrid('getSelected');
	
	if(row) {
		$.get('article/' + row.id + '/remove', function(){
			$('#tt').datagrid('reload');
		});
	}
}

function queryRow() {
	var row = $('#tt').datagrid('getSelected');
	
	if(row) {
		var func = "addTab('文章查看', 'article/" + row.id + "')";
		
		$('#btn',window.parent.document).attr('onclick', func);
		$('#btn',window.parent.document).click();	
	}
}

function editRow() {
	var row = $('#tt').datagrid('getSelected');
	
	if(row) {
		var func = "addTab('文章编辑', 'article/" + row.id + "/edit')";
		
		$('#btn',window.parent.document).attr('onclick', func);
		$('#btn',window.parent.document).click();	
	}
}

function searchRow() {
	$('#tt').datagrid('load',{
       	atitle: $('#atitle').val()
    });
}
</script>
</body>
</html>