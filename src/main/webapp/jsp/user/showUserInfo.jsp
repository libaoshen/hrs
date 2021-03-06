<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page isELIgnored="false" %> 
<script src="<%=request.getContextPath()%>/js/common/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/order/showUserInfo.css" />
<script src="<%=request.getContextPath()%>/js/order/showUserOrder.js"></script>

<div id="body">
	<fieldset id="field">
		<legend>用户信息</legend>
		<div id="info">
			<table>
				<tr>
					<td>用户名</td>
					<td>${user.username }</td>
				</tr>
				<tr>
					<td>性别</td>
					<td>${user.sex == false? '男' : '女'}</td>				</tr>
				<tr>
					<td>电话</td>
					<td>${user.phone }</td>
				</tr>
				<tr>
					<td>账户年龄</td>
					<td>${old }</td>
				</tr>
				<tr>
					<td>最近一次登录时间</td>
					<td>${lastlogintime }</td>
				</tr>
				<tr>
					<td>最近一次登录IP</td>
					<td>${lastloginip }</td>
				</tr>
			</table>
			
			<div id="help">
				<div style="color:olive;">快速通道</div>
				<ul>
					<li><a href="<%=request.getContextPath()%>/user/showFindPassword">修改密码</a></li>
					<li><a href="<%=request.getContextPath()%>/user/showUpdateInfo">修改用户信息</a></li>
					<li><a href="<%=request.getContextPath()%>/order/showUserOrder">查看我的订单</a></li>
				</ul>
			</div>
		</div>
	</fieldset>
</div>


