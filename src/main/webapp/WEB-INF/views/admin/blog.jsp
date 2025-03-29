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
    <h2>Danh sách bài viết</h2>
    <div class="row">
        <div class="col row">
            <div class="col">
                <input type="text" placeholder="Tìm kiếm nội dung" id="search-content">
            </div>
            <table class="table">
                <thead>
                <tr>
                    <th>Nội dung</th>
                    <th>Mô tả </th>
                    <th></th>
                </tr>
                </thead>
                <tbody id="list-blog">
                </tbody>
                <div class="col">
                    <button id="search-blog" class="float-right" >Tìm kiếm</button>
                </div>
            </table>
        </div>
    </div>




</div>

<script src="/js/admin/blog.js" type="text/javascript"></script>
<script src="/js/jquery.min.js"></script>
</body>
</html>