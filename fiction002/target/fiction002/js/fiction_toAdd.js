$(function(){
	
	$(":text[name='bname']").blur(function(){
		
		var str=$(this).val();
		str=$.trim(str);
		
		if(str==null || str==""){
			
			$("#sp1").empty().html("小说名称不能为空");
			 $("#submitBtn").prop("disabled",true);
		}else{
			$("#sp1").empty();
			checkspan();
			
			var str2=$(":text[name='bname']").val();
			str2=$.trim(str2);
			if(str2.length>8){
				$("#sp1").empty().html("小说名过长");
				 $("#submitBtn").prop("disabled",true);
			}else{
				$("#sp1").empty();
				checkspan();
			}
		}
	})
	
	$(":text[name='bauthour']").blur(function(){
		
		var str=$(this).val();
		str=$.trim(str);
		//alert(str);
		if(str.length>15){
			$("#sp2").empty().html("作者名称过长");
			 $(":submit").prop("disabled",true);
		}else{
			$("#sp2").empty();
			checkspan();
			
			var str2=$(":text[name='bauthour']").val();
			str2=$.trim(str2);
			if(str2.length>8){
				$("#sp2").empty().html("作者名称过长");
				 $(":submit").prop("disabled",true);
			}else{
				$("#sp2").empty();
				checkspan();
			}
			
		}
	})
	
	$("#ty").change(function(){
		var str=$(this).val();
		str=$.trim(str);
		if(str==null || str==""){
			$("#sp3").empty().html("简介不能为空");
			 $(":submit").prop("disabled",true);
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
		 $("#submitBtn").prop("disabled",false);
	 }
}