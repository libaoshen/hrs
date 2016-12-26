<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page isELIgnored="false" %> 

<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/main/top.css" />
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/common/icon/style.css" />
<script src="<%=request.getContextPath()%>/js/common/jquery-1.8.3.js"></script>
<script src="<%=request.getContextPath()%>/js/common/js.KinerCode.js"></script>
<script src="<%=request.getContextPath()%>/js/main/top.js"></script>

<span id="first" name="first"></span>
<div id="header">
	<input type="hidden" value="${which}" id="which" />
	<div id="logo">
		<a href="<%=request.getContextPath()%>/" title="首页">
			<img src="<%=request.getContextPath()%>/images/common/logo.png">
		</a>
	</div>
	<div id="menubar">
		<div id="nav">
			<div id="menu">
				<ul>
					<li id="shouye"><a href="<%=request.getContextPath()%>/">首页</a></li>
					<li id="help"><a href="<%=request.getContextPath()%>/showHelp">使用指南</a></li>
				</ul>
			</div>
			<div id="user">
				<div id="login">
					<c:choose>
						<c:when test="${user == null}">
							<span>
								<a href="<%=request.getContextPath()%>/user/showLogin">登录</a>
							</span>
							|
							<span>
								<a href="<%=request.getContextPath()%>/user/showRegister">注册</a>
							</span>
						</c:when>
						<c:otherwise>
							<span>
								欢迎登录,<a href="<%=request.getContextPath()%>/user/showUserInfo">${user.username}</a>
							</span>
						</c:otherwise>
					</c:choose>
					
				</div>
				<!-- 弹出层 -->
				<div id="tanchu">
					<div id="new_login">
						<c:choose>
							<c:when test="${user == null}">
								<a href="<%=request.getContextPath()%>/user/showLogin">登录</a>
							</c:when>
							<c:otherwise>
								<a href="<%=request.getContextPath()%>/user/logout">退出登录</a>
							</c:otherwise>
						</c:choose>
					</div>
					<ul id="function">
						<li id="function1">
							<a href="<%=request.getContextPath()%>/order/showUserOrder"><div id="icon1" class="fs1" aria-hidden="true" data-icon="&#xe101;"></div>我的订单</a>
						</li>
						<li id="function2">
							<a href="<%=request.getContextPath()%>/user/showUserInfo"><div id="icon2" class="fs1" aria-hidden="true" data-icon="&#xe08a;"></div>我的信息</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>


