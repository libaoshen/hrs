/**
 * 
 */
$("document").ready(function(){
	if($("#pageTitle").val() == "首页"){
		$("#shouye").css("border-bottom","3px solid #2fb3ff");
	}
	if($("#pageTitle").val() == "房间管理"){
		$("#room").css("border-bottom","3px solid #2fb3ff");
	}
	if($("#pageTitle").val() == "订单管理"){
		$("#order").css("border-bottom","3px solid #2fb3ff");
	}
	if($("#pageTitle").val() == "用户管理"){
		$("#user").css("border-bottom","3px solid #2fb3ff");
	}
	
});