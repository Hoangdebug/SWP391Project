<%-- 
    Document   : CreateTicket
    Created on : Oct 16, 2023, 2:54:40 AM
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
        <form action="createticket" method="POST">
            <div> Chuyến xe số ${curCarroute.id} </div>
            <c:forEach var="seat" items="${lseatS}">
                <div class="passenger-info">
                    <div> Number seat: ${seat.seat_number}</div>

                    <label>Name: </label>
                    <input value="" name="passen_name${seat.seat_number}" type="text">

                    <label>Phone: </label>
                    <input value="" name="passen_phone${seat.seat_number}" type="text">
                </div>
            </c:forEach>
            <div>Total: ${totalPrice}</div>
            <input class="button-form" type="submit" value="Đi tới trang thanh toán">
        </form>
    </body>
</html>
