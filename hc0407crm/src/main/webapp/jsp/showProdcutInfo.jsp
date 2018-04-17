<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../uiPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 引入当前页面样式 -->
<link rel="stylesheet" href="css/cb/cust.css">
<!-- 引入当前页面样式 -->
<link rel="stylesheet" href="css/hqm/dataDictionaryManager.css">

<!--  引入当前页面js -->
<script type="text/javascript" src="js/hqm/showProdcutInfo.js"></script>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title">
		<legend>
			<a name="use">基础数据 >>产品查询</a>
		</legend>
	</fieldset>
	<form class="layui-form" action="">
		<table class="layui-table">
			<tbody>
				<tr>
					<td><label class="layui-form-label">名称:</label>
						<div class="layui-input-block">
							<input name="prodName" id="prodName" maxlength="15"
								class="layui-input">
						</div></td>
					<td><label class="layui-form-label">型号:</label>
						<div class="layui-input-block">
							<input name="prodType" id="prodType" maxlength="15"
								class="layui-input">
						</div></td>
					<td><label class="layui-form-label">批次:</label>
						<div class="layui-input-block">
							<input name="prodBatch" id="prodBatch" maxlength="15"
								class="layui-input">
						</div></td>
					<td align="center">
						<button class="layui-btn layui-btn-danger tableInit" query="query"
							lay-submit lay-filter="formcheck">
							<i class="layui-icon" data-type="reload" title="查询">&#xe615;</i>
						</button>

					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<!-- 数据表格 -->
	<table id="dataDictionTab" lay-filter="basDataTab"></table>
</body>
</html>