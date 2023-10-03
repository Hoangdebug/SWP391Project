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
            <form name="search" action="search">
                <!--<input class="form-input" type="text" name="search" value="" placeholder="Search..."/>Search...-->
                <div class="form-input"></div>
                <button type="submit" class="form-btn">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </button>
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
                        <tr>
                            <td>1</td>                   
                            <td>Member</td>
                            <td class="fullname">Nguyen Anh Tu</td>
                            <td>tu123</td>
                            <td>tuna1.dev@gmail.com</td>
                            <td>0912644974</td>
                            <td>Da Nang</td>
                            <td><a href="#">Edit</a></td>
                            <td><a href="#">Delete</a></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
