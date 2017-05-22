<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<html>
<head>
    <title>Admin's page</title>
    <style type="text/css">
        body {
            font-family: "Times New Roman", serif;
            background-color: #eeeeee;
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

        #main {
            padding-left: 20px;
        }

        #logout {
            padding-left: 93%;
        }

        #addCourse input, select {
            width: 100%;
        }

    </style>
</head>
<body>
<a href="<c:url value="/login"/>">Back</a>
<a id="logout" href="<c:url value="/logout"/>">Logout</a>
<br/>
<br/>
<div id="main">
    <h1>Welcome, ${login}</h1>
    <c:if test="${!empty listCourses}">
        <h3>Courses</h3>
        <table class="tg">
            <tr>
                <th width="80">ID</th>
                <th width="120">Name Course</th>
                <th width="120">Start Date</th>
                <th width="120">End Date</th>
                <th width="120">Price</th>
                <th width="60">Lecturer</th>
                <th width="60">Status</th>
                <th width="60">Theme</th>
                <th width="60">Edit</th>
                <th width="60">Delete</th>
            </tr>
            <c:forEach items="${listCourses}" var="course">
                <tr>
                    <td>${course.idCourse}</td>
                    <td>${course.nameCourse}</td>
                    <td><fmt:formatDate pattern="dd.MM.yyyy" value="${course.startDate}"/></td>
                    <td><fmt:formatDate pattern="dd.MM.yyyy" value="${course.endDate}"/></td>
                    <td>${course.price}</td>
                    <td>${course.lecturersByIdLecturer.surname} ${course.lecturersByIdLecturer.name} ${course.lecturersByIdLecturer.patronymic}</td>
                    <td>${course.statusByIdStatus.nameStatus}</td>
                    <td>${course.themeByIdTheme.nameTheme}</td>
                    <td><a href="<c:url value='/edit/${course.idCourse}'/>">Edit</a></td>
                    <td><a href="<c:url value='/remove/${course.idCourse}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <br>
    <hr>
    <br>

    <h1>Add a Course</h1>
    <c:url var="addAction" value="/courses/add"/>

    <form:form action="${addAction}" commandName="course">
        <table id="addCourse">
            <c:if test="${!empty courses.nameCourse}">
                <tr>
                    <td>
                        <form:label path="id">
                            <spring:message text="ID"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="idCourse" readonly="true" size="8" disabled="true"/>
                        <form:hidden path="idCourse"/>
                    </td>
                </tr>
            </c:if>
            <tr>
                <td>
                    <form:label path="nameCourse">
                        <spring:message text="Name of Course"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="nameCourse" required="required"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="startDate">
                        <spring:message text="Start date"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="startDate" required="required"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="endDate">
                        <spring:message text="End date"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="endDate" required="required"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="price">
                        <spring:message text="Price"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="price" required="required"/>
                </td>
            </tr>
            <tr>
                <td>Status of course</td>
                <td>
                    <c:if test="${!empty listStatuses}">
                        <select name="Status">
                            <c:forEach items="${listStatuses}" var="Status" varStatus="status">
                                <option value="${Status.idStatus}">${Status.nameStatus}</option>
                            </c:forEach>
                        </select>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>Theme of course</td>
                <td>
                    <c:if test="${!empty listThemes}">
                        <select name="theme">
                            <c:forEach items="${listThemes}" var="theme" varStatus="status">
                                <option value="${theme.idTheme}">${theme.nameTheme}</option>
                            </c:forEach>
                        </select>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>Lecturer on course</td>
                <td>
                    <c:if test="${!empty listLecturers}">
                        <select name="lecturer">
                            <c:forEach items="${listLecturers}" var="lecturer" varStatus="status">
                                <option value="${lecturer.id}">${lecturer.surname} ${lecturer.name} ${lecturer.patronymic}</option>
                            </c:forEach>
                        </select>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:if test="${!empty course.nameCourse}">
                        <input type="submit" value="<spring:message text="Edit Course"/>"/>
                    </c:if>
                    <c:if test="${empty course.nameCourse}">
                        <input type="submit" value="<spring:message text="Add Course"/>"/>
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>

    <c:if test="${!empty listUsers}">
        <h3>Users</h3>
        <table class="tg">
            <tr>
                <th width="80">ID</th>
                <th width="120">Login</th>
                <th width="120">Password</th>
                <th width="60">Email</th>
                <th width="60">Role</th>
                <th width="60">State</th>
                <th width="60">Lock</th>
                <th width="60">Delete</th>
            </tr>
            <c:forEach items="${listUsers}" var="user">
                <tr>
                    <td>${user.idUser}</td>
                    <td>${user.login}</td>
                    <td>${user.password}</td>
                    <td>${user.email}</td>
                    <td>${user.rolesByIdRole.nameRole}</td>
                    <td>${user.statesByIdState.nameState}</td>
                    <c:choose>
                        <c:when test="${user.statesByIdState.idState==1}">
                            <td><a href="<c:url value='/lockUser/${user.idUser}'/>">Lock</a></td>
                        </c:when>
                        <c:otherwise>
                            <td><a href="<c:url value='/lockUser/${user.idUser}'/>">Unlock</a></td>
                        </c:otherwise>
                    </c:choose>
                    <td><a href="<c:url value='/removeUser/${user.idUser}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</div>
</body>
</html>
