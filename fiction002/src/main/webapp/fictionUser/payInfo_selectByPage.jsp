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
		<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>

		<script type="text/javascript">
			function toListPage(){
				window.location="fictionUser/fictionUser_selectByPage.jsp";
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
				$("#selectBtn1").click(function (){
					getClasstList(1);
				})
				$("#selectBtn2").click(function (){
					getClasstList(1);
				})
			})


			//分页函数
			function getClasstList(pageNo){
				var czid=$("#czid").val();
				var startTime=$("#startTime").val();
				var endTime=$("#endTime").val();

				$.ajax({
					url:"settings/user/vip/selectList.do",
					data:{
						"vipid" : czid,
						"startTime":startTime,
						"endTime":endTime,
						"pageNo" : pageNo, //当前页数 ，每页的数量固定为3
					},
					dataType:"json",
					type:"post",
					success:function (data){
						//{"uList":[{对象1},{对象2}，{}],"总页数total":3,"当前页数pageNo":2,"总条数recodeCount":12}
						//alert(1);
						var html="";
						$.each(data.uList,function (i,n){//每一个n就是一个对象
							html += "<tr>";
							html += "<th>"+n.vipid+"</th>";
							html += "<th>"+n.userid+"</th>";
							html += "<th>"+n.rechargetime+"</th>";
							html += "<th>"+n.money+"</th>";
							html += "<th>"+n.addday+"</th>";
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
	</head>
	<body>
		<div id="top"> 当前位置：用户管理 -- 会员充值信息</div>
		<div class="retrunList"><button onclick="toListPage()">返回用户列表</button></div>
		<div id="contexttop">
		<table border="1" cellspacing="0" id="tab">
			<tr>
				<form >
					<td colspan="5" align="left">按时间段查询：
					<input type="text" placeholder="请选择起始时间"   id="startTime" onclick="WdatePicker()"/> --
					<input type="text" placeholder="请选择结束时间"   id="endTime"  onclick="WdatePicker()" />
					<input type="button"  id="selectBtn1" value="查询" />
				</form>				
				</td>
			</tr>
			<tr>
				<form >
					<td colspan="5" align="left">按关键字查询:
						<input type="text" id="czid" placeholder="充值ID" />
					    <input type="button"  id="selectBtn2" value="查询" />
				</form>				
				</td>
			</tr>
			<tr>
				<th>充值ID</th>
				<th>用户名</th>
				<th>充值时间</th>
				<th>充值金额</th>
				<th>增加会员天数</th>
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
