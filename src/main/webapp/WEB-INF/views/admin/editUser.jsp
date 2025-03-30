<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><html>
<c:url var="APIurl" value="/admin/api/user/edit"/>
<c:url var="urlList" value="/admin/user/list"/>
<head>
  <title>Cập nhật thông tin admin</title>
</head>
<body>
<link href="<c:url value='/css/admin/user.css'/>" rel="stylesheet">

<div id="wrapper" style="width: 100%">
  <div class="main-content" style="width: 100%">
    <div class="main-content-inner">
      <div class="breadcrumbs" id="breadcrumbs">
        <script type="text/javascript">
          try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
        </script>
        <ul class="breadcrumb">
          <li>
            <ol class="breadcrumb">
              <li class="breadcrumb-item">
                <a href="<c:url value="/admin"/>"><i class="ace-icon fa fa-home home-icon"></i><b>Trang chủ</b></a>
              </li>
              <li class="breadcrumb-item active"><b>Chỉnh sửa thông tin</b></li>
            </ol>
          </li>
        </ul>
      </div>
      <div class="page-content">
        <div class="row">
          <form id="formSubmit" class="col-md-12">
    <c:forEach items="${roles}" var="item">
        <c:if test="${item == 'SUPER'}">
            <div class="form-group row">
              <label class="col-sm-2 control-label no-padding-right ">Quyền hạn</label>
              <div class="col-sm-9">
                <select class="form-control userId" class="searchable-dropdown" id="roleId" name="roleId" >

                </select>
              </div>
            </div>
        </c:if>
    </c:forEach>
<%--            <div class="form-group row">--%>
<%--              <label class="col-sm-2 control-label no-padding-right">Avatar</label>--%>
<%--              <div class="col-sm-9">--%>
<%--                <div class="avatar" >--%>
<%--                  <img id="avatar"--%>
<%--                       src="${editUser.avatar}"--%>
<%--                       class="img-fluid" style="max-width: 150px; max-height: 120px;" />--%>
<%--                </div>--%>
<%--                <div class="file-field">--%>
<%--                  <p>--%>
<%--                    <strong id="Ithumbnail">Chọn ảnh</strong><br />--%>
<%--                    <button--%>
<%--                            class="btn btn-primary btn-sm waves-effect waves-light"--%>
<%--                            type="button" value="Browse Image"--%>
<%--                            onclick="BrowseServer( 'Images:/', 'Ithumbnail' );" >Browse Image</button>--%>
<%--                  </p>--%>
<%--                </div>--%>
<%--                <form:hidden  path="avatar" id="image_src"/>--%>
<%--              </div>--%>
<%--              <div class="form-group row">--%>
<%--                <label class="col-sm-2 control-label no-padding-right">Họ và Tên</label>--%>
<%--                <div class="col-sm-9">--%>
<%--                  <form:input path="fullName" id="fullName" class="form-control"/>--%>
<%--                </div>--%>
<%--              </div>--%>


              <div class="form-group row">
                <label class="col-sm-2 control-label no-padding-right">Email</label>
                <div class="col-sm-9">
                  <input id="email" class="form-control" type="email" name="email">
                </div>
              </div>
              <div class="form-group row">
                  <label class="col-sm-2 control-label no-padding-right">Họ Tên</label>
                  <div class="col-sm-9">
                      <input id="name" class="form-control"  name="name">
                  </div>
              </div>

              <div class="form-group row">
                  <label class="col-sm-2 control-label no-padding-right">Trạng thái</label>
                  <div class="col-sm-9">
                      <select class="form-control" id="status" name="status">
                          <option selected disabled>-- Trạng thái --</option>
                          <option value="1">Đang hoạt động</option>
                          <option value="0">Không hoạt động</option>
                      </select>
                  </div>
              </div>

              <div class="form-group row">
                  <label class="col-sm-2 control-label no-padding-right">Giới tính</label>
                  <div class="col-sm-9">
                      <select class="form-control" id="gender" name="gender">
                          <option selected disabled>-- Giới tính --</option>
                          <option value="1">Nam</option>
                          <option value="0">Nữ</option>
                      </select>
                  </div>
              </div>
              <div class="form-group row">
                <label class="col-sm-2 control-label no-padding-right">Phone</label>
                <div class="col-sm-9">
                  <input id="phone" type="number" name="phone" class="form-control">
                </div>
              </div>
              <input type="hidden" id="userId" name="userId" value="${userId}">
              <div class="form-group">
                <div class="col-sm-12">
                  <button type="submit"  class="btn btn-white btn-warning btn-bold"  id="btnUpdate"/>Cập nhật
                  <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i></button>
                </div>
              </div>

              <div class="form-group">
                  <div class="col-sm-12">
                      <button type="submit"  class="btn btn-white btn-warning btn-bold"  id="btnCreate"/>Thêm mới
                      <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i></button>
                  </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
<%--  <script src="<c:url value='/ckeditor/ckeditor.js'/>"></script>--%>
<%--  <script src="<c:url value='/ckfinder/ckfinder.js'/>"></script>--%>
<script src="/js/admin/editUser.js" type="text/javascript"></script>
<script src="/js/jquery.min.js"></script>
</body>
</html>
