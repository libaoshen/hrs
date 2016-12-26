/**
 * 
 */
$(document).ready(function() {
	var k = 1;
	var tc = Number(document.getElementById("ordercounts_hidden").value);
	var ps = Number(document.getElementById("orderpages_hidden").value);
	
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
			if($("#orderpages_hidden").val()!= 0 ){
				getPage(num,k);
			}
			
			//$('#p3').html('当前第' + num + '页');
		}
	});
	$('.pagination').jqPaginator('option',{
		totalCounts: tc,
		pageSize: ps
	});
	
	$("#first").click(function(){
		getSize(1);
		tc = Number(document.getElementById("ordercounts_hidden").value);
		ps = Number(document.getElementById("orderpages_hidden").value);
		k = 1;

		$('.pagination').jqPaginator('option',{
			totalCounts: tc,
			pageSize: ps,
			currentPage: 1,
		});
		if(tc > 0) {
			getPage(1,k);
		}else {
			document.getElementById("first1").innerText = "还没有订单";
		}
	});
	
	$("#second").click(function(){
		getSize(2);
		tc = Number(document.getElementById("ordercounts_hidden").value);
		ps = Number(document.getElementById("orderpages_hidden").value);
		k = 2;
		
		$('.pagination').jqPaginator('option',{
			totalCounts: tc,
			pageSize: ps,
			currentPage: 1,
		});
		if(tc > 0) {
			getPage(1,k);
		}else {
			document.getElementById("second1").innerText = "还没有今日订单";
		}
	});
	
	$("#third").click(function(){
		getSize(3);
		tc = Number(document.getElementById("ordercounts_hidden").value);
		ps = Number(document.getElementById("orderpages_hidden").value);
		//alert(tc);
		//alert(ps);
		$('.pagination').jqPaginator('option',{
			totalCounts: tc,
			pageSize: ps,
			currentPage: 1,
		});
		k = 3;
		if(tc > 0) {
			getPage(1,k);
		}else {
			document.getElementById("third1").innerText = "还没有未支付订单";
		}
	});
	
	$("#fourth").click(function(){
		getSize(4);
		tc = Number(document.getElementById("ordercounts_hidden").value);
		ps = Number(document.getElementById("orderpages_hidden").value);
		
		$('.pagination').jqPaginator('option',{
			totalCounts: tc,
			pageSize: ps,
			currentPage: 1,
		});
		k = 4;
		if(tc > 0) {
			getPage(1,k);
		}else {
			document.getElementById("fourth1").innerText = "还没有已支付订单";
		}
	});
	
	$("#fifth").click(function(){
		getSize(5);
		tc = Number(document.getElementById("ordercounts_hidden").value);
		ps = Number(document.getElementById("orderpages_hidden").value);
		
		$('.pagination').jqPaginator('option',{
			totalCounts: tc,
			pageSize: ps,
			currentPage: 1,
		});
		k = 5;
		if(tc > 0) {
			getPage(1,k);
		}else {
			document.getElementById("fifth1").innerText = "还没有已失效订单";
		}
	});
	
	
});

function getPage(page,k){
	var ps = Number(document.getElementById("orderpages_hidden").value);
	var tc = Number(document.getElementById("ordercounts_hidden").value);
	//alert(tc);
	//alert(k);
	$.ajax({  
        type : "POST",  
        url : $('#contextPath').val() + "/order/ajax_operation" + k,  
        dataType:"json",
        cache : false,  
        data : {  
            pageIndex: page,
            pageSize: ps,
            totalPage:tc
        },  
        async : false,  
        error : function() {  
            alert("网络异常！");  
        },  
        success : function(data) { 
        	var html = "";
    		for(var i=0;i<data[0].length;i++){	
				html += "<div class='order'>";
				html += "	<div class='order_numtime'>";
				html += "			<div class='order_num'>";
				html += "				订单编号:" + data[0][i].orderid ;
				html += "				&nbsp;&nbsp;下单用户:" + data[2][i].username ;
				html += "			</div>";
				html += "			<div class='order_time'>";
				html += "    					下单时间:" + data[3][i][0];
				html += " 				</div>";
				html += "	</div>";
				html += "<div class='order_properties>";
				html += "<div class='order_roominfo'>";
				html += "	<div class='room_img'>";
				html += "<img src='" + $("#contextPath").val() + "/images/room/" + data[1][i].imginfo + "'/>";
				html += "	</div>";
				html += "	<div class='room_info'>";
				html += "		<div class='room_name'>";
				html += "			" + data[1][i].roomname;
				html += "		</div>";
				html += "		<div class='bed_type'>";
				html += "			" + data[1][i].bedtype + " - ￥" + data[1][i].roomprice;
				html += "		</div>";
				html += "		<div class='description'>";
				html += "			" + data[1][i].description;
				html += "		</div>";
				html += "	</div>";
				html += "	<div class='user'>";
				html += "		入住信息:<br/>";
				html += "		" + data[0][i].registerinfo;
				html += "	</div>";
				html += "	<div class='room_numprice'>";
				html += "	房间数量:<br>";
				html += "		" + data[0][i].roomnum + "<br>";
				html += "	订单支付价格:<br>";
				html += "	￥" + data[0][i].totalprice ;
				html += "</div>";
				html += "</div>";
				html += "<div class='order_state'>";
				
				if(data[0][i].orderstate == "已支付") {
					html += "	已支付";
				}else if(data[0][i].orderstate == "已失效") {
					html += "			已失效";
				}else {
					html += "			未支付";
				}
				
				html += "</div>";
				html += "<div class='order_paydeadtime'>";  
				html += "	<div class='order_time1'>";
				html += "		入离时间:" + data[3][i][3] + " - " + data[3][i][4] ;
				html += "	</div>";
				
				if(data[0][i].orderstate == "已支付") {
					html += "				支付时间:" + data[3][i][2];
				}else if(data[0][i].orderstate == "已失效") {
					html += "		失效时间:" + data[3][i][1];
				}else {
					html += "		失效时间:" + data[3][i][1];
				}
					
				html += "</div>";
				html += "</div>";
    		}
    		
    		$('#result' + k).html(html);
        }  
    });  
};


function getSize(i) {
	//alert(i);
	$.ajax({  
        type : "POST",  
        url : $('#contextPath').val() + "/order/ajax_operation" + i + "" + i,  
        dataType:"json",
        cache : false,  
        data : {  
        },  
        async : false,  
        error : function() {  
            alert("网络异常！");  
        },  
        success : function(data) { 
        	//alert(i);
        	document.getElementById("ordercounts_hidden").value = data[0];
        	document.getElementById("orderpages_hidden").value = data[1];
        }
    });
};


