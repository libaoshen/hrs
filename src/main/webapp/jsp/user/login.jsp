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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1">
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/user/login.css"/>
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/common/icon/style.css" />
	<title>用户登录</title>
	<script src="<%=request.getContextPath()%>/js/common/jquery-1.8.3.js"></script>
	<script src="<%=request.getContextPath()%>/js/common/js.KinerCode.js"></script>
	<script src="<%=request.getContextPath()%>/js/user/login.js"></script>
</head>
<body>
	<div id="whole">
		<div id="top">
			<table id="firsttable" cellpadding="0" cellspacing="0">
				<tr>
					<td><a href="<%=request.getContextPath()%>/"><img src="<%=request.getContextPath() %>/images/common/logo.png" alt="logo"/></a></td>
					<td><h1>用户登录</h1></td>
				</tr>
			</table>
		</div>
		<div id="middle">
			<div id="poster" style="width:620px;" >
				<img style="width:620px;height:350px;" src="<%=request.getContextPath() %>/images/user/login.jpg" alt="logo"/>
			</div>
			<div id="login">
					<% String action = request.getContextPath() + "/user/login";%>
					<sf:form id="form" method="post" action="<%=action%>" modelAttribute="user" onsubmit="return validate(this)">
						<table>
							<tr>
								<td>
									<div class="input">
										<sf:input path="username" id="username" placeholder=" 用户名" maxlength="20"/>
										<div class="icon" aria-hidden="true" data-icon="&#xe08a;"></div>
										<div class="tip" id="input_tip1"></div>
										<div style="color:red;padding:2px;"><c:out value="${message != null ? message:''}"></c:out></div>
									</div>
								</td>
							<tr>
							<tr>
								<td>
									<div class="input">
										<sf:password path="password" id="password" placeholder=" 密码" maxlength="20"/>
										<div class="icon" aria-hidden="true" data-icon="&#xe06d;"></div>
										<div class="tip" id="input_tip2"></div>
										
									</div>
								</td>
							<tr>
							<tr>
								<td>
									<div id="input1">
										<input id="inputCode" type="text" placeholder=" 验证码" maxlength="4"/>
	        							<span style="font-size:14px;" id="code" class="mycode"></span>
										<a style="margin-left:8px" href="#?" onclick="refresh()">换一张</a>
										<div class="tip" id="input_tip3"></div>
									</div>
								</td>
							<tr>
							<tr>
								<td>
									<div style="margin-top:5px;">
										<a href="<%=request.getContextPath()%>/user/showFindPassword">忘记密码</a>
									</div>
								</td>
							<tr>
							<tr>
								<td style="padding-top:10px;">
									<input id="submit" type="submit" value="登录" />
								</td>
							<tr>
							<tr>
								<td style="padding-top:5px;font-size:15px;height:10px;vertical-align:bottom;">
									<a href="<%=request.getContextPath()%>/user/showRegister" style="float:right;margin-bottom: 2px;line-height:20px;">还没有账号?立即注册<div style="line-height:20px;float:right;display: inline;font-size: 20px;color:#4f7dda;" aria-hidden="true" data-icon="&#xe046;"></div></a>
								</td>
							<tr>
						</table>
					</sf:form>
			</div>
		</div>
		<div id="foot" style="font-size:14px;">
			<p style="text-align: center;">
				<a href="#">关于我们</a>
				|
				<a href="#">联系我们</a>
				|
				<a href="#">广告服务</a>
				
				©2016 LBS, All Rights Reserved. 
			</p>
			
		</div>
	</div>
</body>
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
	    
	    $("document").ready(function(){
	    	$("#submit").mouseover(function(){
	    		$("#submit").css({"background-color":"#ea7b00","cursor":"pointer"});
	    	});
	    	$("#submit").mouseout(function(){
	    		$("#submit").css("background-color","#f80");
	    	});
	    });
</script>
</html>