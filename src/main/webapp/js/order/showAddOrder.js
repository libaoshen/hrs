/**
 * 
 */
var validate_num;
$('document').ready(function(){
	var spinner = $( "#spinner" ).spinner({
		value:1,
		readonly:true
	});
	validate_num = 1;
	$(".totalprice").html("￥" + $("#roomprice").val()*$("#days").val());
	$("#roomtotalprice1").val($("#roomprice").val()*$("#days").val());
	$( "#spinner" ).val(1);
	
	$(".ui-spinner-button").live('click',function(){
		//alert("  ");
		$(".totalprice").html("￥" + $("#spinner").val()*$("#roomprice").val()*$("#days").val());
		$("#roomtotalprice1").val($("#spinner").val()*$("#roomprice").val()*$("#days").val());
		validate_num = $("#spinner").val();
	});
	
	var leftnum = $("#roomleftnum").val();
	var num1 = 1;
	$(".ui-spinner-up").live('click',function(){
		var num = $("#spinner").val();
		//alert(num1);
		//alert(num);
		num = Number(num);
		//alert(num);
		//alert(leftnum);
		//alert(num <= Number(leftnum))
		//alert(num + "" +num1);
		
		if(num == 10){
			$("#roomnuminfo").css("color","red");
			$("#roomnuminfo").html('<span class=" icon_error-circle " aria-hidden="true" ></span>若需预订10间以上,请联系客服');
		}
		
		if(num <= Number(leftnum) && num != num1 && num <=10){
			$("#first").before("<tr id='tr"+ num  +"'><td class='td1'>房间"+num+"</td><td><input name='room" + num + "' type='text' placeholder='姓名,一间房只需填写一位' id='name"+ num + "' onclick='ch("+num+")'/><span id='name_" + num +"'></span></td></tr>");
			num1 = num;
		}
		
	});
	
	$(".ui-spinner-down").live('click',function(){
		//alert("  ");
		var num = $("#spinner").val();
		//alert(num);
		if(num <10) {
			$("#roomnuminfo").html(" ");
		}
		num = Number( num ) + 1;
		$("#tr" + num).remove();
		num1 = num - 1;
	});
	
	$(".close").mouseover(function(){
		$(".close").css("color","red");
	});
	$(".close").mouseout(function(){
		$(".close").css("color","black");
	});
	
	$("#tip #ok input").mouseover(function(){
		$("#tip #ok input").css({"background-color":"#e39400","cursor":"pointer"});
	});
	$("#tip #ok input").mouseout(function(){
		$("#tip #ok input").css({"background-color":"orange","cursor":"pointer"});
	});
	
	$("#right4 #submit").mouseover(function(){
		$("#right4 #submit").css({"background-color":"#fb5200","cursor":"pointer"});
	});
	$("#right4 #submit").mouseout(function(){
		$("#right4 #submit").css("background-color","#ff6c26");
	});

	
	
	var title = $("#title").val();
	//alert(title);
	if(title == "订单填写") {
		$("#li1").css("color","#49f");
		$("#line1").css("border","1px solid #49f");
		$("#circle1").css("background-color","#49f");
	}else if(title == "在线支付") {
		$("#li1").css("color","#49f");
		$("#line1").css("border","1px solid #49f");
		$("#circle1").css("background-color","#49f");
		$("#li2").css("color","#49f");
		$("#line2").css("border","1px solid #49f");
		$("#circle2").css("background-color","#49f");
	}else if(title == "订单完成") {
		$("#li1").css("color","#49f");
		$("#line1").css("border","1px solid #49f");
		$("#circle1").css("background-color","#49f");
		$("#li2").css("color","#49f");
		$("#line2").css("border","1px solid #49f");
		$("#circle2").css("background-color","#49f");
		$("#li3").css("color","#49f");
		$("#line3").css("border","1px solid #49f");
		$("#circle3").css("background-color","#49f");
	}
		
});

function showWindow(){
	$('#tanchu_updateTime').fadeIn();
	$('#tanchu_back').fadeIn();
};
function closeWindow(){
	$('#tanchu_updateTime').fadeOut();
	$('#tanchu_back').fadeOut();
};
function ok(roomid){
	$('#tanchu_updateTime').fadeOut();
	$('#tanchu_back').fadeOut();
	var startdate = document.getElementById("date-range200").value;
	var enddate = document.getElementById("date-range201").value;
	var days = document.getElementsByClassName("selected-days-num")[0].innerText;
	
	startdate = startdate.replace('年','/');
	startdate = startdate.replace('月','/');
	startdate = startdate.replace('日','');
	enddate = enddate.replace('年','/');
	enddate = enddate.replace('月','/');
	enddate = enddate.replace('日','');
	
	
	window.location = "showAddOrder?roomid=" + roomid + "&startdate=" + startdate + "&enddate=" + enddate + "&days=" + days ;
};

//提交验证
function validate(thisform) {
	//alert(validate_num);
	var flag1 = true;
	var flag2 = true;
	var reg1 = /^1[34578]\d{9}$/;
	var tel1 = document.getElementById("phone").value;
	for(var i = 1;i <= Number(validate_num) ;i++) {
		var room = document.getElementById("name" + i);
		var room1 = document.getElementById("name_" + i);
		if(room.value == "" || room.value == null) {
			room1.innerText = "请填写实际入住客人的真实姓名，确保顺利入住";
			room1.style.color = "red";
			flag1 = false;
			break;
		}
	}
	
	if(!reg1.test(tel1)) {
		document.getElementById("phone1").innerText = "电话号码无效";
		document.getElementById("phone1").style.color = "red";
		flag2 = false;
	}
	
	if(!flag) {
		document.getElementById("yzm1").innerText = "验证码错误";
		document.getElementById("yzm1").style.color = "red";
	}
	
	//alert(flag1 && flag2 && flag);
	return flag1 && flag2 && flag;
};

function ch(num) {
	document.getElementById("name_" + num).innerText= "";
}
