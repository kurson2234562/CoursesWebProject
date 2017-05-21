<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Student's page</title>
    <style>
        body {
            font-family: "Times New Roman", serif;
        }
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        td {
            padding: 8px;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            overflow: hidden;
            word-break: normal;
            border: 1px solid #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            overflow: hidden;
            word-break: normal;
            border: 1px solid #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }

        #logout {
            padding-left: 93%;
        }

        table {
            text-align: center;
        }
    </style>
</head>
<body>
<a href="<c:url value="/login"/>">Back</a>
<a id="logout" href="<c:url value="/logout"/>">Logout</a>
<c:url var="selectMarks" value="/student"/>
<h1>Welcome, ${login}</h1>
<form:form id="registrationForm" modelAttribute="student" action="${selectMarks}" method="get">
    <c:choose>
        <c:when test="${!empty journal}">
            <div style="text-align: center;"><h3>Your marks</h3></div>
            <table align="center" class="tg">
                <tr>
                    <th colspan="3">Course</th>
                    <th>Mark</th>
                </tr>
                <c:forEach items="${journal}" var="note">
                    <tr>
                        <td><b>${note.course.nameCourse}</b></td>
                        <td><fmt:formatDate pattern="dd.MM.yyyy" value="${note.course.startDate}"/></td>
                        <td><fmt:formatDate pattern="dd.MM.yyyy" value="${note.course.endDate}"/></td>
                        <td><i>${note.mark}</i></td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            You do not have marks for courses.
        </c:otherwise>
    </c:choose>
</form:form>
</body>
</html>