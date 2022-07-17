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
			$(function (){
				//页面加载完展示类别数据【一页三条】
				//var pageNo=$("#dqy").val();
				/*alert(pageNo);
				alert(pageNo+1);*/
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
				$("#seleteBtn").click(function (){
					getClasstList(1);
				})
			})


			//分页函数
			function getClasstList(pageNo){
				var yhid=$(":text[name=yhid]").val();
				var yhmc=$(":text[name=yhmc]").val();
				var yhnc=$(":text[name=yhnc]").val();
				var yhsj=$(":text[name=yhsj]").val();
				$.ajax({
					url:"settings/message/userSelectList.do",
					data:{
						"yhid" : yhid,
						"yhmc":yhmc,
						"yhnc":yhnc,
						"yhsj":yhsj,
						"pageNo" : pageNo, //当前页数 ，每页的数量固定为3
					},
					dataType:"json",
					type:"post",
					success:function (data){
						//{"uList":[{对象1},{对象2}，{}],"总页数total":3,"当前页数pageNo":2,"总条数recodeCount":12}
						//alert(1);
						var html="";
						$.each(data.uList,function (i,n){//每一个n就是一个对象
							//alert(n.bid);
							//alert(n.cid);
							html += "<tr>";
							html += "<td>"+n.userid+"</td>";
							html += "<td>"+n.uname+"</td>";
							html += "<td>"+n.unickname+"</td>";
							html += "<td>"+n.tel+"</td>";
							html += "<td>"+n.remaindays+"</td>";
							html += "</tr>";
						})
						$("#tbody").html(html);
						$("#zjls").val(data.recodeCount);
						$("#gjy").val(data.total);
						$("#dqy").val(pageNo);
					}

				})
			}

		</script>
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
	</head>
	<body>
		<div id="top"> 当前位置：消息管理 -- 接收消息</div>
		<div class="retrunList"><button onclick="toListPage()">返回查看消息</button></div>
		<div id="contexttop">
		<table border="1" align="center" width="900" id="tab">
			<tr>
				<form >
					<td colspan="10" align="center">
						<input type="text" placeholder="用户ID" name="yhid" />
						<input type="text" placeholder="用户名" name="yhmc"/>
						<input type="text" placeholder="昵称"   name="yhnc"/>
						<input type="text" placeholder="手机"   name="yhsj"/>
						<input type="button" value="查询" id="seleteBtn" />
					</td>
				</form>
			</tr>
			<tr bgcolor="#e0fbc4">
					<th>用户ID</th>
					<th>用户名</th>
					<th>昵称</th>
					<th>手机号</th>
					<th>剩余会员天数</th>
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
