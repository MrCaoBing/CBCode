<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../uiPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎来到客户关系管理系统</title>
    <!-- 引入自定义css -->
    <link rel="stylesheet" href="css/cb/index.css">
    <!-- 引入自定义js -->
    <script src="js/cb/index.js"></script>
</head>
<body>
    <div id="outer" class="easyui-layout" style="width:1228px;height: 890px;margin: 0px auto">
        <div id="head" data-options="region:'north'" style="height:120px;background: #F2F1F1;">
            <div style="margin: 10px">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </div>
            <div>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <img src="images/crm_title_1.png" height="100" width="700"/>
            </div>
            <div>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <br/><br/><br/><br/><br/><br/>
                <span class="head_title">欢迎光临:</span>${sessionScope.sysUser[0].usrName}&nbsp;|&nbsp;
                <span class="head_title">您的职位:</span>${sessionScope.sysUser[0].sysRole.roleName}&nbsp;|&nbsp;
                <a href="jsp/login.jsp">退出登录</a>	
            </div>
        </div>
        <div data-options="region:'west',title:'您的权限',split:true" style="width:207px;" >
            <ul class="layui-nav layui-nav-tree" lay-filter="test" id="tree">
                <c:forEach var="node1" items="${nodes}">
                <li class="layui-nav-item">
                    <a href="javascript:;">${node1.text}</a>
                    <dl class="layui-nav-child">
                    	<c:forEach var="node2" items="${node1.children}">
                    		 <c:if test="${node2.id != 'L0102'}">
                    		 	<dd><a href="javascript:clickOption(this);" pageUrl="jsp/${node2.attributes['pageUrl']}">${node2.text}</a></dd>
                    		 </c:if>                 		 
                    	</c:forEach>

                    </dl>
                </li>
                </c:forEach>
            </ul>
        </div>
        <div data-options="region:'center'" style="padding:5px;background:#eee;">
            <div id="optionTabs" class="easyui-tabs" style="width: 500px; height: 250px;"
                 data-options="fit:true">
                <div title="welcome" style="padding: 20px; display: none;">
                    <img src="images/crm_theme_02.jpg" height="100%" width="100%"/>
                </div>
            </div>
        </div>

        <div data-options="region:'south'" style="height:25px;text-align: center">
            皓晨4班-2017-7组
        </div>
    </div>
</body>
</html>