<%@ page pageEncoding="UTF-8" %>
<footer >
    <div class="row" style="padding-left: 200px; background-color: black;">
        <div class="col-md-5 col-sm-12">
            <c:forEach var="item" items="${infor}">
                <b style="color: white;font-size: 15px;">${item.name}</b><br>
                <a style="color: white;font-size: 10px;">FanPage : ${item.groupName}</a><br>
                <a style="color: white;font-size: 10px;">Website : ${item.websiteName}</a><br>
                <a style="color: white;font-size: 10px;">Email   : ${item.email}</a>
            </c:forEach>
        </div>
        <div class="col-md-6 mt-3">
                <span class="ml-3 ft-sp"><i class="fa fa-facebook"></i></span>
                <span class="ml-3 ft-sp"><i class="fa fa-instagram"></i></span>
                <span class="ml-3 ft-sp"><i class="fa fa-twitter"></i></span>
        </div>
    </div>
    <!-- /.container -->
</footer>
