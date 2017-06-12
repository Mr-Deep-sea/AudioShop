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
    <div class="panel-head"><strong class="icon-reorder"> 还资料 </strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">

		<li>
		  <c:choose>
				<c:when test="${empty borrowUserID}">
					<form method="post" action="workerReturn_checkUser.action" id="listform">

          				<input type="text" placeholder="请输入借阅人的ID号" name="userID" class="input" style="width:250px; line-height:17px;display:inline-block" />
          				<input type="submit" text="确定">
          				
					</form>
				</c:when>
				<c:otherwise>
					<input type="text" placeholder="${borrowUserID}" name="userID" class="input" style="width:250px; line-height:17px;display:inline-block" />
				</c:otherwise>
		 	</c:choose>
          
        </li>
        
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">ID</th>
        <th>名称</th>
        <th>分类名称</th>
        <th>其他</th>
        <th>所借数量</th>
      </tr>
      <volist name="list" id="vo">
      	<c:forEach  items="${borrowRecordList}" var="borrowRecord">
      		<tr>
          		<td style="text-align:left; padding-left:20px;">${borrowRecord.audio.id}</td>
          		<td>${borrowRecord.audio.name}</td>
          		<td>${borrowRecord.audio.category.name}</td>
          		<td>${borrowRecord.audio.otherItem}</td>
          		<td>${borrowRecord.number}</td>
          	</tr>			
		</c:forEach>
		<tr>
        	<td colspan="8"><div class="pagelist"> <a href=workerReturn_deleteborrowRecord.action><span class="current">确认归还</span></a></td>
      	</tr>
    </table>
    
    
  </div>

</body>
</html>