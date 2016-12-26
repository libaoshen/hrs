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
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/common/icon/style.css" />
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/user/findPassword.css" />
	
	<script src="<%=request.getContextPath()%>/js/common/jquery-1.8.3.js"></script>
	<script src="<%=request.getContextPath()%>/js/common/js.KinerCode.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/user/findPassword.js"></script>
	
<title>忘记密码</title>
</head>
<body>
	<div id="whole">
		<input type="hidden" id="pageInfo" value="${pageInfo}"/>
		<div id="top">
			<tiles:insertAttribute name="top"/>
		</div>
		<div id="content">
			<tiles:insertAttribute name="content"/>
		</div>
	</div>
</body>
<script type="text/javascript">
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