<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../../uiPage.jsp"%>

<script src="js/cb/index.js"></script>
<link rel="stylesheet" href="css/lzm/salChanceManager.css" />
<script src="js/lzm/salChanceManager.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div id="selectRo" style="display: none;">
		<select name="usrRoleId" id="usrRoleId" lay-verify="required"
			lay-filter="seRo" class="usrRole">
			${foundationData['custSource']}
		</select>
	</div>
	<fieldset class="layui-elem-field layui-field-title">
		<legend>
			<a name="use">营销管理 >>销售机会管理</a>
		</legend>
	</fieldset>
	<div class="layui-form-item" style="margin-top: 10px">
		<label class="layui-form-label">客户名称</label>
		<div class="layui-input-inline">
			<input type="text" name="chcCustName" onchange="page()"
				class="layui-input">
		</div>
		<label class="layui-form-label">概要</label>
		<div class="layui-input-inline">
			<input type="text" name="chcTitle" onchange="page()"
				class="layui-input">
		</div>
		<label class="layui-form-label">联系人</label>
		<div class="layui-input-inline">
			<input type="text" name="chcLinkman" onchange="page()"
				class="layui-input">
		</div>
	</div>
	<div class="layui-input-inline" style="margin-left: 900px">
		<button onclick="javascript:location.href='jsp/operateSalChance.jsp'"
			class="layui-btn layui-btn-primary layui-btn-xs">
			创建销售机会
		</button>
	</div>
	<div class="layui-form" id="open">
		<select id="chcDueUser" name="chcDueUser.usrId" lay-filter="test1">
			${foundationData['custmanager']}
		</select>
	</div>
	<input type="hidden" id="roleId" name="roleId"
		value="${sessionScope.sysUser[0].sysRole.roleId}" />
	<input type="hidden" id="usrId" name="usrId"
		value="${sessionScope.sysUser[0].usrId}" />
	<table id="tab" lay-filter="test"></table>
	<!-- <a lay-event="cont" class="layui-btn layui-btn-primary layui-btn-xs">
			<i class="layui-icon">&#xe612;</i>
		</a>[SysUser [usrId=19, usrName=admin, usrPassword=admin, sysRole=SysRole [roleId=1, roleName=系统管理员, ], usrFlag=1]]
		 -->
	<%-- <select id="chcDueUser" name="chcDueUser.usrId">
			${foundationData['custmanager']}
		</select> --%>

	<script type="text/html" id="tubiao">
		<a lay-event="cust" ${sessionScope.sysUser[0].sysRole.roleId==3?"style='display:none'":""} class="layui-btn layui-btn-primary layui-btn-xs" title="制定计划">
			<i class="layui-icon">&#xe60a;</i>
		</a>
		<a lay-event="app" ${sessionScope.sysUser[0].sysRole.roleId==4?"style='display:none'":""} class="layui-btn layui-btn-primary layui-btn-xs zhipai" name="zhipai" title="指派">
			<i class="layui-icon">&#xe612;</i>
		</a>
		<a lay-event="del" class="layui-btn layui-btn-primary layui-btn-xs" title="删除">
			<i class="layui-icon">&#xe640;</i>
		</a>
	</script>

	<!-- <div id="select">
				<input id="chcDueUser" readonly name="chcDueUser.usrId" placeholder="请选择">
				<i class="layui-icon" id="TuBiaoShang">&#xe625;</i>
				<i class="layui-icon" id="TuBiaoXia">&#xe625;</i>
			</div>
			<dl class="content" dl-value="false">
				<dd dd-value="请选择">请选择</dd>
				<dd dd-value="0">名字1</dd>
				<dd dd-value="1">名字2</dd>
				<dd dd-value="2">名字3</dd>
				<dd dd-value="3">名字4</dd>
			</dl> -->
</body>
</html>