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
				window.location="fiction/fiction_selectByPage.jsp";
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

				//当点击添加按钮
				$("#addBtn").click(function (){
				var chacMc=$("#chacMc").val();
					$.ajax({
						url:"settings/character/addByMc.do",
						data:{
							"chacMc":chacMc
						},
						dataType:"json",
						type:"post",
						success:function (data) {
							//{"success":true/false}
							//alert("成功");
							if(data.success){
								alert("添加成功");
								getClasstList(1);
							}else {
								alert("添加失败");
							}
						}

					})

				})
			})

			//分页函数
			function getClasstList(pageNo){

				$.ajax({
					url:"settings/character/selectList.do",
					data:{
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
							html+="<tr>";
							html+="<td>"+n.characterid+"</td>";
							html+="<td>"+n.charactername+"</td>";
							html+="<td>"+n.characterpath+"</td>";
							html+="<td>"+n.bid+"</td>";
							html+="<td> <a href='${pageContext.request.contextPath}/settings/character/deleteById.do?characterid="+n.characterid+"&charactername="+n.charactername+"'>删除</a></td>";
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
		<div id="top">当前位置：小说管理 -- 章节管理</div>
		<div class="retrunList"><button onclick="toListPage()">返回查看小说</button>
		<div id="contexttop">
		<table border="1" cellspacing="0" cellpadding="3" id="tab">
			<tr>
				<td colspan="5" >
					<form> 
						章节名称：<input type="text" id="chacMc" placeholder="请填写章节名称" />
						章节文件:<input type="file" />
						<input type="button" value="添加章节"  id="addBtn"/>
					</form>
				</td>
			
			</tr>
			<tr>
				<th>章节ID</th>
				<th>章节名称 </th>
				<th>文件存放路径</th>
				<th>所在小说</th>
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
		</div>
	</body>
</html>
