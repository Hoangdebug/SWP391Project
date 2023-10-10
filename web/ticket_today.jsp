<%-- 
    Document   : ticket_today
    Created on : Oct 5, 2023, 1:56:52 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Vé ngày hôm nay</h1>
        <!-- Hiển thị danh sách vé và nút "Thêm vào giỏ hàng" -->
        <ul>
            <li>Vé A <a href="addToCart?ticketId=1">Thêm vào giỏ hàng</a></li>
            <li>Vé B <a href="addToCart?ticketId=2">Thêm vào giỏ hàng</a></li>
            <!-- Thêm các vé khác vào đây -->
        </ul>
        <!-- Liên kết đến trang giỏ hàng -->
        <a href="cart.jsp">Xem giỏ hàng</a>
    </body>
</html>
