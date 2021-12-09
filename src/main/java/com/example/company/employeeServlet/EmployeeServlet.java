package com.example.company.employeeServlet;

import com.example.company.beans.EmployeeBean;
import com.example.company.dao.CompanyDAO;
import com.example.company.dao.EmployeeDAO;
import com.example.company.data.Company;
import com.example.company.data.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@WebServlet(name = "employeeServlet", value = {"/addEmployee", "/showEmployee", "/changeScheduleEmployee"})
public class EmployeeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        if (request.getRequestURI().contains("mainPage")) {
            init(request, response);
            request.getRequestDispatcher("/mainPage.jsp").forward(request, response);
        }
        if (request.getRequestURI().contains("showEmployee")) {
            List<Employee> employees = new EmployeeDAO().findAll();
            request.setAttribute("empbean", new EmployeeBean(employees));
            request.getRequestDispatcher("/employee.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        if (request.getRequestURI().contains("addEmployee")) {
            addEmployee(request, response);
        }
        if (request.getRequestURI().contains("changeScheduleEmployee")) {
            changeScheduleEmployee(request, response);
        }
    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response) {
        String firstname = request.getParameter("nameReq");
        String lastname = request.getParameter("lastNameReq");
        String startDateStr = request.getParameter("dateTimeReq");
        String departmentName = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startTimeStr = request.getParameter("startTimeEmp");
        String endTimeStr = request.getParameter("endTimeEmp");
        LocalTime startTime = LocalTime.parse(startTimeStr);
        LocalTime endTime = LocalTime.parse(endTimeStr);
        int departmentId = Integer.parseInt(request.getParameter("textReq"));
        String preferenceStr = request.getParameter("preferenceEmp");
        boolean preference = Boolean.parseBoolean(preferenceStr);
        try {
            Date birthDate = sdf.parse(startDateStr);
            java.sql.Date birthDateSql = new java.sql.Date(birthDate.getTime());
            Employee employee = new Employee(firstname, lastname, birthDateSql, departmentId, departmentName, startTime, endTime, preference);
            EmployeeDAO employeeDAO = new EmployeeDAO();
            employeeDAO.addEmployee(employee);
            response.sendRedirect(request.getContextPath() + "/mainPage");
        } catch (ParseException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void changeScheduleEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("chooseEmpNameInChangeMenu"));
        LocalTime newStartTime = LocalTime.parse(request.getParameter("changeStartTimeEmpReq"));
        LocalTime newEndTime = LocalTime.parse(request.getParameter("changeEndTimeEmpReq"));
        String preferenceStr = request.getParameter("preferenceEmp1");
        boolean preference = Boolean.parseBoolean(preferenceStr);
        try {
            Employee employee = new Employee(id, newStartTime, newEndTime, preference);
            EmployeeDAO employeeDAO = new EmployeeDAO();
            employeeDAO.changeScheduleEmployee(employee);
            response.sendRedirect(request.getContextPath() + "/mainPage");
        } catch (SQLException | IOException exception) {
            exception.printStackTrace();
        }
    }

    public void init(HttpServletRequest request, HttpServletResponse response) {
        employeeBeanStart(request, response);
        int percentPreference = new CompanyDAO().getPercentPreference();

    }

    public void getCompanyEarning() {
        int percentPreference = new CompanyDAO().getPercentPreference();
        Company company = new Company(percentPreference, );
        if
    }

    public void employeeBeanStart(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = new EmployeeDAO().findAll();
        request.setAttribute("empbean", new EmployeeBean(employees));
    }

    public void destroy() {
    }
}