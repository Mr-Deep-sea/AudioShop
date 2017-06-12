<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title></title>
<link rel="stylesheet" href="static/css/pintuer.css">
<link rel="stylesheet" href="static/css/admin.css">
<script src="static/js/jquery.js"></script>
<script src="static/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 卖资料 </strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">

		
		<form method="post" action="buy_addBuyAudio.action" id="listform">
  			<li>
          		<input type="text" placeholder="请输入借阅的资料号" name="BuyaudioID" class="input" style="width:250px; line-height:17px;display:inline-block" />
          		<input type="submit" text="确定">
        	</li>
		</form>
        
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">ID</th>
        <th>名称</th>
        <th>分类名称</th>
        <th>其他</th>
      </tr>
      <volist name="list" id="vo">
      	<c:forEach  items="${BuyaudioList}" var="audio">
      		<tr>
          		<td style="text-align:left; padding-left:20px;">${audio.id}</td>
          		<td>${audio.name}</td>
          		<td>${audio.category.name}</td>
          		<td>${audio.otherItem}</td>
          	</tr>			
		</c:forEach>
		<tr>
        	<td colspan="8"><div class="pagelist"> <a href=buy_buy.action><span class="current">确认卖资料</span></a></td>
      	</tr>
    </table>
    
    
  </div>

</body>
</html>