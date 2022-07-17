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
		<script type="text/javascript">
			function toListPage(){
				window.location="notice/notice_selectByPage.jsp";
			}

			$(function () {
				$("#area").val("${messaget.message_t}");
			})
		</script>
		<style type="text/css">
			table{
				margin: 30px auto;
			}
		</style>
	</head>
	<body>
		<div id="top"> 当前位置：消息管理 -- 消息内容</div>
		<div class="retrunList"><button onclick="toListPage()">返回查看消息</button></div>
		<div id="contexttop">
		<table align="center" id="tab">
			<tr>
				<td align="right">消息标题：</td>
				<td align="left"><input type="text" value="${messaget.mtitle}" /></td>
			</tr>
			<tr>
				<td align="right">类别描述：</td>
				<td align="left">
					<textarea id="area"></textarea>
				</td>
			</tr>
		</table>
		</div>
	</body>
</html>
