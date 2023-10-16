<%-- 
    Document   : payment
    Created on : Oct 17, 2023, 2:14:04 AM
    Author     : tuna
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <div>Order Number: ${cur_order.id} </div>
            <div> Car Route Number: ${curCarroute.id} </div>
            <c:forEach var="ticket" items="${lticketS}">
                <div class="passenger-info">
                    <div> Seat Number: ${ticket.seat_id}</div>

                    <div>Name passenger: ${ticket.passenger_name}</div>
                    <div>Phone passenger: ${ticket.passenger_phone}</div>
                </div>
            </c:forEach>
            <div>Total: ${cur_order.total_price}</div>
            <a href="">Payment</a>
        </div>
    </body>
</html>
