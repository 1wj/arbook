$(function(){
	//鼠标点击登录
	$("#submitBtn").click(function(){
		//alert(1);
		login()
	})
	//键盘回车登录
	$(window).keydown(function (event){
		if(event.keyCode==13){
			login();
		}
	})

})
	//登录函数
	function login(){
		var namestr=$(":text").val();
		var passwdstr=$(":password").val();//注意trim()用法
		if($.trim(namestr)==null || $.trim(namestr)==""){
			alert("用户名不能为空");
			return false;
		}else if( passwdstr==null|| passwdstr==""){
			//alert(1);
			alert("密码不能为空");
			return false;
		}
		$.ajax({
			url:"settings/login.do",
			data:{
				"namestr":namestr,
				"passwdstr":passwdstr
			},
			dataType:"json",
			type:"post",
			success:function (data) {
				if(data.success){
					alert("成功");
					document.location.href = "main.html";
				}else {
					alert("失败,请重新输入密码");
					return false;
				}

			}
		})
	}
