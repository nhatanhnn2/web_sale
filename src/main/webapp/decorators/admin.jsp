
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/7/2019
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="/common/taglib.jsp"></jsp:include>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title><sitemesh:write property='title'></sitemesh:write></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link href="<c:url value='/common/admin/fontawesome-free/css/all.min.css'/>" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="<c:url value='/common/admin/sweetalert/sweetalert2.min.css'/> ">
    <!-- Custom styles for this template-->
    <link href="<c:url value='/css/admin/sb-admin.css'/>" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>

</head>

<body>
<%@include file="/common/admin/header.jsp" %>
<div id="wrapper">
    <%@include file="/common/admin/menu.jsp" %>
    <sitemesh:write property='body'></sitemesh:write>
</div>





<%--    <script src="<c:url value='/ckfinder/ckfinder.js'/> "></script>--%>
<%--    <script src="<c:url value='/ckeditor/ckeditor.js'/> " ></script>--%>

<%--    <script src="https://code.jquery.com/jquery-3.1.1.min.js"/>--%>
<%--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>--%>
<%--    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>--%>
<%--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>--%>
    <script src="<c:url value='/common/paging/jquery.twbsPagination.js'/> "></script>
 <script src="<c:url value='/common/admin/sweetalert/sweetalert2.min.js'/> "></script>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

</body>
</html>
