<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title></title>
  <link rel="stylesheet" href="static/css/pintuer.css">
  <link rel="stylesheet" href="static/css/admin.css">
  <script src="static/js/jquery.js"></script>
  <script src="static/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel margin-top" id="add">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> Vip办理</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="worker_addVip.action">
      <div class="form-group">
        <div class="label">
          <label>姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="user.name" data-validate="required:请输入用户姓名" />
          <div class="tips"></div>
        </div>
      </div>
  
      <div class="form-group">
        <div class="label">
          <label>电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="user.phone" data-validate="required:请输入用户电话号码" />
          <div class="tips"></div>
        </div>
      </div> 
      
      <div class="form-group">
        <div class="label">
          <label>密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="user.password" data-validate="required:请输入用户登陆密码" />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit">添加</button>
        </div>
      </div>
      
    </form>
  </div>
</div>
</body>
</html>