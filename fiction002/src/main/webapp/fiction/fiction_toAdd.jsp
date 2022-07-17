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
		<script type="text/javascript" src="js/fiction_toAdd.js"></script>
		<script type="text/javascript">
			function toListPage(){
				window.location="fiction/fiction_selectByPage.jsp";
			}
		</script>
		<style type="text/css">
		table{
			border-collapse: collapse;
			margin:30px auto; 
		
		}</style>

		<script type="text/javascript">
			$(function (){
				var flag=1;
				var pd= $(":text[name=bid]").val();
				if(pd==null ||pd==""){
					flag=0;
				}
				//点击提交按钮
				$("#submitBtn").click(function(){
					//保存数据进入数据库
					var xsid=$(":text[name=bid]").val();
					var xsmc=$("#name").val();
					var xszz=$("#saveauthor").val();
					var xsgs=$("#ty").val();
					var xshy= $(":radio[name=isvip]:checked").val();
					var xssj= $(":radio[name=isshangjia]:checked").val();

					$.ajax({
						url:"settings/book/save.do",
						data:{
							"xsid":xsid,
							"xsmc":xsmc,
							"xszz":xszz,
							"xsgs":xsgs,
							"xshy":xshy,
							"xssj":xssj,
							"flag":flag
						},
						dataType:"json",
						type:"post",
						success:function (data) {//{"success:true/false"}
							//alert("成功进入");
							if(data.success){
								document.location.href = "fiction/fiction_selectByPage.jsp";
							}else {
								alert("添加失败")
							}
						}

					})

				})

				//类别id是否重复
				$(":text[name=bid]").blur(function(){
					//alert(1);
					var xsid= $(":text[name=bid]").val();
					$.ajax({
						url:"settings/book/selectByid.do",
						data:{
							"xsid":xsid,
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

				//修改时先给描述铺上值
				$("#ty").val("${editbook.bproperty}");


			})
		</script>

	</head>
	<body>
		<div id="top">当前位置：小说管理 -- 添加小说类别</div>
		<div class="retrunList"><button onclick="toListPage()">返回小说类别</button>
		<div id="contexttop">
		<form>
			<table border="0">
				<tr>
					<td align="right">小说ID:</th>
					<td> <input type="text" name="bid" value="${editbook.bid}"/></td>
				</tr>
				<tr>
					<td align="right">小说名称:</th>
					<td> 
						<input type="text" name="bname" id="name" value="${editbook.bname}" />
						<span id="sp1" style="color: red;" class="message">*</span>
					</td>
				</tr>
				<tr>
					<td align="right">作者:</th>
					<td>
						<input type="text" name="bauthour" id="saveauthor" value="${editbook.author}"/>
						<span id="sp2" style="color: red;" class="message">*</span>
					</td>
				</tr>
				<tr >
					<td align="right">简要描述:</th>
					<td>
						<textarea id="ty"></textarea>
						<span id="sp3" style="color: red;" class="message">*</span>
					</td>
				</tr>
				<tr>
					<td align="right">是否是会员小说:</th>
					<td>	
						会员<input type="radio" name="isvip"  ${"是" eq editbook.isvip ? "checked" : ""} value="是"/>
						非会员<input type="radio" name="isvip" ${"否" eq editbook.isvip ? "checked" : ""} value="否"/>
						</td>
				</tr>
				<tr>
					<td align="right">上架状态:</th>
					<td>	
						上架<input type="radio" name="isshangjia" ${"已上架" eq editbook.status ? "checked" : ""}  value="已上架"/>
						下架<input type="radio" name="isshangjia" ${"未上架" eq editbook.status ? "checked" : ""} value="未上架"/>
						</td>
				</tr>


				<tr>
					<td colspan="2" align="center"><input type="button" value="提交" id="submitBtn" /></th>
				
				</tr>
			</table>
			
		</form>
		</div>
		</div>
	</body>
</html>
