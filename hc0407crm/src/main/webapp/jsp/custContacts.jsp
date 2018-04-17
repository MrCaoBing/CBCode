<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../uiPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <title>客户联系人</title>
    <meta charset="UTF-8">
    <!-- 引入当前页面样式 -->
    <link rel="stylesheet" href="css/cb/cust.css">
    <!-- 引入当前页面js -->
    <script type="text/javascript" src="js/cb/custContacts.js"></script>

</head>
<body>
    <fieldset class="layui-elem-field layui-field-title">
        <legend>
        	<a name="use">客户信息管理 >> 客户联系人</a></legend>
    </fieldset>
    <script type="text/html" id="switchSex">
  		<input type="checkbox" name="sex" value="{{d.lkmSex}}" lay-skin="switch" lay-text="女|男" lay-filter="sexDemo" {{ d.lkmSex != '男' ? 'checked' : '' }}>
	</script>
    <table class="layui-table" lay-data="{width: 972, height:332, url:'listCstLinkman.do?custNo=${CstCustomer.custNo}',
            id:'idTest'}" lay-filter="lkmData">
        <thead>
        <tr id="headTr">
            <th lay-data="{colspan:3}">客户编号:${CstCustomer.custId}</th>
            <th lay-data="{colspan:4}">客户名称:${CstCustomer.custName}</th>
        </tr>
        <tr>
       		<th lay-data="{field:'lkmId', width:70}">ID</th>
            <th lay-data="{field:'lkmName', width:120,edit: 'text'}">姓名</th>
            <th lay-data="{field:'lkmSex', width:85, templet: '#switchSex', unresize: true}">性别</th>
            <th lay-data="{field:'lkmPostion', width:170,edit: 'text'}">职位</th>
            <th lay-data="{field:'lkmTel', width:170,edit: 'text'}">办公电话</th>
            <th lay-data="{field:'lkmMobile', width:170,edit: 'text'}">手机</th>
            <th lay-data="{field:'lkmMemo', width:190,edit: 'text'}">备注</th>
            <th lay-data="{fixed: 'right',width:46, align:'center', toolbar: '#barDemo'}">操作</th>
        </tr>       
        </thead>
    </table>
    
    <font color="#a9a9a9">注:点击表格可编辑</font>
    <script type="text/html" id="barDemo">
        <a lay-event="del"><i class="layui-icon"
                              style="color: #cecccb;" title="删除">&#xe640;</i></a>
    </script>
    <form class="layui-form" action="">
        <table class="layui-table">
            <thead>
            <tr style="background-color: #ceed8d">
                <th colspan="2">添加客户联系人</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <label class="layui-form-label">姓名:</label>
                    <div class="layui-input-block">
                    	<input name="custNo" value="${CstCustomer.custNo}" type="hidden" class="layui-input">
                        <input name="lkmName" maxlength="18" placeholder="请输入姓名" lay-verify="" class="layui-input">
                    </div>
                </td>
                <td>
                    <label class="layui-form-label">性别:</label>
                    <div class="layui-input-block">&nbsp;&nbsp;
                        <input type="radio" name="lkmSex" value="女" title="女">
                        <input type="radio" name="lkmSex" value="男" title="男" checked>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="layui-form-label">职位:</label>
                    <div class="layui-input-block">
                        <input name="lkmPostion" maxlength="20" placeholder="请输入职位" lay-verify="" class="layui-input">
                    </div>
                </td>
                <td>
                    <label class="layui-form-label">办公电话:</label>
                    <div class="layui-input-block">
                        <input name="lkmTel" maxlength="20" placeholder="请输入办公电话(必填)" lay-verify="required" class="layui-input">
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="layui-form-label">手机:</label>
                    <div class="layui-input-block">
                        <input name="lkmMobile" maxlength="20" placeholder="请输入手机" lay-verify="" class="layui-input">
                    </div>
                </td>
                <td>
                    <label class="layui-form-label">备注:</label>
                    <div class="layui-input-block">
                        <input name="lkmMemo" maxlength="20" placeholder="请输入备注" lay-verify="" class="layui-input">
                    </div>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <div class="layui-input-block" id="submitTr">
                        <button class="layui-btn layui-btn-danger" lay-submit lay-filter="formDemo">
                            确认
                        </button>
                        <button type="reset" class="layui-btn layui-btn-normal" onclick="javaacript:location.href='jsp/custInfoManager.jsp'">返回</button>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</body>
</html>