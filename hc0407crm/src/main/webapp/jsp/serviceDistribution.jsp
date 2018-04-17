<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../uiPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>服务分配</title>
<!-- 引入当前页面样式 -->
<link rel="stylesheet" href="css/cb/cust.css">
<!-- 引入当前页面样式 -->
<link rel="stylesheet" href="css/hqm/dataDictionaryManager.css">
<!--  引入当前页面js -->
<script type="text/javascript" src="js/hqm/serviceDistribution.js"></script>
</head>
<body>
	<div id="selectRo" style="display:none;">
            <select name="usrRoleId" id="usrRoleId" lay-verify="required" lay-filter="seRo" class="usrRole">
            	${foundationData['custmanager']}
			</select>
	</div>
	<fieldset class="layui-elem-field layui-field-title">
		<legend>
			<a name="use">客户服务管理>服务分配</a>
		</legend>
	</fieldset>
	<form class="layui-form" action="">
		<table class="layui-table">
			<tbody>
				<tr>
					<td><label class="layui-form-label">客户:</label>
						<div class="layui-input-block">
							<input name="svrCustCustomer" id="svrCustCustomer" maxlength="100"
								class="layui-input">
						</div></td>
					<td><label class="layui-form-label">概要:</label>
						<div class="layui-input-block">
							<input name="svrTitle" id="svrTitle" maxlength="100"
								class="layui-input">
						</div></td>
					<td><label class="layui-form-label">服务类型:</label>
						<div class="layui-input-inline">
							<select name="svrType" id="svrType" lay-filter="test1">
								${foundationData['serviceType']}
							</select>
						</div></td>

				</tr>
				<tr>
					<td colspan="2"><label class="layui-form-label">创建时间</label>
						<div class="layui-input-inline">
							<input type="text" placeholder="开始" value="" id="svrCreateDate" 
								readonly name="svrCreateDate" class="layui-input svrCreateDate">
						</div>
						<div class="layui-input-inline">
							<input type="text" placeholder="结束" value="" id="svrCreateDate1" 
								readonly name="svrCreateDate1" class="layui-input svrCreateDate">
						</div>
						</td>
					<td align="center">
						<button class="layui-btn layui-btn-danger tableInit" query="query"
							lay-submit lay-filter="formcheck">
							<i class="layui-icon" title="查询">&#xe615;</i>
						</button>
						<button type="reset" class="layui-btn layui-btn-normal tableInit">
		                    <i class="layui-icon" title="重置">&#x1002;</i>
		                </button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<!-- 数据表格 -->
	<table id="dataDictionTab" lay-filter="basDataTab"></table>

	<script type="text/html" id="barDemo">
    <a lay-event="del"><i class="layui-icon"
                          style="color: #cecccb;" title="删除">&#xe640;</i></a>
	</script>
</body>
</html>