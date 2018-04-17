<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
 	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<base href="<%=basePath%>">
<title>客户关系系统登录</title>
    <link rel="stylesheet" href="css/cb/login.css">
    	<!-- 引入jQuery -->
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<script type="text/javascript">

	if (window.top!=window.self) {
		window.top.location.href='jsp/login.jsp';
	}
	
	$(function(){
		$("#form").submit(function(){
			$.post("login.do",{usrName:$("#username").val(),usrPassword:$("#password").val()},function(data){
				if(data){
					if (data == 'jsp/login.jsp') {
						alert("登录失败!")
					}
					location.href = data;
				}
			});
			return false;
		});
	});
	
	
</script>
<body>
<div class="login">
<form method="post" id="form">
	<div class="logo"></div>
    <div class="login_form">
    	<div class="user">
        	<input class="text_value" required="required" maxlength="20" placeholder="请输入用户名" value="" name="usrName" type="text" id="username">
            <input class="text_value" required="required" maxlength="20" placeholder="请输入密码" value="" name="usrPassword" type="password" id="password">
        </div>
        <button class="button" id="button" type="submit">登录</button>
    </div>
    
    <div class="foot">
		2018.HC0407<br/>
		LZM && CB && HQM && HZQ
    </div>
    </form>
</div>
</body>
</html>