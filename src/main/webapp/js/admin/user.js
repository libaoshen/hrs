/**
 * 
 */
$(document).ready(function() {
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
				//alert(num);
				getPage(num);
			}
			
			//$('#p3').html('当前第' + num + '页');
		}
	});
	
	var tc = Number(document.getElementById("usercounts_hidden").value);
	var ps = Number(document.getElementById("userpages_hidden").value);
	
	$('.pagination').jqPaginator('option',{
		totalCounts: tc,
		pageSize: ps
	});	
});

function getPage(page){
	var ps = Number(document.getElementById("userpages_hidden").value);
	var tc = Number(document.getElementById("usercounts_hidden").value);
	//alert(tc);
	//alert(ps);
	$.ajax({  
        type : "POST",  
        url : $('#contextPath').val() + "/user/ajax_operation",  
        dataType:"json",
        cache : false,  
        data : {  
            pageIndex: page,
            pageSize: ps,
            totalPage: tc,
        },  
        async : false,  
        error : function() {  
            alert("网络异常！");  
        },  
        success : function(data) {
        	var html = "";
        	html += "<table id='user_table'>";
			html += "<tr>";
			html += "		<td>用户编号</td>";
			html += "			<td>用户名</td>";
			html += "<td>性别</td>";
			html += "<td>电话号码</td>";
			html += "<td>注册时间</td>";
			html += "<td>注册IP</td>";
			html += "	<td>最近一次的登录时间</td>";
			html += "	<td>最近一次的登录IP</td>";
			html += "</tr>";
    		for(var i=0;i<data[0].length;i++){	
    			html += "<tr>";
    			html += 	"<td>" + data[0][i].userid + "</td>";
    			html += 	"<td>" + data[0][i].username + "</td>";
    			if(data[0][i].sex == false) {
    				html += 	"<td>男</td>";
    			}else {
    				html += 	"<td>女</td>";
    			}
    			html += 	"<td>" + data[0][i].phone + "</td>";
    			html += 	"<td>" + data[1][i][0] + "</td>";
    			html += 	"<td>" + data[0][i].regip + "</td>";
    			html += 	"<td>" + data[1][i][1] + "</td>";
    			html += 	"<td>" + data[0][i].lastloginip + "</td>";
    			html += "</tr>";
    		}
    		html +="</table>";
    		$('#result').html(html);
        }  
    });  
};