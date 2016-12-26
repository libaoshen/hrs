/**
 * 
 */
$("document").ready(function(){
	if($("#which").val() == 1 || $("#which").val() == null || $("#which").val() == "") {
		$("#shouye").css("background-color","#000088");
		$("#shouye").mouseover(function(){
			$("#shouye").css("cursor","pointer");
		});
	}else {
		$("#shouye").mouseover(function(){
			$("#shouye").css({"background-color":"#1b53a7","cursor":"pointer"});
		});
		$("#shouye").mouseout(function(){
			$("#shouye").css({"background-color":"#2064c8","cursor":"pointer"});
		});
	}
	
	if($("#which").val() == 2) {
		$("#help").css("background-color","#000088");
		$("#help").mouseover(function(){
			$("#help").css("cursor","pointer");
		});
	}else {
		$("#help").mouseover(function(){
			$("#help").css({"background-color":"#1b53a7","cursor":"pointer"});
		});
		$("#help").mouseout(function(){
			$("#help").css({"background-color":"#2064c8","cursor":"pointer"});
		});
	}
	
	
	$("#header #new_login").mouseover(function(){
		$("#header #new_login").css("background-color","#dd4800");
	});
	$("#header #new_login").mouseout(function(){
		$("#header #new_login").css("background-color","#ff641a");
	});
	$("#function1").mouseover(function(){
		$("#icon1").css({"color":"#2064c8","cursor":"pointer"});
		$("#function1 a").css({"color":"#2064c8","cursor":"pointer"});
	});
	$("#function1").mouseout(function(){
		$("#icon1").css({"color":"#a2a2a2","cursor":"pointer"});
		$("#function1 a").css({"color":"#a2a2a2","cursor":"pointer"});
	});
	$("#function2").mouseover(function(){
		$("#icon2").css({"color":"#2064c8","cursor":"pointer"});
		$("#function2 a").css({"color":"#2064c8","cursor":"pointer"});
	});
	$("#function2").mouseout(function(){
		$("#icon2").css({"color":"#a2a2a2","cursor":"pointer"});
		$("#function2 a").css({"color":"#a2a2a2","cursor":"pointer"});
	});
	$("#header #login").mouseover(function(){
		$("#header #tanchu").css("display","inline");
	});
	$("#header #login").mouseout(function(){
		$("#header #tanchu").css("display","none");
	});
	$("#header #tanchu").mouseover(function(){
		$("#header #tanchu").css("display","inline");
	});
	$("#header #tanchu").mouseout(function(){
		$("#header #tanchu").css("display","none");
	});
});