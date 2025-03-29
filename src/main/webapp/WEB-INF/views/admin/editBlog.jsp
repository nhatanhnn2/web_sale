<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><html>
<c:url var="APIurl" value="/admin/api/blog/edit"/>
<c:url var="urlList" value="/admin/blog/list"/>
<head>
    <title>Cập nhật thông tin blog</title>
</head>
<body>
<link href="<c:url value='/css/admin/user.css.css'/>" rel="stylesheet">

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
                    <div class="col-md-12">
                        <div class="form-group row">
<%--                            <c:forEach var="item" items="${blog}">--%>
<%--                                <c:if test="${item.id == editBlog.blogId}">--%>
<%--                                    <option value="${item.id} " selected="selected">${item.content}</option>--%>
<%--                                </c:if>--%>
<%--                                <c:if test="${item.id != editBlog.blogId}">--%>
<%--                                    <option value="${item.id}">${item.content}</option>--%>
<%--                                </c:if>--%>
<%--                            </c:forEach>--%>

                        <div class="form-group row">
                            <label class="col-sm-2 control-label no-padding-right">Nội dung</label>
                            <div class="col-sm-9">
                                <input id="content" class="form-control" type="content">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 control-label no-padding-right">Mô tả</label>
                            <div class="col-sm-9">
                                <input id="description" class="form-control" type="description">
                            </div>
                        </div>
                            <input type="hidden" id="blogId" name="blogId" value="${blogId}">
                        <div class="form-group">
                            <div class="col-sm-12">
                                <button type="submit"  class="btn btn-white btn-warning btn-bold"  id="btnUpdateNew"/>Cập nhật
                                <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/js/admin/editBlog.js" type="text/javascript"></script>
<script src="/js/jquery.min.js"></script>
</body>
</html>
