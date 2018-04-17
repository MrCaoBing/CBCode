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
	String svrSatisfy =request.getParameter("svrSatisfy");
	if (svrSatisfy.equals("3")) {
		svrSatisfy = "良好";
	} else if (svrSatisfy.equals("4")) {
		svrSatisfy = "优秀";
	} else if (svrSatisfy.equals("5")) {
		svrSatisfy = "卓越";
	}
%>
</head>
<body>
	<div class="layui-input-inline" style="margin-left: 900px">
		<button onclick="javascript:location.href='jsp/serviceSaveIndex.jsp'" class="layui-btn layui-btn-primary layui-btn-xs">返回</button>
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
						class="layui-input" value="<%=request.getParameter("svrStatus")%>">
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
					<textarea class="layui-textarea" name="svrDeal"><%=request.getParameter("svrDeal")%></textarea>
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
					<input type="text" name="svrResult" class="layui-input" readonly="readonly"
						value="<%=request.getParameter("svrResult")%>">
				</div></td>
			<td><label class="layui-form-label">满意度</label>
				<div class="layui-input-inline">
					<input type="text" name="svrSatisfy" class="layui-input" readonly="readonly"
						value="<%=svrSatisfy%>" />
				</div></td>
		</tr>
	</table>
</body>
</html>