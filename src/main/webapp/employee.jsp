<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 08.12.2021
  Time: 08:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="styles/styleInfo.css" rel="stylesheet" type="text/css">
<script src="js/script.js"></script>
<link rel="icon" type="image/x-icon" href="https://trackensure.com/images/favicon.png">
<head>
    <title>Employees</title>
</head>
<body>
<jsp:useBean id="empbean" scope="request" type="com.example.company.beans.EmployeeBean"/>
<table>
    <thead>
    <tr>
        <th>Имя Сотрудника</th>
        <th>Фамилия сотрудника</th>
        <th>Дата рождения</th>
        <th>Департамент</th>
        <th>Начало рабочего времени</th>
        <th>Конец рабочего времени</th>
        <th>Рабочее время совпадает с предпочтением сотрудника</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${empbean.employees}" var="e">
        <tr>
            <td>${e.firstName}</td>
            <td>${e.lastName}</td>
            <td>${e.dateOfBirth}</td>
            <td>${e.departmentName}</td>
            <td>${e.startTime}</td>
            <td>${e.endTime}</td>
            <td><c:choose>
                <c:when test="${not e.preference}">Нет</c:when>
                <c:otherwise>Да</c:otherwise>
            </c:choose> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<ul>
    <li class="form__line">
        <button onclick="location.href = 'mainPage';" id="button1" class="ui-button">Назад</button>
    </li>
</ul>
</body>
</html>
