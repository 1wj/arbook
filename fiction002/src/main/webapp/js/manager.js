$(function(){
	
	$(":text[name='mname']").blur(function(){
		
		var str=$(this).val();
		//str=$.trim(str);
		
		if(str==null || str==""){
			//alert(str);
			$("#sp2").empty().html("用户名不能为空");
			
			$("#submitBtn").prop("disabled",true);
		}else{
			$("#sp2").empty();
			checkspan();
			
			var str2=$(":text[name='mname']").val();
			str2=$.trim(str2);
			if(str2.length>8){
				$("#sp2").empty().html("用户名过长");
				 $("#submitBtn").prop("disabled",true);
			}else{
				$("#sp2").empty();
				checkspan();
			}
		}
	
		
	})
	

	$(":input[name='password2']").change(function(){
		var passwd2=$(this).val();
		passwd2=$.trim(passwd2);
		var passwd=$(":input[name='password']").val();
		passwd=$.trim(passwd);
		if(passwd!=passwd2){
			$("#message2").html("对不起，两次输入不一致");
			$("#submitBtn").empty().prop("disabled",true);
		}else{
			$("#message2").empty();
			checkspan();
		}
		
	})
	
	$(":text[name='nc']").blur(function(){
		
		var str=$(this).val();
		str=$.trim(str);
		
		if(str==null || str==""){
		//	alert(str);
			$("#sp3").empty().html("昵称不能为空");
			
			$("#submitBtn").prop("disabled",true);
		}else{
			$("#sp3").empty();
			checkspan();
			
			var str2=$(":text[name='nc']").val();
			str2=$.trim(str2);
			if(str2.length>8){
				$("#sp3").empty().html("昵称过长");
				 $("#submitBtn").prop("disabled",true);
			}else{
				$("#sp3").empty();
				checkspan();
			}
		}
	
		
	})
	
})
/*判断是否亮*/
function checkspan(){
	 var flag=$(".message").text();
	 if(flag.length==0){
		 $("#submitBtn").prop("disabled",false);
	 }
}