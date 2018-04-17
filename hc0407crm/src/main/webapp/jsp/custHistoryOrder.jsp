<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../uiPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>客户历史订单</title>
<!-- 引入当前页面样式 -->
<link rel="stylesheet" href="css/cb/cust.css">
<!-- 引入当前页面js -->
<script type="text/javascript" src="js/cb/custHistoryOrder.js"></script>

</head>
<body>
	<fieldset class="layui-elem-field layui-field-title">
		<legend>
			<a name="use">客户信息管理 >> 客户订单</a>
		</legend>
	</fieldset>
	<button type="reset" class="layui-btn layui-btn-normal" onclick="javaacript:location.href='jsp/custInfoManager.jsp'">返回</button>
	<table class="layui-table"
		lay-data="{width: 972,  url:'listOrders.do?map[\'custNo\']=${CstCustomer.custNo}',page:true,
           page:{theme: '#5FB878'},
            id:'idTest'}"
		lay-filter="demo">
		<thead>
			<tr id="headTr">
				<th lay-data="{colspan:3}">客户编号:${CstCustomer.custId}</th>
				<th lay-data="{colspan:4}">客户名称:${CstCustomer.custName}</th>
			</tr>
			<tr>
				
				<th lay-data="{field:'odrId', width:120}">订单编号</th>
				<th lay-data="{field:'odrDate', width:150}">日期</th>
				<th lay-data="{field:'odrAddr', width:230}">送货地址</th>
				<th lay-data="{field:'odrStatus', width:235,templet:function(d){if(d.odrStatus == 5){return '已发货'}else{return '已付款'}}}">状态</th>
				<th lay-data="{field:'odrMemo', width:170}">备注</th>
				<th lay-data="{width:70, align:'center', toolbar: '#barDemo'}">
					操作</th>
			</tr>
		</thead>
	</table>
	<script type="text/html" id="barDemo">
    <a lay-event="minxi"><i class="layui-icon"
                          style="color: #cecccb;" title="订单明细">&#xe705;</i></a>
</script>
</body>
</html>