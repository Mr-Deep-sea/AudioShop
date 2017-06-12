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
<title></title>
<link rel="stylesheet" href="static/css/pintuer.css">
<link rel="stylesheet" href="static/css/admin.css">
<script src="static/js/jquery.js"></script>
<script src="static/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改资料信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="workerAudio_ChangeAudioInfo.action">  
      <div class="form-group">
        <div class="label">
          <label>资料名：</label>
        </div>
        <div class="field">
        <input type="hidden" value="${changeAudio.id }" name="audio.id" />
          <input type="text" class="input w50" value="${changeAudio.name }" name="audio.name" data-validate="required:请输入标题" />
          <div class="tips"></div>
        </div>
      </div>

   <!--   <div class="form-group">
        <div class="label">
          <label>图片：</label>
        </div>
        <div class="field">
          <input type="text" id="url1" name="img" class="input tips" style="width:25%; float:left;"  value=""  data-toggle="hover" data-place="right" data-image="" />
          <input type="button" class="button bg-blue margin-left" id="image1" value="+ 浏览上传"  style="float:left;">
          <div class="tipss">图片尺寸：500*500</div>
        </div>
      </div>-->

        <div class="form-group">
          <div class="label">
            <label>分类</label>
          </div>
          <div class="field">
            <select name="audio.category.id" class="input w50">
              <!--<option value="">请选择分类</option>-->
              <!-- <option value="" >CD</option>
              <option value="">DVD</option>
              <option value="">产品分类</option> -->
             
              <c:forEach var="category" items="${changeCategories}" varStatus="status"> 
 				<option value="${category.id }">${category.name}</option>
 				<%-- <option value="">${status.index}</option> --%>
			  </c:forEach>
            </select>
            <div class="tips"></div>
          </div>
        </div>
       <!-- <div class="form-group">
          <div class="label">
            <label>其他属性：</label>
          </div>
          <div class="field" style="padding-top:8px;"> 
            首页 <input id="ishome"  type="checkbox" />
            推荐 <input id="isvouch"  type="checkbox" />
            置顶 <input id="istop"  type="checkbox" /> 
         
          </div>
        </div>-->
      <div class="form-group">
        <div class="label">
          <label>描述：</label>
        </div>
        <div class="field">
          <textarea class="input" name="audio.otherItem" style=" height:90px;" >${changeAudio.otherItem }</textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>库存：</label>
        </div>
        <div class="field">
          <div class="input w50" />${changeAudio.stock}</div>
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>预约数量：</label>
        </div>
        <div class="field">
          <div class="input w50" />${changeAudio.reservation}</div>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
<script>
function check(){

}
</script>
</body></html>
