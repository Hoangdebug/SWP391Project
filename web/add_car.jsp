<%-- 
    Document   : add_car
    Created on : Oct 4, 2023, 10:16:58 PM
    Author     : tuna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/add_staff.css"/>

        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
            integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <style>
            :root {
                --primary: #20c997;
                --secondary: #E0E0E0;
                --light: #befff7;
                --dark: #419197;
                --font-family-sans-serif: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
            }
            *{
                font-family: sans-serif;
            }

            .body{
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
            }
            .title-page{
                color: white;
            }

            .form-box{
                margin-top: 100px;
                width: 60%;
                height: auto;
                display: flex;
                flex-direction: column;
                background-color: #419197;
                border-radius: 20px;
                box-shadow: 10px 10px 50px grey;
            }

            .form-items{
                margin-top: 10px;
                width: 60%;
                height:50px;
                display: flex;
                flex-direction: column;
                /*background-color: #befff7;*/
                font-size: 16px;
                color: white;
                gap: 10px;
            }

            .form-items input{
                padding: 8px 20px;
                font-size: 16px;
                border: none;
                background-color: #419197;
                border-bottom: solid 1px white;
                color: white;
            }

            .button-form{
                margin:20px 0px;
                padding: 10px;
                color: #419197;
                background-color: white;
                border-radius: 10px;
                border: none;
            }

            .button-form:hover {
                background-color: #20c997;
                color: white;
            }

            .form-items select{
                padding: 5px;
                border-radius: 10px;
            }

        </style>
    </head>
    <body>
        <%@ include file="/include/header.jsp" %>
        <%@ include file="/include/sidebar.jsp" %>
        <div class="body">
            <form action="addcar" method="POST" class="form-box">
                <div class="title-page">
                    Add new car
                </div>
                <div class="form-items">
                    <label for="name">Tên Xe:</label>
                    <input type="text" id="name" name="name" required><br><br>
                </div>

                <div class="form-items">
                    <label for="cars">Loai xe:</label>
                    <select name="type" id="cars">
                        <option value="VIP">VIP</option>
                        <option value="STANDARD">STANDARD</option>
                    </select>
                </div>
                <div class="form-items">
                    <label for="countseat">Số ghế:</label>
                    <select name="countseat" id="countseat">
                        <option value="45">45</option>
                        <option value="22">22</option>
                    </select>
                </div>
                <div class="form-items">
                    <label for="licenseplate">Biển Số Xe:</label>
                    <input type="text" id="licenseplate" name="licenseplate" required><br><br>
                </div>
                <input class="button-form" type="submit" value="Thêm Xe">
            </form>
        </div>
    </body>
</html>
