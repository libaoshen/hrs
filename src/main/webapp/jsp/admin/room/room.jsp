<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page isELIgnored="false" %> 
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jqPaginator.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/admin/room.js"></script>
<style>
	/*分页*/
	#pagination {
		float:right;
	}
	#addRoom_form .room_2 input, #addRoom_form .room_2 textarea {
		border-radius:2px;
	}
</style>


<div id="showRoom">
	<input id="room_hidden" type="hidden" value="${feedback_addroom}" />
	<input id="roomcounts_hidden" type="hidden" value="${roomcounts}" />
	<input id="roompages_hidden" type="hidden" value="${roompages}" />
	<div id="addRoom" style="color:">
		请点击添加房型信息
		<span class="addRoomButton" data-icon="&#x50;" title="添加房型信息" onclick="showWindow()"></span>
	</div>
	
	<div id="result" style="overflow:hidden;"></div>
	<div style="margin-bottom:10px;overflow:hidden;">
		<ul class="pagination" id="pagination"></ul>
	</div>
</div>

