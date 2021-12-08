package com.example.company.departmentServlet;
import com.example.company.beans.DepartmentBean;
import com.example.company.beans.EmployeeBean;
import com.example.company.dao.DepartmentDAO;
import com.example.company.dao.EmployeeDAO;
import com.example.company.data.Department;
import com.example.company.data.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.List;

@WebServlet(name = "departmentServlet", value = {"/addDepartment", "/showDepartment", "/mainPage"})
public class DepartmentServlet extends HttpServlet {
    private String message;

    public void init(HttpServletRequest request, HttpServletResponse response) {
        beansStart(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getRequestURI().contains("mainPage")) {
            init(request, response);
            request.getRequestDispatcher("/mainPage.jsp").forward(request, response);
        }
        if (request.getRequestURI().contains("showDepartment")) {
            List<Department> departments = new DepartmentDAO().findAll();
            request.setAttribute("depbean", new DepartmentBean(departments));
            request.getRequestDispatcher("/department.jsp").forward(request, response);
//            showDepartment(departments, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().contains("addDepartment")) {
            try {
                addDepartment(request, response);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //response.sendRedirect(request.getContextPath() + "/mainPage");
        }
    }

    private void beansStart(HttpServletRequest request, HttpServletResponse response) {
        List<Department> departments = new DepartmentDAO().findAll();
        request.setAttribute("depbean", new DepartmentBean(departments));
        List<Employee> employees = new EmployeeDAO().findAll();
        request.setAttribute("empbean", new EmployeeBean(employees));
    }

    private void addDepartment(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        int id = 0;
        String name = request.getParameter("nameDepReq");
        String startTime = request.getParameter("startTimeReq");
        String endTime = request.getParameter("endTimeReq");
        LocalTime startTimeReq = LocalTime.parse(startTime);
        LocalTime endTimeReq = LocalTime.parse(endTime);
        int floor = Integer.parseInt(request.getParameter("floorDepReq"));
        try {
            Department department = new Department(id, name, startTimeReq, endTimeReq, floor);
            DepartmentDAO departmentDAO = new DepartmentDAO();
            departmentDAO.addDepartment(department);
            response.sendRedirect(request.getContextPath() + "/mainPage");
        } catch (SQLException | IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void showDepartment(List<Department> departments, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.writeValue(writer, departments);
    }

    public void destroy() {
    }
}