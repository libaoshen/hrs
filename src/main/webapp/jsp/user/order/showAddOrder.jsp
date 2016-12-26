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
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/order/showAddOrder.css" />
<div id="content1">
	<div id="left">
		<div>
			<ul>
				<li>
					<div id="img"><img style="width:280px;height:160px;" src="<%=request.getContextPath()%>/images/room/${room.imginfo}" /></div>
					<div id="name">
						${room.roomname} - ${room.bedtype} - ${room.hasbroadband == true ? '有宽带' : '没有宽带'}
					</div>
				</li>
			</ul>
			<div id="description">
				<c:forEach items="${fn:split(room.description,';|s+') }" var="item">
					${item}<br/>
				</c:forEach> 
			</div>
		</div>
	</div>
	
	<div id="right">
		<% String action = request.getContextPath() + "/order/addOrder";%>
		<form action="<%=action%>" method="post" onsubmit="return validate(this)"> 
			<div id="right1">
				<input type="hidden" name="token" value="${token}" />
				<input id="days" name="days" type="hidden" value="${days}"/>
				<input id="roomleftnum" type="hidden" value="${room.roomleftnum}"/>
				<input id="roomprice" type="hidden" value="${room.roomprice}"/>
				<input name="roomid" type="hidden" value="${room.roomid}"/>
				<input id="roomtotalprice1" name="roomtotalprice" type="hidden" value=""/>
				<input name="startdate" type="hidden" value="${startdate }"/>
				<input name="enddate" type="hidden" value="${enddate }"/>
				<span class="title_info">预订信息</span>
				<table>
					<tr>
						<td>入离日期</td>
						<td>${fn:replace(startdate,'/','-')} 到  ${fn:replace(enddate,'/','-')}(共${days}天)
							<a href="#" onclick="showWindow()">修改日期</a>
						</td>
					</tr>
					<tr>
						<td>房间数量</td>
						<td>
							<input type="text" style="width:30px;" name="roomnumber" id="spinner" min="1" max="${room.roomleftnum > 10 ? 10 : room.roomleftnum }" >
							<sapn style="margin-left:5px;" id="roomnuminfo"></sapn>
						</td>
					</tr>
					<tr>
						<td>房费总计</td>
						<td><label class="totalprice"></label> </td>
					</tr>
				</table>
			</div>
			<div id="right2">
				<span class="title_info">入住信息</span>
				<table>
					<tr>
						<td class="td1">房间1</td>
						<td><input class="td2" name="room1" type="text" placeholder="姓名,一间房只需填写一位" id="name1" onclick="{document.getElementById('name_1').innerText='';}"/><span id="name_1"></span></td>
					</tr>
					<tr id='first'>
						<td class="td1">验证电话</td>
						<td>
							<input class="td2" type="text" name="phone" id="phone" onclick="{document.getElementById('phone1').innerText='';}" /><span id="phone1" style="color:red;">${message}</span>
						</td>
					</tr>
					<tr>
						<td class="td1">验证码</td>
						<td>
							<input class="td2" style="width:80px;" id="inputCode" type="text" maxlength="4" onclick="{document.getElementById('yzm1').innerText='';}"/>
				        	<span style="font-size:14px;" id="code" class="mycode"></span>
							<a id="yanzhengma" style="margin-left:8px" href="#?" onclick="refresh()">换一张</a>
							<span id="yzm1"></span>
						</td>
					</tr>
				</table>
			</div>
			<div style="width:700px;margin:5px auto;font-size:15px;color:#555;">
				如需发票,请到前台领取。
			</div>
			<div id="right33">	
				<div id="right3">
					<div id="right3_info">	
						<span>预订须知</span>
						<ul>
							<li>订单提交后需要在线支付房费 <label class="totalprice"></label>，如未预订成功，房费全部原路退还</li>
							<li>订单一经预订成功不可变更/取消，如未入住已支付房费不予退还</li>
							<li>退还金额境内卡5个工作日内到账，境外卡20个工作日内到账</li>
						</ul>
					</div>
					<div id="submit">
					
					</div>
				</div>
				<div id="right4">
					<ul>
						<li style="float:left;">在线支付房费<label class="totalprice"></label></li>
						<li style="margin-right:10px;">
							<input id="submit" type="submit" value="支付房费">
						</li>
					</ul>
				</div>
				<div id="rechoose">
					<a href="<%=request.getContextPath()%>/"><span class="fs1" aria-hidden="true" data-icon="&#x44;"></span>重新选择房型信息</a>
				</div>
			</div>
			
		</form>
		
	</div>
</div>
<div id="tanchu_back"></div>
<div id="tanchu_updateTime">
		<div style="background-color: #e0e0e0;">
			<span class="close" title="关闭" data-icon="&#x4d;" onclick="closeWindow()"></span>
			<span style="margin-top:-50px;padding:0px;">修改日期</span>
		</div>
		<div id="tip" style="margin-bottom:50px;">
			<jsp:include page="/jsp/user/common/time1.jsp"></jsp:include>
			<div id="ok" style="width:200px;margin:5px auto;">
				<input style="width:200px;height:30px;background-color: orange;border:1px solid orange;" type="button" value="确定" onclick="ok(${room.roomid})"/>
			</div>
		</div>
</div>

<script>
var inp = document.getElementById('inputCode');
var code = document.getElementById('code');
var flag = false;
var code1 = "";

var c = new KinerCode({
    len: 4,//需要产生的验证码长度
//        chars: ["1+2","3+15","6*8","8/4","22-15"],//问题模式:指定产生验证码的词典，若不给或数组长度为0则试用默认字典
    chars: [
        1, 2, 3, 4, 5, 6, 7, 8, 9, 0,
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    ],//经典模式:指定产生验证码的词典，若不给或数组长度为0则试用默认字典
    question:false,//若给定词典为算数题，则此项必须选择true,程序将自动计算出结果进行校验【若选择此项，则可不配置len属性】,若选择经典模式，必须选择false
    copy: false,//是否允许复制产生的验证码
    bgColor:"#ffffff",//背景颜色[与背景图任选其一设置]
    bgImg:"",//若选择背景图片，则背景颜色失效
    randomBg : false,//若选true则采用随机背景颜色，此时设置的bgImg和bgColor将失效
    inputArea: inp,//输入验证码的input对象绑定【 HTMLInputElement 】
    codeArea: code,//验证码放置的区域【HTMLDivElement 】
    click2refresh:true,//是否点击验证码刷新验证码
    false2refresh:true,//在填错验证码后是否刷新验证码
    validateEven : "change",//触发验证的方法名，如click，blur等
    validateFn : function(result,code){//验证回调函数
        if(result){
            //alert('验证成功');
            flag = true;
        }else{

            //if(this.opt.question){
                //alert('验证失败:'+code.answer);
            //}else{
                //alert('验证失败:'+code.strCode);
                //alert('验证失败:' + code.arrCode);
            //}
        }
    
    	code1 = this.opt.inputArea.value;
    }
});

function refresh(){
	c.init();
}
</script>