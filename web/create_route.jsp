<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean class="model.repository.UserRepository" id="getDriver"></jsp:useBean>
<jsp:useBean class="model.repository.CarRepository" id="getCar"></jsp:useBean>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Thêm Tuyến Đường Mới</h2>
        <form action="car-route" method="POST">
            <label for="car_id">ID Xe:</label>
            <select name="car_id" class="form-control" id="car_id">
                <c:forEach items="${getCar.getAllCar()}" var="g">
                    <option value="${g.getId()}">${g.getName()}</option>
                </c:forEach>
            </select>
            <label for="user_id">Driver:</label>
            <select name="user_id" class="form-control" id="car_id">
                <c:forEach items="${getDriver.getDriverById()}" var="c">
                    <option value="${c.getId()}">${c.getFullname()}</option>
                </c:forEach>
            </select>
            <label >Điểm Đi:</label>
            <input type="text" id="from" name="from" required><br><br>

            <label >Điểm Đến:</label>
            <input type="text" id="to" name="to" required><br><br>

            <label for="price">Giá Vé:</label>
            <input type="text" id="price" name="price" required><br><br>

            <label for="start">Giờ Khởi Hành:</label>
            <input type="text" name="start" required><br><br>

            <label for="end">Giờ Đến:</label>
            <input type="text"  name="end" required><br><br>

            <label for="datestart">Ngày Khởi Hành:</label>
            <input type="date"  name="datestart" required><br><br>

            <input type="submit" value="Thêm Tuyến Đường">
        </form>

    </body>
</html>
