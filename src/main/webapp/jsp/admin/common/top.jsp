<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ page isELIgnored="false" %> 
<link href='//cdn.webfont.youziku.com/webfonts/nomal/94977/19673/583136ecf629d8120c370fe9.css' rel='stylesheet' type='text/css' />
<script>
$("document").ready(function(){
	if($("#pageTitle").val() == "首页"){
		$("#shouye").css("border-bottom","3px solid #2fb3ff");
	}
	if($("#pageTitle").val() == "房间管理"){
		$("#room").css("border-bottom","3px solid #2fb3ff");
	}
	if($("#pageTitle").val() == "订单管理"){
		$("#order").css("border-bottom","3px solid #2fb3ff");
	}
	if($("#pageTitle").val() == "用户管理"){
		$("#user").css("border-bottom","3px solid #2fb3ff");
	}
});
</script>
<div>
	<div id="top1">
		<div id="logo">
			<a href="<%=request.getContextPath()%>/admin/home"><img alt="logo" src="<%=request.getContextPath()%>/images/common/logo.png"></a>
		</div>
		<div id="title">
			<h2 style="font-family:'jdzhonyuanjian72567d45117301';">酒店预订后台管理系统</h2>
		</div>
		<div id="login">
			<table>
				<tr>
					<td id="firsttd">欢迎<span style="color:red;"> ${sessionScope.admin.adminname}</span> 登录</td>
					<td><a href="<%=request.getContextPath()%>/admin/logout">退出登录</a></td>
				</tr>
			</table>
		</div>
	</div>
	
	<div id="top2">
		<div id="menu">
			<table>
				<tr>
					<td id="shouye"><a href="<%=request.getContextPath()%>/admin/home">首页</a></td>
					<td id="room"><a href="<%=request.getContextPath()%>/room">房间管理</a></td>
					<td id="order"><a href="<%=request.getContextPath()%>/order">订单管理</a></td>
					<td id="user"><a href="<%=request.getContextPath()%>/user">用户管理</a></td>
				</tr>
			</table>
		</div>
	</div>
</div>