<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'addWorker.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">

<link rel="stylesheet" href="./static/css/pintuer.css">
<link rel="stylesheet" href="./static/css/admin.css">
<script src="./static/js/jquery.js"></script>
<script src="./static/js/pintuer.js"></script>

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="addWorder">
			<strong><span class="icon-pencil-square-o"></span>增加收银员</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="admin_addWorker.action">
				<div class="form-group">
					<div class="label">
						<label>姓名 ： </label>
					</div>
					<div class="field">

						<div class="tips">
							<input id="name" type="text" class="input w50" value=""
								name="user.name" data-validate="required:请输入姓名"
								style="width: 240px; ">
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>密码 ： </label>
					</div>
					<div class="field">

						<div class="tips">
							<input id="passwprd" type="password" class="input w50" value=""
								name="user.password" data-validate="密码设置至少6位数，至多10位数"
								style="width: 240px; ">
						</div>
					</div>
				</div>


				<div class="form-group">
					<div class="label">
						<label>再次输入密码 ： </label>
					</div>
					<div class="field">
						<input id="repass" type="password" class="input w50" value=""
							name="repass" data-validate="密码设置至少6位数，至多10位数" style="width: 240px; " />
						<div class="tips"></div>
					</div>
				</div>


				<div class="form-group" style="height: 79px; ">
					<div class="label">
						<label>电话 ： </label>
					</div>
					<div class="field">
						<input id="phone" type="text" class="input w50" name="user.phone"
							value="" style="width: 240px; " />
						<div class="tips"></div>
					</div>
				</div>


				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">
							提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
