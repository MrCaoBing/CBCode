<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../../uiPage.jsp"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>客户服务</title>
   
    <!-- 引入当前页面样式 -->
    <link rel="stylesheet" href="css/cb/cust.css">
    <!-- 导入Echarts -->
     <script type="text/javascript" src="js/echarts.min.js"></script>
    <!-- 引入当前页面js -->
    <script type="text/javascript" src="js/cb/custServiceAnalyse.js"></script>
    
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title">
        <legend><a name="use">统计报表 >> 客户服务分析</a></legend>
    </fieldset>
      <div>
			<table id="custTable" lay-filter="custDataTab"></table>
	</div>
	<fieldset class="layui-elem-field layui-field-title"  style="width:500px;">
        <legend><a name="use">统计报表 >> 统计图</a></legend>
    </fieldset>
	 <!-- 图 -->
    <div id="pillar" style="width: 950px;height:500px;"></div>
</body>
</html>