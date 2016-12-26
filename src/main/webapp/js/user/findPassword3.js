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
			$("#input_tip1").html("密码由3至20位字母或数字组成");
		}else {
			$("#input_tip1").css("display","none");
		}
	});
	
	$("#input_2").blur(function(){
		var value = $("#input_2").val();

		if(value == null || value == ""){
			$("#input_tip3").css("display","none");
		}else if(value.length < 3 || !reg.test(value)){
			$("#input_tip3").css("display","inline");
			$("#input_tip3").html("密码由3至20位字母或数字组成");
		}else if(value != $("#input_1").val()){
			$("#input_tip3").css("display","inline");
			$("#input_tip3").html("两次输入的密码不一样");
		}else{
			$("#input_tip3").css("display","none");
		}
	});
	
});

var reg = /^[a-zA-Z\u4e00-\u9fa5][a-zA-Z0-9\u4e00-\u9fa5]*$/;
function validate_required1(field){
	document.getElementById("input_tip1").style.display = "none";
	//alert(value);
	with(field){
		if(value == null || value == ""){
			document.getElementById("input_tip1").style.display = "inline";
			document.getElementById("input_tip1").innerHTML = "请输入密码";
			return false;
		}else if(value.length < 3 || !reg.test(value)){
			document.getElementById("input_tip1").style.display = "inline";
			document.getElementById("input_tip1").innerHTML = "密码由3至20位字母或数字组成";
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

function validate_required3(field){
	document.getElementById("input_tip3").style.display = "none";
	with(field){
		//alert(value);
		if(value == null || value == ""){
			document.getElementById("input_tip3").style.display = "inline";
			document.getElementById("input_tip3").innerHTML = "请再次输入密码";
			return false;
		}else if(value.length < 3 || !reg.test(value)){
			document.getElementById("input_tip3").style.display = "inline";
			document.getElementById("input_tip3").innerHTML = "密码由3至20位字母或数字组成";
			return false;
		}else if(value != document.getElementById("input_1").value){
			document.getElementById("input_tip3").style.display = "inline";
			document.getElementById("input_tip3").innerHTML = "两次输入的密码不一致";
			return false;
		}else {
			document.getElementById("input_tip3").style.display = "none";
			return true;
		}
	}
};

function validate(thisform){
	with(thisform){
		c.init();
		document.getElementById("inputCode").value = "";
		//alert(validate_required1(username));
		//alert(document.getElementById("inputCode").value);
		//alert(validate_required1(password));
		//alert("hah ");
		if (validate_required1(password)==false) {
			return false;
		}else if(validate_required3(password1) == false){
			return false;
		}else if(validate_required2() == false){
			return false;
		}
	}
}