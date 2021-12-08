<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<link href="styles/style.css" rel="stylesheet" type="text/css">
<script src="js/script.js"></script>
<link rel="icon" type="image/x-icon" href="https://trackensure.com/images/favicon.png">
<head>
    <title>Department manager</title>
</head>
<body>
<jsp:useBean id="depbean" scope="request" type="com.example.company.beans.DepartmentBean"/>
<jsp:useBean id="empbean" scope="request" type="com.example.company.beans.EmployeeBean"/>
<h1>
    <a href="https://trackensure.com"><img src="https://s.dou.ua/img/static/companies/LOGO_qmxPasW.png"></a>
</h1>
<br/>
<div class="form__wrapper">
    <div class="menu">
        <form onsubmit="return false">
            <ul>
                <li class="form__line">
                    <button id="button1" onclick="showDepartmentForm(addDepartment)" class="ui-button">Добавить отдел в
                        компанию
                    </button>
                </li>
            </ul>
        </form>
        <form onsubmit="return false">
            <ul>
                <li class="form__line">
                    <button id="button2" onclick="showEmployeeForm(addEmployee)" class="ui-button">Добавить сотрудника
                    </button>
                </li>
            </ul>
        </form>
        <form onsubmit="return false">
            <ul>
                <li class="form__line">
                    <button id="button3" onclick="setScheduleDepartment(showDepartment)" class="ui-button">Изменить
                        рабочий график отделу
                    </button>
                </li>
            </ul>
        </form>
        <form onsubmit="return false">
            <ul>
                <li class="form__line">
                    <button id="button4" onclick="setEmployeeSchedule(showEmployee)" class="ui-button">Изменить рабочий
                        график сотруднику
                    </button>
                </li>
            </ul>
        </form>
        <form method="get" action="showEmployee">
            <ul>
                <li class="form__line">
                    <button id="button5" class="ui-button">Показать всех сотрудников
                    </button>
                </li>
            </ul>
        </form>
        <form method="get" action="showDepartment">
            <ul>
                <li class="form__line">
                    <button id="button6" class="ui-button">Показать все департаменты
                    </button>
                </li>
            </ul>
        </form>
        <form onsubmit="return false">
            <ul>
                <li class="form__line">
                    <button id="button7" onclick="showStatistic(showStat)" class="ui-button statistic-button">Показать статистику
                    </button>
                </li>
            </ul>
        </form>
    </div>
    <div id="addDep" class="form1" style="display: none">
        <form method="post" action="addDepartment">
            <div class="form_changer">
                <label for="name">Название отдела:</label>
                <input type="text" id="name" placeholder="Введите название..." name="nameDepReq" required>
            </div>
            <div class="form_changer">
                <label for="timeStart">Время начала рабочего дня:</label>
                <input type="time" id="timeStart" name="startTimeReq" required>
            </div>
            <div class="form_changer">
                <label for="timeEnd">Время окончания рабочего дня:</label>
                <input type="time" id="timeEnd" name="endTimeReq" required>
            </div>
            <div class="form_changer">
                <label for="floor">Этаж:</label>
                <input type="text" id="floor" placeholder="Введите этаж..." name="floorDepReq" required>
            </div>
            <button type="submit" class="ui-button-submit">Отправить</button>
        </form>
    </div>
    <div id="addEmp" class="form1" style="display: none">
        <form method="post" action="addEmployee">
            <div class="form_changer">
                <label for="nameReq">Имя сотрудника</label>
                <br>
                <input type="text" id="nameReq" placeholder="Введите имя" name="nameReq" required>
            </div>
            <div class="form_changer">
                <label for="lastNameReq">Фамилия сотрудника</label>
                <br>
                <input type="text" id="lastNameReq" placeholder="Введите фамилию" name="lastNameReq" required>
            </div>
            <div class="form_changer">
                <label for="dateTimeReq">Дата рождения</label>
                <br>
                <input type="datetime-local" id="dateTimeReq" name="dateTimeReq" required>
            </div>
            <div class="form_changer">
                <label for="selectDep">Работает в отделе</label>
                <br>
                <select class="ui-select" id="selectDep" name="textReq" required>
                        <c:forEach items="${depbean.departments}" var="d">
                            <option value=${d.id}>${d.name}</option>
                        </c:forEach>
                </select>
            </div>
            <div class="form_changer">
                <label for="startTimeEmp">Начинает работать</label>
                <br>
                <input type="time" id="startTimeEmp" name="startTimeEmp" required>
            </div>
            <div class="form_changer">
                <label for="endTimeEmp">Заканчивает работать</label>
                <br>
                <input type="time" id="endTimeEmp" name="endTimeEmp" required>
            </div>
            <button type="submit" class="ui-button-submit">Отправить</button>
        </form>
    </div>
    <div id="setDep" class="form1" style="display: none">
        <form>
            <div class="form_changer">
                <label>Выберите департамент:</label>
                <select class="ui-select" id="selectDepForChange" name="chooseDepNameInChangeMenu" required>
                    <c:forEach items="${depbean.departments}" var="d">
                        <option value=${d.id}>${d.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form_changer">
                <label for="timeStartDepChange">Время начала рабочего дня:</label>
                <input type="time" id="timeStartDepChange" name="changeStartTimeDepReq" required>
            </div>
            <div class="form_changer">
                <label for="timeEndDepChange">Время окончания рабочего дня:</label>
                <input type="time" id="timeEndDepChange" name="changeEndTimeDepReq" required>
            </div>
            <button type="submit" class="ui-button-submit">Отправить</button>
        </form>
    </div>
    <div id="setEmp" class="form1" style="display: none">
        <form>
            <div class="form_changer">
                <label>Выберите сотрудника:</label>
                <select class="ui-select" id="selectEmpForChange" name="chooseEmpNameInChangeMenu" required>
                    <c:forEach items="${empbean.employees}" var="e">
                        <option value=${e.firstName}>${e.firstName} ${e.lastName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form_changer">
                <label for="timeStartEmpChange">Время начала рабочего дня:</label>
                <input type="time" id="timeStartEmpChange" name="changeStartTimeEmpReq" required>
            </div>
            <div class="form_changer">
                <label for="timeStartEmpChange">Время окончания рабочего дня:</label>
                <input type="time" id="timeEndEmpChange" name="changeEndTimeEmpReq" required>
            </div>
            <button type="submit" class="ui-button-submit">Отправить</button>
        </form>
    </div>
</div>
<script>
    const addEmployee = document.getElementById("addEmp");
    const addDepartment = document.getElementById("addDep");
    const showDepartment = document.getElementById("setDep")
    const showEmployee = document.getElementById("setEmp")
    const showStat = document.getElementById("setEmp")
</script>
</body>
</html>