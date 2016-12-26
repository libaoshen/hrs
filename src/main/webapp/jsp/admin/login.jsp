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
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>登录</title>
	
    <link href="<%=request.getContextPath()%>/css/admin/login/styles.css" type="text/css" rel="stylesheet"/>
    <script src="<%=request.getContextPath()%>/js/common/jquery-1.8.3.js"></script>
    <script>
	    $("document").ready(function(){
	    	$("#submit").mouseover(function(){
	    		$("#submit").css({"color":"red","cursor":"pointer"});
	    	});  
	    	$("#submit").mouseout(function(){
	    		$("#submit").css("color","black");
	    	});
	    	$("#input1").mouseover(function(){
	    		$("#input1").css("border-color","black");
	    	});
	    	$("#input1").mouseout(function(){
	    		$("#input1").css("border-color","#b3b3b3");
	    	});
	    	$("#input2").mouseover(function(){
	    		$("#input2").css("border-color","black");
	    	});
	    	$("#input2").mouseout(function(){
	    		$("#input2").css("border-color","#b3b3b3");
	    	});
	    	$("#input1").focus(function(){
	    		$("#input1").css("border-color","black");
	    	});
	    	$("#input2").click(function(){
	    		$("#input2").css("border-color","black");
	    	});
	    });
    </script>
</head>
<body>
	 <div id="base">
	 	<div id="left" style="background-image: url('<%=request.getContextPath()%>/images/admin/login/backgroundcolor.png');">
	 		<div id="logo">
	 			<img id="logoimg" alt="logo" src="<%=request.getContextPath()%>/images/common/logo.png">
	 		</div>
	 		<div id="left-title">
	 			<h3>酒店预订后台管理系统</h3>
	 		</div>
	 		<div id="copyright">
	 			<h6>Copyright &copy; LBS,2016</h6>
	 		</div>
	 		<div id="backimage">
	 			<img alt="backgroundimg" src="<%=request.getContextPath()%>/images/admin/login/background.png">
	 		</div>
	 	</div>
	 	<div id="right" style="background-image: url('<%=request.getContextPath()%>/images/admin/login/login.png');">
	 		<div id="right-title">
	 			<h3>登录</h3>
	 		</div>
	 		<div id="message"><c:out value="${message!=null?message:' '}"></c:out></div>
	 		<div id="form">
	 			<% String action = request.getContextPath() + "/admin/login";%>
	 			<sf:form method="post" modelAttribute="admin" action="<%=action %>">
	 				<sf:input id="input1" class="input" path="adminname" placeholder="账号"/>
	 				<sf:password id="input2" class="input" path="password" placeholder="密码"/>
	 				<input id="submit" type="submit" value="登录"/>
	 			</sf:form>
	 		</div>
	 	</div>
	 </div>
</body>
</html>