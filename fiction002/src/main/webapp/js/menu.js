window.onload = function(){
	var divs = document.getElementsByTagName("div");
	for(var a=0;a<divs.length;a++){
		var dd = divs[a].getElementsByTagName("dd");
		for(var i=0;i<dd.length;i++){
			dd[i].style.display = "none";
		}
	}
}

function menu(o){
	var dd = o.getElementsByTagName("dd");
	for(var i=0;i<dd.length;i++){
		if(dd[i].style.display=="none"){
			dd[i].style.display = "block";
		}else{
			dd[i].style.display = "none";
		}
	}
}