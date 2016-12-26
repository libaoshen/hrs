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
		<legend>修改用户信息</legend>
		<div id="info">
			<% String action = request.getContextPath() + "/user/updateInfo"; %>
			<form action="<%=action%>" method="post" onsubmit="return validate(this)">
				<input name="token" value="${token }" type="hidden"/>
				<table>
					<tr>
						<td>性别</td>
						<td>
							<input type="radio" name="sex" value="false" checked="checked"/>男
							<input type="radio" name="sex" value="true"/>女
						</td>				
					</tr>
					<tr>
						<td>电话</td>
						<td><input id="phone" type="text" name="phone"/><span id="phone_info" style="font-size:12px;"></span></td>
					</tr>
					<tr>
						<td colspan="2" style="border-bottom: none;"><input onmouseout="{this.style.backgroundColor = 'orange'}" onmousemove="{this.style.backgroundColor = '#e89700';this.style.cursor='pointer'}" style="width:100px;height:50px;background-color: orange;border: 1px solid orange;color:white;font-size: 20px;" type="submit" value="修改"/></td>
					</tr>
				</table>
			</form>
			
			<div id="help">
				<div style="color:olive;">快速通道</div>
				<ul>
					<li><a href="http://localhost:8080/hrs/user/showFindPassword">修改密码</a></li>
					<li><a href="<%=request.getContextPath()%>/user/showUpdateInfo">修改用户信息</a></li>
					<li><a href="<%=request.getContextPath()%>/order/showUserOrder">查看我的订单</a></li>
				</ul>
			</div>
		</div>
	</fieldset>
</div>
<script>
	function validate(thisform) {
		var value = document.getElementById("phone").value;
		var reg = /^1[34578]\d{9}$/;
		if(value == "" || value == null) {
			document.getElementById("phone_info").innerHTML = "手机号码不能为空";
			document.getElementById("phone_info").style.color = "red"; 
			return false;
		}else if(!reg.test(value)) {
			document.getElementById("phone_info").innerHTML = "无效的手机号码";
			document.getElementById("phone_info").style.color = "red"; 
			return false;
		}
		return true;
	};
</script>

