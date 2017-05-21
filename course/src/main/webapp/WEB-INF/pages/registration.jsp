<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Registration</title>
    <style>
        body {
            font-family: "Times New Roman", serif;
        }
        td {
            padding: 8px;
            margin: 5px;
        }

        h1 {
            padding-top: 185px;
        }
    </style>
</head>
<body>
<c:if test="${not empty error}">
    Error: ${error}
</c:if>
<a href="<c:url value="/login"/>">Back</a>
<h1>
    <div style="text-align: center;">Registration</div>
</h1>
<form:form id="registrationForm" modelAttribute="user" action="register" method="get">
    <table align="center">
        <tr>
            <form:errors path="email">A</form:errors>
            <td>
                <form:label path="login">
                    <spring:message text="Login"/>
                </form:label>
            </td>
            <td>
                <form:input path="login" name="login" id="login" required="required"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password">
                    <spring:message text="Password"/>
                </form:label>
            </td>
            <td>
                <form:password path="password" name="password" id="password" required="required"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password">
                    <spring:message text="Confirm Password"/>
                </form:label>
            </td>
            <td>
                <input type="password" name="confirm" required title="a">
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="email">
                    <spring:message text="Email"/>
                </form:label>
            </td>
            <td>
                <form:input path="email" name="email" id="email" required="required"/>
            </td>
        </tr>
        <tr>
            <td>
                Role
            </td>
            <td>
                <c:if test="${!empty roles}">
                    <select name="role">
                        <c:forEach items="${roles}" var="role" varStatus="status">
                            <option value="${role.idRole}">${role.nameRole}</option>
                        </c:forEach>
                    </select>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>
                <form:button id="action" name="register">Register</form:button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>