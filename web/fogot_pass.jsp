<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Forgot Password</title>
    </head>
    <body>
        <h1>Forgot Password</h1>
        <form action="ForgotPasswordServlet" method="post">
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required><br>
            <label for="email">Password:</label>
            <input type="text" name="password"  required><br>
            <label for="email">Xác nhận:</label>
            <input type="text" name="confirmPassword"  required><br>
            <input type="submit" value="Reset Password">
        </form>
    </body>
</html>