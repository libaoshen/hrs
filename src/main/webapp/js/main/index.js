/**
 * 
 */
$('docunment').ready(function(){
	$("#first1").css({"background-color":"white"});
	$("#first1 a").css({"color":"black"});
	$("#first2").css({"background-color":"white"});
	$("#first2 a").css({"color":"black"});
	$("#second1").css({"background-color":"white"});
	$("#second1 a").css({"color":"black"});
	$("#second2").css({"background-color":"white"});
	$("#second2 a").css({"color":"black"});
	$("#third1").css({"background-color":"white"});
	$("#third1 a").css({"color":"black"});
	$("#third2").css({"background-color":"white"});
	$("#third2 a").css({"color":"black"});
	
	$("#first1").css({"background-color":"#4ba8fc"});
	$("#first1 a").css({"color":"white"});
	$("#first2").css({"background-color":"#4ba8fc"});
	$("#first2 a").css({"color":"white"});
	
	$("#first1").click(function(){
		$("#first1").css({"background-color":"#4ba8fc"});
		$("#first1 a").css({"color":"white"});
		$("#first2").css({"background-color":"#4ba8fc"});
		$("#first2 a").css({"color":"white"});
	});
	$("#first2").click(function(){
		$("#first1").css({"background-color":"#4ba8fc"});
		$("#first1 a").css({"color":"white"});
		$("#first2").css({"background-color":"#4ba8fc"});
		$("#first2 a").css({"color":"white"});
	});
	$("#second1").click(function(){
		$("#second1").css({"background-color":"#4ba8fc"});
		$("#second1 a").css({"color":"white"});
		$("#second2").css({"background-color":"#4ba8fc"});
		$("#second2 a").css({"color":"white"});
	});
	$("#second2").click(function(){
		$("#second1").css({"background-color":"#4ba8fc"});
		$("#second1 a").css({"color":"white"});
		$("#second2").css({"background-color":"#4ba8fc"});
		$("#second2 a").css({"color":"white"});
	});
	$("#third1").click(function(){
		$("#third1").css({"background-color":"#4ba8fc"});
		$("#third1 a").css({"color":"white"});
		$("#third2").css({"background-color":"#4ba8fc"});
		$("#third2 a").css({"color":"white"});
	});
	$("#third2").click(function(){
		$("#third1").css({"background-color":"#4ba8fc"});
		$("#third1 a").css({"color":"white"});
		$("#third2").css({"background-color":"#4ba8fc"});
		$("#third2 a").css({"color":"white"});
	});
	
	
	
	
	$("#first1").mouseover(function(){
		if($("#first1 a").css("color") == "rgb(0, 0, 0)"){
			//alert($("#first1 a").css("color"));	
			$("#first1 a").css({"color":"#4ba8fc"});
		}
	});
	$("#first1").mouseout(function(){
		if($("#first1 a").css("color") == "rgb(75, 168, 252)"){
			$("#first1 a").css({"color":"black"});
		}
	});
	$("#first2").mouseover(function(){
		if($("#first2 a").css("color") == "rgb(0, 0, 0)"){
			$("#first2 a").css({"color":"#4ba8fc"});
		}
	});
	$("#first2").mouseout(function(){
		if($("#first2 a").css("color") == "rgb(75, 168, 252)"){
			$("#first2 a").css({"color":"black"});
		}
	});
	
	$("#second1").mouseover(function(){
		if($("#second1 a").css("color") == "rgb(0, 0, 0)"){
			$("#second1 a").css({"color":"#4ba8fc"});
		}
	});
	$("#second1").mouseout(function(){
		if($("#second1 a").css("color") == "rgb(75, 168, 252)"){
			$("#second1 a").css({"color":"black"});
		}
	});
	$("#second2").mouseover(function(){
		if($("#second2 a").css("color") == "rgb(0, 0, 0)"){
			$("#second2 a").css({"color":"#4ba8fc"});
		}
	});
	$("#second2").mouseout(function(){
		if($("#second2 a").css("color") == "rgb(75, 168, 252)"){
			$("#second2 a").css({"color":"black"});
		}
	});
	
	$("#third1").mouseover(function(){
		if($("#third1 a").css("color") == "rgb(0, 0, 0)"){
			$("#third1 a").css({"color":"#4ba8fc"});
		}
	});
	$("#third1").mouseout(function(){
		if($("#third1 a").css("color") == "rgb(75, 168, 252)"){
			$("#third1 a").css({"color":"black"});
		}
	});
	$("#third2").mouseover(function(){
		if($("#third2 a").css("color") == "rgb(0, 0, 0)"){
			$("#third2 a").css({"color":"#4ba8fc"});
		}
	});
	$("#third2").mouseout(function(){
		if($("#third2 a").css("color") == "rgb(75, 168, 252)"){
			$("#third2 a").css({"color":"black"});
		}
	});
	
	$(".submitOrder").mouseover(function() {
		$(".submitOrder").css("backgound-color","red");
	});
	
});

