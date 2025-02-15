<%@ page pageEncoding="UTF-8" %>
<div>
        <div>
            <c:forEach var="item" items="${infor}">
                <a class="navbar-brand" href="<c:url value="/trang-chu"/>" ><img class="img-header" src="${item.logo}"></a>
            </c:forEach>
        </div>

    <nav class="navbar navbar-expand-lg navbar-light bg-light nav-header" style="background-color:#ffd400 !important">
        <div class="container">
            <a href="<c:url value="/trang-chu"/>"  class="btn btn-primary btn-b" style="background-color: white"
                    aria-haspopup="true" aria-expanded="false" type="button" >
                <i class="fa fa-home"></i>
            </a>
            <c:forEach items="${group}" var="item">
                <div  class="dropdown" style="position: relative">
                    <a  href="/bai-viet/nhom/the-loai/${item.id}"class="btn btn-primary dropdown-toggle padding btn-b" style="background-color: #f02904"
                            aria-haspopup="true" aria-expanded="false" type="button" id="navbarDropdown${item.id}"  data-toggle="dropdown">${item.name}
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown${item.id}" style="background-color: #ececec">
                        <c:forEach var="items" items="${item.categoryName}" varStatus="loop">
                            <a class="dropdown-item" href="/bai-viet/the-loai/${item.ids[loop.index]}" >${items}</a>
                        </c:forEach>
                    </div>
                </div>
            </c:forEach>

        </div>
    </nav>
</div>

