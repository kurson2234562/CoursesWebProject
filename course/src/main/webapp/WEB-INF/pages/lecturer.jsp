<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>Lecturer's page</title>
        <style>
            body {
                font-family: "Times New Roman", serif;
                background-color: #eeeeee;
            }
            #logout {
                padding-left: 93%;
            }
            table {
                text-align: center;
            }
            #main {
                padding-left: 35px;
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
        </style>
    </head>
    <body>
        <a href="<c:url value="/login"/>">Back</a>
        <a id="logout" href="<c:url value="/logout"/>">Logout</a>
        <div id="main">
            <h1>Welcome, ${login}</h1>
            <c:choose>
                <c:when test="${!empty notMarkedList}">
                    <h3>Not marked students.</h3>
                    <table class="tg">
                        <tr>
                            <th>Name of course</th>
                            <th colspan="3">Student</th>
                            <th>Mark</th>
                            <th></th>
                        </tr>
                        <c:forEach items="${notMarkedList}" var="cell">
                            <tr>
                                <td>${cell.nameCourse}</td>
                                <td>${cell.surname}</td>
                                <td>${cell.name}</td>
                                <td>${cell.patronymic}</td>
                                <td><input></td>
                                <td>
                                    <input type="submit" value="<spring:message text="Mark"/>"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                    You are do not have a not marked students on courses.
                </c:otherwise>
            </c:choose>
            <hr>
            <h3>Marks of students for your courses</h3>
            <c:if test="${!empty markedList}">
                <table class="tg">
                    <tr>
                        <th>Name of course</th>
                        <th>Start date</th>
                        <th>End date</th>
                        <th colspan="3">Student</th>
                        <th>Mark</th>
                    </tr>
                    <c:forEach items="${markedList}" var="cell">
                        <tr>
                            <td>${cell.nameCourse}</td>
                            <td><fmt:formatDate pattern="dd.MM.yyyy" value="${cell.startDate}"/></td>
                            <td><fmt:formatDate pattern="dd.MM.yyyy" value="${cell.endDate}"/></td>
                            <td>${cell.surname}</td>
                            <td>${cell.name}</td>
                            <td>${cell.patronymic}</td>
                            <td>${cell.mark}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </body>
</html>