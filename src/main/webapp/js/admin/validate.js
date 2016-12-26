/**
 * 
 */
		var reg = /^[a-zA-Z\u4e00-\u9fa5][a-zA-Z0-9\u4e00-\u9fa5]*$/;
		function validate_required1(field)
		{
			with (field)
			{
			  if (value==null||value=="") {
				  document.getElementById("room11").innerHTML = "请输入房型名";
				  document.getElementById("room21").style.borderColor="red"
				  return false;
			  }
			  else {
				  if(value.length > 20){
					  document.getElementById("room11").innerHTML = "房型名字数小于20";
					  document.getElementById("room21").style.borderColor="red"
					  return false;
				  }else if(!reg.test(value)){
					  document.getElementById("room11").innerHTML = "房型名必须以中文或字母开头";
					  document.getElementById("room21").style.borderColor="red"
					  return false;
				  }else {
					  document.getElementById("room11").innerHTML = "";
					  return true;
				  }
			  }
			}
		};
		
		function validate_required2(field)
		{
			with (field)
			{
			  if (value==null||value=="") {
				  document.getElementById("room12").innerHTML = "请输入床型名";
				  document.getElementById("room22").style.borderColor="red"
				  return false;
			  }
			  else {
				  if(value.length > 20){
					  document.getElementById("room12").innerHTML = "床型名字数小于20";
					  document.getElementById("room22").style.borderColor="red"
					  return false;
				  }else if(!reg.test(value)){
					  document.getElementById("room11").innerHTML = "房型名必须以中文或字母开头";
					  document.getElementById("room21").style.borderColor="red"
					  return false;
				  }else {
					  document.getElementById("room11").innerHTML = "";
					  return true;
				  }
			  }
			}
		};
		//验证图片格式和大小
		function getPhotoInfo(obj){
			  photoExt=obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();//获得文件后缀名
			  if(photoExt!='.png' && photoExt!='.jpg' && photoExt!='.jpeg' ){
			    //alert("请上传后缀名为png,jpg,jpeg的图片!");
			    return 1;
			  }
			  var fileSize = 0;
			  var isIE = /msie/i.test(navigator.userAgent) && !window.opera;      
			  if (isIE && !obj.files) {     
			     var filePath = obj.value;      
			     var fileSystem = new ActiveXObject("Scripting.FileSystemObject");  
			     var file = fileSystem.GetFile (filePath);        
			     fileSize = file.Size;     
			  }else { 
			     fileSize = obj.files[0].size;   
			  } 
			  fileSize=Math.round(fileSize/1024*100)/100; //单位为KB
			  if(fileSize>=100){
			    //alert("照片最大尺寸为100KB，请重新上传!");
			    return 2;
			  }
		}
		
		function validate_required3(field)
		{
			with (field)
			{
			  //alert(getPhotoInfo(field));
			  if (value==null||value=="") {
				  document.getElementById("room13").innerHTML = "请选择图片";
				  document.getElementById("room23").style.borderColor="red"
				  return false;
			  }else if(getPhotoInfo(field)==1){
				  document.getElementById("room13").innerHTML = "请上传后缀名为png,jpg,jpeg的图片";
				  document.getElementById("room23").style.borderColor="red"
				  return false;
			  }else if(getPhotoInfo(field)==2){
				  document.getElementById("room13").innerHTML = "图片最大尺寸为100KB,请重新选择";
				  document.getElementById("room23").style.borderColor="red"
				  return false;
			  }else {
				  document.getElementById("room13").innerHTML = "";
				  return true;
			  }
			  
			}
		};
		
		function validate_required4(field)
		{
			with (field)
			{
			  if (value==null||value=="") {
				  document.getElementById("room14").innerHTML = "请输入房间价格";
				  document.getElementById("room24").style.borderColor="red"
				  return false;
			  }
			  else if(!isNaN(value)) {
				  if(value.length > 6){
					  document.getElementById("room14").innerHTML = "房间价格必须小于999999";
					  document.getElementById("room24").style.borderColor="red"
					  return false;
				  }else{
					  document.getElementById("room14").innerHTML = "";
					  return true;
				  }
			  }else {
				  document.getElementById("room14").innerHTML = "房间价格必须为数字";
				  document.getElementById("room24").style.borderColor="red"
				  return false;
			  }
			}
		}
		
		function validate_required5(field)
		{
			with (field)
			{
			  if (value==null||value=="") {
				  document.getElementById("room15").innerHTML = "请输入房间数量";
				  document.getElementById("room25").style.borderColor="red"
				  return false;
			  }
			  else if(!isNaN(value)) {
				  if(value.length > 4){
					  document.getElementById("room15").innerHTML = "房间数量必须小于9999";
					  document.getElementById("room25").style.borderColor="red"
					  return false;
				  }else{
					  document.getElementById("room15").innerHTML = "";
					  return true;
				  }
			  }else {
				  document.getElementById("room15").innerHTML = "房间数量必须为数字";
				  document.getElementById("room25").style.borderColor="red"
				  return false;
			  }
			}
		}
		
		function validate_required6(field)
		{
			with (field)
			{
			  if (value==null||value=="") {
				  document.getElementById("room16").innerHTML = "请输入描述信息";
				  document.getElementById("room26").style.borderColor="red"
				  return false;
			  }
			  else {
				  if(value.length > 20){
					  document.getElementById("room16").innerHTML = "描述信息字数小于100";
					  document.getElementById("room26").style.borderColor="red"
					  return false;
				  }else{
					  document.getElementById("room16").innerHTML = "";
					  return true;
				  }
			  }
			}
		}
		
		
		function validate_form(thisform) {
			 with (thisform)
			  {
				  if (validate_required1(roomname)==false) {
					  roomname.focus();return false;
				  }else if (validate_required2(bedtype)==false){
					  bedtype.focus();return false;
				  }else if (validate_required3(imageInfo)==false){
					  imageInfo.focus();return false;
				  }else if (validate_required4(roomprice)==false){
					  roomprice.focus();return false;
				  }else if (validate_required5(roomtotalnum)==false){
					  roomtotalnum.focus();return false;
				  }else if (validate_required6(description)==false){
					  description.focus();return false;
				  }
			  }
		}
		
		$(document).ready(function(){
			
			$("#radiobutton1").attr("checked","checked");
			
			$("#room21").blur(function(){
				if($("#room21").val() == null || $("#room21").val() == ""){
					$("#room21").css("border-color","red");
					$("#room11").text("请输入房型名");
				}else if($("#room21").val().length > 20) {
					$("#room21").css("border-color","red");
					$("#room11").text("房型名字数小于20");
				}else if(!reg.test($("#room21").val())){
					$("#room21").css("border-color","red");
					$("#room11").text("房型名必须以中文或字母开头");
				}else {
					$("#room11").text("");
				}
			});
			
			$("#room22").blur(function(){
				if($("#room22").val() == null || $("#room22").val() == ""){
					$("#room22").css("border-color","red");
					$("#room12").text("请输入床型名");
				}else if($("#room22").val().length > 20) {
					$("#room22").css("border-color","red");
					$("#room12").text("床型名字数小于20");
				}else if(!reg.test($("#room22").val())){
					$("#room22").css("border-color","red");
					$("#room12").text("床型名必须以中文或字母开头");
				}else {
					$("#room12").text("");
				}
			});
			
			$("#room23").live('change',function(){
			  obj = document.getElementById("room23");
			  photoExt=obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();//获得文件后缀名
			  if(photoExt!='.png' && photoExt!='.jpg' && photoExt!='.jpeg' ){
			    //alert("请上传后缀名为png,jpg,jpeg的图片!");
			    document.getElementById("room13").innerHTML = "请上传后缀名为png,jpg,jpeg的图片";
			    document.getElementById("room23").style.borderColor = 'red';
			    return false;
			  }
			  var fileSize = 0;
			  var isIE = /msie/i.test(navigator.userAgent) && !window.opera;      
			  if (isIE && !obj.files) {     
			     var filePath = obj.value;      
			     var fileSystem = new ActiveXObject("Scripting.FileSystemObject");  
			     var file = fileSystem.GetFile (filePath);        
			     fileSize = file.Size;     
			  }else { 
			     fileSize = obj.files[0].size;   
			  } 
			  fileSize=Math.round(fileSize/1024*100)/100; //单位为KB
			  if(fileSize>=100){
			    //alert("照片最大尺寸为100KB，请重新上传!");
			    document.getElementById("room13").innerHTML = "照片最大尺寸为100KB,请重新上传";
			    document.getElementById("room23").style.borderColor = 'red';
			    return false;
			  }
			  document.getElementById("room13").innerHTML = "";
			  document.getElementById("room23").style.borderColor = none;
			  return false;
			});
			//function(){
//				if($("#room23").val() == null || $("#room23").val() == ""){
//					$("#room23").css("border-color","red");
//					//alert($("#room23").val());
//					$("#room13").text("请选择图片");
//				}else if(getPhotoSize($("#room23")) == 1){
//					$("#room13").text("请上传后缀名为png,jpg,jpeg的图片");
//					$("#room23").css("border-color","red");
//				}else if(getPhotoSize($("#room23"))==2){
//					$("#room13").text("图片最大尺寸为100KB,请重新选择");
//					$("#room23").css("border-color","red");
//				}else {
//					//alert(getPhotoSize($("#room23")));
//					$("#room13").text("");
					//alert($("#room23").val())
					//alert(getPhotoSize(document.getElementById("room23")));
				//}
			//});
			
			$("#room24").blur(function(){
				if($("#room24").val() == null || $("#room24").val() == ""){
					$("#room24").css("border-color","red");
					$("#room14").text("请输入房间价格");
				}else if(!isNaN($("#room24").val())){
					if($("#room24").val().length > 6) {
						$("#room24").css("border-color","red");
						$("#room14").text("房间价格必须小于999999");
					}else {
						$("#room14").text("");
					}
				}else {
					$("#room14").text("房间价格必须为数字");
				}
			});
			
			$("#room25").blur(function(){
				if($("#room25").val() == null || $("#room25").val() == ""){
					$("#room25").css("border-color","red");
					$("#room15").text("请输入房间数量");
				}else if(!isNaN($("#room25").val())){
					if($("#room25").val().length > 4) {
						$("#room25").css("border-color","red");
						$("#room15").text("房间数量必须小于9999");
					}else {
						$("#room15").text("");
					}
				}else {
					$("#room15").text("房间数量必须为数字");
				}
			});
			
			$("#room26").blur(function(){
				if($("#room26").val() == null || $("#room26").val() == ""){
					$("#room26").css("border-color","red");
					$("#room16").text("请输入描述信息");
				}else if($("#room26").val().length > 100) {
						$("#room26").css("border-color","red");
						$("#room16").text("描述信息字数小于100");
				}else {
					$("#room16").text("");
				}
			});
			
			
		});