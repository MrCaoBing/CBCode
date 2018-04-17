<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../../uiPage.jsp"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>客户流失管理</title>  
    <!-- 引入当前页面样式 -->
    <link rel="stylesheet" href="css/cb/cust.css">
    <!-- 引入当前页面js -->
    <script type="text/javascript" src="js/cb/custLoseManager.js"></script>
   
</head>
<body>
	<!-- 拿到客户信息 -->
	<input type="hidden" id="usrId" value="${sessionScope.sysUser[0].usrId}"/>
	<input type="hidden" id="usrName" value="${sessionScope.sysUser[0].usrName}"/>
	<input type="hidden" id="roleId" value="${sessionScope.sysUser[0].sysRole.roleId}"/>
	<input type="hidden" id="roleName" value="${sessionScope.sysUser[0].sysRole.roleName}"/>
    <fieldset class="layui-elem-field layui-field-title">
        <legend><a name="use">客户流失管理</a></legend>
    </fieldset>
    <form class="layui-form" action="">
        <label class="layui-form-label">名称</label>
        <div class="layui-input-block">
            <input name="custName" id="custName" maxlength="25" placeholder="请输入客户名称" class="layui-input">
        </div>
        <label class="layui-form-label">客户经理</label>
        <div class="layui-input-block">     
        	<select name="sysUser" id="sysUser"  lay-search>
                ${foundationData['custmanager']}
            </select>
        </div>
		<label class="layui-form-label">客户状态</label>
        <div class="layui-input-block">     
        	<select name="lstStatus" id="lstStatus">
                <option value="" selected="selected">全部</option>
                <option value="1">预警</option>
                <option value="2">暂缓</option>
                <option value="3">流失</option>
            </select>
        </div>
       
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-danger tableInit" query="query"  lay-submit lay-filter="formDemo">
                    <i class="layui-icon" data-type="reload" title="查询">&#xe615;</i>
                </button>
                <button type="reset" class="layui-btn layui-btn-normal tableInit">
                    <i class="layui-icon" title="重置">&#x1002;</i>
                </button>
            </div>
        </div>
    </form>
	<table id="lostTable" lay-filter="custTab"></table>
    <script type="text/html" id="barDemo">
        <a lay-event="lost"><img class="icon" src='images/crm_qrls_icon.jpg' title='确认流失'/></a>
        <a lay-event="rescue"><img class="icon"  src='images/crm_zhls_icon.png' title='暂缓流失'/></a>
      
    </script>
</body>
</html>