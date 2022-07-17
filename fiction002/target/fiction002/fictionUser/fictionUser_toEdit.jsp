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
		<link rel="stylesheet" type="text/css" href="css/query.css">
		<script type="text/javascript" src="jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="js/fictionUser_toEdit.js"></script>
		<script type="text/javascript">
			$(function () {
				var flag=1;
				var pd= $(":text[name=bid]").val();
				if(pd==null ||pd==""){
					flag=0;
				}
				//点击提交按钮
				$("#submitBtn").click(function () {
						//保存数据进入数据库
						var yhid=$(":text[name=uid]").val();
						var yhnc=$(":text[name=nichen]").val();
						var yhtel=$("#tel").val();
						var yhvip=$(":text[name=vip]").val();
						$.ajax({
							url:"settings/user/save.do",
							data:{
								"yhid":yhid,
								"yhnc":yhnc,
								"yhtel":yhtel,
								"yhvip":yhvip,
								"flag":flag
							},
							dataType:"json",
							type:"post",
							success:function (data) {//{"success:true/false"}
								//alert("成功进入");
								if(data.success){
									document.location.href = "fictionUser/fictionUser_selectByPage.jsp";
								}else {
									alert("添加失败")
								}
							}

						})
				})
			})
		</script>
	</head>
	<body>
		<table id="tab" >
			<tr>
				<td align="right">用户ID:</td>
				<td align="left"><input type="text" name="uid" value="${edituser.userid}" /></td>
			</tr>
			<tr>
				<td align="right">昵称:</td>
				<td align="left">
					<input type="text" name="nichen" value="${edituser.unickname}" />
					<span id="sp4" style="color: red;" class="message">*</span>
				</td>
			</tr>
			<tr>
				<td align="right" style="width: 40%;" >手机号码:</td>
				<td align="left">
					<input type="text" id="tel" value="${edituser.tel}" />
					<span id="sp1" style="color: red; " class="message">*</span>
				</td>
			</tr>
			<tr>
				<td align="right">会员剩余天数:</td>
				<td align="left">
					<input type="text" name="vip"  value="${edituser.remaindays}"/>
					<span id="sp2" style="color: red;" class="message">*</span>
					</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" id="submitBtn" value="提交"  />
					</td>
				
			</tr>
		</table>
		
	</body>
</html>
