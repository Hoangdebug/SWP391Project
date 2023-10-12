<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/list_staff.css"/>

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
                List Seat
            </div>

            <div class="table">
                <table border="2">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Car id</th>
                            <th>Seat Number</th>
                            <th>Is Booked</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="seat" items="${sList}">
                            <tr id="row${seat.id}">
                                <td>${seat.id}</td>
                                <td>${seat.idcar}</td>
                                <td>${seat.seat_number}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${seat.isbooked == 0}">
                                            <button>Đặt</button>
                                        </c:when>
                                        <c:otherwise>
                                            Đã đặt
                                        </c:otherwise>
                                    </c:choose>
                                </td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>


        </div>
    </body>
</html>