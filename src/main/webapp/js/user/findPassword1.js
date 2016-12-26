/**
 * 
 */
$("document").ready(function(){
	var reg = /^[a-zA-Z\u4e00-\u9fa5][a-zA-Z0-9\u4e00-\u9fa5]*$/;
	
	$("#input_1").blur(function(){
		var value = $("#input_1").val();

		if(value == null || value == ""){
			$("#input_tip1").css("display","none");
		}else if(value.length < 3 || !reg.test(value)){
			$("#input_tip1").css("display","inline");
			$("#input_tip1").html("用户名由3至20个字符或数字组成");
		}else {
			$("#input_tip1").css("display","none");
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

function validate_required2(){
	document.getElementById("input_tip2").style.display = "none";
	var value = code1;
	//alert(code1);
	if(value == null || value == ""){
		document.getElementById("input_tip2").style.display = "inline";
		document.getElementById("input_tip2").innerHTML = "请输入验证码";
		return false;
	}else if(flag == false){
		document.getElementById("input_tip2").style.display = "inline";
		document.getElementById("input_tip2").innerHTML = "验证码错误";
		return false;
	}else {
		document.getElementById("input_tip2").style.display = "none";
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
		}else if(validate_required2() == false){
			return false;
		}
	}
}