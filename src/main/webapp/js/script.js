var selectedBackground = "linear-gradient(#dcdcdca3, #91ded359)";

function showDepartmentForm(department) {
    var buttonDep = document.getElementById("button1");
    const buttonDep1 = document.querySelector('#button1');
    if (department.style.display == "none") {
        department.style.display = "block";
        buttonDep.style.background = selectedBackground;
    } else {
        department.style.display = "none";
        buttonDep.style.removeProperty('background')
    }
}

function showEmployeeForm(employee) {
    var buttonEmp = document.getElementById("button2");
    if (employee.style.display == "none") {
        employee.style.display = "block";
        buttonEmp.style.background = selectedBackground;
    } else {
        employee.style.display = "none";
        buttonEmp.style.removeProperty('background')
    }
}

function setScheduleDepartment(department) {
    var buttonDep1 = document.getElementById("button3");
    if (department.style.display == "none") {
        department.style.display = "block";
        buttonDep1.style.background = selectedBackground;
    } else {
        department.style.display = "none";
        buttonDep1.style.removeProperty('background')
    }
}

function setEmployeeSchedule(employee) {
    var buttonEmp1 = document.getElementById("button4");
    if (employee.style.display == "none") {
        employee.style.display = "block";
        buttonEmp1.style.background = selectedBackground;
    } else {
        employee.style.display = "none";
        buttonEmp1.style.removeProperty('background')
    }
}

function showStatistic(statistic) {
    var buttonStat = document.getElementById("button7");
    if (statistic.style.display == "none") {
        statistic.style.display = "block";
        buttonStat.style.background = selectedBackground;
    } else {
        statistic.style.display = "none";
        buttonStat.style.removeProperty('background')
    }
}