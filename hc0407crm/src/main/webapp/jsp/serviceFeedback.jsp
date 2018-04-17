<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../../uiPage.jsp"%>
<script src="js/lzm/serviceFeedback.js"></script>
<title>Insert title here</title>
<%
	String svrStatus = request.getParameter("svrStatus");
	if (svrStatus.equals("3")) {
		svrStatus = "已处理";
	}
%>
</head>
<style>
	.xingColor{
	color:red}
</style>
<body>
	<div class="layui-input-inline" style="margin-left: 900px">
		<button onclick="javascript:location.href='jsp/serviceFeedbackIndex.jsp'" class="layui-btn layui-btn-primary layui-btn-xs">返回</button>
	</div>
	<div class="layui-input-inline">
		<button class="layui-btn layui-btn-primary layui-btn-xs"
			onclick="setserviceHandle()" lay-submit>保存</button>
	</div>
	<table class="layui-table layui-form">
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
						class="layui-input"
						value="<%=request.getParameter("svrCreateDate")%>">
				</div></td>
		</tr>
		<tr>
			<td colspan="2"></td>
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
						class="layui-input"
						value="<%=request.getParameter("svrDueDate")%>">
				</div></td>
		</tr>
		<tr>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td><label class="layui-form-label">服务处理</label>
				<div class="layui-input-inline">
					<textarea class="layui-textarea" name="svrDeal" id="svrDeal" readonly><%=request.getParameter("svrDeal")%></textarea>
				</div></td>
			<td><label class="layui-form-label">处理时间</label>
				<div class="layui-input-inline">
					<input type="text" name="title" readonly="readonly"
						class="layui-input"
						value="<%=request.getParameter("svrDealDate")%>">
				</div></td>
		</tr>
		<tr>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td><label class="layui-form-label">处理结果</label>
				<div class="layui-input-inline">
					<input type="text" name="svrResult" id="svrResult"
						class="layui-input"
						value="" lay-verify="required">
				</div><div class="layui-input-inline xingColor">*</div></td>
			<td><label class="layui-form-label">满意度</label>
				<div class="layui-input-inline">
					<input class="custSatisfy" type="radio" name="svrSatisfy"
						value="1" title="不满" checked>
					<input class="custSatisfy" type="radio" name="svrSatisfy" 
						value="2" title="合格"> 
					<input class="custSatisfy" type="radio" name="svrSatisfy"
						 value="3" title="良好"> 
					<input class="custSatisfy" type="radio" name="svrSatisfy"
						 value="4" title="优秀"> 
					<input class="custSatisfy" type="radio" name="svrSatisfy"
					 value="5" title="卓越">
				</div></td>
		</tr>
	</table>
</body>
</html>