$(window).scroll(function() {
    //alert($(document).height());
    var scrollTop = $(this).scrollTop();
    //alert($(this).height());
	var first = $("#first").offset().top;
	var second = $("#second").offset().top;
	var third = $("#third").offset().top;
	//alert(first);
	//alert(second);
	//alert(third);
	$("#first1").css({"background-color":"white"});
	$("#first1 a").css({"color":"black"});
	$("#first2").css({"background-color":"white"});
	$("#first2 a").css({"color":"black"});
	$("#second1").css({"background-color":"white"});
	$("#second1 a").css({"color":"black"});
	$("#second2").css({"background-color":"white"});
	$("#second2 a").css({"color":"black"});
	$("#third1").css({"background-color":"white"});
	$("#third1 a").css({"color":"black"});
	$("#third2").css({"background-color":"white"});
	$("#third2 a").css({"color":"black"});
	if(scrollTop <= second - 100) {
		$("#first1").css({"background-color":"#4ba8fc"});
		$("#first1 a").css({"color":"white"});
		$("#first2").css({"background-color":"#4ba8fc"});
		$("#first2 a").css({"color":"white"});
	}else if(scrollTop >= third - 100){
		$("#third1").css({"background-color":"#4ba8fc"});
		$("#third1 a").css({"color":"white"});
		$("#third2").css({"background-color":"#4ba8fc"});
		$("#third2 a").css({"color":"white"});
	}else {
		$("#second1").css({"background-color":"#4ba8fc"});
		$("#second1 a").css({"color":"white"});
		$("#second2").css({"background-color":"#4ba8fc"});
		$("#second2 a").css({"color":"white"});
	}
	
});

function menuFixed(id){
    var obj = document.getElementById(id);
    var _getHeight = obj.offsetTop;
    var id1 = "menubar2";
    window.onscroll = function(){
        changePos(id1,_getHeight);
    }
}
function changePos(id,height){
    var obj = document.getElementById(id);
    var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
    if(scrollTop < height){
        obj.style.display = 'none';
    }else{
        obj.style.display = 'inline';
    }
}

function change1(thisTag){
	thisTag.style.boxShadow = "1px 1px 5px gray";
	thisTag.style.cursor = "pointer";
}
function change2(thisTag){
	thisTag.style.boxShadow = "none";
}

function submitOrder(roomid){
	var startdate = document.getElementById("date-range200").value;
	var enddate = document.getElementById("date-range201").value;
	var days = document.getElementsByClassName("selected-days-num")[0].innerText;
	var path = document.getElementById("path").value;
	startdate = startdate.replace('年','/');
	startdate = startdate.replace('月','/');
	startdate = startdate.replace('日','');
	enddate = enddate.replace('年','/');
	enddate = enddate.replace('月','/');
	enddate = enddate.replace('日','');
	
	
	window.location = path + "/order/showAddOrder?roomid=" + roomid + "&startdate=" + startdate + "&enddate=" + enddate + "&days=" + days ;
}


function getMonth(date) {
	var arr;
	arr=date.split("/");
//alert(arr);	
    return arr[1];
}

function getDate(date) {
	var arr;
	arr=date.split("/");
	//alert(arr);	
	return arr[2];
}