<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/order/top.css"/> 
<div>
	<div id="top1">
		<div id="logo">
			<a href="<%=request.getContextPath()%>/">
				<img src="<%=request.getContextPath()%>/images/common/logo.png"/>
			</a>
		</div>
		
	</div>
	
	<div id="top_process">
		<ul>
			<li id="li1">
				<span id="line1" class="line"></span>
				<span id="circle1" class="circle"></span>
				订单填写
	 		</li>
			<li id="li2">
				<span id="line2" class="line"></span>
				<span id="circle2" class="circle"></span>
				在线支付
			</li>
			<li id="li3">
				<span id="line3" class="line"></span>
				<span id="circle3" class="circle"></span>
				订单完成
			</li>
		</ul>
	</div>
</div>