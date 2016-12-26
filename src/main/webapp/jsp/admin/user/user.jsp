<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page isELIgnored="false" %> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/user/showUser.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jqPaginator.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/admin/user.js"></script>
<style>
	/*分页*/
	#pagination {
		float:right;
		margin-right: 100px;
	}
	#result {
		width:1000px;
		min-height:100px;
		margin: 10px auto;
	}
</style>
<div>
	<input id="usercounts_hidden" type="hidden" value="${usercounts}" />
	<input id="userpages_hidden" type="hidden" value="${userpagesize}" />
	
	<div id="result" style="overflow:hidden;"></div>

	<div>
		<div style="margin-bottom:10px;overflow:hidden;">
			<ul style="display:inline" class="pagination" id="pagination"></ul>
		</div>
	</div>
</div>