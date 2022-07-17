$(function(){

	//类别名称改变
	$("#categoryName").change(function(){
		if($(this).val().length>15){
			$("#message0").html("类别名称长度不能超过15字符");
			$("#submit").prop("disabled",true);
		}else{
			$("#message0").empty();
			//$("#submit").prop("disabled",false);
			checkspan();
		}
		
	})
	//描述改变
	$("#description").change(function(){
		if($(this).val().length>15){
			$("#message1").html("类别名称描述不能超过15字符");
			$("#submit").prop("disabled",true);
		}else{
			$("#message1").empty();
			
			checkspan();
		}
		
	})

	
})
/*判断是否亮   是两个class的长度和*/
function checkspan(){
	 var flag=$(".message").text();
	 if(flag.length==0){
		 
		 $("#submit").prop("disabled",false);
	 }
}