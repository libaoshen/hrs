/**
 * 
 */
function showWindow(){
	$('#tanchu_front').fadeIn();
	$('#tanchu_back').fadeIn();
};
function closeWindow(){
	$('#tanchu_front').fadeOut();
	$('#tanchu_back').fadeOut();
};
function closeWindow_addRoom(){
	$('#tanchu_addRoom').fadeOut();
	$('#tanchu_back').fadeOut();
	location.href='http://localhost:8080/hrs/room';
};
function closeWindow_deleteRoom(){
	$('#tanchu_deleteRoom').fadeOut();
	$('#tanchu_back').fadeOut();
	location.href='http://localhost:8080/hrs/room';
};
function closeWindow_updateRoom(){
	$('#tanchu_updateRoom').fadeOut();
	$('#tanchu_back').fadeOut();
	location.href='http://localhost:8080/hrs/room';
};

$(document).ready(function(){
	if($('#room_hidden').val() == 1){
		$("#tanchu_addRoom").fadeIn();
		$('#tanchu_back').fadeIn();
	}else if($('#room_hidden').val() == 2){
		$("#tanchu_front").fadeIn();
		$('#tanchu_back').fadeIn();
	}else if($('#room_hidden').val() == 3){
		$("#tanchu_deleteRoom").fadeIn();
		$('#tanchu_back').fadeIn();
	}else if($('#room_hidden').val() == 4){
		alert("删除的房型信息不存在!");
	}else if($('#room_hidden').val() == 5){
		$("#tanchu_front1").fadeIn();
		$('#tanchu_back').fadeIn();
	}else if($('#room_hidden').val() == 6){
		alert("修改的房型信息不存在!");
	}if($('#room_hidden').val() == 7){
		$("#tanchu_updateRoom").fadeIn();
		$('#tanchu_back').fadeIn();
	}else if($('#room_hidden').val() == 8){
		alert("修改后的房型名已存在,请重新修改!");
	}
	
	$("#addRoom").css({"font-size":"25px","width":"300px","margin":"5px auto","color":"blue"});
	
	
	for(var i = 0;i < 5;i++){
		$('#addRoom_form input')[0].value = "";
	}
	$('#addRoom_form radiobutton').value = "";
	$('#addRoom_form textarea').value = "";
	
	$("#addRoom_form #room21").mouseover(function(){
		if($(this).css("border-color")=="red"){
			
		}else{
			$("#addRoom_form #room21").css("border-color","#74ddf3");
		} 
	});
	
	$("#addRoom_form #room21").mouseout(function(){
		if($(this).css("border-color")=="red"){
							
	 	}else{
	 		$("#addRoom_form #room21").css("border-color","gray");
	 	}
	});
	
	$("#addRoom_form #room22").mouseover(function(){
	    $("#addRoom_form #room22").css("border-color","#74ddf3");
	});
	$("#addRoom_form #room22").mouseout(function(){
	    $("#addRoom_form #room22").css("border-color","gray");
	});
	$("#addRoom_form #room23").mouseover(function(){
	    $("#addRoom_form #room23").css("border-color","#74ddf3");
	});
	$("#addRoom_form #room23").mouseout(function(){
	    $("#addRoom_form #room23").css("border-color","gray");
	});
	$("#addRoom_form #room24").mouseover(function(){
	    $("#addRoom_form #room24").css("border-color","#74ddf3");
	});
	$("#addRoom_form #room24").mouseout(function(){
	    $("#addRoom_form #room24").css("border-color","gray");
	});
	$("#addRoom_form #room25").mouseover(function(){
	    $("#addRoom_form #room25").css("border-color","#74ddf3");
	});
	$("#addRoom_form #room25").mouseout(function(){
	    $("#addRoom_form #room25").css("border-color","gray");
	});
	$("#addRoom_form #room26").mouseover(function(){
	    $("#addRoom_form #room26").css("border-color","#74ddf3");
	});
	$("#addRoom_form #room26").mouseout(function(){
	    $("#addRoom_form #room26").css("border-color","gray");
	});

	$(".addRoomButton").css("cursor","pointer");
	$(".addRoomButton").mouseover(function(){
		$(".addRoomButton").css({"color":"red"});
	});
	$(".addRoomButton").mouseout(function(){
		$(".addRoomButton").css({"color":"blue"});
	});
			
	$(".close").mouseover(function(){
		$(".close").css({"color":"red"});
	});
	$(".close").mouseout(function(){
		$(".close").css({"color":"black"});
	});
	
	$("#addRoom_form #submit").css({"color":"white"});
	$("#addRoom_form #submit").mouseover(function(){
		$("#addRoom_form #submit").css({"background-color":"#0579c7"});
	});
	$("#addRoom_form #submit").mouseout(function(){
		$("#addRoom_form #submit").css({"background-color":"#0996f8","font-size":"15px"});
	});
	
	
	$("#updateRoom_form #room21").mouseover(function(){
	    $("#updateRoom_form #room21").css("border-color","#74ddf3");
	});
	$("#updateRoom_form #room21").mouseout(function(){
	    $("#updateRoom_form #room21").css("border-color","gray");
	});
	$("#updateRoom_form #room22").mouseover(function(){
	    $("#updateRoom_form #room22").css("border-color","#74ddf3");
	});
	$("#updateRoom_form #room22").mouseout(function(){
	    $("#updateRoom_form #room22").css("border-color","gray");
	});
	$("#updateRoom_form #room23").mouseover(function(){
	    $("#updateRoom_form #room23").css("border-color","#74ddf3");
	});
	$("#updateRoom_form #room23").mouseout(function(){
	    $("#updateRoom_form #room23").css("border-color","gray");
	});
	$("#updateRoom_form #room24").mouseover(function(){
	    $("#updateRoom_form #room24").css("border-color","#74ddf3");
	});
	$("#updateRoom_form #room24").mouseout(function(){
	    $("#updateRoom_form #room24").css("border-color","gray");
	});
	$("#updateRoom_form #room25").mouseover(function(){
	    $("#updateRoom_form #room25").css("border-color","#74ddf3");
	});
	$("#updateRoom_form #room25").mouseout(function(){
	    $("#updateRoom_form #room25").css("border-color","gray");
	});
	$("#updateRoom_form #room26").mouseover(function(){
	    $("#updateRoom_form #room26").css("border-color","#74ddf3");
	});
	$("#updateRoom_form #room26").mouseout(function(){
	    $("#updateRoom_form #room26").css("border-color","gray");
	});
	
	
	
	$('.pagination').jqPaginator({
		totalCounts: 1,
		pageSize: 1,
		visiblePages: 5,
		currentPage: 1,
		first: '<li class="first"><a href="javascript:;">首页</a></li>',
		last: '<li class="last"><a href="javascript:;">尾页</a></li>',
		prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
		next: '<li class="next"><a href="javascript:;">下一页</a></li>',
		page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
		onPageChange: function (num, type) {
			if($("#roompages_hidden").val()!= 0 ){
				getPage(num);
			}
			
			//$('#p3').html('当前第' + num + '页');
		}
	});
	var tc = Number(document.getElementById("roomcounts_hidden").value);
	var ps = Number(document.getElementById("roompages_hidden").value);
	
	$('.pagination').jqPaginator('option',{
		totalCounts: tc,
		pageSize: ps
	});
});

