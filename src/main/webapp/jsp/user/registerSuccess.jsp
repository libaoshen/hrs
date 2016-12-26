<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-9">
	<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1">
	<title>注册成功</title>
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/user/register.css" />
	<script src="<%=request.getContextPath()%>/js/common/jquery-1.8.3.js"></script>
	<style type="text/css">
		a {
			  text-decoration: none;
			  color:#7b7bff;
		}
		a:hover {
			color:#f80;
		}
	</style>
</head>
<body>
	<div id="whole">
		<div id="top">
			<img alt="logo" src="<%=request.getContextPath() %>/images/common/logo.png">
		</div>
		<div id="form">
			<fieldset>
				<legend>新用户注册</legend>
				<div>
					注册成功!
					<a href="<%=request.getContextPath() %>/user/showLogin">登录</a>
					<a href="<%=request.getContextPath() %>/">回到首页</a>
				</div>
			</fieldset>
		</div>
	</div>
</body>
</html>