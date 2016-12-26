<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page isELIgnored="false" %> 
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/user/findPassword2.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/user/findPassword3.js"></script>
<% String action = request.getContextPath() + "/user/updatePassword";%>
<form  id="form1" action="<%=action %>" method="post" onsubmit="return validate(this)" >
		<input type="hidden" value="${token }" name="token"/>
		<table>
			<tr>
				<td colspan="3">
					<div style="color:red;padding-top:50px;margin-left:100px;">
						<c:out value="${message != null ? message : ''}"></c:out>
					</div>
				</td>
			</tr>
			<tr>
				<td class="input1">密码</td>
				<td class="input2">
					<input type="hidden" name="userid" value="${userid}"/>
					<input id="input_1" type="password" name="password" maxlength="20"/>
				</td>
				<td class="input3"><div class="tip" id="input_tip1"></div></td>
			</tr>
			<tr>
				<td class="input1">再次输入密码</td>
				<td class="input2">
					<input id="input_2" type="password"  name="password1" maxlength="20"/>
				</td>
				<td class="input3"><div class="tip" id="input_tip3"></div></td>
			</tr>
			<tr>
				<td class="input1">验证码</td>
				<td class="input2">
					<input id="inputCode" type="text" maxlength="4"/>
		        	<span style="font-size:14px;" id="code" class="mycode"></span>
					<a style="margin-left:8px" href="#?" onclick="refresh()">换一张</a>
				</td>
				<td class="input3"><div class="tip" id="input_tip2"></div></td>
			</tr>
			<tr>
				<td colspan="3"><input id="submit" type="submit" value="提交" /></td>
			</tr>
		</table>
</form>