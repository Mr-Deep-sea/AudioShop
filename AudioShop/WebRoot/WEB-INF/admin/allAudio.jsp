<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="static/css/pintuer.css">
<link rel="stylesheet" href="static/css/admin.css">
<style>
#mask {
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, .5);
	position: fixed;
	top: 0;
	left: 0;
	z-index: 999;
	display: none;
}

#box {
	display: none;
	width: 600px;
	max-width: 600px;
	margin: 0 auto;
	height: 400px;
	background-color: #fff;
	position: fixed;
	top: 45%;
	left: 45%;
	border-radius: 10px;
	margin: -125px 0 0 -200px;
	z-index: 1000;
}

#box span {
	position: absolute;
	top: 10px;
	right: 10px;
	width: 15px;
	height: 15px;
	font-size: 15px;
	cursor: pointer;
}

.containerchild {
	max-width: 400px;
	margin: 0 auto;
	padding: 20px 0;
	height: 300px;
	text-align: center;
	z-index: 1000;
}

.containerchild h1 {
	font-size: 40px;
	-webkit-transition-duration: 1s;
	transition-duration: 1s;
	-webkit-transition-timing-function: ease-in-put;
	transition-timing-function: ease-in-put;
	font-weight: 200;
}

form {
	padding: 20px 0;
	position: relative;
	z-index: 2;
}

form input {
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	outline: 0;
	border: 1px solid rgba(175, 237, 255, 0.96);
	background-color: rgba(211, 255, 219, 0.87);
	width: 95%;
	border-radius: 25px;
	-webkit-border-radius: 25px;
	-moz-border-radius: 25px;
	-o-border-radius: 25px;
	-ms-border-radius: 25px;
	padding: 15px 15px;
	margin: 0 auto 10px auto;
	display: block;
	text-align: center;
	font-size: 18px;
	color: #2f3d33;
	-webkit-transition-duration: 0.25s;
	transition-duration: 0.25s;
	font-weight: 300;
}

form input:hover {
	background-color: rgba(245, 255, 187, 0.71);
}

form input:focus {
	background-color: #ffffff;
	width: 300px;
	color: #53ca8e;
}

form button {
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	outline: 0;
	background-color: #76c9c8;
	border: 0;
	padding: 10px 15px;
	color: #45b586;
	border-radius: 3px;
	width: 250px;
	cursor: pointer;
	font-size: 18px;
	-webkit-transition-duration: 0.25s;
	transition-duration: 0.25s;
}

form button:hover {
	background-color: #f5f7f9;
}
</style>
<script src="static/js/jquery.js"></script>
<script src="static/js/pintuer.js"></script>
</head>
<body>
	<div id="mask"></div>
	<div id="box">
		<span id="close_all">×</span>
		<div class="containerchild">
			<h1>请输入数量</h1>
			<form class="form" method="POST" id="login_form" action="order_addOrderItem.action">
				<input name="audioId" id="audioId" type="hidden"> <input
					name="orderItemNumber" type="text" placeholder="数量"
					onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"
					onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}">
				<!-- <input name="userPassword" type="password" placeholder="password">-->
				<input type="submit" value="添加">
			</form>
		</div>
	</div>

	<form method="post" action="">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder">资料列表</strong>
				<div class="button-group"> <a class="button border-green" href="order_currentOrder.action" ><span class="icon-circle-o"></span>查看订单</a> </div>
			</div>
			<!-- <div class="padding border-bottom">
      <ul class="search">
        <li>
          <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
          <button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button>
        </li>
      </ul>
    </div>-->
			<table class="table table-hover text-center">
				<tr>
					<!--  <th width="120">ID</th>-->
					<th>资料名</th>
					<th>类型</th>
					<th>描述</th>
					<th>库存</th>
					<th>预约数量</th>
					<th>操作</th>
				</tr>
				<c:forEach var="audio" items="${pageResult.items}"
					varStatus="status">
					<%-- <c:forEach var="audio" items="${audios}" varStatus="status"> --%>
					<td>${audio.name}</td>
					<td>${audio.category.name}</td>
					<td>${audio.otherItem}</td>
					<td>${audio.stock}</td>
					<td>${audio.reservation}</td>
					<td><div class="button-group">
							<a class="button border-red" href="javascript:addOrderItem('${audio.id}')"><span
								class="icon-circle-o"></span>订货</a>
						</div></td>
					</tr>
				</c:forEach>
				<!-- <tr>
					<td>资料名</td>
					<td>类型</td>
					<td>描述</td>
					<td>库存</td>
					<td>预约数量</td>
					<td><div class="button-group">
							<a class="button border-red" href="javascript:void(0)"
								onclick="return del(1)"><span class="icon-circle-o"></span>订货</a>
						</div></td>
				</tr> -->
				<tr>
					<td colspan="8">
						<div class="pagelist">
							<c:if test="${pageResult.pageNo!=1}">
								<a
									href="${ pageContext.request.contextPath }/audio_showAudio.action?pageNo=1">首页</a>
								<a
									href="${ pageContext.request.contextPath }/audio_showAudio.action?pageNo=${ pageResult.pageNo-1}">上一页</a>

							</c:if>
							<c:if test="${pageResult.pageNo!=pageResult.totalPageCount}">
								<a
									href="${ pageContext.request.contextPath }/audio_showAudio.action?pageNo=${ pageResult.pageNo+1}">下一页</a>
								<a
									href="${ pageContext.request.contextPath }/audio_showAudio.action?pageNo=${ pageResult.totalPageCount}">尾页</a>
							</c:if>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		window.onload = function() {
			//事件源:  登录
			var login = document.getElementById("login");
			var mask = document.getElementById("mask");
			var box = document.getElementById("box");

			// 事件源 span x
			var close_all = document.getElementById("close_all");
			close_all.onclick = function() {
				mask.style.display = 'none';
				box.style.display = "none";
			}
		}
		function addOrderItem(id) {
		//alert(id);
			var audioId = document.getElementById("audioId");
			audioId.value = id;
			var mask = document.getElementById("mask");
			var box = document.getElementById("box");
			mask.style.display = "block";
			box.style.display = "block";

		}
		function del(id) {
			if (confirm("您确定要删除吗?")) {

			}
		}

		$("#checkall").click(function() {
			$("input[name='id[]']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		})

		function DelSelect() {
			var Checkbox = false;
			$("input[name='id[]']").each(function() {
				if (this.checked == true) {
					Checkbox = true;
				}
			});
			if (Checkbox) {
				var t = confirm("您确认要删除选中的内容吗？");
				if (t == false)
					return false;
			} else {
				alert("请选择您要删除的内容!");
				return false;
			}
		}
	</script>
</body>
</html>
