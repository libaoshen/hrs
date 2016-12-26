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
	<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1"> 
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>${title}</title>
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/common/icon/style.css"/>
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/admin/main.css"/>
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/admin/room/styles.css"/>
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/common/pagination/pagination.css"/>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jquery-1.8.3.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/admin/main.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/admin/validate.js"></script>
	<script type="text/javascript">
		
	</script>
	<style type="text/css">
		#content #showRoom tr:last-child {
			color: black;
			font-size: 100%;
		} 
	</style>
</head>
<body>
	<input type="hidden" id="contextPath" value="<%=request.getContextPath()%>"/>
	<input type="hidden" id="pageTitle" value="${title}"/>
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
	
	<div id="tanchu_front">
	<div id="whole">
		<div id="close">
			<span>
				<span class="close fs1" title="关闭" data-icon="&#x4d;" onclick="closeWindow_addRoom()"></span>
			</span>
		</div>
		<div id="addRoom_form">
			<% String action1 = request.getContextPath() + "/room/addRoom";%>
			<sf:form modelAttribute="room" method="post" action="<%=action1 %>" onsubmit="return validate_form(this)" enctype="multipart/form-data">
				<table>
					<tr>
						<td colspan="2">新增房型信息</td>
					</tr>
					<tr>
						<td colspan="2" style="color:red;text-align: center;">${message}</td>
					</tr>
					<tr>
						<td class="room_1">房型名</td>
						<td class="room_2">
							<div id="room11" style="color:red;"></div>
							<sf:input path="roomname" id="room21"/>
						</td>
					</tr>
					<tr>
						<td class="room_1">床型</td>
						<td class="room_2">
							<div id="room12" style="color:red;"></div>
							<sf:input path="bedtype" id="room22"/>
						</td>
					</tr>
					<tr>
						<td class="room_1">图片</td>
						<td class="room_2">
							<div id="room13" style="color:red;"></div>
							<input type="file" name="imageInfo" style="border:none;" id="room23" />
						</td>
					</tr>
					<tr>
						<td class="room_1">价格</td>
						<td class="room_2">
							<div id="room14" style="color:red;"></div>
							<sf:input path="roomprice" id="room24"/>
						</td>
					</tr>
					<tr>
						<td class="room_1">数量</td>
						<td class="room_2">
							<div id="room15" style="color:red;"></div>
							<sf:input path="roomtotalnum" id="room25"/>
						</td>
					</tr>
					<tr>
						<td class="room_1">是否有宽带</td>
						<td id="room_radio">
							<sf:radiobutton path="hasbroadband" id="radiobutton1" value="true" label="有" />
							<sf:radiobutton path="hasbroadband" value="false" label="没有" />
						</td>
					</tr>
					<tr>
						<td class="room_1">描述</td>
						<td class="room_2">
							<div id="room16" style="color:red;"></div>
							<sf:textarea path="description" id="room26"></sf:textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" >
							<input type="submit" id="submit" value="增加"/>
						</td>
					</tr>
				</table>
			</sf:form>
		</div>
	</div>
	</div>
	
	<div id="tanchu_front1">
		<div id="close">
			<span>
				<span class="close fs1" title="关闭" data-icon="&#x4d;" onclick="closeWindow_addRoom()"></span>
			</span>
		</div>
		<div id="updateRoom_form">
			<% String action2 = request.getContextPath() + "/room/updateRoom";%>
			<sf:form modelAttribute="room" method="post" action="<%=action2 %>"  enctype="multipart/form-data">
				<table>
					<tr>
						<td colspan="2">修改房型信息</td>
					</tr>
					<tr>
						<td>
							<sf:hidden path="roomid"/>
						</td>
					</tr>
					<tr>
						<td>
							<sf:hidden path="roomleftnum"/>
						</td>
					</tr>
					
					<tr>
						<td colspan="2" style="color:red;text-align: center;">${message1}</td>
					</tr>
					<tr>
						<td class="room_1">房型名</td>
						<td class="room_2">
							<div id="room11" style="color:red;"></div>
							<sf:input path="roomname" id="room21"/>
						</td>
					</tr>
					<tr>
						<td class="room_1">床型</td>
						<td class="room_2">
							<div id="room12" style="color:red;"></div>
							<sf:input path="bedtype" id="room22"/>
						</td>
					</tr>
					<tr>
						<td class="room_1">图片</td>
						<td class="room_2">
							<div id="room13" style="color:red;"></div>
							<input type="file" name="imageInfo1" style="border:none;" id="room23" />
						</td>
					</tr>
					<tr>
						<td class="room_1">价格</td>
						<td class="room_2">
							<div id="room14" style="color:red;"></div>
							<sf:input path="roomprice" id="room24"/>
						</td>
					</tr>
					<tr>
						<td class="room_1">数量</td>
						<td class="room_2">
							<div id="room15" style="color:red;"></div>
							<sf:input path="roomtotalnum" id="room25"/>
						</td>
					</tr>
					<tr>
						<td class="room_1">是否有宽带</td>
						<td id="room_radio">
							<sf:radiobutton path="hasbroadband" id="radiobutton1" value="true" label="有" />
							<sf:radiobutton path="hasbroadband" value="false" label="没有" />
						</td>
					</tr>
					<tr>
						<td class="room_1">描述</td>
						<td class="room_2">
							<div id="room16" style="color:red;"></div>
							<sf:textarea path="description" id="room26"></sf:textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" >
							<input type="submit" id="submit" value="修改"/>
						</td>
					</tr>
				</table>
			</sf:form>
		</div>
	</div>
	
	<div id="tanchu_back"></div>
	<div id="tanchu_addRoom">
		<span class="close" title="关闭" data-icon="&#x4d;" onclick="closeWindow_addRoom()"></span>
		<div id="tip" style="margin-bottom:50px;"><div  data-icon="&#x5a;" style="display:inline-block;margin-right:10px ;"></div>添加成功</div>
	</div>
	<div id="tanchu_deleteRoom">
		<span class="close" title="关闭" data-icon="&#x4d;" onclick="closeWindow_deleteRoom()"></span>
		<div id="tip" style="margin-bottom:50px;"><div  data-icon="&#x5a;" style="display:inline-block;margin-right:10px ;"></div>删除成功</div>
	</div>
	<div id="tanchu_updateRoom">
		<span class="close" title="关闭" data-icon="&#x4d;" onclick="closeWindow_updateRoom()"></span>
		<div id="tip" style="margin-bottom:50px;"><div  data-icon="&#x5a;" style="display:inline-block;margin-right:10px ;"></div>修改成功</div>
	</div>
</body>
<script type="text/javascript">
</script>
</html>