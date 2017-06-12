<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="static/js/jquery.js"></script>
<script src="static/js/pintuer.js"></script>
</head>
<body>
	<form method="post" action="admin_allWorker.action" id="listform">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 收银员信息</strong> <a href=""
					style="float:right; display:none;">添加字段</a>
			</div>
			<div class="padding border-bottom">
				<ul class="search" style="padding-left:10px;">
					<li><a class="button border-main icon-plus-square-o"
						href="admin_toadd.action"> 增加收银员</a>
					</li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th width="100" style="text-align:left; padding-left:20px;">ID</th>
					<th>电话</th>
					<th>姓名</th>
					<th width="310">操作</th>
				</tr>
				<c:forEach var="user" items="${userList}" varStatus="status">
					<tr>
						<td>${user.id}</td>
						<td>${user.phone}</td>
						<td>${user.name}</td>
						<td colspan="7" style="text-align:center;padding-left:20px;">
							<a class="button border-red icon-trash-o"
							style="padding:5px 15px;"
							
							onclick="del('${user.id}')"> 删除</a>
					</tr>
				</c:forEach>

			</table>
		</div>
	</form>
	<script type="text/javascript">
		//搜索
		function changesearch() {

		}

		//单个删除
		function del(id) {
			if (confirm("您确定要删除吗?")) {
					window.location.href="admin_deleteWorker.action?id="+id;
			}
		}

		
	</script>
</body>
</html>