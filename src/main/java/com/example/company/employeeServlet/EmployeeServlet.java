package com.example.company.employeeServlet;

import com.example.company.beans.EmployeeBean;
import com.example.company.dao.EmployeeDAO;
import com.example.company.data.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@WebServlet(name = "employeeServlet", value = { "/addEmployee", "/showEmployee" })
public class EmployeeServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
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
        try {
            Date birthDate = sdf.parse(startDateStr);
            java.sql.Date birthDateSql = new java.sql.Date(birthDate.getTime());
            Employee employee = new Employee(firstname, lastname, birthDateSql, departmentId, departmentName, startTime, endTime);
            EmployeeDAO employeeDAO = new EmployeeDAO();
            employeeDAO.addEmployee(employee);
            response.sendRedirect(request.getContextPath() + "/mainPage");
        } catch (ParseException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEmployee(List<Employee> employees, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, employees);
    }

    public void destroy() {
    }
}