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
    <button id="search-user">Tìm kiếm</button>
    <table class="table">
        <thead>
        <tr>
            <th>Tên</th>
            <th>Email</th>
            <th>Số điện thoại</th>
            <th>Giới tính</th>
            <th>Trạng thái</th>
        </tr>
        </thead>
        <tbody id="list-user">
<%--        <tr>--%>
<%--            <td>admin product</td>--%>
<%--            <td>admin2@gmail.com</td>--%>
<%--            <td>123456789</td>--%>
<%--            <td>Nam</td>--%>
<%--            <td>Đang hoạt động</td>--%>
<%--        </tr>--%>
        </tbody>
    </table>
</div>

<script src="/js/admin/user.js" type="text/javascript"></script>
<script src="/js/jquery.min.js"></script>
</body>
</html>