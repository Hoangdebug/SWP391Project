<%-- 
    Document   : otpConfirm
    Created on : Oct 4, 2023, 2:09:59 PM
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
        <div class="form-container">
            <form action="" method="get">
                <label for="otp">Enter OTP:</label>
                <input type="text" id="otp" name="otp">
                <input type="submit" name="btAction" value="Verify" class="btn btn-primary"/>
            </form>
        </div>
    </body>
</html>
