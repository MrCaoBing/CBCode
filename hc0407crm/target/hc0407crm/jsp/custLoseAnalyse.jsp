<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../../uiPage.jsp"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>客户流失管理</title>

<!-- 引入当前页面样式 -->
<link rel="stylesheet" href="css/cb/cust.css">
<!-- 导入Echarts -->
<script type="text/javascript" src="js/echarts.min.js"></script>
<!-- 引入当前页面js -->
<script type="text/javascript" src="js/cb/custLoseAnalyse.js"></script>

</head>
<body>
	<fieldset class="layui-elem-field layui-field-title">
		<legend>
			<a name="use">客户流失管理</a>
		</legend>
	</fieldset>
	<form class="layui-form" action="">
		<div class="float" style="width: 300px">
			<label class="layui-form-label">名称</label>
			<div class="layui-input-block">
				<input name="custName" id="custName" maxlength="25"
					placeholder="请输入客户名称" class="layui-input">
			</div>
		</div>
		<div class="float" style="width: 300px">
			<label class="layui-form-label">客户经理</label>
			<div class="layui-input-block">
				<select name="sysUser" id="sysUser">
					${foundationData['custmanager']}
				</select>
			</div>
		</div>
		<div class="float">
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn layui-btn-danger tableInit" query="query"
						lay-submit lay-filter="formDemo">
						<i class="layui-icon" data-type="reload" title="查询">&#xe615;</i>
					</button>
					<button type="reset" class="layui-btn layui-btn-normal tableInit">
						<i class="layui-icon" title="重置">&#x1002;</i>
					</button>
				</div>
			</div>
		</div>
	</form>
	<div style="float: left; heigth: 100px"width:100px;>
		<table id="lostTable" lay-filter="custTab"
			style="width: 800px; float: left;"></table>
	</div>
	<fieldset class="layui-elem-field layui-field-title"
		style="width: 500px;">
		<legend>
			<a name="use">统计报表 >> 统计图</a>
		</legend>
	</fieldset>
	<!-- 图 -->
	<div id="pillar" style="width: 950px; height: 500px;"></div>
</body>
</html>