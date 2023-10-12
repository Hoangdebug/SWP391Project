<jsp:useBean class="model.repository.StaffRepository" id="list"></jsp:useBean>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if (session != null && session.getAttribute("iduser") != null) {
        // Lấy giá trị iduser từ phiên ở đây
        int iduser = (int) session.getAttribute("iduser");
    }%>

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
                        <tr>
                            <th>Car Id</th>
                            <th>User Id</th>
                            <th>From</th>
                            <th>To</th>
                            <th>Price</th>
                            <th>Start</th>
                            <th>End</th>
                            <th>Date Start</th>
                            <th>Edit</th>
                            <th>Delete</th>
                            <th>Booking</th>
                        </tr>

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
                                <td><a href="#">Edit</a></td>
                                <td><a href="#">Delete</a></td>
                                <td><a href="${pageContext.request.contextPath}/ListSeatsServlet?idCar=${carroutes.car_id}&price=${carroutes.price}&idUser=${iduser}&datastart=${carroutes.datastart}">Booking</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>