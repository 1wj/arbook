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
		<style type="text/css">
			td{
				padding:10px 20px;
			}
			table{
				border-collapse: collapse;
			}
			table,td,th{
				border:1px solid black;
			}
		</style>
		<link rel="stylesheet" type="text/css" href="css/query.css" />
		<script type="text/javascript" src="jquery-1.11.3.min.js"></script>
		<script type="text/javascript">
			$(function (){


				getClasstList(1);//传过去一个页数

				//当点击首页时
				$("#firstPage").click(function (){

					getClasstList(1);
				});
				//当点击上一页时
				$("#previousPage").click(function (){
					var pageNo=$("#dqy").val();
					if(pageNo!=1){
						getClasstList(pageNo-1);
					}

				});
				//当点击下一页时
				$("#nextPage").click(function (){
					var pageNo=$("#dqy").val();
					if(pageNo<$("#gjy").val()){
						getClasstList(parseInt(pageNo)+1);
					}

				});
				//当点击最后一页时
				$("#lastPage").click(function (){
					var pageNo=$("#gjy").val();
					getClasstList(pageNo);
				});

				//当点击查询按钮
				$("#selectBtn").click(function (){
					getClasstList(1);

				})


			})


			//分页函数
			function getClasstList(pageNo){
				var glyid=$(":text[name=glyid]").val();
				var glymc=$(":text[name=glymc]").val();
				var glync=$(":text[name=glync]").val();
				$.ajax({
					url:"settings/admin/selectList.do",
					data:{
						"aid" : glyid,
						"aname":glymc,
						"anickname":glync,
						"pageNo" : pageNo, //当前页数 ，每页的数量固定为3
					},
					dataType:"json",
					type:"post",
					success:function (data){
						//{"uList":[{对象1},{对象2}，{}],"总页数total":3,"当前页数pageNo":2,"总条数recodeCount":12}
						//alert(1);
						var html="";
						$.each(data.uList,function (i,n){//每一个n就是一个对象
							//alert(n.cid);
							html +='<tr>';
							html +='<td align="center">'+n.aid+'</td>';
							html +='<td align="center">'+n.aname+'</td>';
							html +='<td align="center">'+n.anickname+'</td>';
							html +='<td align="center">'+n.acreatetime+'</td>';
							html +='<td align="center"><a href="${pageContext.request.contextPath}/settings/admin/editById.do?aid='+n.aid+'">编辑</a></td>';
							html +='<td align="center"><a href="${pageContext.request.contextPath}/manager/manager_toUpdate.jsp?aid='+n.aid+'">重置密码</a></td>';
							html +='<td align="center"><a href="${pageContext.request.contextPath}/settings/admin/deleteById.do?aid='+n.aid+'">删除</a></td>';
							html +='</tr>';
						})
						$("#tbody").html(html);

						$("#zjls").val(data.recodeCount);
						$("#gjy").val(data.total);
						$("#dqy").val(pageNo);
					}

				})
			}
		</script>
	</head>
	<body>
		<div id="top">当前位置：管理员管理 -- 查看管理员</div>
		<div id="contexttop">
		
		<table border="1" align="center" width="900" id="tab">
			<form>
				<tr align="center">
					<td colspan="7">
				<input type="text" placeholder="管理员ID" name="glyid" />&nbsp;
				<input type="text" placeholder="管理员用户名" name="glymc" />&nbsp;
				<input type="text" placeholder="管理员昵称" name="glync"/>&nbsp;
				<input type="button"  id="selectBtn" value="查询" />
				    </td>
				</tr>
			</form>
			<tr bgcolor="#e0fbc4">
					<th>管理员ID</th>
					<th>管理员用户名</th>
					<th>管理员昵称</th>
					<th>管理员创建时间</th>
					<th colspan="3">操作</th>
			</tr>
			<tbody id="tbody">

			</tbody>
	    </table>
		</div>
		<div align="center" id="contextbotton">
			总记录数 <input type="text" id="zjls"> 条
			共 <input type="text" id="gjy"> 页
			<a href="javascript:void(0)" id="firstPage">首页</a>
			<a href="javascript:void(0)" id="previousPage">上一页</a>
			<a href="javascript:void(0)" id="nextPage">下一页</a>
			<a href="javascript:void(0)" id="lastPage">尾页</a>
			第 <input type="text" id="dqy" > 页

		</div>
	</body>
</html>
