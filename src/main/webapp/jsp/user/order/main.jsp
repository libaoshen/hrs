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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1">
	<META HTTP-EQUIV="pragma" CONTENT="no-cache"> 
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"> 
	<META HTTP-EQUIV="expires" CONTENT="Wed, 26 Feb 1997 08:21:57 GMT">
	<link style="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/order/main.css"/>
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/common/jquery-ui.css" />
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/common/jquery-ui.theme.css" />
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/common/icon/style.css"/>
	<script src="<%=request.getContextPath()%>/js/common/jquery-1.8.3.js"></script>
	<script src="<%=request.getContextPath()%>/js/common/jquery-ui.js"></script>
	<script src="<%=request.getContextPath()%>/js/order/showAddOrder.js"></script>
	
	<title>${title}</title>
</head>
<body>
	<input type="hidden" value="${title}" id="title" />
	<div id="base">
		<div id="top">
			<tiles:insertAttribute name="top"/>
		</div>
		<div id="content">
			<tiles:insertAttribute name="content"/>
		</div>
		<div id="bottom">
			<tiles:insertAttribute name="bottom"/>
		</div>
	</div>
</body>
</html>