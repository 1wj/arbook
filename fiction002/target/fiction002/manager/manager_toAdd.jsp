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
		<script type="text/javascript" src="js/manager.js"></script>
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

			$(function (){
				var flag=1;
				var pd= $("#glyid").val();
				if(pd==null ||pd==""){
					flag=0;
				}
				//当提交按钮点击时
				$("#submitBtn").click(function () {
					var glyid= $("#glyid").val();
					var glyxm= $("#glyxm").val();
					var glync= $("#glync").val();
					var glymm2= $("#glymm2").val();

					$.ajax({
						url:"settings/admin/save.do",
						data:{
							"aid":glyid,
							"aname":glyxm,
							"anickname":glync,
							"apasswd":glymm2,
							"flag":flag
						},
						dataType:"json",
						type:"post",
						success:function (data) {//{"success:true/false"}
							//alert("成功进入");
							if(data.success){
								document.location.href = "manager/manager_selectByPage.jsp";
							}else {
								alert("添加失败")
							}
						}

					})
				})
				//类别id是否重复
				$("#glyid").blur(function(){

					var glyid= $(this).val();
					$.ajax({
						url:"settings/admin/selectById.do",
						data:{
							"aid":glyid,
						},
						dataType:"json",
						type:"post",
						success:function (data) {//{"success:true/false"}
							//alert("成功进入");
							if(data.success){
								alert("值已重复")
							}
						}
					})
				})

				//修改时如先给描述铺上值
				/*$("#description").val("${editclasst.describe_1}");*/

			})
		</script>
	</head>
	<body>
		<div id="top">当前位置：管理员管理 -- 添加管理员</div>
		<div class="retrunList"><button onclick="toListPage()">返回查看管理员</button></div>
		<div id="contexttop">
		
		<table align="center"  id="tab" style="margin-top: 30px;border-collapse: separate; border-spacing: 0px 10px;">
			<tr>
				<td align="right">管理员ID：</td>
				<td align="left"><input type="text" id="glyid"  value="${editadmint.aid}"/></td>
			</tr>
			<tr>
				<td align="right">管理员用户名：</td>
				<td align="left"><input type="text" name="mname" id="glyxm" value="${editadmint.aname}"/>
				<span id="sp2" style="color: red;" class="message">*</span>
				</td>
			</tr>
			<tr>
				<td align="right">管理员密码：</td>
				<td align="left"><input type="password" name="password" id="glymm" value="${editadmint.apasswd}"/>
					<span style="color: red;">*</span>
				</td>
			</tr>
			<tr>
				<td align="right" style="width:40%;" >重复输入密码：</td>
				<td align="left"><input type="password" name="password2" id="glymm2" value="${editadmint.apasswd}"/>
					<span id="message2" class="message" style="color: red;" >*</span>
				</td>
			</tr>
			<tr>
				<td align="right">管理员昵称：</td>
				<td align="left"><input type="text" name="nc" id="glync" value="${editadmint.anickname}"/>
				<span id="sp3" style="color: red;" class="message">*</span>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="button" value="提交" id="submitBtn" /></td>
			</tr>
		</table>
		</div>

	</body>
</html>
