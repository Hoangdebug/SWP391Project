<%-- 
    Document   : login
    Created on : Sep 30, 2023, 11:49:37 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div class="log-form">
            <h2>Login to your account</h2>
            <form method="POST" action="login">
                <input type="text" id="email" name="email" title="email" placeholder="email" />
                <input type="password" id="password" name="password" title="password" placeholder="password" />
                <button type="submit" class="btn">Login</button>
                <a class="forgot" href="#">Forgot Username?</a>
            </form>
        </div><!--end log form -->
    </body>
</html>
