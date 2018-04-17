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
    <!-- 导入Echarts -->
     <script type="text/javascript" src="js/echarts.min.js"></script>
    <!-- 引入当前页面js -->
    <script type="text/javascript" src="js/cb/roleManager.js"></script>
    <style>
 
    </style>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title">
        <legend><a name="use">权限管理 >>用户管理</a></legend>
    </fieldset>
      <div>
		    <div class="float">
				<table id="roleTab" lay-filter="roleTab"></table>
				<script type="text/html" id="barDemo">
				    <a lay-event="edit"><i class="layui-icon"
                          style="color: rgb(255,210,80);" title="编辑">&#xe642;</i></a>
     				<a lay-event="del"><i class="layui-icon"
                          style="color: #cecccb;" title="删除">&#xe640;</i></a>					
				</script>
			</div>
			<form class="layui-form" action="">
		<table class="layui-table">
			<thead>
				<tr style="background-color: #ceed8d">
					<th colspan="2"><strong><span id="editOradd">添加</span>角色</strong></th>
				</tr>
			</thead>
			<form class="layui-form" action="" id="rightForm">
			<tbody>				
				<tr>
					 <td>
		                <label class="layui-form-label">角色名称:</label>
		                <div class="layui-input-block">
		                	<input name="roleId"  id="roleId" type="hidden">                    
		                    <input lay-verify="required|ifName" name="roleName"  id="roleName" maxlength="15" value="" class="layui-input" placeholder="请输入角色名称(必填)">                    
		                </div>
		             </td>
		              <td>
		                <label class="layui-form-label">角色备注:</label>
		                <div class="layui-input-block">
		                    <input name="roleDesc" id="roleDesc" value="" maxlength="15" placeholder="请输入角色备注" class="layui-input">
		                </div>
	           		</td>
				</tr>
				<tr>
					 
					 <table class="layui-table" id="roleTab">
					 	<tr>
					 		<td rowspan="6" width="15px">
					 			<strong>权<br/>限<br/>管<br/>理</strong>
					 		</td>
					 		<td width="100px" class="parentRight">
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L01" title="营销管理" >
					 		</td>
					 		<td class="childrenRight">
					 			      <input type="checkbox" name="right" lay-filter="right" class="right" value="L0101" title="销售机会管理" >
					 			      <input type="checkbox" name="right" lay-filter="right" class="right" value="L0102" title="客户开发计划" >
					 		</td>
					 	</tr>
					 	<tr>
					 		<td width="100px" class="parentRight">
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L02" title="客户管理" >
					 		</td>
					 		<td class="childrenRight">
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L0201"  title="客户信息管理" >
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L0202"  title="客户流失管理" >
					 		</td>
					 	</tr>
					 	<tr>
					 		<td width="100px" class="parentRight">
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L03"  title="服务管理" >
					 		</td>
					 		<td class="childrenRight">
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L0301" title="服务创建" >
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L0302" title="服务分配" >
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L0303" title="服务处理" >
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L0304" title="服务反馈" >
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L0305" title="服务归档" >
					 		</td>
					 	</tr>
					 	<tr>
					 		<td width="100px" class="parentRight">
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L04"  title="统计报表" >
					 		</td>
					 		<td class="childrenRight">
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L0401" title="客户贡献分析" >
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L0402" title="客户构成分析" >
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L0403" title="客户服务分析" >
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L0404" title="客户流失分析" >
					 		</td>
					 	</tr>
					 	<tr>
					 		<td width="100px" class="parentRight">
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L05" title="基础数据" >
					 		</td>
					 		<td class="childrenRight">
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L0501" title="数据字典管理" >
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L0502" title="查询产品信息" >
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L0503" title="查询库存" >					 			
					 		</td>
					 	</tr>
					 	<tr>
					 		<td width="100px" class="parentRight">
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L06" title="权限管理"  >
					 		</td>
					 		<td class="childrenRight">
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L0601" title="用户管理" >
					 			<input type="checkbox" name="right" lay-filter="right" class="right" value="L0602"  title="角色管理" >
					 		</td>
					 	</tr>
					 	<tr>
			                <td align="center" colspan="3">
			                    <div class="layui-input-block" id="submitTr">
			                        <button class="layui-btn layui-btn-danger" lay-submit lay-filter="formDemo">
			                            确认
			                        </button>
			                        <button type="reset" class="layui-btn layui-btn-normal reset">
			                            取消
			                        </button>
			                    </div>
			                </td>
           				 </tr>
					 </table>
					 </from>
				</tr>
			</tbody>
			
		</table>
	</form>
		</div>
</body>
</html>