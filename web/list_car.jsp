<%-- 
    Document   : list_car
    Created on : Oct 5, 2023, 8:35:06 PM
    Author     : tuna
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
        <style>

        </style>
    </head>
    <body>
        <%@ include file="/include/header.jsp" %>
        <%@ include file="/include/sidebar.jsp" %>
        <div class="body">
            <div class="container">
                <div class="box-search">
                    <form action="listcarroute">
                        <table width="100%" cellspacing="0" class="table-search">
                            <tbody>
                                <tr>
                                    <td>
                                        <select class="form-control col-sm-12">
                                            <option value="Điểm đi" selected>Điểm đi</option>
                                            <option>Sài gòn</option>
                                        </select>
                                    </td>
                                    <td>
                                        <select class="form-control col-sm-12">
                                            <option value="Điểm đến" selected>Điểm đến</option>
                                            <option>Cà Mau</option>
                                        </select>
                                    </td>
                                    <td class="date">
                                        <input class="form-control col-sm-12"
                                               type="date">
                                    </td>
                                    <td>
                                        <input type="submit" class="btn-find-ticket" value="Tìm vé">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>

            <div class="title-page">
                List Car 
            </div>

            <div class="table">
                <table border="2">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Type</th>
                            <th>Count seat</th>
                            <th>Active</th>
                            <th>Licenseplate</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="car" items="${clistS}">
                            <tr id="row${car.id}">
                                <td>${car.id}</td>
                                <td>${car.name}</td>
                                <td>${car.type}</td>
                                <td>${car.countseat}</td>
                                <td>${car.isactive}</td>      
                                <td>${car.licenseplate}</td>      
                                <td><a href="#">Edit</a></td>
                                <td><a href="#">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
