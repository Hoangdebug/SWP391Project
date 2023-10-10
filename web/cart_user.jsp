<%-- 
    Document   : cart_user
    Created on : Oct 5, 2023, 1:57:38 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Giỏ hàng</title>
    </head>
    <body>
        <h1>Giỏ hàng</h1>
        <table border="1">
            <tr>
                <th>Vé</th>
                <th>Số lượng</th>
                <th>Giá</th>
                <th>Tổng</th>
                <th>Xóa</th>
            </tr>
            <c:forEach var="item" items="${sessionScope.cart}">
                <tr>
                    <td>${item.key}</td>
                    <td>${item.value}</td>
                    <td>${getTicketPrice(item.key)}</td>
                    <td>${item.value * getTicketPrice(item.key)}</td>
                    <td><a href="removeFromCart?ticketId=${item.key}">Xóa</a></td>
                </tr>
            </c:forEach>
        </table>
        <p>Tổng tiền: ${calculateTotal()}</p>
        <a href="today.jsp">Quay trở lại</a>
</html>
