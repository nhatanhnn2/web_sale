<%@ page pageEncoding="UTF-8" %>

    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="<c:url value="/admin"/>">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span>
                </a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link" href="<c:url value='/admin/new/list?page=1&limit=3'/>">&nbsp;Danh sách bài viết</a>
                <a class="nav-link" href="<c:url value='/admin/comment/list?page=1&limit=10'/>">&nbsp;Comment</a>
                <c:forEach items="${roles}" var="item">
                    <c:if test="${item == 'AD_PRD'}">
                        <a class="nav-link" href="<c:url value='/admin/category/list?page=1&limit=10'/>">&nbsp;Loại sản phảm</a>
                        <a class="nav-link" href="<c:url value='/admin/group-category/list?page=1&limit=10'/>">&nbsp;Nhóm loại sản phẩm</a>
                    </c:if>
                    <c:if test="${item == 'BANNER'}">
                        <a class="nav-link" href="<c:url value='/admin/infor/edit-banner/1'/>">&nbsp;Thay đổi banner</a>
                    </c:if>
                    <c:if test="${item == 'INFOR'}">
                        <a class="nav-link" href="<c:url value='/admin/infor/edit/1'/>">&nbsp;Thông tin liên hệ website</a>
                    </c:if>
                    <c:if test="${item == 'USER'}">
                        <a class="nav-link" href="<c:url value='/admin/feedback/list?page=1&limit=7'/>">&nbsp;Feedback</a>
                    </c:if>
                    <c:if test="${item == 'SUPER'}">
                        <a class="nav-link" href="<c:url value='/admin/user/role'/>"><i class="fas fa-passport"></i> Quyền hạn</a>
                    </c:if>
                </c:forEach>
                <a class="nav-link" href="<c:url value="/admin/user/list"/>">Danh sách Admin</a>
            </li>
    </ul>

    <!-- /.content-wrapper -->
    <!-- Sticky Footer -->

<!-- /#wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>
