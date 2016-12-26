<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page isELIgnored="false" %>
<script src="<%=request.getContextPath()%>/js/common/js.KinerCode.js"></script> 
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/order/showOrderPay.css" />

<div id="content1">
	<div id="up">
		<div id="order_info">
			<div id="order_name">订单详情</div>
			<table id="order">
				<tr>
					<td>订单号</td>
					<td>${order.orderid}</td>
				</tr>
				<tr>
					<td>订单提交时间</td>
					<td>${ordertime}</td>
				</tr>
				<tr>
					<td>订单失效时间</td>
					<td>${deadline}</td>
				</tr>
				<tr>
					<td>订单价格</td>
					<td>${order.totalprice }元</td>
				</tr>
			</table>
			<div id="room_name">用户信息</div>
			<table id="user">
				<tr>
					<td>提交订单用户</td>
					<td>${user.username}</td>
				</tr>
				<tr>
					<td>入住用户信息</td>
					<td>${order.registerinfo}</td>
				</tr>
				<tr>
					<td>联系电话</td>
					<td>${user.phone}</td>
				</tr>
			</table>
			<div id="room_name">房间信息</div>
			<div id="room">
				<div style="float:left;">
					<img src="<%=request.getContextPath()%>/images/room/${room.imginfo}"/>
				</div>
				<table>
					<tr>
						<td>房间</td>
						<td>${room.roomname} - ${room.bedtype} - ${room.hasbroadband == true ? "有宽带" : "无宽带" }</td>
					</tr>
					<tr>
						<td>房间数量</td>
						<td>${order.roomnum}</td>
					</tr>
					<tr>
						<td>房间单价</td>
						<td>${room.roomprice}元</td>
					</tr>
					<tr>
						<td>入离时间</td>
						<td>${startdate} - ${enddate}</td>
					</tr>
					<tr>
						<td>描述信息</td>
						<td>${room.description}</td>
					</tr>
				</table>
			</div>
			
		</div>
		<div style="color:olive;float:right;margin-top:-250px;margin-right:50px;border:2px dotted red;width:100px;text-align: center;">
			需支付金额<br/>￥<span style="color:red;font-size:25px;">${order.totalprice}</span>
		</div>
		<div style="color:olive;float:right;margin-top:-180px;margin-right:50px;font-size:15px;border-top:1px dashed gray;">
			提示:<br>请在<span style="color:red;">30分钟内</span>完成支付,<br/>否则订单将会被取消!
		</div>
	</div>
	<div id="down">
		<div style="width:200px;height:100px;margin:15px auto;padding:20px;font-size:18px;">
			<% String action = request.getContextPath() + "/order/pay";%>
			<form action="<%=action%>" method="post">
				<input type="hidden" name="token" value="${token}"/>
				<input type="hidden" name="orderid" value="${order.orderid}"/>
				<div style="color:olive;">支付方式选择</div>
				<div style="margin-left:20px;margin-top:5px;">
					<input type="radio" name="pay" value="zhifubao" checked="checked"/>支付宝
					<input type="radio" name="pay" value="weixin"/>微信支付<br>
				</div>
				
				<input type="submit" style="background-color:orange;color:white;border:1px solid orange;width:200px;height:40px;font-size:20px;margin-top:10px;" value="支付"/>
			</form>
		</div>
	</div>
</div>