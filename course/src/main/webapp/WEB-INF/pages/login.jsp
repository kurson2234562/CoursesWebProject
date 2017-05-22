<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<style>
    body {
        font-family: "Times New Roman", serif;
        background-color: #eeeeee;
    }
    table {
        padding-top: 175px;
    }

    #home {
        padding-bottom: 300px;
    }

    td {
        padding: 10px;
    }

    #registration {
        padding-top: 2px;
        padding-left: 27px;
    }
</style>
<body>
<a id="home" href="<c:url value="/index.jsp"/>">Home</a>
<form:form id="loginForm" modelAttribute="user" action="loginProcess" method="get">
    <table align="center">
                <tr>
                    <td></td>
                </tr>
        <tr></tr>
        <tr>
            <td>
                <form:label path="login">Login: </form:label>
            </td>
            <td>
                <form:input path="login" name="login" id="login" required="required"/>
            </td>
        </tr>
                <tr>
                    <td>
                        <form:label path="password">Password:</form:label>
                    </td>
                    <td>
                        <form:password path="password" name="password" id="password" required="required"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td align="left">
                        <form:button id="action" name="action">Login</form:button>
                        <a id="registration" href="/registration">Registration</a>
                    </td>
                </tr>
            </table>
</form:form>
<table align="center">
    <tr>
        <td style="font-style: italic; color: red;">${message}</td>
    </tr>
</table>
</body>
</html>