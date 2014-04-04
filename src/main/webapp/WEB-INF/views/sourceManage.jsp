<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="header/header-easyui.jsp"/>
<jsp:include page="header/header-artDialog.jsp"/>

<body style="margin:0;padding:0;height:100%,width:100%">

<div id="tb" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="refreshData()">刷新</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="queryRow()">查看</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="addRow()">新增</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editRow()">编辑</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteRow()">删除</a>
       	<span style="margin-left:50px;"></span> 
                      来源名：<input class="easyui-textbox" style="width:250px;margin-right:10px" id="srcName">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="searchRow()">搜索</a>
    </div>
</div>

<table id="tt" class="easyui-datagrid"
        url="fetchurls"
        title="来源列表" fit="true"
        rownumbers="true" pagination="true" fitColumns="true"
        toolbar="#tb" singleSelect="true" pageSize="15" pageList="[15,20,30,40]">
    <thead>
        <tr>
            <th field="id" width="20%">来源编号</th>
            <th field="sourceName" width="40%">来源名</th>
            <th field="fetchUrl" width="40%">链接链接</th>
        </tr>
    </thead>
</table>
<script type="text/javascript">

//刷新
function refreshData() {
	$('#tt').datagrid('reload');
}

//删除
function deleteRow() {
	var row = $('#tt').datagrid('getSelected');
	
	if(row) {
		art.dialog({
			title: '确认',
		    content: '您确定要删除所选行吗？',
		    lock: true,
		    ok: function () {
		    	$.get('fetchurl/' + row.id + '/remove', function(data){
					if(data.success) {
						art.dialog({
							title: '操作结果', time: 1, icon: 'succeed', content: '删除成功'
						});
						
						$('#tt').datagrid('reload');	
					}
				});
		    },
		    cancelVal: '取消',
		    cancel: true
		});
	}
	else {
		tip();
	}
}

//查看
function queryRow() {
	var row = $('#tt').datagrid('getSelected');
	
	if(row) {
		var func = "addTab('来源查看', 'fetchurl/" + row.id + "')";
		
		$('#btn',window.parent.document).attr('onclick', func);
		$('#btn',window.parent.document).click();	
	}
	else {
		tip();
	}
}

//新增
function addRow() {
	var func = "addTab('新增来源', 'fetchurl/add')";
	
	$('#btn',window.parent.document).attr('onclick', func);
	$('#btn',window.parent.document).click();	
}

//编辑
function editRow() {
	var row = $('#tt').datagrid('getSelected');
	
	if(row) {
		var func = "addTab('来源编辑', 'fetchurl/" + row.id + "/edit')";
		
		$('#btn',window.parent.document).attr('onclick', func);
		$('#btn',window.parent.document).click();	
	}
	else {
		tip();
	}
}

//搜索
function searchRow() {
	$('#tt').datagrid('load',{
       	srcName: $('#srcName').val()
    });
}

//操作未选择行时提示
function tip() {
	art.dialog({
		title: '提示', time: 1, icon: 'face-sad', content: '请选择行'
	});
}
</script>
</body>
</html>