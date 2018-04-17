<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
 	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- 引入layui样式文件 -->
    <link rel="stylesheet" href="layui/css/layui.css">
    <!-- 引入EasyUi的图标样式文件 -->
    <link rel="stylesheet" href="jquery-easyui-1.5.3/themes/icon.css">
    <!-- 引入EasyUi的样式文件 -->
    <link rel="stylesheet" href="jquery-easyui-1.5.3/themes/gray/easyui.css">
	<!-- 引入jQuery -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 引入EasyUi -->
    <script type="text/javascript" src="jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
    <!-- 引入国际化js,便可支持中文 -->
    <script src="jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>    
    <!-- 引入layuijs文件 -->
    <script src="layui/layui.js"></script>
     <!-- 引入页面样式 -->
    <link rel="stylesheet" href="css/cb/cust.css">
<title>客户关系管理</title>
</head>
<body>

</body>
</html>