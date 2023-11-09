<%-- 
    Document   : CreateTicket
    Created on : Oct 16, 2023, 2:54:40 AM
    Author     : tuna
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean class="model.repository.LocationRepository" id="show1"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="createticket" method="POST">
            <div> Chuyến xe số ${curCarroute.id} </div>
            <table border="1">
                <thead>
                    <tr>
                        <th>Passenger Information</th>
                        <th>Ticket information</th>
                        <th>Price</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="seat" items="${lseatS}">
                        <tr>
                            <td>
                                <label>Name Passenger:</label>
                                <input value="" name="passen_name${seat.seat_number}" type="text">
                                <br>
                                <label>Phone Passenger:</label>
                                <input value="" name="passen_phone${seat.seat_number}" type="text">
                            </td>
                            <td>
                                <p>Number seat: ${seat.seat_number}</p>
                                <p>Carroute: ${curCarroute.id}</p>
                                <p>From: ${show1.getlocation(curCarroute.from).province}</p>
                                <p>To: ${show1.getlocation(curCarroute.to).province}</p>
                                
                            </td>
                            <td>
                                ${curCarroute.price}
                            </td>
                            <td>
                                <a href="">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div>Total: ${totalPrice}</div>
            <input class="button-form" type="submit" value="Đi tới trang thanh toán">
        </form>
    </body>
</html>
