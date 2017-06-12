<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
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
    <title>店主管理中心</title>  
    <link rel="stylesheet" href="static/css/pintuer.css">
    <link rel="stylesheet" href="static/css/admin.css">
    <script src="static/js/jquery.js"></script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="static/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />店主管理中心</h1>
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
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <!-- <h2><span class="icon-user"></span>基本设置</h2> -->
  <ul style="display:block">
    <li><a href="audio_showAudio.action" target="right"><span class="icon-caret-right"></span>所有资料</a></li>
    <li><a href="admin_allWorker.action" target="right"><span class="icon-caret-right"></span>收银员管理</a></li>
    <li><a href="audio_toAddAudio.action" target="right"><span class="icon-caret-right"></span>添加资料</a></li>  
    <li><a href="order_allOrder.action" target="right"><span class="icon-caret-right"></span>所有订单</a></li>   
  </ul>   
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>

<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="audio_showAudio.action" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">

</div>
</body>
</html>