/**
 * 
 */

$(document).ready(function(){
	var reg = /^[a-zA-Z\u4e00-\u9fa5][a-zA-Z0-9\u4e00-\u9fa5]*$/;
	$("#username").focus(function(){
		$("#username").attr("placeholder","");
	});
	
	$("#username").blur(function(){
		var value = $("#username").val();
		if(value == null || value == ""){
			$("#input_tip1").css("display","none");
			$("#username").attr("placeholder"," 用户名");
		}else if(value.length < 3 || !reg.test(value)){
			$("#input_tip1").css("display","inline");
			$("#input_tip1").html("用户名由3至20个字符或数字组成");
		}else {
			$("#input_tip1").css("display","none");
		}
	});
	
	$("#password").focus(function(){
		$("#password").attr("placeholder","");
	});
	
	$("#password").blur(function(){
		var value = $("#password").val();
		if(value == null || value == ""){
			$("#input_tip2").css("display","none");
			$("#password").attr("placeholder"," 密码");
		}else if(value.length < 3 || !reg.test(value)){
			$("#input_tip2").css("display","inline");
			$("#input_tip2").html("密码至少是三位");
		}else {
			$("#input_tip2").css("display","none");
		}
	});
	
	
	$("#inputCode").focus(function(){
		$("#inputCode").attr("placeholder","");
	});
	
	$("#inputCode").blur(function(){
		var value = code1;
		if(value != null && value != ""){
			$("#input_tip3").css("display","none");
		}else {
			$("#inputCode").attr("placeholder"," 验证码");
			$("#input_tip3").css("display","none");
		}
	});
	
});

var reg1 = /^[a-zA-Z\u4e00-\u9fa5][a-zA-Z0-9\u4e00-\u9fa5]*$/;
function validate_required1(field){
	document.getElementById("input_tip1").style.display = "none";
	with(field){
		if(value == null || value == ""){
			document.getElementById("input_tip1").style.display = "inline";
			document.getElementById("input_tip1").innerHTML = "请输入用户名";
			return false;
		}else if(value.length < 3 || !reg1.test(value)){
			document.getElementById("input_tip1").style.display = "inline";
			document.getElementById("input_tip1").innerHTML = "用户名由3至20个字符或数字组成";
			return false;
		}else {
			document.getElementById("input_tip1").style.display = "none";
			return true;
		}
	}
};

function validate_required2(field){
	document.getElementById("input_tip2").style.display = "none";
	with(field){
		if(value == null || value == ""){
			document.getElementById("input_tip2").style.display = "inline";
			document.getElementById("input_tip2").innerHTML = "请输入密码";
			return false;
		}else if(value.length < 3 || !reg1.test(value)){
			document.getElementById("input_tip2").style.display = "inline";
			document.getElementById("input_tip2").innerHTML = "密码至少是三位";
			return false;
		}else {
			document.getElementById("input_tip2").style.display = "none";
			return true;
		}
	}
};

function validate_required3(){
	document.getElementById("input_tip3").style.display = "none";
	var value = code1;
	//alert(code1);
	if(value == null || value == ""){
		document.getElementById("input_tip3").style.display = "inline";
		document.getElementById("input_tip3").innerHTML = "请输入验证码";
		return false;
	}else if(flag == false){
		document.getElementById("input_tip3").style.display = "inline";
		document.getElementById("input_tip3").innerHTML = "验证码错误";
		return false;
	}else {
		document.getElementById("input_tip3").style.display = "none";
		return true;
	}
};

function validate(thisform){
	with(thisform){
		c.init();
		document.getElementById("inputCode").value = "";
		//alert(validate_required1(username));
		//alert(document.getElementById("inputCode").value);
		
		if (validate_required1(username)==false) {
			return false;
		}else if (validate_required2(password)==false){
			return false;
		}else if(validate_required3() == false){
			return false;
		}
	}
}





