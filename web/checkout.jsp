<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link href="Cart.css">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
              crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
              integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
              crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
        <!------ Include the above in your HEAD tag ---------->
        <title>Document</title>
        <link rel="stylesheet" href="css/Cart.css">
        <style>
            strong.thongtin {
                color: chocolate;
                font-size: 20px;
            }

            body {
                background-color: white;
            }

            img {
                margin-left: 180px;
                position: absolute;
                width: 250px;
                height: 50px;
                margin-top: -5px;
            }
        </style>
    </head>

    <body>

        <div id="sb-site">
            <a href="${pageContext.request.contextPath}/ShowAllBus"><img
                    src="./images/logo2.png"></a>

            <div class="br-header">
                <div id="top-nav" class="hidden-xs">
                    <div class="container">
                        <ul class="clearfix">

                            <li class="pull-right diff"><a
                                    href="${pageContext.request.contextPath}/AccountServlet"><span
                                        class="hidden-xs">Hi, ${userlogin.getFullName()}</span></a></li>
                            <li class="pull-right"><a
                                    href="${pageContext.request.contextPath}/ViewCartCustomer?idUser=${userlogin.getIdUser()}">Lịch
                                    sử mua vé</a></li>
                            <li class="pull-right"><a
                                    href="${pageContext.request.contextPath}/UpdateNdServlet?idUser=${userlogin.getIdUser()}">Cập
                                    nhật thông tin</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- ngView:  -->
            <section id="body-content">
                <div id="steps" class="container">
                    <ul class="list-step clearfix">
                        <li>Chọn tuyến <span></span>
                        </li>
                        <li>Chọn ghế <span></span></li>
                        <li>Thông tin khách hàng <span></span></li>
                        <li class="active first">Thanh toán <span></span></li>
                    </ul>
                </div>
                <div id="content-steps" class="container">
                    <div class="row">
                        <div class="col-ld-6 col-md-12 col-sm-12 col-xs-12 col-ms-12">
                            <div class="">
                                <p class="">
                                    <strong class="thongtin">Thông tin đặt vé</strong>
                                </p>
                                <form action="CheckOutServlet" method="post">
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <table class="table">
                                                <tbody>
                                                    <tr>
                                                        <td class="col-xs-3">Tuyến:</td>
                                                        <td class="col-xs-9" colspan="3" name="departure">${bus.getDeparture()}
                                                            => ${bus.getDestination()}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Ngày đi:</td>

                                                        <td><span name="bday">${date}</span></td>
                                                        <td>Mã tuyến</td>
                                                        <td><span>${bus.getIdBus()}</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Thời gian</td>
                                                        <td><span name="time">${bus.getTime()}</span>
                                                    </tr>
                                                    <tr>
                                                        <td>Điểm lên xe:</td>
                                                        <td colspan="3">VP Bến Xe Bạc Liêu , Đường Trần Phú ,
                                                            Khóm 2 , P.7 , TP.Bạc Liêu (TERMINAL BUS STATION)</td>
                                                    </tr>
                                                    <tr class="sperator">
                                                        <td>Họ tên:</td>
                                                        <td name="fullname">${user.getFullName()}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Email:</td>
                                                        <td name="email">${user.getEmail()}</td>
                                                        <td>SĐT:</td>
                                                        <td><span name="phone">${user.getPhoneNum()}</span> <span
                                                                ng-bind-html="step3Info.CustMobile2"></span></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Tổng tiền:</td>
                                                        <td colspan="3"><strong class="text-primary"
                                                                                name="price">${price}<sup>₫</sup></strong></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-12 col-md-12 col-sm-2 col-xs-12 col-ms-12">
                                            <a href="${pageContext.request.contextPath}/ShowAllBus"
                                               type="" class="btn btn-primary btn-block btn-flat"> <i
                                                    class="fa fa-arrow-left icon-flat bg-btn-actived"></i> Quay
                                                lại
                                            </a>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>

    </body>

</html>