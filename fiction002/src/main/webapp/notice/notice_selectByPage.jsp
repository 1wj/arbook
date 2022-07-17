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
				$("#selectBtn1").click(function (){
					getClasstList(1);
				})
				$("#selectBtn2").click(function (){
					getClasstList(1);
				})
			})


			//分页函数
			function getClasstList(pageNo){
				var xsid=$("#xsid").val();
				var xsbt=$("#xsbt").val();
				var xsnr=$("#xsnr").val();
				var startTime=$("#startTime").val();
				var endTime=$("#endTime").val();
				$.ajax({
					url:"settings/message/selectList.do",
					data:{
						"mid" : xsid,
						"mtitle" : xsbt,
						"message_t" : xsnr,
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
							html +='<tr>';
							html +='<td align="center">'+n.mid+'</td>';
							html +='<td align="center">'+n.mtitle+'</td>';
							html +='<td align="center">'+n.sendtime+'</td>';
							html +='<td align="center">'+n.senderid+'</td>';
							html +='<td align="center"><a href="${pageContext.request.contextPath}/settings/message/selectById.do?mid='+n.mid+'">消息内容</a></td>';
							html +='<td align="center"><a href="notice/receiver_selectByPage.jsp">消息接收人</a></td>';
							html +='<td align="center"><a href="${pageContext.request.contextPath}/settings/message/deleteById.do?mid='+n.mid+'">消息删除</a></td>';
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
		<div id="top">当前位置：消息管理 -- 查看消息</div>
		<div id="contexttop">
		<table border="1" align="center" width="1200" id="tab">
			<tr>
				<td colspan="7">按时间段查询：
				<input type="text" placeholder="起始时间"  id="startTime" onclick="WdatePicker()"/>--
				<input type="text" placeholder="结束时间"  id="endTime"   onclick="WdatePicker()"/></td>
				<input type="button" id="selectBtn1" value="查询"/></td>
			</tr>
			<tr>
				<td colspan="7">按关键字查询：
				<input type="text" id="xsid" placeholder="消息ID"/>&nbsp;&nbsp;
				<input type="text" id="xsbt" placeholder="消息标题"/>&nbsp;&nbsp;
				<input type="text" id="xsnr" placeholder="消息内容"/>&nbsp;&nbsp;
				<input type="button" id="selectBtn2" value="查询"/></td>
			</tr>
			<tr bgcolor="#e0fbc4">
				<th>消息ID</th>
				<th>消息标题</th>
				<th>发送时间</th>
				<th>发送人</th>
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
