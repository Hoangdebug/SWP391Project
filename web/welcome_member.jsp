<jsp:useBean class="model.repository.StaffRepository" id="list"></jsp:useBean>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--<link rel="stylesheet" href="css/sidebar.css"/>-->
        <link rel="stylesheet" href="css/member.css"/>

        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
            integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
    </head>
    <body>
        <%@ include file="/include/header.jsp" %>
        <%@ include file="/include/sidebar.jsp" %>
        <div class="body">
            <form action="showAllUser" method="get">
                <table width="100%" cellspacing="0" class="table-search">
                    <input type="text" class="form-control"
                           placeholder="Tìm kiếm " autocomplete="off" name="keySearch">
                    <a
                        href="${pageContext.request.contextPath}/showAllUser" >
                        <button type="submit" class="btn-search"
                                value="Tìm kiếm người dùng">Tìm kiếm</button>
                    </a>
                </table>
            </form>
            <div class="title-page">
               Danh sách chuyến đi hiện có
            </div>
            <div class="table">
                <table border="2">
                    <thead>
                        <tr>
                            <th>1</th>
                            <th>2</th>
                            <th>3</th>
                            <th>4</th>
                            <th>5</th>
                            <th>6</th>
                            <th>7</th>
                            <th>8</th>
                            <th>8</th>
                            <th>8</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="carroutes" items="${list.getAllCarroutes()}">
                            <tr id="row${carroutes.id}">
                                <td>${carroutes.car_id}</td>
                                <td>${carroutes.users_id}</td>
                                <td>${carroutes.from}</td>
                                <td>${carroutes.to}</td>
                                <td>${carroutes.price}</td>
                                <td>${carroutes.start}</td>
                                <td>${carroutes.end}</td>
                                <td>${carroutes.datastart}</td>
                                <td><a
                                        href="#">Booking</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
