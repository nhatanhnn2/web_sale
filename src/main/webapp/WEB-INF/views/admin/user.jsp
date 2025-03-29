<%@ include file="/common/taglib.jsp"%>
<%@ page pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Admin | Home</title>
</head>
<body  id="page-top">
<div class="container">
    <h2>Danh sách tài khoản</h2>
    <div class="row">
        <div class="col row">
            <div class="col">
                <input type="text" placeholder="tìm kiếm tên" id="search-name">
            </div>

<%--            <div class="dropdown col">--%>
<%--                <button class="btn btn-secondary dropdown-toggle" type="button" id="search-status" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
<%--                   Trạng thái--%>
<%--                </button>--%>
<%--                <div class="dropdown-menu" aria-labelledby="search-status">--%>
<%--                    <a class="dropdown-item" value="1">Đang hoạt động</a>--%>
<%--                    <a class="dropdown-item" value="0">Không hoạt động</a>--%>
<%--                </div>--%>
<%--            </div>--%>
        </div>
        <div class="col">
            <button id="search-user" class="float-right" >Tìm kiếm</button>
            <button id="add-user" class="float-right fa fa-plus" style="margin-right: 10px;">Thêm Tài Khoản</button>
        </div>

    </div>

    <table class="table">
        <thead>
        <tr>
            <th>Tên</th>
            <th>Email</th>
            <th>Số điện thoại</th>
            <th>Giới tính</th>
            <th>Trạng thái</th>
            <th></th>
<%--            <th></th>--%>
        </tr>
        </thead>
        <tbody id="list-user">
        </tbody>
    </table>
</div>

<script src="/js/admin/user.js" type="text/javascript"></script>
<script src="/js/jquery.min.js"></script>
</body>
</html>