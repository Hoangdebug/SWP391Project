<%-- 
    Document   : list_seat
    Created on : Oct 10, 2023, 2:34:30 PM
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
        <link rel="stylesheet" href="css/list_staff.css"/>

        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
            integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <style>
            html,body{
                width:100%;
            }
            .body{
                margin: 10px 0px;
                text-align: center;
                width: 100%;
            }
            .content{
                width: 100%;
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .left{
                width: 50%;
            }
            .all-seats {
                /*background-color: antiquewhite;*/
                width: 100%;
                display: grid;
                grid-template-columns: repeat(6, 1fr);
                grid-gap: 15px;
                margin: 20px 0;
                margin-top: 20px;
                /* position: relative; */
            }

            .seat {
                width: 40px;
                height: 40px;
                background: white;
                border-radius: 0.5mm;
                outline: 0.3mm solid rgb(180, 180, 180);
                cursor: pointer;
            }

            .all-seats input:checked+label {
                background: rgb(28, 185, 120);
                outline: none;
            }

            .seat.booked {
                background: rgb(180, 180, 180);
                outline: none;
            }

            input {
                display: none;
            }

            .seat{
                text-align: center;
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .right{
                width: 50%;
            }
        </style>
    </head>
    <body>
        <%
            String seat[];
            seat = request.getParameterValues("tickets");
        %>    

        <%@ include file="/include/header.jsp" %>
        <div class="body">
            <div class="content">
                <div class="left">
                    <div class="title-page">
                        List Seat
                    </div>
                    <form>
                        <div class="all-seats">
                            <c:forEach var="seat" items="${sList}">
                                <c:if test="${seat.is_booked == 0}">
                                    <input type="checkbox" name="ticket" id="${seat.seat_number}"  onClick="handleClick(this,${curCarroute.price})"/>
                                    <label for="${seat.seat_number}" class="seat ">${seat.seat_number}</label>
                                </c:if>
                                <c:if test="${seat.is_booked == 1}">
                                    <input type="checkbox" name="ticket" id="${seat.seat_number}" />
                                    <label for="${seat.seat_number}" class="seat booked">${seat.seat_number}</label>
                                </c:if>
                            </c:forEach>
                        </div>
                    </form>
                </div>

                <div class="right">
                    <div class="carroute information">
                        <div class="name-car">
                            Name: ${curCar.name}
                        </div>
                        <div class="datestart">
                            Date: ${curCarroute.datestart}
                        </div>
                        <div class="from">
                            From: ${curCarroute.from}
                        </div>
                        <div class="to">
                            To: ${curCarroute.to}
                        </div>
                        <div class="start">
                            Start: ${curCarroute.start}
                        </div>
                        <div class="end">
                            End: ${curCarroute.end}
                        </div>
                        <div class="list-seat" >
                            Seat: <span id="seat-list">${seat}</span>
                        </div>
                        <div class="total">
                            Total:
                            <span id="total">0</span>VND
                        </div>
                    </div>
                    <button href="" onclick="createTicket()" >Tiếp tục</button>

                </div>
            </div>
        </div>
        <script>
            const seatList = document.getElementById("seat-list");
            const total = document.getElementById("total");

            let arr = [];
            let count = 0;
            const handleClick = (e, b) => {
                if (arr.includes(e.id)) {
                    arr = arr.filter((item) => item !== e.id);
                    count -= b;
                    total.innerHTML = count.toFixed(3);
                    seatList.innerHTML = arr;
                } else {
                    count += b;
                    arr = [...arr, e.id];
                    total.innerHTML = count.toFixed(3);
                    seatList.innerHTML = arr;
                }
            }
            
            const createTicket = () => {
                window.location.href = 'createticket?lseat=' + arr;
            }
        </script>
    </body>

</html>
