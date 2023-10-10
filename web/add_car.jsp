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
        <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
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
                width: 50%;
                height: auto;
                display: flex;
                flex-direction: column;
                background-color: #419197;
                border-radius: 20px;
                box-shadow: 10px 10px 50px grey;
            }

            .form-items{
                margin-top: 10px;
                width: 70%;
                /*height:50px;*/
                display: flex;
                flex-direction: column;
                /*background-color: #befff7;*/
                font-size: 16px;
                color: white;
                gap: 10px;
            }

            .double-form-items{
                display: flex;
                width: 70%;
                justify-content: space-between;
                gap: 20px;

            }

            .form-items-select{
                font-size: 16px;
                color: white;
                gap: 20px;
            }


            input{
                padding: 5px 20px;
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

            .form-items-select select{
                padding: 5px;
                border-radius: 10px;
            }

        </style>
    </head>
    <body>
        <%@ include file="/include/header.jsp" %>
        <%@ include file="/include/sidebar.jsp" %>
        <div class="body">
            <!--            <form action="addcar" method="POST" class="form-box">
                            <div class="title-page">
                                Add New Car
                            </div>
                            <div class="form-items">
                                <label for="name">Tên Xe:</label>
                                <input type="text" id="name" name="name" required>
                            </div>
            
                            <div class="double-form-items">
                                <div class="form-items-select">
                                    <label for="types">Loai xe:</label>
                                    <select name="type" id="types">
                                        <option value="VIP">VIP</option>
                                        <option value="STANDARD">STANDARD</option>
                                    </select>
                                </div>
                                <div class="form-items-select">
                                    <label for="countseat">Số ghế:</label>
                                    <select name="countseat" id="countseat">
                                        <option value="45">45</option>
                                        <option value="22">22</option>
                                    </select>
                                </div>
                            </div>
            
                            <div class="form-items">
                                <label for="licenseplate">Biển Số Xe:</label>
                                <input type="text" id="licenseplate" name="licenseplate" required>
                            </div>
                            <input class="button-form" type="submit" value="Thêm Xe">
                        </form>-->
            <form id="myForm" method="POST" class="form-box">
                <div class="title-page">
                    Add New Car
                </div>
                <div class="form-items">
                    <label for="name">Tên Xe:</label>
                    <input type="text" id="name" name="name" required>
                </div>

                <div class="double-form-items">
                    <div class="form-items-select">
                        <label for="types">Loai xe:</label>
                        <select name="type" id="type">
                            <option value="VIP">VIP</option>
                            <option value="STANDARD">STANDARD</option>
                        </select>
                    </div>
                    <div class="form-items-select">
                        <label for="countseat">Số ghế:</label>
                        <select name="countseat" id="countseat">
                            <option value="45">45</option>
                            <option value="22">22</option>
                        </select>
                    </div>
                </div>

                <div class="form-items">
                    <label for="licenseplate">Biển Số Xe:</label>
                    <input type="text" id="licenseplate" name="licenseplate" required>
                </div>
                <input class="button-form" type="submit" value="Thêm Xe">
            </form>

        </div>
        <script>
            $(document).ready(function () {
                $("myForm").submit(function (event) {
                    event.preventDefault(); // Ngăn chặn chuyển trang mặc định

                    // Lấy giá trị từ các trường nhập liệu
                    var ten = $("#name").val();
                    var loai = $("#type").val();
                    var soghe = $("#countseat").val();
                    var bienso = $("#licenseplate").val();


                    // Tạo đối tượng dữ liệu để gửi lên server
                    var data = {
                        ten: ten,
                        loai: loai,
                        soghe: soghe,
                        bienso: bienso
                    };

                    // Sử dụng Ajax để gửi dữ liệu lên server (thay đổi URL và phương thức tùy theo yêu cầu của bạn)
                    $.ajax({
                        url: "add_car.jsp", // Thay đổi thành URL của bạn
                        method: "POST", // Thay đổi thành phương thức của bạn (POST hoặc GET)
                        data: data,
                        success: function (response) {
                            // Xử lý kết quả từ server (nếu cần)
                            alert("Thêm dữ liệu thành công!");
                        },
                        error: function (error) {
                            // Xử lý lỗi (nếu có)
                            alert("Có lỗi xảy ra: " + error);
                        }
                    });
                });
            });
        </script>

    </body>
</html>
