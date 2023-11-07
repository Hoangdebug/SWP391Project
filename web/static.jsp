<%-- 
    Document   : static
    Created on : Nov 7, 2023, 3:43:22 PM
    Author     : tuna
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:useBean class="model.repository.CarRepository" id="totalCar"></jsp:useBean>
    <jsp:useBean class="model.repository.CarRouteRepository" id="totalCarrotes"></jsp:useBean>
    <jsp:useBean class="model.repository.OrderRepository" id="totalAmount"></jsp:useBean>
    <jsp:useBean class="model.repository.UserRepository" id="totalUser"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang Quản Trị</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <style>
            .stats-container {
                display: flex;
                justify-content: space-around;
                flex-wrap: wrap;
                margin-left: 400px;
            }

            .stats-box {
                width: 450px;
                height: 200px;
                padding: 20px;
                margin-top: 150px;
                border-radius: 10px;
                text-align: center;
                color: white;
                transition: transform 0.3s ease-in-out, box-shadow 0.3s ease-in-out;
                position: relative;
                display: flex; /* Sử dụng flexbox */
                flex-direction: column; /* Xếp các mục theo hướng dọc */
                justify-content: center; /* Căn giữa theo chiều dọc */
                align-items: center; /* Căn giữa theo chiều ngang */
            }

            .stats-box h3 {
                font-size: 2em; /* Điều chỉnh kích thước phù hợp */
                margin-bottom: 0.5em;
            }

            .stats-box p {
                font-size: 1.5em; /* Điều chỉnh kích thước phù hợp */               
                position: absolute;
                bottom: 0; /* Đẩy xuống dưới cùng với cách lề dưới 10px */
                left: 0;
                width: 100%; /* Chiếm toàn bộ chiều rộng của stats-box */
                background-color: rgba(0, 0, 0, 0.2); /* Màu nền với độ trong suốt */
                padding: 5px; /* Thêm padding cho background */
                border-radius: 0 0 10px 10px; /* Bo tròn góc dưới của background */
            }

            /* Màu sắc và gradient cho mỗi ô thống kê */
            .stats-box:nth-child(1) {
                background: linear-gradient(to right, #ff7e5f, #feb47b);
            }

            .stats-box:nth-child(2) {
                background: linear-gradient(to right, #6dd5ed, #2193b0);
            }

            .stats-box:nth-child(3) {
                background: linear-gradient(to right, #ff6a00, #ee0979);
            }

            .stats-box:nth-child(4) {
                background: linear-gradient(to right, #667db6, #0082c8, #0082c8, #667db6);
            }

            .stats-box:nth-child(5) {
                background: linear-gradient(to right, #f7971e, #ffd200);
            }

            .stats-box:nth-child(6) {
                background: linear-gradient(to right, #e43a15, #e65245);
            }

            .stats-box:hover {
                transform: translateY(-5px);
                box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
            }

        </style>


    </head>
    <body>
        <%@ include file="/include/header.jsp" %>
        <%@ include file="/include/sidebar.jsp" %>

        <div class="stats-container">
            <div class="stats-box">
                <h3>${totalCar.totalCar()}</h3>
                <p>Cars <i class="fa-solid fa-bus"></i></p>
            </div>
            <div class="stats-box">
                <h3>${totalCarrotes.totalCarroute()}</h3>
                <p>Carroutes <i class="fa-solid fa-route"></i></p>
            </div>
            <div class="stats-box">
                <h3>${totalAmount.calculateTotalRevenueFromOrderc()}</h3>
                <p>Total Amount <i class="fa-solid fa-money-bill"></i></p>
            </div>
            <div class="stats-box">
                <h3>${totalUser.totalStaff()}</h3>
                <p>Staff <i class="fa-solid fa-person"></i></p>
            </div>
            <div class="stats-box">
                <h3>${totalUser.totalDrivers()}</h3>
                <p>Driver <i class="fa-solid fa-person"></i></p>
            </div>
            <div class="stats-box">
                <h3>${totalUser.totalMembers()}</h3>
                <p>Member <i class="fa-solid fa-person"></i></p>
            </div>

        </div>

    </body>
</html>