<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../../uiPage.jsp"%>
<script src="js/lzm/serviceHandleIndex.js"></script>
<title>Insert title here</title>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title">
		<legend>
			<a name="use">营销管理 >>服务处理展示</a>
		</legend>
	</fieldset>
	<div class="layui-form-item layui-form" style="margin-top: 10px">
		<label class="layui-form-label">概要</label>
		<div class="layui-input-inline">
			<input type="text" name="svrTitle" onchange="page()"
				class="layui-input">
		</div>


		<label class="layui-form-label">服务类型</label>
		<div class="layui-input-inline">
			<select name="svrType" lay-filter="test1">
				${foundationData['serviceType']}
			</select>
		</div>
	</div>
	<div class="layui-form-item layui-form" style="margin-top: 10px">
		<label class="layui-form-label">创建时间</label>
		<div class="layui-input-inline">
			<input type="text" placeholder="开始时间" value="" id="svrCreateDate"
				readonly name="svrCreateDate" class="layui-input">
		</div>
		<div class="layui-input-inline">
			<input type="text" id="svrCreateDate1" placeholder="结束时间" value=""
				readonly name="svrCreateDate1" class="layui-input">
		</div>
	</div>
	<table id="tab" lay-filter="test"></table>
	<script type="text/html" id="tubiao">
		<a lay-event="handle" class="layui-btn layui-btn-primary layui-btn-xs" title="处理">
			<i class="layui-icon">&#xe620;</i>
		</a>
	</script>
</body>
</html>