<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 08.12.2021
  Time: 06:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="styles/styleInfo.css" rel="stylesheet" type="text/css">
<script src="js/script.js"></script>
<link rel="icon" type="image/x-icon" href="https://trackensure.com/images/favicon.png">
<head>
    <title>Departments</title>
</head>
<body>
<jsp:useBean id="depbean" scope="request" type="com.example.company.beans.DepartmentBean"/>
<table>
    <thead>
    <tr>
        <th>ID Департамента</th>
        <th>Имя департамента</th>
        <th>Начало рабочего времени</th>
        <th>Конец рабочего времени</th>
        <th>Этаж</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${depbean.departments}" var="d">
        <tr>
            <td>${d.id}</td>
            <td>${d.name}</td>
            <td>${d.startTime}</td>
            <td>${d.endTime}</td>
            <td>${d.floor}</td>
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
