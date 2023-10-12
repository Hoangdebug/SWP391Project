<%-- 
    Document   : sidebar
    Created on : Oct 4, 2023, 1:05:26 AM
    Author     : tuna
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/sidebar.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="sidebar">
            <div class="items">
                <c:if test="${role=='ROLE_MEMBER'}">
                    <a href="welcome_member.jsp" class=""> Car Route List</a>         
                    <a href="ticket_member.jsp" class=""> Ticket</a>

                </c:if>
                <c:if test="${role=='ROLE_ADMIN'}">
                    <a href="add_car.jsp" class="">Create Car</a>
                    <a href="list_staff_driver.jsp" class="">List Staff/Driver</a>
                    <a href="add_staff.jsp" class="">Create Staff/Driver</a>
                    <a href="create_route.jsp" class="">Create Car Route</a>

                </c:if>
                <c:if test="${role=='ROLE_STAFF'}">
                    <a href="add_car.jsp" class="">Create Staff/Driver</a>

                    <a href="add_car_route.jsp" class="">Create Car Route</a>
                </c:if>

            </div>
        </div>
    </body>
</html>
