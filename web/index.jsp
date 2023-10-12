<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Document</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    </head>
    <style>
        
        .carousel-item img {
            max-height: 500px; /* Điều chỉnh chiều cao tối đa */
            object-fit: cover; /* Hiển thị hình ảnh đầy đủ trong khung hiển thị */
            width: 100%;
        }
        .step-item{
            width: auto;
            height: 250px;
            border: dashed 3px var(--teal);
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            align-items: center;
            padding: 20px 40px;
        }

        .step-name{
            font-weight: 600;
            font-size: 28px;
            color: black;
        }

        .step-content{
            text-align: left;
            margin-bottom: 10px;
        }

        .step-content p{
            margin: 0;
        }

        .highlight{
            color: var(--dark);
            font-weight: 600;
        }

        .step-item a{
            height: auto;
            background-color: var(--teal);
            margin: 0 auto;
            padding: 10px 40px;
            color: white;
            font-weight: 600;
            border-radius: 2px;
        }
        .box-search {
            background-color: #fff;
            padding: 10px;
            margin-top: -300px; /* Điều chỉnh khoảng cách giữa carousel và giao diện tìm kiếm */
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
            position: relative; /* Để điều chỉnh vị trí tương đối cho box-search */
            z-index: 1; /* Để đảm bảo rằng box-search nằm trên carousel */
        }
        /* Đảm bảo rằng các phần tử trong carousel không bị che phủ bởi box-search */
        .carousel-item {
            z-index: 0; }
        .ftco-section {
            margin-top: 250px; /* Điều chỉnh khoảng cách theo ý muốn */
        }
        /* CSS cho nút "Tìm vé" */
        .btn-find-ticket {
            background-color: #007bff; /* Màu nền */
            color: #fff; /* Màu chữ */
            border: none; /* Loại bỏ viền */
            border-radius: 5px; /* Bo tròn góc */
            width: 100px;
            /* Kích thước nút */
            margin-left: 30px;
            font-size: 16px; /* Cỡ chữ */
            cursor: pointer; /* Đổi con trỏ chuột thành con trỏ tay khi di chuột qua nút */
            transition: background-color 0.3s ease; /* Hiệu ứng màu nền thay đổi mượt mà */
        }

        /* CSS cho hover nút "Tìm vé" (thay đổi màu nền khi di chuột qua) */
        .btn-find-ticket:hover {
            background-color: #0056b3; /* Màu nền thay đổi khi hover */
        }

        footer {
            margin-top: 30px;
            background-color: var(--teal);
            color: #fff;
            padding: 20px 0;
            /*text-align: center;*/
        }

        /* Định dạng cho liên kết trong footer */
        footer a {
            color: #fff;
            text-decoration: none;
        }

        /* Định dạng cho liên kết hover */
        footer a:hover {
            text-decoration: underline;
        }
       

    </style>

    <body>
        <!--NAVBAR-->
        <!--    <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a href="#" class="navbar-brand">VH<b>EXPRESS</b></a> 
                 Collection of nav links, forms, and other content for toggling 
                <div id="navbarCollapse" class="collapse navbar-collapse justify-content-start">
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Ngôn ngữ
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="#">Tiếng Anh</a>
                            <a class="dropdown-item" href="#">Tiếng việt</a>
                            <a class="dropdown-item" href="#">Tiếng Nhật</a>
                        </div>
                    </div>
                    <div class="navbar-nav">
                        <a href="#" class="nav-item nav-link">Trang chủ</a>
                        <a href="#" class="nav-item nav-link">Thông tin</a>			
                    </div>
                    <a href="#" class="nav-item nav-link">Liên hệ</a>
                    <div class="navbar-nav ml-auto action-buttons">
                        <div class="nav-item">
                            <a href="${pageContext.request.contextPath}/AccountServlet" class="nav-link dropdown-toggle mr-4">Đăng nhập</a>
        
                        </div>
                        <div class="nav-item ">
                            <a href="${pageContext.request.contextPath}/RegisterServlet"  class="btn btn-primary dropdown-toggle sign-up-btn">Đăng ký</a>
                        </div>
                    </div>
        
            </nav>-->

        <div class="container-fluid p-3">
            <div class="row">
                <div class="col-md-2 text-left" >
                   <span style="color: black; font-weight: bold; font-size: 23px;">VH</span><span style="color: var(--teal);font-weight: bold;font-size: 23px;F">Express</span>
                </div>
                <div class="col-md-10 text-right" >
                    <a href="${pageContext.request.contextPath}/login" class="btn btn-success"><i class="fa-solid fa-right-to-bracket"></i> Đăng nhập</a>
                    <a href="${pageContext.request.contextPath}/register" class="btn btn-primary text-white"><i class="fa-solid fa-user-plus"></i> Đăng ký</a>
                </div>
            </div>
        </div>

        <!--END NAVBAR-->

        <!--CAROUSEL-->
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ul class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ul>

            <!-- Slides -->
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="images/img1.webp" alt="Image 1" class="img-fluid">
                    <div class="carousel-caption">
                        <h3>Slide 1</h3>
                        <p>Some text for slide 1.</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="images/img2.jpeg" alt="Image 2" class="img-fluid">
                    <div class="carousel-caption">
                        <h3>Slide 2</h3>
                        <p>Some text for slide 2.</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="images/img3.jpeg" alt="Image 3" class="img-fluid">
                    <div class="carousel-caption">
                        <h3>Slide 3</h3>
                        <p>Some text for slide 3.</p>
                    </div>
                </div>
            </div>

            <!-- Left and right controls -->
            <a class="carousel-control-prev" href="#myCarousel" data-slide="prev">
                <span class="carousel-control-prev-icon"></span>
            </a>
            <a class="carousel-control-next" href="#myCarousel" data-slide="next">
                <span class="carousel-control-next-icon"></span>
            </a>
        </div>

        <!-- CAROUSEL-->
        <div class="container">
            <div class="box-search">
                <form>
                    <table width="100%" cellspacing="0" class="table-search">
                        <tbody>
                            <tr>
                                <td><select class="form-control col-sm-12">
                                        <option value="Điểm đi" selected>Điểm đi</option>
                                        <option>Sài gòn</option>
                                    </select></td>
                                <td><select class="form-control col-sm-12">
                                        <option value="Điểm đến" selected>Điểm đến</option>
                                        <option>Cà Mau</option>
                                    </select></td>
                                <td class="date"><input class="form-control col-sm-12"
                                                        type="date"></td>
                                <td><input type="submit" class="btn-find-ticket" value="Tìm vé"></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
        <div class="container">
            <section class="ftco-section">
                <div class="container">
                    <div class="row justify-content-center mb-5">
                        <div class="col-md-7 text-center heading-section ftco-animate">
                            <span class="subheading">Dịch vụ</span>
                            <h2 class="mb-3">ĐÓN XE KHÔNG ĐỢI CHỜ</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-3">
                            <div class="step-item">
                                <div class="step-name">
                                    Bước 1
                                </div>
                                <div class="step-content">
                                    <p>Vào trang cho khách hàng</p>
                                    <div class="highlight">
                                        VHEXPRESS.COM
                                    </div>
                                </div>
                                <a href="">Đi tới KHTT</a>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <div class="step-item">
                                <div class="step-name">
                                    Bước 2
                                </div>
                                <div class="step-content">
                                    <div class="highlight">
                                        ĐĂNG KÝ TÀI KHOẢN 
                                    </div>
                                    <p>bằng số điện thoại đặt vé</p>
                                </div>
                                <a href="">Đi tới KHTT</a>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <div class="step-item">
                                <div class="step-name">
                                    Bước 3
                                </div>
                                <div class="step-content">
                                    <p>Đăng nhập và chọn </p>
                                    <div class="highlight">
                                        “QUẢN LÝ VÉ XE”
                                    </div>
                                </div>
                                <a href="">Đi tới KHTT</a>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <div class="step-item">
                                <div class="step-name">
                                    Bước 4
                                </div>
                                <div class="step-content">
                                    <p>Chọn</p>
                                    <div class="highlight">
                                        “XEM VỊ TRÍ XE”
                                    </div>
                                </div>
                                <a href="">Đi tới KHTT</a>
                            </div>
                        </div>
                    </div>
            </section>
        </div>


        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <h5>Thông tin liên hệ</h5>
                        <p>123 Đường ABC, Thành phố XYZ</p>
                        <p>Email: example@example.com</p>
                    </div>
                    <div class="col-md-6">
                        <h5>Liên kết hữu ích</h5>
                        <ul class="list-unstyled">
                            <li><a href="#">Trang chủ</a></li>
                            <li><a href="#">Về chúng tôi</a></li>
                            <li><a href="#">Sản phẩm</a></li>
                            <li><a href="#">Liên hệ</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</html>