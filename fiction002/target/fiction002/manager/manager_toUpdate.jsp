<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/query.css" />
		<script type="text/javascript" src="jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="js/manager_toupdate.js"></script>
		<style type="text/css">
			table{
				border-collapse: collapse;
				margin:30px auto; 
			}
		</style>
		
		<script type="text/javascript">
			function toListPage(){
				window.location="manager/manager_selectByPage.jsp";
			}
			$(function () {
				$("#submitBtn").click(function () {
					var glymc=$("#glymc").val();
					var oldpa=$("#oldpa").val();
					var newpa2=$("#newpa2").val();
					$.ajax({
						url:"settings/admin/chongzhi.do",
						data:{
							"aid" : "${param.aid}",
							"aname":glymc,
							"oldpa":oldpa,
							"newpa2":newpa2
						},
						dataType:"json",
						type:"post",
						success:function (data){
							//{"uList":[{对象1},{对象2}，{}],"总页数total":3,"当前页数pageNo":2,"总条数recodeCount":12}
							if(data){
								alert("重置密码成功");
							}else {
								alert("重置密码失败");
							}

						}

					})
				})
			})
		</script>
	</head>
	<body>
		<div id="top">当前位置：管理员管理 -- 修改管理员</div>
		<div class="retrunList"><button onclick="toListPage()">返回查看管理员</button></div>
		<div id="contexttop">
		<table align="center" >
			<tr>
				<td align="right">管理员用户名：</td>
				<td><input type="text" name="uname" id="glymc"/>
					<span id="sp1" style="color:red" class="message">*</span>
				</td>
			</tr>
			<tr>
				<td align="right" >旧密码：</td>
				<td><input type="password" name="old" id="oldpa"/>
					<span id="sp2" style="color:red" class="message">*</span>
				</td>
			</tr>
			<tr>
				<td align="right">新密码：</td>
				<td><input type="password" name="neew" id="newpa"/></td>
			</tr>
			<tr>
				<td align="right">重复输入新密码：</td>
				<td><input type="password" name="cf" id="newpa2"/>
				<span id="sp3" style="color:red" class="message">*</span>
				</td>
			</tr>
			<tr>
				<td align="right"><input type="button" id="submitBtn" value="提交" /></td>
			</tr>
		</table>
		</div>
	</body>
</html>
