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

<script type="text/javascript">
    $(document).ready(function () {
        $.ajaxSetup({
            beforeSend: function (xhr) {
                const token = localStorage.getItem("access-token");
                if (token) {
                    xhr.setRequestHeader("Authorization", "Bearer " + token);
                }
            }
        });
    });
</script>

</body>
</html>
