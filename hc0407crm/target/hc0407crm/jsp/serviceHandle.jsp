<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../../uiPage.jsp"%>
<script src="js/lzm/serviceHandle.js"></script>
<title>Insert title here</title>
</head>
<%
	String svrStatus=request.getParameter("svrStatus");
	if (svrStatus.equals("2")) {
		svrStatus = "已分配";
	}
%>
<style>
	.xingColor{
	color:red}
</style>
<body>
	<fieldset class="layui-elem-field layui-field-title">
        <legend><a name="use">营销管理 >>服务处理</a></legend>
    </fieldset>
	<div class="layui-input-inline" style="margin-left:900px">
		<button class="layui-btn layui-btn-primary layui-btn-xs" onclick="location.href='jsp/serviceHandleIndex.jsp'">返回</button>
	</div>
	<div class="layui-input-inline">
		<button lay-submit lay-filter="*" class="layui-btn layui-btn-primary layui-btn-xs" >保存</button>
	</div>
	<form class="layui-form">
	<table class="layui-table">
		<tr>
			<td><label class="layui-form-label">编号</label>
				<div class="layui-input-inline">
					<input type="text" name="svrId" readonly="readonly"
						class="layui-input" value="<%=request.getParameter("svrId")%>">
				</div></td>
			<td><label class="layui-form-label">服务类型</label>
				<div class="layui-input-inline">
					<input type="text" name="title" readonly="readonly"
						class="layui-input" value="<%=request.getParameter("svrType")%>">
				</div></td>
		</tr>
		<tr>
			<td colspan="2"><label class="layui-form-label">概要</label>
				<div class="layui-input-inline">
					<input type="text" name="title" readonly="readonly"
						class="layui-input" value="<%=request.getParameter("svrTitle")%>">
				</div></td>
		</tr>
		<tr>
			<td><label class="layui-form-label">客户</label>
				<div class="layui-input-inline">
					<input type="text" name="title" readonly="readonly"
						class="layui-input" value="<%=request.getParameter("svrCustCustomerName")%>">
				</div></td>
			<td><label class="layui-form-label">状态</label>
				<div class="layui-input-inline">
					<input type="text" name="title" readonly="readonly"
						class="layui-input" value="<%=svrStatus%>">
				</div></td>
		</tr>
		<tr>
			<td colspan="2"><label class="layui-form-label">服务请求</label>
				<div class="layui-input-inline">
					<input type="text" name="title" readonly="readonly"
						class="layui-input" value="<%=request.getParameter("svrRequest")%>">
				</div></td>
		</tr>
		<tr>
			<td><label class="layui-form-label">创建人</label>
				<div class="layui-input-inline">
					<input type="text" name="title" readonly="readonly"
						class="layui-input" value="<%=request.getParameter("svrCreateName")%>">
				</div></td>
			<td><label class="layui-form-label">创建时间</label>
				<div class="layui-input-inline">
					<input type="text" name="title" readonly="readonly"
						class="layui-input" value="<%=request.getParameter("svrCreateDate")%>">
				</div></td>
		</tr>
		<tr>
			<td><label class="layui-form-label">分配人</label>
				<div class="layui-input-inline">
					<input type="text" name="title" readonly="readonly"
						class="layui-input" value="<%=request.getParameter("svrDueName")%>">
				</div></td>
			<td><label class="layui-form-label">分配时间</label>
				<div class="layui-input-inline">
					<input type="text" name="title" readonly="readonly"
						class="layui-input" value="<%=request.getParameter("svrDueDate")%>">
				</div></td>
		</tr>
		<tr>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td colspan="2"><label class="layui-form-label">服务处理</label>
				<div class="layui-input-block">
					<textarea name="svrDeal" id="svrDeal" required
								lay-verify="required" class="layui-textarea"></textarea>
				</div><div class="layui-input-inline xingColor">*</div></td>
		</tr>
	</table>
	</form>
</body>
</html>