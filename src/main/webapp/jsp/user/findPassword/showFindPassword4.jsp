<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page isELIgnored="false" %> 
<style>
	a {
		text-decoration:none;
		color:#6868ff;
	}
	a:hover {
		color:#f80;
	}
</style>
<div style="font-size:20px;">
	<table style="margin-left:300px;">
			<tr>
				<td colspan="3">
					<div style="color:red;padding-top:50px;margin-left:100px;">
						<c:out value="${a != null ? '' : ''}"></c:out>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<c:out value="${message}"></c:out>
					<a href="<%=request.getContextPath()%>/user/showLogin">返回登录界面</a>
				</td>
			</tr>
	</table>
</div>