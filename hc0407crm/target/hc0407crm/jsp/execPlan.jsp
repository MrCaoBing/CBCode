<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../uiPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/lzm/execPlan.js"></script>
<%-- <%
	String chcSource = new String(request.getParameter("chcSource").getBytes("ISO-8859-1"), "UTF-8");
	String chcCustName = new String(request.getParameter("chcCustName").getBytes("ISO-8859-1"), "UTF-8");
	String chcLinkman = new String(request.getParameter("chcLinkman").getBytes("ISO-8859-1"), "UTF-8");
	String chcTitle = new String(request.getParameter("chcTitle").getBytes("ISO-8859-1"), "UTF-8");
	String chcDesc = new String(request.getParameter("chcDesc").getBytes("ISO-8859-1"), "UTF-8");
	String chcCreateName = new String(request.getParameter("chcCreateName").getBytes("ISO-8859-1"), "UTF-8");
	String chcDueName = new String(request.getParameter("chcDueName").getBytes("ISO-8859-1"), "UTF-8");
%> --%>
<title>Insert title here</title>
</head>
<body>
	<table class="layui-table">
		<tr>
			<td colspan="2" align="right">
				<div class="layui-input-inline">
					<a href="jsp/custDevelopPlan.jsp" class="layui-btn layui-btn-primary layui-btn-sm"
						> 返回 </a>
				</div>
				<div class="layui-input-inline">
					<a class="layui-btn layui-btn-primary layui-btn-sm"
						onclick="developStatus(3)"> 开发成功 </a>
				</div>
				<div class="layui-input-inline">
					<a class="layui-btn layui-btn-primary layui-btn-sm"
						onclick="developStatus(4)"> 终止开发 </a>
				</div>
			</td>
		</tr>
		<tr>
			<td><label class="layui-form-label">编号</label>
				<div class="layui-input-inline">
					<input type="text" name="usrId" class="layui-input"
						value="${sessionScope.sysUser[0].usrId}">
					<input type="text" name="chcId" class="layui-input"
						value="<%=request.getParameter("chcId")%>" readonly="readonly">
				</div></td>
			<td><label class="layui-form-label">机会来源</label>
				<div class="layui-input-inline">
					<input type="text" name="chcSource" class="layui-input"
						value="<%=request.getParameter("chcSource")%>" lay-verify="required" readonly="readonly">
				</div></td>
		</tr>
		<tr>
			<td><label class="layui-form-label">客户名称</label>
				<div class="layui-input-inline">
					<input type="text" name="chcCustName" class="layui-input"
						value="<%=request.getParameter("chcCustName")%>" readonly="readonly">
				</div></td>
			<td><label class="layui-form-label">成功几率(%)</label>
				<div class="layui-input-inline">
					<input type="text" name="chcRate" class="layui-input"
						value="<%=request.getParameter("chcRate")%>" readonly="readonly">
				</div></td>
		</tr>
		<tr>
			<td><label class="layui-form-label">联系人</label>
				<div class="layui-input-inline">
					<input type="text" name="chcLinkman" class="layui-input"
						value="<%=request.getParameter("chcLinkman")%>" readonly="readonly">
				</div></td>
			<td><label class="layui-form-label">联系人电话</label>
				<div class="layui-input-inline">
					<input type="text" name="chcMobile" class="layui-input"
						value="<%=request.getParameter("chcMobile")%>" readonly="readonly">
				</div></td>
		</tr>
		<tr>
			<td colspan="2"><label class="layui-form-label">办公室电话</label>
				<div class="layui-input-inline">
					<input type="text" name="chcTel" class="layui-input"
						value="<%=request.getParameter("chcTel")%>" readonly="readonly">
				</div></td>
		</tr>
		<tr>
			<td><label class="layui-form-label">概要</label>
				<div class="layui-input-inline">
					<textarea class="layui-textarea" name="chcTitle"
						readonly="readonly"><%=request.getParameter("chcTitle")%></textarea>
				</div></td>
			<td><label class="layui-form-label">机会描述</label>
				<div class="layui-input-inline">
					<textarea class="layui-textarea" name="chcDesc" readonly="readonly"><%=request.getParameter("chcDesc")%></textarea>
				</div></td>
		</tr>
		<tr>
			<td><label class="layui-form-label">创建人</label>
				<div class="layui-input-inline">
					<input type="text" readonly="readonly" name="chcCreateName"
						class="layui-input" value="<%=request.getParameter("chcCreateName")%>"> <input
						type="hidden" name="chcCreateUser.usrId"
						value="<%=request.getParameter("chcCreateId")%>" />
				</div></td>
			<td><label class="layui-form-label">创建时间</label>
				<div class="layui-input-inline">
					<input type="text" name="chcCreateDate" readonly="readonly"
						class="layui-input"
						value="<%=request.getParameter("chcCreateDate")%>">
				</div></td>
		</tr>
		<tr>
			<td><label class="layui-form-label">指派人</label>
				<div class="layui-input-inline">
					<input type="text" name="chcDueName" readonly="readonly"
						class="layui-input" value="<%=request.getParameter("chcDueName")%>"> <input
						type="hidden" name="chcDueUser.usrId"
						value="<%=request.getParameter("chcDueId")%>" />
				</div></td>
			<td><label class="layui-form-label">指派时间</label>
				<div class="layui-input-inline">
					<input type="text" name="chcDueDate" readonly="readonly"
						class="layui-input"
						value="<%=request.getParameter("chcDueDate")%>">
				</div></td>
		</tr>
	</table>
	<table id="tab" lay-filter="test"></table>
	<script type="text/html" id="tubiao">
		<div class="layui-input-inline">
			<button  lay-event="set" class="layui-btn layui-btn-primary layui-btn-sm">
				<i class="layui-icon">&#x1005;</i>
			</button>
		</div>
	</script>
</body>
</html>