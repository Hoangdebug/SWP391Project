<%-- 
    Document   : list_staff_driver
    Created on : Oct 4, 2023, 4:56:19 AM
    Author     : tuna
--%>

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
                Create Page Staff and Driver
            </div>

            <div class="table">
                <table border="2">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Authority</th>
                            <th>Full Name</th>
                            <th>User Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Address</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${user}">
                            <tr>
                                <td>${user.getFullname()}</td>
                                <td>${user.getPassword()}</td>
                                <td>${user.getGender()}</td>
                                <td class="wrapper">${user.getAddress()}</td>
                                <td>${user.getPhoneNum()}</td>
                                <td>${user.getRole()}</td>
                                <td>${user.getEmail()}</td>
                                <td><a
                                        href="${pageContext.request.contextPath}/UpdateUserServlet?idUser=${user.getIdUser()}">Update</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
