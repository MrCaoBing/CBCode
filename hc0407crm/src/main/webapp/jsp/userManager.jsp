<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../../uiPage.jsp"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
   
    <!-- 引入当前页面样式 -->
    <link rel="stylesheet" href="css/cb/cust.css">
    <!-- 引入当前页面js -->
    <script type="text/javascript" src="js/cb/userManager.js"></script>
    <style>
  
    </style>
</head>
<body>	
	<div id="selectRo" style="display:none;">
            <select name="usrRoleId" id="usrRoleId" lay-verify="required" lay-filter="seRo" class="usrRole">
			</select>
	</div>
	<div id="updPwdDiv" style="display:none;">
		
	</div>
	
	<fieldset class="layui-elem-field layui-field-title">
        <legend><a name="use">权限管理 >>用户管理</a></legend>
    </fieldset>
      <div>
    <form class="layui-form" action="">	  
		    	<div class="float" style="width:700px">
		    		 <label class="layui-form-label">名称</label>
			        <div class="layui-input-block">
			            <input name="usrName" id="queryName"  maxlength="25" placeholder="请输入用户名称" class="layui-input">
			        </div>
		    	</div>
		       <div class="float">
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
		       </div>
		    </form>
		    <div class="float">
				<table id="userTab" lay-filter="userTab"></table>
				<script type="text/html" id="barDemo">
     				<a lay-event="del"><i class="layui-icon"
                          style="color: #cecccb;" title="删除">&#xe640;</i></a>
					<a lay-event="updPwd"><i class="layui-icon"
                          style="color: #cecccb;" title="修改密码">&#xe639;</i></a>
				</script>
			</div>
			<form class="layui-form" action="">
		<table class="layui-table">
			<thead>
				<tr style="background-color: #ceed8d">
					<th colspan="2"><strong>添加用户</strong></th>
				</tr>
			</thead>
			<tbody>				
				<tr>
					<td width="460px"><label class="layui-form-label">用户名:</label>
						<div class="layui-input-block">
							<input lay-filter="usrName"  name="usrName" id="usrName" maxlength="20" placeholder="请输入用户名(必填)"
								lay-verify="required|ifName" class="layui-input">
						</div></td>
					<td><label class="layui-form-label">角色:</label>
                    <div class="layui-input-block" id="addRoleSel">
                        <select lay-filter="seRo" name="usrRoleId" id="usrRoleId" lay-verify="required" value="1" class="usrRole" >
		                </select>
                    </div></td>
				</tr>
				<tr>
					<td><label class="layui-form-label">密码:</label>
						<div class="layui-input-block">
							<input type="password" name="usrPwd" id="usrPwd" maxlength="20" placeholder="请输入密码(必填)"
								lay-verify="required|pass" class="layui-input">
						</div></td>
					<td><label class="layui-form-label">确认密码:</label>
						<div class="layui-input-block">
							<input type="password"  name="usrPwdre" id="usrPwdRe" maxlength="20" placeholder="请输入再次输入密码(必填)"
								lay-verify="required|pwdRe" class="layui-input">
						</div>
						</td>					
				</tr>
				 <tr>
                <td align="center" colspan="2">
                    <div class="layui-input-block" id="submitTr">
                        <button class="layui-btn layui-btn-danger" lay-submit lay-filter="formDemo">
                            确认
                        </button>
                        <button type="reset" class="layui-btn layui-btn-normal" >重置</button>
                    </div>
                </td>
            </tr>
			</tbody>
		</table>
	</form>
		</div>
</body>
</html>