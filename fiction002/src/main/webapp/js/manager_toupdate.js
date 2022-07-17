$(function(){
	
	$(":text[name='uname']").blur(function(){
		
		var str=$(this).val();
		//str=$.trim(str);
		
		if(str==null || str==""){
			//alert(str);
			$("#sp1").empty().html("用户名不能为空");
			
			$("#sumitBtn").prop("disabled",true);
		}else{
			$("#sp1").empty();
			checkspan();
			
			var str2=$(":text[name='uname']").val();
			str2=$.trim(str2);
			if(str2.length>8){
				$("#sp1").empty().html("用户名过长");
				 $("#sumitBtn").prop("disabled",true);
			}else{
				$("#sp1").empty();
				checkspan();
			}
		}
	
		
	})
	$(":password[name='old']").blur(function(){
		
		var str=$(this).val();
		//str=$.trim(str);
		
		if(str==null || str==""){
			//alert(str);
			$("#sp2").empty().html("旧密码不能为空");
			
			$("#sumitBtn").prop("disabled",true);
		}else{
			$("#sp2").empty();
			checkspan();
		}
	
		
	})

	$(":password[name='cf']").change(function(){
		var passwd2=$(this).val();
		passwd2=$.trim(passwd2);
		var passwd=$(":password[name='neew']").val();
		passwd=$.trim(passwd);
		if(passwd!=passwd2){
			alert(passwd);
			alert(passwd2);
			$("#sp3").html("对不起，两次输入不一致");
			$("#sumitBtn").empty().prop("disabled",true);
		}else{
			$("#sp3").empty();
			checkspan();
		}
		
	})
	
	
})
/*判断是否亮*/
function checkspan(){
	 var flag=$(".message").text();
	 if(flag.length==0){
		 $(":submit").prop("disabled",false);
	 }
}