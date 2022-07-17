$(function(){
	
	$(":text[name='nichen']").blur(function(){
		//alert(2);
		var str=$(this).val();
		str=$.trim(str);
		
		if(str==null || str==""){
			alert(str);
			$("#sp4").empty().html("昵称不能为空");
			
			$("#submitBtn").prop("disabled",true);
		}else{
			$("#sp4").empty();
			checkspan();

				var str2=$(":text[name='nichen']").val();
				str2=$.trim(str2);
				if(str2.length>8){
					$("#sp4").empty().html("昵称过长");
					 $("#submitBtn").prop("disabled",true);
				}else{
					$("#sp4").empty();
					checkspan();
				}
				
			
		}
	
		
	})
	
	
	
	
	
	$("#tel").change(function(){
		var str=$(this).val();
		var reg=/^1[3-9]\d{9}$/;
		if(!reg.test(str)){
			$("#sp1").empty().html("对不起，手机号不规范");
			$("#submitBtn").prop("disabled",true);
		}else{
			$("#sp1").empty();
			//$(":submit").prop("disabled",false);
			checkspan();
		}
	})
	$(":text[name='vip']").blur(function(){
		
		var str=$(this).val();
		str=$.trim(str);
		if(str==null || str==""){
			$("#sp2").empty().html("剩余会员天数不能为空");	
			$("#submitBtn").prop("disabled",true);
		}else{
			$("#sp2").empty();
			checkspan();
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