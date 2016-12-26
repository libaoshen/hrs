<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page isELIgnored="false" %> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/order/showUserOrder.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jqPaginator.js"></script>
<script src="<%=request.getContextPath()%>/js/admin/order.js"></script>
<script src="<%=request.getContextPath()%>/js/order/showUserOrder.js"></script>

<style>
	/*分页*/
	#pagination1,#pagination2,#pagination3,#pagination4,#pagination5 {
		float:right;
	}
</style>

<div id="body"> 
	<div id="outer" style="width:1100px;">
		<input id="ordercounts_hidden" type="hidden" value="${ordercounts}" />
		<input id="orderpages_hidden" type="hidden" value="${orderpagesize}" />
	    <ul id="tab">
			<li id="first" class="current">全部</li>
			<li id="second">今日</li>
			<li id="third">未支付</li>
			<li id="fourth">已支付</li>
			<li id="fifth">已失效</li>
		</ul>
	    <div id="content1">
	        <ul style="display:block;" id="first1">
	        	<div id="result1" style="overflow:hidden;"></div>
	        	<div>
					<div style="margin-bottom:10px;overflow:hidden;">
						<ul style="display:inline" class="pagination" id="pagination1"></ul>
					</div>
				</div>
	        </ul>
	        <ul id="second1">
	        	<div id="result2" style="overflow:hidden;"></div>
	        	<div>
					<div style="margin-bottom:10px;overflow:hidden;">
						<ul style="display:inline" class="pagination" id="pagination2"></ul>
					</div>
				</div>
	        </ul>
	        <ul id="third1">
	        	<div id="result3" style="overflow:hidden;"></div>
	        	<div>
					<div style="margin-bottom:10px;overflow:hidden;">
						<ul style="display:inline" class="pagination" id="pagination3"></ul>
					</div>
				</div>
	        </ul>
			<ul id="fourth1">
				<div id="result4" style="overflow:hidden;"></div>
	        	<div>
					<div style="margin-bottom:10px;overflow:hidden;">
						<ul style="display:inline" class="pagination" id="pagination4"></ul>
					</div>
				</div>
			</ul>
			<ul id="fifth1">
				<div id="result5" style="overflow:hidden;"></div>
	        	<div>
					<div style="margin-bottom:10px;overflow:hidden;">
						<ul style="display:inline" class="pagination" id="pagination5"></ul>
					</div>
				</div>
			</ul>
	    </div>
	</div>
	
</div>



