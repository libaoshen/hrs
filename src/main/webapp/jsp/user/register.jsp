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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-9">
	<meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1">
	<title>注册新用户</title>
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/user/register.css" />
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/common/icon/style.css" />
	<script src="<%=request.getContextPath()%>/js/common/js.KinerCode.js"></script>
	<script src="<%=request.getContextPath()%>/js/common/jquery-1.8.3.js"></script>
	<script src="<%=request.getContextPath()%>/js/user/register.js"></script>
</head>
<body>
	<div id="whole">
		<div id="top">
			<a href="<%=request.getContextPath()%>/">
				<img alt="logo" src="<%=request.getContextPath() %>/images/common/logo.png"/>
			</a>
		</div>
		<div id="form">
			<fieldset>
				<legend>新用户注册</legend>
				<div>
					<table>
						<tr>
							<td colspan="2" id="tip">已有账号,<a href="<%=request.getContextPath() %>/user/showLogin">直接登录</a></td>
							
						</tr>
						<tr>
							<td style="color:red;font-size:20px;">${message}</td>
						</tr>
						<% String action = request.getContextPath() + "/user/register"; %>
						<sf:form id="form" method="post" action="<%=action %>" modelAttribute="user" onsubmit="return validate_form(this)">
							<tr>
								<td colspan="2"><input type="hidden" name="token" value="${token}" /></td>
							</tr>
							<tr>
								<td class="info"><span style="color:red;font-size:18px;">*</span>用户名:</td>
								<td>
									<sf:input id="username" class="input" path="username" maxlength="20"></sf:input>
									<span class="tip1" id="username1">由3到20个字符或数字组成</span>
									<span class="tip1" id="username2">用户名不能为空</span>
									<span class="tip1" id="username3">由3到20个字符或数字组成,请重新输入</span>
									<span id="username4" class="icon" aria-hidden="true" data-icon="&#xe052;" style="color:#00c100;font-size:20px;vertical-align:middle;"></span>
								</td>
							</tr>
							<tr>
								<td class="info"><span style="color:red;font-size:18px;">*</span>密码:</td>
								<td>
									<sf:password id="password" class="input" path="password" maxlength="20" ></sf:password>
									<span class="tip1" id="password1">由3到20个字符或数字组成</span>
									<span class="tip1" id="password2">密码不能为空</span>
									<span class="tip1" id="password3">由3到20个字符或数字组成,请重新输入</span>
									<span id="password4" class="icon" aria-hidden="true" data-icon="&#xe052;" style="color:#00c100;font-size:20px;vertical-align:middle;"></span>
								</td>
							</tr>
							<tr>
								<td class="info"><span style="color:red;font-size:18px;">*</span>再次输入密码:</td>
								<td>
									<input class="input" id="password01" type="password" name="password01" maxlength="20"/>
									<span class="tip1" id="password11">请再次输入密码</span>
									<span class="tip1" id="password12">再次输入的密码不能为空</span>
									<span class="tip1" id="password13">由3到20个字符或数字组成,请重新输入</span>
									<span class="tip1" id="password14">两次密码输入不一致,请重新输入</span>
									<span id="password15" class="icon" aria-hidden="true" data-icon="&#xe052;" style="color:#00c100;font-size:20px;vertical-align:middle;"></span>
								</td>
							</tr>
							<tr>
								<td class="info"><span style="color:red;font-size:18px;">*</span>性别:</td>
								<td>
									<sf:radiobutton id="radiosex" path="sex" value="false"/> 男 
									<sf:radiobutton path="sex" value="true"/> 女
								</td>
							</tr>
							<tr>
								<td class="info"><span style="color:red;font-size:18px;">*</span>手机号码:</td>
								<td>
									<sf:input id="phone" class="input" path="phone" maxlength="11"></sf:input>
									<span class="tip1" id="phone1">请输入手机号码</span>
									<span class="tip1" id="phone2">手机号码不能为空</span>
									<span class="tip1" id="phone3">无效手机号码,请重新输入手机号码</span>
									<span id="phone4" class="icon" aria-hidden="true" data-icon="&#xe052;" style="color:#00c100;font-size:20px;vertical-align:middle;"></span>
								</td>
							</tr>
							<tr>
								<td class="info"><span style="color:red;font-size:18px;">*</span>输入验证码:</td>
								<td>
									<input id="inputCode" type="text" style="height:25px;" maxlength="4"/>
	        						<span id="code" class="mycode"></span>
	        						<a href="#?" onclick="refresh()" style="margin-left:5px;">换一张</a>
	        						<span class="tip1" id="code1" display="none">验证码不正确</span>
	        						<span id="code2" class="icon" aria-hidden="true" data-icon="&#xe052;" style="color:#00c100;font-size:20px;vertical-align:middle;"></span>
								</td>
							</tr>
							<tr>
								<td colspan="2"><input id="submit" type="submit" value="注册"/></td>
							</tr>
						</sf:form>
					</table>
				</div>
			</fieldset>
		</div>
	</div>
</body>
<script>
		var inp = document.getElementById('inputCode');
	    var code = document.getElementById('code');
		var flag = false;
	    
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
	                $("#code2").css("display","inline");
	            }else{
	            	$("#code1").css("display","inline");
					flag = false;
	                //if(this.opt.question){
	                    //alert('验证失败:'+code.answer);
	                //}else{
	                    //alert('验证失败:'+code.strCode);
	                    //alert('验证失败:' + code.arrCode);
	                //}
	            }
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
	    	$("#inputCode").focus(function(){
	    		$("#code1").css("display","none");
	    	});
	    });
</script>
</html>