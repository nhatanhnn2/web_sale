<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="APIUrl" value="/admin/api/user/create"/>
<c:url var="userListUrl" value="/admin/user/list"/>

<html>
<head>
  <title>Thêm người dùng</title>
  <link href="<c:url value='/css/admin/user.css' />" rel="stylesheet"/>
</head>
<body>
<div id="wrapper" style="width: 100%">
  <div class="main-content" style="width: 100%">
    <div class="main-content-inner">
      <div class="breadcrumbs" id="breadcrumbs">
        <script type="text/javascript">
          try { ace.settings.check('breadcrumbs', 'fixed') } catch (e) {}
        </script>
        <ul class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="<c:url value='/admin' />"><i class="ace-icon fa fa-home home-icon"></i><b>Trang chủ</b></a>
          </li>
          <li class="breadcrumb-item active"><b>Thêm người dùng</b></li>
        </ul>
      </div>

      <div class="page-content">
        <h2>Thêm người dùng mới</h2>
        <form action="/api/admin/user/create" method="post">
        <div class="form-group row">
          <label for="role" class="col-sm-2 control-label no-padding-right">Quyền hạn:</label>
          <div class="col-sm-9">
            <select class="form-control row " id="role" name="roleId">
              <option value="2">super admin</option>
              <option value="1">admin product</option>
              <c:forEach var="item" items="${roles}">
                <c:if test="${item.name eq 'super admin' or item.name eq 'admin product'}">
                  <option value="${item.id}">${item.name}</option>
                </c:if>
              </c:forEach>
<%--              <c:forEach var="item" items="${role}">--%>
<%--                <c:if test="${item.id == editUser.roleId}">--%>
<%--                  <option value="${item.id} " selected="selected">${item.name}</option>--%>
<%--                </c:if>--%>
<%--                <c:if test="${item.id != editUser.roleId}">--%>
<%--                  <option value="${item.id} ">${item.name}</option>--%>
<%--                </c:if>--%>
<%--              </c:forEach>--%>
            </select>
          </div>
        </div>
          <div class="form-group row">
            <label for="email" class="col-sm-2 control-label no-padding-right">Email:</label>
            <div class="col-sm-9">
              <input id="email" class="form-control" type="email">
            </div>
          </div>
          <div class="form-group row">
            <label for="name" class="col-sm-2 control-label no-padding-right">Tên người dùng:</label>
            <div class="col-sm-9">
              <input id="name" class="form-control" type="name">
            </div>
          </div>
          <div class="form-group row">
            <label for="phone" class="col-sm-2 control-label no-padding-right">Số điện thoại:</label>
            <div class="col-sm-9">
              <input id="phone" class="form-control" type="phone">
            </div>
          </div>
          <button type="button" id="createUserBtn">Tạo người dùng</button>
        </form>
      </div>
    </div>
  </div>
</div>

<script src="<c:url value='/js/jquery.min.js'/>"></script>
<script src="<c:url value='/js/admin/createUser.js'/>"></script>
</body>
</html>
