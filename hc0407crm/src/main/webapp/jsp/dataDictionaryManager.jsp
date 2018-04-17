<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../uiPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>数据字典管理</title>
<!-- 引入当前页面样式 -->
<link rel="stylesheet" href="css/cb/cust.css">
<!-- 引入当前页面样式 -->
<link rel="stylesheet" href="css/hqm/dataDictionaryManager.css">
<!--  引入当前页面js -->
<script type="text/javascript" src="js/hqm/dataDictionaryManager.js"></script>

</head>
<body>
	<fieldset class="layui-elem-field layui-field-title">
		<legend>
			<a name="use">基础数据 >>数据字典管理</a>
			<c:choose>
				<c:when test="${empty BasDict.dictId}">
					<span id="addOrSet">添加</span>
				</c:when>
			</c:choose>
		</legend>
	</fieldset>
	<form class="layui-form" action="">
		<table class="layui-table">
			<tbody>
				<tr>
					<td><label class="layui-form-label">类别:</label>
						<div class="layui-input-block">
						<!-- 可以通过设定属性 lay-search 来开启搜索匹配功能 -->
							<select name="dictType" id="dictType" lay-verify="" >
							
							<!-- disabled禁用 -->
								 <option value="">查询所有</option>
								<option value="地区">地区</option>
								<option value="客户等级">客户等级</option>
								<option value="服务类型">服务类型</option>
								<option value="客户来源">客户来源</option>
							</select>
						</div></td>
					<td><label class="layui-form-label">条目:</label>
						<div class="layui-input-block">
							<input name="dictItem" id="dictItem" maxlength="15"
								class="layui-input">
						</div></td>
					<td><label class="layui-form-label">代号:</label>
						<div class="layui-input-block">
							<input name="dictValue" id="dictValue" maxlength="15"
								class="layui-input">
						</div></td>
					<td align="center">
						<button class="layui-btn layui-btn-danger tableInit" query="query"
							lay-submit lay-filter="formcheck">
							<i class="layui-icon" id="check" data-type="reload" title="查询">&#xe615;</i>
						</button>

					</td>
				</tr>
			</tbody>
		</table>
		<script type="text/html" id="ifEdit">
  			<input type="checkbox" name="dictIsEdiTable" value="{{d.dictIsEdiTable}}" lay-text="是|否" lay-skin="switch" lay-filter="ifEditSwitch" {{ d.dictIsEdiTable == 1 ? 'checked' : '' }}>
		</script>
	</form>
	<!-- 数据表格 -->
	<table id="dataDictionTab" lay-filter="basDataTab"></table>

	<font color="#a9a9a9">注:点击表格可编辑</font>
	<form class="layui-form" action="">
		<table class="layui-table">
			<thead>
				<tr style="background-color: #ceed8d">
					<th colspan="2">新建数据字典条目</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td  width="453px"><label class="layui-form-label">编号:</label>
						<div class="layui-input-block">
							<input name="dictId" maxlength="15" class="layui-input"
								readonly="readonly" placeholder="编号系统自动生成">
						</div></td>
					<td><label class="layui-form-label">类别:</label>

						<div class="layui-input-block">
							<!-- lay-verify="required" 非空验证 -->
							<select name="dictType" lay-verify="required">
								<option value="">请选择</option>
								<option value="地区">地区</option>
								<option value="服务类型">服务类型</option>
								<option value="客户等级">客户等级</option>
								<option value="客户来源">客户来源</option>

							</select>
						</div></td>
				</tr>
				
				<tr>
					<td><label class="layui-form-label">条目:</label>
						<div class="layui-input-block">
							<input name="dictItem1" id="dictItem1" maxlength="20" placeholder=""
								lay-verify="required|ifName" class="layui-input">
						</div></td>
					<td><label class="layui-form-label">值:</label>
						<div class="layui-input-block">
							<input name="dictValue" maxlength="20" placeholder=""
								lay-verify="required|number" class="layui-input">
						</div></td>
				</tr>
				<tr>
					<td>
						<div class="layui-form-item" pane>
							<label class="layui-form-label">是否可编辑:</label>
							<div class="layui-input-block">&nbsp;&nbsp;
								<input type="radio" name="dictIsEdiTable" id="dictIsEdiTable"
									value="1" title="是" checked> <input type="radio"
									name="dictIsEdiTable" id="dictIsEdiTable" value="0" title="否">
							</div>
						</div>
					</td>  
				</tr>
				<tr>
					<td align="center" colspan="2">
						<div class="layui-input-block" id="submitTr">
							<button id="submit" class="layui-btn layui-btn-danger" lay-submit lay-filter="formDemo">确认</button>
							<button type="reset" class="layui-btn layui-btn-normal reset">重置</button>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<script type="text/html" id="barDemo">
    <a lay-event="del"><i class="layui-icon"
                          style="color: #cecccb;" title="删除">&#xe640;</i></a>
	</script>
</body>
</html>