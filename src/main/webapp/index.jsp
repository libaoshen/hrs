<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page isELIgnored="false" %> 
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/main/index.css"/>
<script src="<%=request.getContextPath()%>/js/common/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/main/index.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common/time/daterangepicker.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common/icon/style.css" />
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/common/time/moment.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/common/time/jquery.daterangepicker.min.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=LPTx5954nw6DAcI3BzB5Bh6iKrTvG97S"></script>
<style type="text/css">
		#allmap{height:700px;width:100%;}
</style>
<div>
	<input id="path" type="hidden" value="<%=request.getContextPath()%>" />
	<div id="menubar1">
		<ul>
			<li id="first1"><a  href="#first">房型信息</a></li>
			<li id="second1"><a  href="#second">酒店信息</a></li>
			<li id="third1"><a  href="#third">交通</a></li>
		</ul>
	</div>
	<div id="menubar2" style="display:none;width:1000px;">
		<ul>
			<li id="first2"><a  href="#first">房型信息</a></li>
			<li id="second2"><a  href="#second">酒店信息</a></li>
			<li id="third2"><a  href="#third">交通</a></li>
			<li style="margin-left:100px;">
				<img src="<%=request.getContextPath()%>/images/common/logo.png"/>
			</li>
			<li style="margin-top:15px;margin-left:20px;overflow:hidden;">
				<h4">欢迎使用酒店预订平台</h4>
			</li>
		</ul>
	</div>
	<div id="time" >
		<jsp:include page="jsp/user/common/time.jsp"></jsp:include>
	</div>
	<div id="roomList">
		<c:choose>
			<c:when test="${roomList != null}">
					<c:forEach items="${roomList}" var="room">
						<div class="room" onmousemove="change1(this)" onmouseout="change2(this)">
							<div class="img">
								<img src="<%=request.getContextPath()%>/images/room/${room.imginfo}" />
							</div>
							<div class="info">
								<div class="info_name">
									<p>${room.roomname}</p>
								</div>
								<div class="info_all">
									<div style="float:left;">${room.bedtype}&nbsp;&nbsp;|</div>
									<div style="float:left;">
										&nbsp;&nbsp;${room.hasbroadband == true ? '有宽带':'	没有宽带'}	|	
									</div>
									<div style="float:left;color:#f9926a;">&nbsp;&nbsp;剩余${room.roomleftnum}间</div>
								</div>
							</div>
							<div class="priceInfo">
								<div class="price">
									<span style="font-size:15px;color:gray;">¥</span>${room.roomprice}
								</div>
								<div class="submitOrder" onclick="submitOrder(${room.roomid})" onmouseover="this.style.backgroundColor ='#fc8603';" onmouseout="this.style.backgroundColor ='orange';">
									<a href="#" >预订</a>
								</div>
							</div>
							<div class="description">
								<span style="color:gray;">具体描述:</span><br/>
								${room.description}
							</div>
						</div>
					</c:forEach>
			</c:when>
			<c:otherwise>
				<div class="room"  onmousemove="change1(this)" onmouseout="change2(this)">
					<p style="font-size:30px;color:red;height:50px;margin:10px auto;text-align: center;vertical-align: middle;">还没有房型信息</p>
				</div>
			</c:otherwise>
		</c:choose>
		
	</div>
	<span id="second" name="second"></span>
	<div style="height:20px;"></div>
	<div id="hotelInfo">
		<div class="h_first">
			<p style="margin-left:5px;">酒店信息</p>
		</div>
		<div id="h_second">
			<ul>
				<li>
					<div class="fs1" aria-hidden="true" data-icon="&#xe09e;"></div>
					<div style="float:left;font-size: 20px;margin-left:25px;">WIFI</div>
				</li>
				<li>
					<div class="fs1" aria-hidden="true" data-icon="&#xe077;"></div>
					<div style="float:left;font-size: 20px;margin-left:25px;">停车场</div>
				</li>
				<li>
					<div class="fs1" aria-hidden="true" data-icon="&#xe103;"></div>
					<div style="float:left;font-size: 20px;margin-left:20px;">商务中心</div>
				</li>
			</ul>
		</div>
		<div id="h_third">
			<ul>
				<li><span style="margin-right:10px;">入离时间</span><span>入住时间:12点以后,离店时间:12点以前</span></li>
				<li><span style="margin-right:10px;">停车场 </span><span>    &nbsp;&nbsp;酒店提供停车位</span></li>
				<li><span style="margin-right:10px;">酒店设施</span><span>免费Wifi、免费停车、商务中心、会议室、医疗支援、叫醒服务、洗衣服务、24小时热水</span></li>
			</ul>
		</div>
	</div>
	<span id="third" name="third"></span>
	<div style="height:20px;"></div>
	<div id="transport">
		<div class="h_first">
			<p style="margin-left:5px;">位置及周边</p>
		</div>
		<div id="allmap"></div>
	</div>
</div>
<script type="text/javascript">
	window.onload = function(){
	    menuFixed('menubar1');
	}
	
	
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	map.centerAndZoom(new BMap.Point(114.441512,30.517017),18);
	//map.enableScrollWheelZoom(true);
	
	
	var icon = new BMap.Icon('<%=request.getContextPath()%>/images/common/pin.png', new BMap.Size(50, 79),{
		anchor: new BMap.Size(40,50),
		infoWindowAnchor: new BMap.Size(10, 0)
	});

	var mkr =new BMap.Marker(new	BMap.Point(114.441512,30.517017), {
    icon: icon
	});
	
	//添加导航
	var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
	var top_left_navigation = new BMap.NavigationControl();  //左上角，添加默认缩放平移控件

	map.addControl(top_left_control);      // 测距离的   
	map.addControl(top_left_navigation);   // 左导航默认  
	//map.addControl(top_right_navigation);  // 右导航平移与缩放 
	

	map.addOverlay(mkr);
</script>