function getPage(page){
	//alert(page);
	var ps = Number(document.getElementById("roompages_hidden").value);
	var tc = Number(document.getElementById("roomcounts_hidden").value);
	
	$.ajax({  
        type : "POST",  
        url : $('#contextPath').val() + "/room/ajax_operation",  
        dataType:"json",
        cache : false,  
        data : {  
            pageIndex: page,
            pageSize: ps,
            totalPage:tc
        },  
        async : true,  
        error : function() {  
            alert("网络异常！");  
        },  
        success : function(data) { 
        	var html="<table>";
    		html +="<tr><td>房型</td><td>图片</td><td>床型</td><td>宽带</td><td>房价(元)</td><td>描述</td><td>房间数量(间)</td><td>房间剩余数量(间)</td><td>操作</td></tr>";
    		for(var i=0;i<data.length;i++){
    			html += "<tr>";
    			html +="	<td>"+ data[i].roomname+"</td>";
    			html +="	<td>";
    			html +=     "<img src='" + $("#contextPath").val() + "/images/room/" + data[i].imginfo + "'/>";
    			html +="	</td>";
    			html +="	<td>"+ data[i].bedtype+"</td>";
    			html +="	<td>";
    			
    			if(data[i].hasbroadband==true){
    				html +="有";
    			}else {
    				html +="无";
    			}
    			html +="	</td>";
    			html +="	<td>"+ data[i].roomprice+"</td>";
    			html +="	<td>"+ data[i].description+"</td>";
    			html +="	<td>"+ data[i].roomtotalnum+"</td>";
    			html +="	<td>"+ data[i].roomleftnum+"</td>";
    			html +="	<td width='5%'>";
    			html +="		<a href='#' onclick='updateRoom(" + data[i].roomid + ")'><div style='font-size:20px;'  data-icon='&#x6c;' title='修改'></div></a></br>";
    			html +="		<a href='#' onclick='deleteRoom(" + data[i].roomid + ")'><div style='font-size:30px;' data-icon='&#x4d;' title='删除'></div></a>";
    			html +="	</td>";
    			html +="	</tr>";
    		}
    		html +="</table>";
    		
    		$('#result').html(html);
        }  
    });  
};

function updateRoom(roomid){
	window.location.href= $('#contextPath').val() + "/room/showUpdateRoom?id=" + roomid;
}

function deleteRoom(roomid){
	if(confirm('你确定真的要删除该房型信息吗?') == true){
		 window.location.href= $('#contextPath').val() + "/room/deleteRoom?id=" + roomid; 
	}
}