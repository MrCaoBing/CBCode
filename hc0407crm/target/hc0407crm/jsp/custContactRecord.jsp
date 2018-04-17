<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../uiPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>客户交往记录</title>
<!--  引入当前页面样式 -->
<link rel="stylesheet" href="css/cb/cust.css">
<!-- 引入当前页面js -->
<script type="text/javascript" src="js/cb/custContactRecord.js"></script>

</head>
<body>
	<fieldset class="layui-elem-field layui-field-title">
		<legend>
			<a name="use">客户信息管理 >> 客户交往记录</a>
		</legend>
	</fieldset>
	<table class="layui-table"
		lay-data="{width: 972, height:332, url:'listCstActivity.do?custNo=${CstCustomer.custNo}',
            id:'idTest'}"
		lay-filter="atvTab">
		<thead>
			<tr id="headTr">
				<th lay-data="{colspan:3}">客户编号:${CstCustomer.custId}</th>
				<th lay-data="{colspan:4}">客户名称:${CstCustomer.custName}</th>
			</tr>
			<tr>
				<th lay-data="{field:'atvId', width:120}">ID</th>
				<th lay-data="{field:'atvDate', width:120,edit:'text',sort: true}">时间</th>
				<th lay-data="{field:'atvPlace', width:150,edit:'text'}">地点</th>
				<th lay-data="{field:'atvTitle', width:230,edit:'text'}">概要</th>
				<th lay-data="{field:'atvDesc', width:235,edit:'text'}">详细信息</th>
				<th lay-data="{field:'atvMemo', width:170,edit:'text'}">备注</th>
				<th
					lay-data="{fixed: 'right',width:46, align:'center', toolbar: '#barDemo'}">操作</th>
			</tr>
		</thead>
	</table>
	<font color="#a9a9a9">注:点击表格可编辑</font>
	<script type="text/html" id="barDemo">
    <a lay-event="del"><i class="layui-icon"
                          style="color: #cecccb;" title="删除">&#xe640;</i></a>
	</script>
	<form class="layui-form" action="">
		<table class="layui-table">
			<thead>
				<tr style="background-color: #ceed8d">
					<th colspan="2">添加客户联系人</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><label class="layui-form-label">时间:</label>
						<div class="layui-input-block">
							<input name="custNo" id="custNo" type="hidden"
								lay-verify="required" class="layui-input"
								value="${CstCustomer.custNo}"> <input name="atvDate"
								id="date" placeholder="点击输入时间(必填)" lay-verify="required" 
								class="layui-input">
						</div></td>
					<td><label class="layui-form-label">地点:</label>
						<div class="layui-input-block">
							<input name="atvPlace" maxlength="20" placeholder="请输入地点(必填)"
								lay-verify="required" class="layui-input">
						</div></td>
				</tr>
				<tr>
					<td><label class="layui-form-label">概要:</label>
						<div class="layui-input-block">
							<input name="atvTitle" maxlength="20" placeholder="请输入概要(必填)"
								lay-verify="required" class="layui-input">
						</div></td>
					<td><label class="layui-form-label">详细信息:</label>
						<div class="layui-input-block">
							<input name="atvDesc" maxlength="20" placeholder="请输入详细信息"
								lay-verify="" class="layui-input">
						</div></td>
				</tr>
				<tr>
					<td><label class="layui-form-label">备注:</label>
						<div class="layui-input-block">
							<input name="atvMemo" maxlength="20" placeholder="请输入备注"
								lay-verify="" class="layui-input">
						</div></td>
					<td></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<div class="layui-input-block" id="submitTr">
							<button class="layui-btn layui-btn-danger" lay-submit
								lay-filter="formDemo">确认</button>
							<button type="reset" class="layui-btn layui-btn-normal"
								onclick="javaacript:location.href='jsp/custInfoManager.jsp'">
								返回</button>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>