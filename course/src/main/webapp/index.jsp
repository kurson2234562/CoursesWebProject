<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Courses</title>
        <style>
            h2 {
                padding-top: 200px;
            }

            a {
                color: black;
                cursor: default;
                text-decoration: none;
                font-size: 55px;
            }

            a:focus {
                color: black;
            }

            h1 {
                color: dodgerblue;
            }
        </style>
    </head>
    <body>
    <h1>Serhii Tatarinov presents</h1>
        <hr>
        <br>
    <div style="text-align: center;"><h2><a href="<c:url value="/login"/>">Login</a></h2></div>
        <br/>
    </body>
</html>