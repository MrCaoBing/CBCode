<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../uiPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/lzm/operateSalChance.js"></script>
<style type="text/css">
.xingColor {
	color: red;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title">
		<legend>
			<a name="use">营销管理 >>创建销售机会</a>
		</legend>
	</fieldset>
	<form class="layui-form">
		<table class="layui-table">
			<thead>
				<tr>
					<th colspan="2" style="text-align: right;">
						<input onclick="location.href='jsp/salChanceManager.jsp'" type="button" class="layui-btn layui-btn-xs layui-btn-primary" value="返回">
						
						<button lay-submit lay-filter="formDemo"
							class="layui-btn layui-btn-xs layui-btn-primary">保存
						</button>
					</th>
				</tr>
			</thead>
			<tr>
				<td><label class="layui-form-label">客户名称</label>
					<div class="layui-input-inline">
						<input type="text" id="chcCustName" onblur="checkName()"
							name="chcCustName" class="layui-input"
							lay-verify="required|chcCustName">
					</div>
					<div class="layui-input-inline xingColor">*</div></td>
				<td><label class="layui-form-label">机会来源</label>
					<div class="layui-input-inline">
						<!-- <input type="text" id="chcSource" 
							class="layui-input"> -->
						<select name="chcSource"> ${foundationData['custSource']}
						</select>
					</div></td>
			</tr>
			<tr>

				<td colspan="2"><label class="layui-form-label">成功几率</label>
					<div class="layui-input-inline">
						<input type="text" id="chcRate" name="chcRate" class="layui-input"
							lay-verify="required|chcRate">
					</div>
					<div class="layui-input-inline xingColor">*</div></td>
			</tr>
			<tr>
				<td><label class="layui-form-label">联系人</label>
					<div class="layui-input-inline">
						<input type="text" id="chcLinkman" name="chcLinkman"
							class="layui-input" lay-verify="chcLinkman">
					</div></td>
				<td><label class="layui-form-label">联系人电话</label>
					<div class="layui-input-inline">
						<input type="text" id="chcMobile" name="chcMobile"
							class="layui-input" lay-verify="chcMobile">
					</div></td>
			</tr>
			<tr>
				<td><label class="layui-form-label">机会描述</label>
					<div class="layui-input-inline">
						<textarea class="layui-textarea" name="chcDesc" id="chcDesc"
							lay-verify="required"></textarea>
					</div>
					<div class="layui-input-inline xingColor">*</div></td>
				<td><label class="layui-form-label">概要</label>
					<div class="layui-input-inline">
						<textarea class="layui-textarea" id="chcTitle" name="chcTitle"
							lay-verify="required"></textarea>
					</div>
					<div class="layui-input-inline xingColor">*</div></td>
			</tr>
			<tr>
				<td><label class="layui-form-label">创建人</label>
					<div class="layui-input-inline">
						<input type="text" value="${sessionScope.sysUser[0].usrName}"
							readonly name="chcCreateUser.usrName" class="layui-input">
						<input type="hidden" lay-verify="required"
							value="${sessionScope.sysUser[0].usrId}"
							name="chcCreateUser.usrId" class="layui-input">
					</div>
					<div class="layui-input-inline xingColor">*</div></td>
				<td><label class="layui-form-label">指派给</label>
					<div class="layui-input-block">
						<select id="chcDueUser.usrId" name="chcDueUser.usrId"
							${sessionScope.sysUser[0].sysRole.roleId==3?"":"disabled"}>
							${foundationData['custmanager']}
						</select>
					</div></td>
			</tr>
		</table>
	</form>
</body>
</html>