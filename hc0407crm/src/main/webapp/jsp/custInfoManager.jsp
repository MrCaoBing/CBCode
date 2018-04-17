<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../../uiPage.jsp"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>客户开发计划</title>
   
    <!-- 引入当前页面样式 -->
    <link rel="stylesheet" href="css/cb/cust.css">
    <!-- 引入当前页面js -->
    <script type="text/javascript" src="js/cb/custInfoManager.js"></script>
   
</head>
<body>
	<!-- 拿到客户信息 -->
	<input type="hidden" id="usrId" value="${sessionScope.sysUser[0].usrId}"/>
	<input type="hidden" id="usrName" value="${sessionScope.sysUser[0].usrName}"/>
	<input type="hidden" id="roleId" value="${sessionScope.sysUser[0].sysRole.roleId}"/>
	<input type="hidden" id="roleName" value="${sessionScope.sysUser[0].sysRole.roleName}"/>
	
    <fieldset class="layui-elem-field layui-field-title">
        <legend><a name="use">客户信息管理</a></legend>
    </fieldset>
    <form class="layui-form" action="">
        <label class="layui-form-label">客户编号</label>
        <div class="layui-input-block">
            <input name="custId" id="custId" maxlength="15" placeholder="请输入客户编号" class="layui-input">
        </div>
        <label class="layui-form-label">名称</label>
        <div class="layui-input-block">
            <input name="custName" id="custName" maxlength="25" placeholder="请输入客户名称" class="layui-input">
        </div>
        <label class="layui-form-label">地区</label>
        <div class="layui-input-block">
            <select name="custRegion" id="custRegion">
                ${foundationData['area']}
            </select>
        </div>
        <label class="layui-form-label">客户经理</label>
        <div class="layui-input-block">     
        	<select name="sysUser" id="sysUser" lay-search>
                ${foundationData['custmanager']}
            </select>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">客户等级</label>
            <div class="layui-input-block">
                <select name="custLevel" id="custLevel">
                    ${foundationData['custLevel']}
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-danger tableInit" query="query"  lay-submit lay-filter="formDemo">
                    <i class="layui-icon" data-type="reload" title="查询">&#xe615;</i>
                </button>
                <button type="reset" class="layui-btn layui-btn-normal tableInit">
                    <i class="layui-icon" title="重置">&#x1002;</i>
                </button>
                <button type="button" class="layui-btn layui-btn-normal" onclick="javascript:location.href = 'jsp/custInfoEdit.jsp';">
                    <i class="layui-icon" title="添加">&#xe654;</i>
                </button>
            </div>
        </div>
    </form>
	<table id="custTable" lay-filter="custDataTab"></table>
    <script type="text/html" id="barDemo">
        <a lay-event="edit"><i class="layui-icon"
                               style="color: rgb(255,210,80);" title="编辑">&#xe642;</i></a>
        <a lay-event="cont"><i class="layui-icon"
                               style="color: rgba(153,255,17,0.7);" title="联系人">&#xe613;</i></a>
        <a lay-event="sugg"><i class="layui-icon"
                               style="color: #5e594b;" title="交往记录">&#xe63c;</i></a>
        <a lay-event="hist"><i class="layui-icon"
                               style="color: #ff8473;" title="历史订单">&#xe637;</i></a>
        <a lay-event="del"><i class="layui-icon"
                              style="color: #cecccb;" title="删除">&#xe640;</i></a>
    </script>
</body>
</html>