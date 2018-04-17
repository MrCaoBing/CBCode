<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../uiPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>服务创建</title>
<link rel="stylesheet" href="jquery-ui-1.12.1.custom/jquery-ui.min.css">
<script src="jquery-ui-1.12.1.custom/jquery-ui.js"></script>
<!-- 引入当前页面样式 -->
<link rel="stylesheet" href="css/cb/cust.css">
<!-- 引入当前页面样式 -->
<link rel="stylesheet" href="css/hqm/dataDictionaryManager.css">
<!--  引入当前页面js -->
<script type="text/javascript" src="js/hqm/serviceCreate.js"></script>


</head>
<body>
	<fieldset class="layui-elem-field layui-field-title">
		<legend>
			<a name="use">客户服务管理 >>服务创建</a>
			<c:choose>
				<c:when test="${empty CstService.svrId}">
					<span id="addOrSet">添加</span>
				</c:when>
			</c:choose>
		</legend>
	</fieldset>
	<form class="layui-form" action="">
		<table class="layui-table">
			<tbody>
				<tr>
					<td><label class="layui-form-label">编号:</label>
						<div class="layui-input-block">
							<input name="svrId" id="svrId" class="layui-input"
								readonly="readonly" placeholder="编号系统自动生成">
						</div></td>
					<td><label class="layui-form-label">服务类型:</label>
						<div class="layui-input-inline">
							<select name="svrType" lay-filter="test1" lay-verify="required" >
								${foundationData['serviceType']}
							</select>
						</div></td>
				</tr>
				<tr>
					<td colspan="2"><label class="layui-form-label">概要:</label>
						<div class="layui-input-block">
							<input name="svrTitle" id="svrTitle" maxlength="1000" lay-verify="required"
								class="layui-input">
						</div></td>
				</tr>
				<tr>
					<td><label class="layui-form-label">客户:</label>
						<div class="layui-input-block">
							<input name="svrCustCustomerName" id="svrCustCustomerName" maxlength="50"
								class="layui-input" lay-verify="required|ifName" >
							<input name="svrCustCustomer" id="svrCustCustomer" maxlength="50"  type="hidden"1
								class="layui-input">
						</div></td>
					<td><label class="layui-form-label">状态:</label>
						<div class="layui-input-block">
							<input name="svrStatus" id="svrStatus" maxlength="15"
								class="layui-input" readonly="readonly" placeholder="新创建">

						</div></td>
				</tr>
				<tr>
					<td colspan="2"><label class="layui-form-label">服务请求:</label>
						<div class="layui-input-block">
							<textarea name="svrRequest" id="svrRequest" required
								lay-verify="required" class="layui-textarea"></textarea>
						</div></td>
				</tr>
				<tr>
					<td><label class="layui-form-label">创建人:</label> <input
						type="hidden" id="usrId" name="usrId" value="${sessionScope.sysUser[0].usrId}" />
						<div class="layui-input-block">
							<input name="svrCreateUser" id="svrCreateUser" maxlength="15"
								class="layui-input" readonly="readonly"
								value="${sessionScope.sysUser[0].usrName}">
						</div></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<div class="layui-input-block" id="submitTr">
							<button id="submit" class="layui-btn layui-btn-danger" lay-submit
								lay-filter="formDemo">确认</button>
							<button type="reset" class="layui-btn layui-btn-normal reset">重置</button>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>