<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>欢迎来到音像资料销售店</title>  
    <link rel="stylesheet" href="static/css/pintuer.css">
    <link rel="stylesheet" href="static/css/admin.css">
    <script src="static/js/jquery.js"></script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="static/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />欢迎来到音像资料销售店</h1>
  </div>
  <div class="head-l">
  <c:choose>
	<c:when test="${empty existCommonUser}">
		<a href="login.jsp" class="button button-little bg-green" target="_blank"><span class="icon-home"></span> VIP用户登录</a> &nbsp;&nbsp;
	</c:when>
	<c:otherwise>
		<a href="user_logout.action?user.author=1" class="button button-little bg-green" target="_blank"><span class="icon-home"></span> VIP用户登出</a> &nbsp;&nbsp;	
	</c:otherwise>
  </c:choose>
  <c:choose>
	<c:when test="${empty existWorker}">
		<a href="workerLogin.jsp" class="button button-little bg-green" target="_blank"><span class="icon-home"></span> 收银员登录</a> &nbsp;&nbsp;
	</c:when>
	<c:otherwise>
		<a href="user_logout.action?user.author=2" class="button button-little bg-green" target="_blank"><span class="icon-home"></span> 收银员登出</a> &nbsp;&nbsp;	
	</c:otherwise>
  </c:choose>
  <c:choose>
	<c:when test="${empty existAdminUser}">
		<a  href="adminLogin.jsp" class="button button-little bg-red"><span class="icon-power-off"></span> 管理员登录</a>
    </c:when>
	<c:otherwise>
		<a href="user_logout.action?user.author=3" class="button button-little bg-green" target="_blank"><span class="icon-home"></span> 管理员登出</a> &nbsp;&nbsp;	
	</c:otherwise>
  </c:choose>
 </div>
 </div>
<div class="admin">
 <!--  <iframe scrolling="auto" rameborder="0" src="info.html" name="right" width="100%" height="100%"></iframe>
 -->
 <form method="post" action="admin_allWorker.action" id="listform">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 所有资料</strong> 
			</div>
			
			 <table class="table table-hover text-center">
     			 <tr>
       				 <th width="100" style="text-align:left; padding-left:20px;">ID</th>
       				 <th>名称</th>
       				 <th>分类名称</th>
        			 <th>其他</th>
        			 <th>操作</th>
    		     </tr>
     			 <volist name="list" id="vo">
      				<c:forEach  items="${allAudioList}" var="audio">
      					<tr>
          					<td style="text-align:left; padding-left:20px;">${audio.id}</td>
          					<td>${audio.name}</td>
          					<td>${audio.category.name}</td>
          					<td>${audio.otherItem}</td>
          					<td>
          					<c:choose>
								<c:when test="${empty existCommonUser}">
								</c:when>
								<c:otherwise>
									<div class="button-group">
									<a class="button border-red" href="reservation_reservation.action?audioID=${audio.id}"><span
										class="icon-circle-o"></span>预约</a>
									</div>
								</c:otherwise>
  							</c:choose>	
						</td>
          			</tr>			
				</c:forEach>
			</table>
		</div>
	</form>
 </div>

</body>
</html>