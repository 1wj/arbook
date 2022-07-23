<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<script type="text/javascript">
			function toListPage(){
				window.location="fiction/fiction_selectByPage.jsp";
			}

			$(function (){



			})
		</script>
	</head>
	<body>
		<div id="top">当前位置：小说管理 -- 详细信息</div>
		<div class="retrunList"><button onclick="toListPage()">返回查看小说</button>
		<div id="contexttop">
			<table >
			<tr >
				<td align="right">小说ID:</td>
				<td>${detailbook.bid}</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td align="right">小说名称:</td>
				<td>${detailbook.bname}</td>
			</tr>
			<tr >
				<td align="right">作者:</td>
				<td>${detailbook.author}</td>
				<td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<%--<td align="right">类别:</td>
				<td>${detailbook.author}</td>--%>
			</tr>
			<tr>
				<td align="right">是否四会员小说:</td>
				<td>${detailbook.isvip}</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td align="right">上架状态:</td>
				<td>${detailbook.status}</td>
			</tr>
		<%--	<tr >
				<td align="right">浏览量:</td>
				<td>${detailbook.author}</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td align="right">收藏量:</td>
				<td>${detailbook.author}</td>
			</tr>--%>
			<tr >
				<td align="right">封面图片:</td>
				<td><img src="pic/1.jpg"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td align="right">描述:</td>
				<td>${detailbook.bproperty}</td>
			</tr>
		</table>
		</div>
		</div>

	<c:forEach var=" " items="">

	</c:forEach>
	</body>

</html>
