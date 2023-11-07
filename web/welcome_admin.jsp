<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang Quản Trị</title>
        <!-- Thêm một số style CSS nếu bạn muốn -->
        <style>
            .welcome-text {
                position: absolute; /* Hoặc 'fixed' nếu bạn muốn nó luôn hiển thị ngay cả khi scroll */
                top: 40%; /* Đặt nó ở giữa theo chiều dọc của trang */
                left: 60%; /* Đặt nó ở giữa theo chiều ngang của trang */
                transform: translate(-50%, -50%); /* Dịch chuyển nó về vị trí chính xác giữa */
                font-size: 32px; /* Kích thước chữ */
                color: #333; /* Màu sắc chữ */
            }
        </style>
    </head>
    <body>
        <%@ include file="/include/header.jsp" %>
        <%@ include file="/include/sidebar.jsp" %>
        
        <!-- Thêm dòng chữ chào mừng -->
        <div class="welcome-text">
            <h1>Welcome Back: Admin!!!</h1>
        </div>
    </body>
</html>
