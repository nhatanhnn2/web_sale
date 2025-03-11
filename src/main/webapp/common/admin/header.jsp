<%@ page import="com.example.webSale.utils.SecurityUtils" %>
<%@ page pageEncoding="UTF-8" %>
<c:url var="emailPw" value="<%=SecurityUtils.getPrincipal().getUsername()%>"/>
<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="<c:url value="/admin"/>">ADMIN</a>

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
    </button>

    <!-- Navbar Search -->
    <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">

    </form>

    <!-- Navbar -->
    <ul class="navbar-nav ml-auto ml-md-0">
        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-user-circle fa-fw"></i>
            </a>
            <a style="color: white">Hello , <%=SecurityUtils.getPrincipal().getEmail()%></a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="<c:url value='/admin/user/edit-profile/${emailPw}'/>"><i class="far fa-id-card"></i> Edit Profile</a>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#passwordModal"><i class="ace-icon fa fa-key"></i> Change PassWord</a>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal"> <i class="ace-icon fa fa-power-off"></i> Logout</a>
            </div>
        </li>
    </ul>
</nav>
<!-- Logout Modal logout-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Đăng Xuất</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body"></div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="/dang-nhap">Logout</a>
            </div>
        </div>
    </div>
</div>
<!-- Logout Modal password-->
<div class="modal fade" id="passwordModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel1">Đổi mật khẩu</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <label>Mật khẩu mới sẽ được gửi vào email</label>
            </div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">No</button>
                <a class="btn btn-primary" href="<c:url value='/admin/api/user/pw/${emailPw}'/>">Yes</a>
            </div>
        </div>
    </div>
</div>
