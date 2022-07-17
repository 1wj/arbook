<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE >
<html>
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8"/>
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/query.css" />
		<script type="text/javascript" src="jquery-1.11.3.min.js"></script>
		<%--<script type="text/javascript" src="js/category.js"></script>--%>
		<script type="text/javascript" src="js/category.js"></script>
		<script type="text/javascript">


			function toListPage(){
				window.location="category/category_selectByPage.jsp";
			}
		</script>
		<style type="text/css">
		table{
			border-collapse: collapse;
			margin:30px auto; 
		}
		</style>
		<script type="text/javascript">
			$(function (){
				var flag=1;
				var pd= $(":text[name=cateid]").val();
				if(pd==null ||pd==""){
					flag=0;
				}
				//点击提交按钮
				$("#submit").click(function(){
					var categoryName=$("#categoryName").val();
					var description=$("#description").val();
					if($.trim(categoryName)==null || $.trim(categoryName)==""){

						$("#message0").empty().html("请输入类别名称");

						return false;
					}else{
						$("#message0").empty();

					}
					if($.trim(description)==null || $.trim(description)==""){
						$("#message1").empty().html("请输入类别描述");
						return false;
					}else{
						$("#message1").empty();

					}

					//保存数据进入数据库
					var lbid= $(":text[name=cateid]").val();
					var lbmc= $("#categoryName").val();
					var lbms= $("#description").val();

					$.ajax({
						url:"settings/save.do",
						data:{
							"lbid":lbid,
							"lbmc":lbmc,
							"lbms":lbms,
							"flag":flag
						},
						dataType:"json",
						type:"post",
						success:function (data) {//{"success:true/false"}
							//alert("成功进入");
							if(data.success){
								document.location.href = "category/category_selectByPage.jsp";
							}else {
								alert("添加失败")
							}
						}

					})

				})

				//类别id是否重复
				$(":text[name=cateid]").blur(function(){
					//alert(1);
					var lbid= $(":text[name=cateid]").val();
					$.ajax({
						url:"settings/selectById.do",
						data:{
							"lbid":lbid,
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
				$("#description").val("${editclasst.describe_1}");

				//
			})
		</script>

	</head>
	<body>
		<div id="top">当前位置：类别管理 -- 添加小说类别</div>
		<div class="retrunList"><button onclick="toListPage()">返回查看类别</button>
		<div id="contextbotton">
		<form >
			<table    id="tab" style="margin-top: 30px;border-collapse: separate; border-spacing: 0px 10px;">
				<tr>
					<td align="right">类别ID:</td>
					<td align="left"><input type="text" name="cateid" value="${editclasst.cid}"/></td>
				</tr>
				<tr>
					<td align="right" style="width:40%;">类别名称:</td>
					<td align="left">
						<input type="text" name="categoryname" id="categoryName" value="${editclasst.cname}"/>
						<span id="message0" class="message" style="color: red"></span>
					</td>
					
				</tr>
				<tr>
					<td align="right">类别描述:</td>
					<td align="left">
						<textarea id="description" ></textarea>
						<span class="message" id="message1" style="color: red"></span>
					</td>
				</tr>
				<tr>
					<td colspan="2" ><input type="button" value="提交" id="submit" style="width: 60px;"/> </td>
					
				</tr>
			</table>

		</form>
		</div>
		</div>
	</body>
</html>