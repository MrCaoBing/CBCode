<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../uiPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>客户信息编辑</title>
   <!--  引入当前页面样式 -->
    <link rel="stylesheet" href="css/cb/cust.css">
    <!--  引入当前页面js -->
    <script type="text/javascript" src="js/cb/custInfoEdit.js"></script>
</head>
<body>
    <fieldset class="layui-elem-field layui-field-title">
        <legend><a name="use">客户信息管理 >>      	 
        	<c:choose>
				<c:when test="${not empty CstCustomer.custNo}"><span id="addOrSet">编辑</span></c:when>
				<c:when test="${empty CstCustomer.custNo}"><span id="addOrSet">添加</span></c:when>
			</c:choose>		
		</a></legend>
    </fieldset>
	
    <form class="layui-form" action="">
        <table class="layui-table">
        <thead>
        <tr style="background-color: #ceed8d">
            <th>属性</th>
            <th>属性</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <label class="layui-form-label">客户编号:</label>
                <div class="layui-input-block">
                    <input name="custId" maxlength="15" value="${CstCustomer.custId}" class="layui-input" readonly="readonly" placeholder="客户编号系统自动生成">
                    <input id="custNo" name="custNo" type="hidden" value="${CstCustomer.custNo}" class="layui-input" readonly="readonly">
                </div>
            </td>
            <td>
                <label class="layui-form-label">客户名称:</label>
                <div class="layui-input-block">
                	<input id="custNameRe" name="custName" value="${CstCustomer.custName}"  readonly="readonly"  type="hidden" >
                     <input type="text" id="custName" name="custName" value="${CstCustomer.custName}" maxlength="50" placeholder="请输入客户名称(必填)" lay-verify="required|ifName" class="layui-input">                   
                </div>
            </td>
        </tr>
        <script>
	        $(function(){
		    	if('${CstCustomer.custId}' != ''){
		    		$("#custRegion option[value=${CstCustomer.custRegion}]").attr('selected',true);
		    		$("#sysUser option[value=${CstCustomer.sysUser.usrId}]").attr('selected',true);
		    		$("#custLevel option[value=${CstCustomer.custLevel}]").attr('selected',true);
		    		$(".custSatisfy:radio").each(function(index,domEle){
						if($(domEle).val()== '${CstCustomer.custSatisfy}'){
							$(domEle).attr('checked',true);
						}
		    		});	
		    		$(".custCredit:radio").each(function(index,domEle){
						if($(domEle).val()== '${CstCustomer.custCredit}'){
							$(domEle).attr('checked',true);
						}
		    		});			    
		    	}
		    });
        </script>
        <tr>
            <td>
                <label class="layui-form-label">客户地区:</label>
                <div class="layui-input-block">
                   <select name="custRegion" id="custRegion">
               	 		${foundationData['area']}
            	   </select>
                </div>
            </td>
            <td>
                <label class="layui-form-label">客户经理:</label>
                <div class="layui-input-block">   
			        <select name="sysUser" id="sysUser">
			              ${foundationData['custmanager']}
			       </select>
                </div>
            </td>
            </tr>
            <tr>
                <td>
                    <label class="layui-form-label">客户等级:</label>
                    <div class="layui-input-block">
                        <select name="custLevel" id="custLevel">
		                    ${foundationData['custLevel']}
		                </select>
                    </div>
                </td>
                <td></td>
            </tr>
            <tr>
                <td>
                    <label class="layui-form-label">客户满意度:</label>
                    <div class="layui-input-block">&nbsp;&nbsp;
                        <input class="custSatisfy" type="radio" name="custSatisfy" value="1" title="不满" checked>
                        <input class="custSatisfy" type="radio" name="custSatisfy" value="2" title="合格">
                        <input class="custSatisfy" type="radio" name="custSatisfy" value="3" title="良好">
                        <input class="custSatisfy" type="radio" name="custSatisfy" value="4" title="优秀">
                        <input class="custSatisfy" type="radio" name="custSatisfy" value="5" title="卓越">
                    </div>
                </td>
                <td>
                    <label class="layui-form-label">客户信用度:</label>
                    <div class="layui-input-block">&nbsp;&nbsp;
                        <input class="custCredit" type="radio" name="custCredit" value="1" title="极差" checked>
                        <input class="custCredit" type="radio" name="custCredit" value="2" title="较差">
                        <input class="custCredit" type="radio" name="custCredit" value="3" title="中等">
                        <input class="custCredit" type="radio" name="custCredit" value="4" title="良好">
                        <input class="custCredit" type="radio" name="custCredit" value="5" title="优秀">
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="layui-form-label">客户地址:</label>
                    <div class="layui-input-block">
                        <input name="custAddr" value="${CstCustomer.custAddr}"  maxlength="30" placeholder="请输入客户地址(必填)" lay-verify="required" class="layui-input">
                    </div>
                </td>
                <td>
                    <label class="layui-form-label">邮政编码:</label>
                    <div class="layui-input-block">
                        <input name="custZip" value="${CstCustomer.custZip}"  maxlength="6" placeholder="请输入客户邮箱(必填)" lay-verify="required|number" class="layui-input">
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="layui-form-label">客户电话:</label>
                    <div class="layui-input-block">
                        <input name="custTel" value="${CstCustomer.custTel}"  maxlength="11" placeholder="请输入客户电话(必填)" lay-verify="required|number" class="layui-input">
                    </div>
                </td>
                <td>
                    <label class="layui-form-label">客户传真:</label>
                    <div class="layui-input-block">
                        <input name="custFax" value="${CstCustomer.custFax}"  maxlength="11" placeholder="请输入客户传真(必填)" lay-verify="required|number" class="layui-input">
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="layui-form-label">客户网址:</label>
                    <div class="layui-input-block">
                        <input name="custWebsite" value="${CstCustomer.custWebsite}"  maxlength="30" placeholder="请输入客户网址(必填)" lay-verify="required" class="layui-input">
                    </div>
                </td>
                <td>

                </td>
            </tr>
            <tr>
                <td>
                    <label class="layui-form-label numIuput">营业注册号:</label>
                    <div class="layui-input-block">
                        <input name="custLicenceNo" value="${CstCustomer.custLicenceNo}"  maxlength="18" placeholder="请输入营业注册号" lay-verify="number" class="layui-input">
                    </div>
                </td>
                <td>
                    <label class="layui-form-label">公司法人:</label>
                    <div class="layui-input-block">
                        <input name="custChieftain" value="${CstCustomer.custChieftain}"  maxlength="10" placeholder="请输入客户公司法人(必填)" lay-verify="required" class="layui-input">
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="layui-form-label numIuput">营业额:</label>
                    <div class="layui-input-block">
                        <input name="custTurnover" value="${CstCustomer.custTurnover}"  maxlength="18" placeholder="请输入营业额" lay-verify="" class="layui-input">
                    </div>
                </td>
                <td>
                    <label class="layui-form-label numIuput">注册资金:</label>
                    <div class="layui-input-block">
                        <input name="custBankroll" value="${CstCustomer.custBankroll}"  maxlength="10" placeholder="请输入客户公司注册资金" lay-verify="" class="layui-input">
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="layui-form-label">开户银行:</label>
                    <div class="layui-input-block">
                        <input name="custBank" value="${CstCustomer.custBank}"  maxlength="18" placeholder="请输入开户银行(必填)" lay-verify="required" class="layui-input">
                    </div>
                </td>
                <td>
                    <label class="layui-form-label">银行帐号:</label>
                    <div class="layui-input-block">
                        <input name="custBankAccount" value="${CstCustomer.custBankAccount}"  maxlength="18" placeholder="请输入客户公司银行帐号(必填)" lay-verify="required|number" class="layui-input">
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="layui-form-label">地税登记号:</label>
                    <div class="layui-input-block">
                        <input name="custLocalTaxNo" value="${CstCustomer.custLocalTaxNo}"  maxlength="20" placeholder="请输入地税登记号(必填)" lay-verify="required|number" class="layui-input">
                    </div>
                </td>
                <td>
                    <label class="layui-form-label">国税登记号:</label>
                    <div class="layui-input-block">
                        <input name="custNationalTaxNo" value="${CstCustomer.custNationalTaxNo}" maxlength="20" placeholder="请输入国税登记号(必填)" lay-verify="required|number" class="layui-input">
                    </div>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <div class="layui-input-block" id="submitTr">
                        <button class="layui-btn layui-btn-danger" lay-submit lay-filter="formDemo">
                            确认
                        </button>
                         <button type="reset"  class="layui-btn layui-btn-danger reset" >
                            重置
                        </button>
                        <button type="button" class="layui-btn layui-btn-normal"  onclick="javaacript:location.href='jsp/custInfoManager.jsp'">
                            返回
                        </button>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</body>
</html>
