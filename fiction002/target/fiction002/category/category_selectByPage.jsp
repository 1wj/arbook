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
		<title>小说类别管理</title>
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
				$("#selectBtn").click(function (){
					getClasstList(1);

				})

				//当点击删除按钮 目前做不到
				/*$("#tbody").on("click",$("a[name=sca]"),function () {
					var str=$("a[name=sca]").attr(value);
					alert(str);
					if(confirm("你确定删除吗？")){
						document.location.href = "settings/deleteById.do?cid="+str+"";
					}
				})
*/

			})


//分页函数
			function getClasstList(pageNo){
				var lbid=$(":text[name=lbid]").val();
				var lbmc=$(":text[name=lbmc]").val();
				var ms=$(":text[name=ms]").val();
				$.ajax({
					url:"settings/selectList.do",
					data:{
						"lbid" : lbid,
						"lbmc":lbmc,
						"ms":ms,
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
							html+="<tr>";
							html+="<td>"+n.cid+"</td>";
							html+="<td>"+n.cname+"</td>";
							html+="<td>"+n.ccreatetime+"</td>";
							html+="<td class='desc'>"+n.describe_1+"</td>";
							html+="<td><a href='${pageContext.request.contextPath}/settings/editById.do?cid="+n.cid+"'>编辑</a></td>";
							html+="<td><a href='${pageContext.request.contextPath}/settings/deleteById.do?cid="+n.cid+"'>删除</a></td>";
							html+="</tr>";
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
		<div id="top">当前位置：类别管理 -- 查看小说类别</div>
		<div id="contexttop">
		<table border="1" id="tab">
			<tr height="50">
				<form>
					<td colspan="6" >
						<input type="text"  name="lbid" placeholder="类别ID" />
						<input type="text"  name="lbmc" placeholder="类别名称" />
						<input type="text"  name="ms" placeholder="描述" />
						<input type="button" value="查询" id="selectBtn"/>
					</td>
				</form>
				
			</tr>
			<tr bgcolor="aquamarine">
				<th>类别ID</th>
				<th>类别名称</th>
				<th>创建时间</th>
				<th>描述</th>
				<th colspan="2">操作</th>
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