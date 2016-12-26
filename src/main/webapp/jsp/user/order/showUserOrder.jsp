<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page isELIgnored="false" %> 
<script src="<%=request.getContextPath()%>/js/common/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/order/showUserOrder.css" />
<script src="<%=request.getContextPath()%>/js/order/showUserOrder.js"></script>

<div id="body"> 
	<div id="outer">
	    <ul id="tab">
			<li class="current">今日</li>
			<li>未支付</li>
			<li>全部</li>
			<li>已支付</li>
			<li>已失效</li>
		</ul>
	    <div id="content1">
	        <ul style="display:block;" id="first1">
	        	<c:forEach items="${orderList}" var="order" varStatus="i">
	        		<c:choose>
	        			<c:when test="${today == dateList[i.index][5]}">
	        				<div class="order">
			        			<div class="order_numtime">
			        				<div class="order_num">
			        					订单编号:${order.orderid }
			        				</div>
			        				<div class="order_time">
			        					下单时间:${dateList[i.index][0] }
			        				</div>
			        			</div>
			        			<div class="order_properties">
			        				<div class="order_roominfo">
			        					<div class="room_img">
			        						<img src="<%=request.getContextPath()%>/images/room/${roomList[i.index].imginfo}"/>
			        					</div>
			        					<div class="room_info">
			        						<div class="room_name">
			        							${roomList[i.index].roomname }
			        						</div>
			        						<div class="bed_type">
			        							${roomList[i.index].bedtype } - ￥${roomList[i.index].roomprice }
			        						</div>
			        						<div class="description">
			        							${roomList[i.index].description }
			        						</div>
			        					</div>
			        					<div class="user">
			        						入住信息:<br/>
			        						${order.registerinfo}
			        					</div>
			        					<div class="room_numprice">
			        						房间数量:<br>
			        						${order.roomnum }<br>
			        						订单支付价格:<br>
			        						￥${order.totalprice }
			        					</div>
			        				</div>
			        				<div class="order_state">
			        					<c:choose>
			        						<c:when test="${order.orderstate == '已支付'}">
			        							已支付
			        						</c:when>
			        						<c:when test="${order.orderstate == '已失效'}">
			        							已失效
			        						</c:when>
			        						<c:otherwise>
			        							<a onmouseover="change1(this)" onmouseout="change2(this)" style="color:white;" href="<%=request.getContextPath()%>/order/showOrderPay?orderid=${order.orderid}">支付</a>
			        						</c:otherwise>
			        					</c:choose>
			        				</div>
			        			</div>
			        			<div class="order_paydeadtime">
			        				<div class="order_time1">
			        					入离时间:${dateList[i.index][3] } - ${dateList[i.index][4] }
			        				</div>
			        				<c:choose>
			        					<c:when test="${order.orderstate == '已支付'}"> 
					        				<div class="order_paytime">
					        					支付时间:${dateList[i.index][2] }
					        				</div>
				        				</c:when>
				        				<c:when test="${order.orderstate == '已失效'}">
				        						失效时间:${dateList[i.index][1] }
				        				</c:when>
				        				<c:otherwise>
				        					<div class="order_deadline">
				        						失效时间:${dateList[i.index][1] }
				        					</div>
				        				</c:otherwise>
			        				</c:choose>
			        					
			        			</div>
			        		</div>
	        			</c:when>
	        		</c:choose>
	        		
	        	</c:forEach>
	        </ul>
	        <ul id="second1">
	        	<c:forEach items="${orderList}" var="order" varStatus="i">
	        		<c:choose>
	        			<c:when test="${order.orderstate == '未支付' }">
	        				<div class="order">
			        			<div class="order_numtime">
			        				<div class="order_num">
			        					订单编号:${order.orderid }
			        				</div>
			        				<div class="order_time">
			        					下单时间:${dateList[i.index][0] }
			        				</div>
			        			</div>
			        			<div class="order_properties">
			        				<div class="order_roominfo">
			        					<div class="room_img">
			        						<img src="<%=request.getContextPath()%>/images/room/${roomList[i.index].imginfo}"/>
			        					</div>
			        					<div class="room_info">
			        						<div class="room_name">
			        							${roomList[i.index].roomname }
			        						</div>
			        						<div class="bed_type">
			        							${roomList[i.index].bedtype } - ￥${roomList[i.index].roomprice }
			        						</div>
			        						<div class="description">
			        							${roomList[i.index].description }
			        						</div>
			        					</div>
			        					<div class="user">
			        						入住信息:<br/>
			        						${order.registerinfo}
			        					</div>
			        					<div class="room_numprice">
			        						房间数量:<br>
			        						${order.roomnum }<br>
			        						订单支付价格:<br>
			        						￥${order.totalprice }
			        					</div>
			        				</div>
			        				<div class="order_state">
			        					<c:choose>
			        						<c:when test="${order.orderstate == '已支付'}">
			        							已支付
			        						</c:when>
			        						<c:when test="${order.orderstate == '已失效'}">
			        							已失效
			        						</c:when>
			        						<c:otherwise>
			        							<a onmouseover="change1(this)" onmouseout="change2(this)" style="color:white;" href="<%=request.getContextPath()%>/order/showOrderPay?orderid=${order.orderid}">支付</a>
			        						</c:otherwise>
			        					</c:choose>
			        				</div>
			        			</div>
			        			<div class="order_paydeadtime">
			        				<div class="order_time1">
			        					入离时间:${dateList[i.index][3] } - ${dateList[i.index][4] }
			        				</div>
			        				<c:choose>
			        					<c:when test="${order.orderstate == '已支付'}"> 
					        				<div class="order_paytime">
					        					支付时间:${dateList[i.index][2] }
					        				</div>
				        				</c:when>
				        				<c:when test="${order.orderstate == '已失效'}">
				        						失效时间:${dateList[i.index][1] }
				        				</c:when>
				        				<c:otherwise>
				        					<div class="order_deadline">
				        						失效时间:${dateList[i.index][1] }
				        					</div>
				        				</c:otherwise>
			        				</c:choose>
			        					
			        			</div>
			        		</div>
	        			</c:when>
	        		</c:choose>
	        		
	        	</c:forEach>
	        </ul>
	        <ul id="third1">
	        	<c:forEach items="${orderList}" var="order" varStatus="i">
	        		<div class="order">
	        			<div class="order_numtime">
	        				<div class="order_num">
	        					订单编号:${order.orderid }
	        				</div>
	        				<div class="order_time">
	        					下单时间:${dateList[i.index][0] }
	        				</div>
	        			</div>
	        			<div class="order_properties">
	        				<div class="order_roominfo">
	        					<div class="room_img">
	        						<img src="<%=request.getContextPath()%>/images/room/${roomList[i.index].imginfo}"/>
	        					</div>
	        					<div class="room_info">
	        						<div class="room_name">
	        							${roomList[i.index].roomname }
	        						</div>
	        						<div class="bed_type">
	        							${roomList[i.index].bedtype } - ￥${roomList[i.index].roomprice }
	        						</div>
	        						<div class="description">
	        							${roomList[i.index].description }
	        						</div>
	        					</div>
	        					<div class="user">
	        						入住信息:<br/>
	        						${order.registerinfo}
	        					</div>
	        					<div class="room_numprice">
	        						房间数量:<br>
	        						${order.roomnum }<br>
	        						订单支付价格:<br>
	        						￥${order.totalprice }
	        					</div>
	        				</div>
	        				<div class="order_state">
	        					<c:choose>
	        						<c:when test="${order.orderstate == '已支付'}">
	        							已支付
	        						</c:when>
	        						<c:when test="${order.orderstate == '已失效'}">
	        							已失效
	        						</c:when>
	        						<c:otherwise>
	        							<a onmouseover="change1(this)" onmouseout="change2(this)" style="color:white;" href="<%=request.getContextPath()%>/order/showOrderPay?orderid=${order.orderid}">支付</a>
	        						</c:otherwise>
	        					</c:choose>
	        				</div>
	        			</div>
	        			<div class="order_paydeadtime">
	        				<div class="order_time1">
	        					入离时间:${dateList[i.index][3] } - ${dateList[i.index][4] }
	        				</div>
	        				<c:choose>
	        					<c:when test="${order.orderstate == '已支付'}"> 
			        				<div class="order_paytime">
			        					支付时间:${dateList[i.index][2] }
			        				</div>
		        				</c:when>
		        				<c:when test="${order.orderstate == '已失效'}">
		        						失效时间:${dateList[i.index][1] }
		        				</c:when>
		        				<c:otherwise>
		        					<div class="order_deadline">
		        						失效时间:${dateList[i.index][1] }
		        					</div>
		        				</c:otherwise>
	        				</c:choose>
	        					
	        			</div>
	        		</div>
	        	</c:forEach>
	        </ul>
			<ul id="fourth1">
				<c:forEach items="${orderList}" var="order" varStatus="i">
	        		<c:choose>
	        			<c:when test="${order.orderstate == '已支付' }">
	        				<div class="order">
			        			<div class="order_numtime">
			        				<div class="order_num">
			        					订单编号:${order.orderid }
			        				</div>
			        				<div class="order_time">
			        					下单时间:${dateList[i.index][0] }
			        				</div>
			        			</div>
			        			<div class="order_properties">
			        				<div class="order_roominfo">
			        					<div class="room_img">
			        						<img src="<%=request.getContextPath()%>/images/room/${roomList[i.index].imginfo}"/>
			        					</div>
			        					<div class="room_info">
			        						<div class="room_name">
			        							${roomList[i.index].roomname }
			        						</div>
			        						<div class="bed_type">
			        							${roomList[i.index].bedtype } - ￥${roomList[i.index].roomprice }
			        						</div>
			        						<div class="description">
			        							${roomList[i.index].description }
			        						</div>
			        					</div>
			        					<div class="user">
			        						入住信息:<br/>
			        						${order.registerinfo}
			        					</div>
			        					<div class="room_numprice">
			        						房间数量:<br>
			        						${order.roomnum }<br>
			        						订单支付价格:<br>
			        						￥${order.totalprice }
			        					</div>
			        				</div>
			        				<div class="order_state">
			        					<c:choose>
			        						<c:when test="${order.orderstate == '已支付'}">
			        							已支付
			        						</c:when>
			        						<c:when test="${order.orderstate == '已失效'}">
			        							已失效
			        						</c:when>
			        						<c:otherwise>
			        							<a onmouseover="change1(this)" onmouseout="change2(this)" style="color:white;" href="<%=request.getContextPath()%>/order/showOrderPay?orderid=${order.orderid}">支付</a>
			        						</c:otherwise>
			        					</c:choose>
			        				</div>
			        			</div>
			        			<div class="order_paydeadtime">
			        				<div class="order_time1">
			        					入离时间:${dateList[i.index][3] } - ${dateList[i.index][4] }
			        				</div>
			        				<c:choose>
			        					<c:when test="${order.orderstate == '已支付'}"> 
					        				<div class="order_paytime">
					        					支付时间:${dateList[i.index][2] }
					        				</div>
				        				</c:when>
				        				<c:when test="${order.orderstate == '已失效'}">
				        						失效时间:${dateList[i.index][1] }
				        				</c:when>
				        				<c:otherwise>
				        					<div class="order_deadline">
				        						失效时间:${dateList[i.index][1] }
				        					</div>
				        				</c:otherwise>
			        				</c:choose>
			        					
			        			</div>
			        		</div>
	        			</c:when>
	        		</c:choose>
	        		
	        	</c:forEach>
			</ul>
			<ul id="fifth1">
				<c:forEach items="${orderList}" var="order" varStatus="i">
	        		<c:choose>
	        			<c:when test="${order.orderstate == '已失效' }">
	        				<div class="order">
			        			<div class="order_numtime">
			        				<div class="order_num">
			        					订单编号:${order.orderid }
			        				</div>
			        				<div class="order_time">
			        					下单时间:${dateList[i.index][0] }
			        				</div>
			        			</div>
			        			<div class="order_properties">
			        				<div class="order_roominfo">
			        					<div class="room_img">
			        						<img src="<%=request.getContextPath()%>/images/room/${roomList[i.index].imginfo}"/>
			        					</div>
			        					<div class="room_info">
			        						<div class="room_name">
			        							${roomList[i.index].roomname }
			        						</div>
			        						<div class="bed_type">
			        							${roomList[i.index].bedtype } - ￥${roomList[i.index].roomprice }
			        						</div>
			        						<div class="description">
			        							${roomList[i.index].description }
			        						</div>
			        					</div>
			        					<div class="user">
			        						入住信息:<br/>
			        						${order.registerinfo}
			        					</div>
			        					<div class="room_numprice">
			        						房间数量:<br>
			        						${order.roomnum }<br>
			        						订单支付价格:<br>
			        						￥${order.totalprice }
			        					</div>
			        				</div>
			        				<div class="order_state">
			        					<c:choose>
			        						<c:when test="${order.orderstate == '已支付'}">
			        							已支付
			        						</c:when>
			        						<c:when test="${order.orderstate == '已失效'}">
			        							已失效
			        						</c:when>
			        						<c:otherwise>
			        							<a onmouseover="change1(this)" onmouseout="change2(this)" style="color:white;" href="<%=request.getContextPath()%>/order/showOrderPay?orderid=${order.orderid}">支付</a>
			        						</c:otherwise>
			        					</c:choose>
			        				</div>
			        			</div>
			        			<div class="order_paydeadtime">
			        				<div class="order_time1">
			        					入离时间:${dateList[i.index][3] } - ${dateList[i.index][4] }
			        				</div>
			        				<c:choose>
			        					<c:when test="${order.orderstate == '已支付'}"> 
					        				<div class="order_paytime">
					        					支付时间:${dateList[i.index][2] }
					        				</div>
				        				</c:when>
				        				<c:when test="${order.orderstate == '已失效'}">
				        						失效时间:${dateList[i.index][1] }
				        				</c:when>
				        				<c:otherwise>
				        					<div class="order_deadline">
				        						失效时间:${dateList[i.index][1] }
				        					</div>
				        				</c:otherwise>
			        				</c:choose>
			        					
			        			</div>
			        		</div>
	        			</c:when>
	        		</c:choose>
	        		
	        	</c:forEach>
			</ul>
	    </div>
	</div>
</div>
<script>
var str1=document.getElementById("first1").innerHTML;
var str2=document.getElementById("second1").innerHTML;
var str3=document.getElementById("third1").innerHTML;
var str4=document.getElementById("fourth1").innerHTML;
var str5=document.getElementById("fifth1").innerHTML;

if(trim(str1).length == 0) {
	document.getElementById("first1").innerText = "还没有今日订单,快去下单吧~";
}
if(trim(str2).length == 0) {
	document.getElementById("second1").innerText = "还没有未支付订单,快去下单吧~";
}
if(trim(str3).length == 0) {
	document.getElementById("third1").innerText = "还没有订单记录,快去下单吧~";
}
if(trim(str4).length == 0) {
	document.getElementById("fourth1").innerText = "还没有已支付订单,快去下单吧~";
}
if(trim(str5).length == 0) {
	document.getElementById("fifth1").innerText = "还没有失效订单,快去下单吧~";
}

function trim(str){ //删除左右两端的空格
    return str.replace(/(^\s*)|(\s*$)/g, "");
}
</script>


