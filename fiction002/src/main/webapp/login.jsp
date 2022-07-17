<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE >
<html>
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<title>小说网后台管理</title>
		<link rel="stylesheet" type="text/css" href="css/index.css" />
		<script type="text/javascript" src="jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="js/login.js"></script>
		<script type="text/javascript">
		/*	$(function(){
				$("#submitBtn").click(function(){
					//alert(1);
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

				})


			})*/


		</script>
	</head>
	<body>
		<div id="total">
		<form  action="main.html">
			<table id="tab">
				<tr>
					<td>用户姓名</td>
					<td><input type="text" name="username"  id="username"    placeholder="请输入用户名" /></td>
				</tr>
				<tr>
					<td>用户密码</td>
					<td><input type="password" name="passwd"  id="password"  placeholder="请输入用户密码"  /></td>
				</tr>
				<tr>
					<td><input type="button" id="submitBtn" value="登录" /></td>
					<td><input type="reset"  value="重置"  /></td>
				</tr>
			</table>
		</form>
		</div>
		
	</body>
</html>