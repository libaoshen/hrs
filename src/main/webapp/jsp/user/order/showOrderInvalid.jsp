<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page isELIgnored="false" %>
<script src="<%=request.getContextPath()%>/js/common/js.KinerCode.js"></script> 
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/order/showOrderPay.css" />

<div id="content1">
	<div style="color:red;font-size:50px;width:1200px;margin:300px auto;text-align: center;">
		订单已过期!<a href="<%=request.getContextPath()%>/">返回首页</a>
	</div>
</div>