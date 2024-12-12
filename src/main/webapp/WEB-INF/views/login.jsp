<%@ include file="/common/taglib.jsp"%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>VnPost | Đăng nhập</title>

</head>

<body>


<div class="container" style="height: 64%">
    <div class="card card-login mx-auto mt-5"  style="width: 600px">
        <div class="card-header">Login</div>
        <div class="card-body">
            <c:if test="${param.incorrectAccount != null}">
                <div class="alert alert-danger">
                    Đăng nhập thất bại!
                </div>
            </c:if>
            <form action="/j_spring_security_check" method="post">
                <div class="form-group">
                    <div class="form-label-group">
                        <input type="text" class="form-control" name="j_username" placeholder="Email" required="required">
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <input type="password" id="inputPassword" name="j_password" class="form-control" placeholder="Password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me">
                            Remember Password
                        </label>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Login</button>
            </form>
        </div>
    </div>
</div>
<!-- /.container -->

<!-- Footer -->
<!-- Bootstrap core JavaScript -->


</body>

</html>
