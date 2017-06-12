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
<script src="static/js/jquery.js"></script>
<script src="static/js/pintuer.js"></script>
</head>
<body>
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
          					<td><div class="button-group">
							<a class="button border-red" href="reservation_reservation.action?audioID=${audio.id}"><span
								class="icon-circle-o"></span>预约</a>
							</div>
							</td>
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
		function del(id, mid, iscid) {
			if (confirm("您确定要删除吗?")) {

			}
		}

		
	</script>
</body>
</html>