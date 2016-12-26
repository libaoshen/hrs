/**
 * 
 */
/**
 * 
 */
		var reg = /^[a-zA-Z\u4e00-\u9fa5][a-zA-Z0-9\u4e00-\u9fa5]*$/;
		function validate_required1(field)
		{
			document.getElementById("username1").style.display="none";
			document.getElementById("username2").style.display="none";
			document.getElementById("username3").style.display="none";
			document.getElementById("username4").style.display="none";
			with (field)
			{
			  //alert(value);
			  if (value==null||value=="") {
				  document.getElementById("username2").style.display="inline";
				  document.getElementById("username").style.borderColor="red";
				  return false;
			  }
			  else {
				  if(value.length < 3){
					  document.getElementById("username3").style.display="inline";
					  document.getElementById("username").style.borderColor="red";
					  return false;
				  }else if(!reg.test(value)){
					  document.getElementById("username3").style.display="inline";
					  document.getElementById("username").style.borderColor="red";
					  return false;
				  }else {
					  document.getElementById("username4").style.display="inline";
					  return true;
				  }
			  }
			}
		};
		
		function validate_required2(field)
		{	
			document.getElementById("password1").style.display="none";
			document.getElementById("password2").style.display="none";
			document.getElementById("password3").style.display="none";
			document.getElementById("password4").style.display="none";
			with (field)
			{
			  //alert(value);
			  if (value==null||value=="") {
				  document.getElementById("password2").style.display="inline";
				  document.getElementById("password").style.borderColor="red";
				  return false;
			  }
			  else {
				  if(value.length < 3){
					  document.getElementById("password3").style.display="inline";
					  document.getElementById("password").style.borderColor="red";
					  return false;
				  }else if(!reg.test(value)){
					  document.getElementById("password3").style.display="inline";
					  document.getElementById("password").style.borderColor="red";
					  return false;
				  }else {
					  document.getElementById("password1").style.display="none";
					  document.getElementById("password2").style.display="none";
					  document.getElementById("password3").style.display="none";
					  document.getElementById("password4").style.display="inline";
					  return true;
				  }
			  }
			}
		};
		
		function validate_required3(field)
		{
			document.getElementById("password11").style.display="none";
			document.getElementById("password12").style.display="none";
			document.getElementById("password13").style.display="none";
			document.getElementById("password14").style.display="none";
			document.getElementById("password15").style.display="none";
			with (field)
			{
			  //alert(value);
			  if (value==null||value=="") {
				  document.getElementById("password11").style.display="none";
				  document.getElementById("password12").style.display="none";
				  document.getElementById("password13").style.display="none";
				  document.getElementById("password14").style.display="none";
				  document.getElementById("password15").style.display="none";
				  document.getElementById("password12").style.display="inline";
				  document.getElementById("password01").style.borderColor="red";
				  return false;
			  }
			  else {
				  if(value.length < 3){
					  document.getElementById("password13").style.display="inline";
					  document.getElementById("password01").style.borderColor="red";
					  return false;
				  }else if(!reg.test(value)){
					  document.getElementById("password13").style.display="inline";
					  document.getElementById("password01").style.borderColor="red";
					  return false;
				  }else if(document.getElementById("password01").value != document.getElementById("password").value){
					  document.getElementById("password14").style.display="inline";
					  document.getElementById("password01").style.borderColor="red";
					  return false;
				  }else {
					  document.getElementById("password15").style.display="inline";
					  return true;
				  }
			  }
			}
		};
		
		function validate_required4(field)
		{	
			var reg1 = /^1[34578]\d{9}$/;
			document.getElementById("phone1").style.display="none";
			document.getElementById("phone2").style.display="none";
			document.getElementById("phone3").style.display="none";
			document.getElementById("phone4").style.display="none";
			with (field)
			{
			  //alert(value);
			  if (value==null||value=="") {
				  document.getElementById("phone2").style.display="inline";
				  document.getElementById("phone").style.borderColor="red";
				  return false;
			  }
			  else {
				  if(value.length < 3){
					  document.getElementById("phone3").style.display="inline";
					  document.getElementById("phone").style.borderColor="red";
					  return false;
				  }else if(!reg1.test(value)){
					  document.getElementById("phone3").style.display="inline";
					  document.getElementById("phone").style.borderColor="red";
					  return false;
				  }else {
					  document.getElementById("phone4").style.display="inline";
					  return true;
				  }
			  }
			}
		};
		
		function validate_form(thisform) {
			 with (thisform)
			  {
				  c.init();
				  document.getElementById("inputCode").value = "";
				  //alert(validate_required4(phone));
				  
				  if (validate_required1(username)==false) {
					  return false;
				  }else if (validate_required2(password)==false){
					  return false;
				  }else if (validate_required3(password01)==false){
					  return false;
				  }else if (validate_required4(phone)==false){
					  return false;
				  }else if(flag == false){
					  return false;
				  }
			  }
		}
		
		$(document).ready(function(){
			
			$("#radiosex").attr("checked","checked");
			
			$("#username").blur(function(){
				$("#username1").css("display","none");
				$("#username2").css("display","none");
				$("#username3").css("display","none");
				$("#username4").css("display","none");
				if($("#username").val() != null && $("#username").val()!=""){
					 if($("#username").val().length < 3) {
						$("#username").css("border-color","red");
						$("#username3").css("display","inline");
					 }else if(!reg.test($("#username").val())){
						$("#username").css("border-color","red");
						$("#username3").css("display","inline");
					 }else {
						$("#username").css("border-color","#a2a2a2");
						$("#username4").css("display","inline");
					 }
				}else {
					$("#username").css("border-color","#a2a2a2");
				}
				//alert($("#username").val() == "");
			});
			
			$("#username").focus(function(){
				$("#username1").css("display","none");
				$("#username2").css("display","none");
				$("#username3").css("display","none");
				$("#username4").css("display","none");
				if($("#username").val() == null || $("#username").val()==""){
					$("#username").css("border-color","red");
					$("#username1").css("display","inline");
				}else {
					//$("#username").css("border-color","black");
					$("#username1").css("display","none");
				}
			});
			
			$("#password").blur(function(){
				$("#password1").css("display","none");
				$("#password2").css("display","none");
				$("#password3").css("display","none");
				$("#password4").css("display","none");
				if($("#password").val() != null && $("#password").val()!=""){
					 if($("#password").val().length < 3) {
						$("#password").css("border-color","red");
						$("#password3").css("display","inline");
					 }else if(!reg.test($("#password").val())){
						$("#password").css("border-color","red");
						$("#password3").css("display","inline");
					 }else {
						$("#password").css("border-color","#a2a2a2");
						$("#password4").css("display","inline");
					 }
				}else {
					$("#password").css("border-color","#a2a2a2");
				}
				//alert($("#password").val() == "");
			});
			
			$("#password").focus(function(){
				$("#password1").css("display","none");
				$("#password2").css("display","none");
				$("#password3").css("display","none");
				$("#password4").css("display","none");
				if($("#password").val() == null || $("#password").val()==""){
					$("#password").css("border-color","red");
					$("#password1").css("display","inline");
				}else {
					//$("#password").css("border-color","black");
					$("#password1").css("display","none");
				}
			});
			
			
			$("#password01").blur(function(){
				$("#password11").css("display","none");
				$("#password12").css("display","none");
				$("#password13").css("display","none");
				$("#password14").css("display","none");
				$("#password15").css("display","none");
				if($("#password01").val() != null && $("#password01").val()!=""){
					 if($("#password01").val().length < 3) {
						$("#password01").css("border-color","red");
						$("#password13").css("display","inline");
					 }else if(!reg.test($("#password01").val())){
						$("#password01").css("border-color","red");
						$("#password13").css("display","inline");
						alert($("#password01").val());
					 }else if($("#password").val() != $("#password01").val()){
						 $("#password01").css("border-color","red");
						 $("#password14").css("display","inline");
					 }else{
						$("#password01").css("border-color","#a2a2a2");
						$("#password15").css("display","inline");
					 }
				}else {
					$("#password01").css("border-color","#a2a2a2");
				}
				//alert($("#password01").val() == "");
			});
			
			$("#password01").focus(function(){
				$("#password11").css("display","none");
				$("#password12").css("display","none");
				$("#password13").css("display","none");
				$("#password14").css("display","none");
				$("#password15").css("display","none");
				if($("#password01").val() == null || $("#password01").val()==""){
					$("#password01").css("border-color","red");
					$("#password11").css("display","inline");
				}else {
					//$("#password1").css("border-color","black");
					$("#password11").css("display","none");
				}
			});
			
			var reg1 = /^1[34578]\d{9}$/;
			$("#phone").blur(function(){
				$("#phone1").css("display","none");
				$("#phone2").css("display","none");
				$("#phone3").css("display","none");
				$("#phone4").css("display","none");
				if($("#phone").val() != null && $("#phone").val()!=""){
					 if($("#phone").val().length < 11) {
						$("#phone").css("border-color","red");
						$("#phone3").css("display","inline");
					 }else if(!reg1.test($("#phone").val())){
						$("#phone").css("border-color","red");
						$("#phone3").css("display","inline");
					 }else {
						$("#phone").css("border-color","#a2a2a2");
						$("#phone4").css("display","inline");
					 }
				}else {
					$("#phone").css("border-color","#a2a2a2");
				}
				//alert($("#phone").val() == "");
			});
			
			$("#phone").focus(function(){
				$("#phone1").css("display","none");
				$("#phone2").css("display","none");
				$("#phone3").css("display","none");
				$("#phone4").css("display","none");
				if($("#phone").val() == null || $("#phone").val()==""){
					$("#phone").css("border-color","red");
					$("#phone1").css("display","inline");
				}else {
					//$("#phone").css("border-color","black");
					$("#phone1").css("display","none");
				}
			});
			
		});