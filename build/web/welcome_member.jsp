<%-- 
    Document   : welcome_member
    Created on : Oct 3, 2023, 12:38:16 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--<link rel="stylesheet" href="css/sidebar.css"/>-->
        <link rel="stylesheet" href="css/member.css"/>

        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
            integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
    </head>
    <body>
        <%@ include file="/include/header.jsp" %>
        <%@ include file="/include/sidebar.jsp" %>
        <div class="body">
            <form name="search" action="search">
                <!--<input class="form-input" type="text" name="search" value="" placeholder="Search..."/>Search...-->
                <div class="form-input"></div>
                <button type="submit" class="form-btn">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </button>
            </form>
            
            <div class="title-page">
                Car Route List
            </div>
            
            <div class="table">
                <table border="2">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>From</th>
                            <th>To</th>
                            <th>Date</th>
                            <th>Start time</th>
                            <th>End time</th>
                            <th>Price</th>
                            <th>Buy</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>                   
                            <td>Da Nang</td>
                            <td>Kon Tum</td>
                            <td>20/10/2023</td>
                            <td>7:00 AM</td>
                            <td>14:00 PM</td>
                            <td>240 000</td>
                            <td><a href="#">Buy</a></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
