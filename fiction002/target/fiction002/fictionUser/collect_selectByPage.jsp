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
				$("#seBtn").click(function (){
                   // alert(1);
                    getClasstList(1);
                })
			})

			function toListPage(){
				window.location="fictionUser/fictionUser_selectByPage.jsp";
			}

			//分页函数
			function getClasstList(pageNo){
				var xsid=$("#xsid").val();
				var xsmc=$("#xsmc").val();
				var xszz=$("#xszz").val();

				$.ajax({
					url:"settings/user/collect/selectList.do",
					data:{
						"xsid" : xsid,
						"xsmc":xsmc,
						"xszz":xszz,
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
							html +="<tr>";
							html +="<td>"+n.bid+"</td>";
							html +="<td>"+n.bname+"</td>";
							html +="<td>"+n.author+"</td>";
							html +="<td>"+n.bproperty+"</td>";
							html +="<td><img  src='bookimg/"+(parseInt(i)+1)+"0000.jpg'></td>";
							html +="<td><a href='${pageContext.request.contextPath}/settings/user/collect/deleteById.do?collectId="+n.bid+"&status="+n.status+"'>删除收藏</a></td>";
							html +="</tr>";
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
		<div id="top"> 当前位置：用户管理 -- 收藏信息</div>
		<div class="retrunList"><button onclick="toListPage()">返回用户列表</button></div>
		<div id="contexttop">
		<table border="1" cellspacing="0" id="tab">
			<tr>
				<form>
					<td colspan="6" align="center">

						<input type="text" placeholder="小说ID" id="xsid"/> --
						<input type="text" placeholder="小说名称" id="xsmc"/> --
						<input type="text" placeholder="作者" id="xszz"/> --
						<input type="button" id="seBtn" value="查询" />

					</td>
				</form>

			</tr>
			
			<tr bgcolor="aquamarine">
				<th>小说ID</th>
				<th>小说名称</th>
				<th>作者</th>
				<th>简要概述</th>
				<th>封面</th>
				<th>操作</th>
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
