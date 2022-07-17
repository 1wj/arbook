$(function(){
		 $("dd").hide();
		 
})
function menu(o){
		var dd=$(o).find("dd");
		if(dd.is(":hidden")){
			dd.show();
		}else{
			dd.hide();
		}
}


