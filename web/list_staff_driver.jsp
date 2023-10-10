<jsp:useBean class="model.repository.UserRepository" id="show"></jsp:useBean>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
    </head>
    <body>
        <%@ include file="/include/header.jsp" %>
        <%@ include file="/include/sidebar.jsp" %>

        <div class="body">
            <!--            <form action="showAllUser" method="get">
                            <table width="100%" cellspacing="0" class="table-search">
                                <input type="text" class="form-control"
                                       placeholder="Tìm kiếm " autocomplete="off" name="keySearch">
                                <a
                                    href="${pageContext.request.contextPath}/showAllUser" >
                                    <button type="submit" class="btn-search"
                                            value="Tìm kiếm người dùng">Tìm kiếm</button>
                                </a>
                            </table>
                        </form>--><h1>Chọn ghế</h1>
            <button id="showTextButton">Hiển thị Văn Bản</button>
            <div id="textContainer" style="display: none;"></div>

            <script>
                $(document).ready(function () {
                    // Khai báo một mảng để lưu trữ userId
                    var userIds = [];

                    // Lặp qua các dòng và lưu trữ user.id vào mảng
                <c:forEach var="user" items="${show.getListUser()}">
                    userIds.push("${user.id}");
                </c:forEach>

                    // Bắt sự kiện khi nút được nhấp
                    $("#showTextButton").click(function () {
                        // Lấy giá trị đầu tiên trong mảng userIds và hiển thị trong thẻ div
                        var firstUserId = userIds[0];
                        console.log(firstUserId);
                        $("#textContainer").text(firstUserId);
                        $("#textContainer").show();
                    });
                });
            </script>


            <div class="title-page">
                List Staff Driver and Member
            </div>

            <div class="table">
                <table border="2">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Authority</th>
                            <th>Full Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Age</th>
                            <th>Gender</th>
                            <th>Address</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${show.getListUser()}">
                            <tr id="row${user.id}">
                                <td>${user.id}</td>
                                <td>${user.authority}</td>
                                <td>${user.fullname}</td>
                                <td>${user.email}</td>
                                <td>${user.phone}</td>      
                                <td>${user.age}</td>      
                                <td>${user.gender}</td>
                                <td >${user.address}</td>
                                <td><a href="#">Edit</a></td>
                                <td><a href="deletestaff?id=${user.id}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>