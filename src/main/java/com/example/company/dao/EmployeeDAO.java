package com.example.company.dao;

import com.example.company.data.Employee;
import com.example.company.dbConnection.ConnectionManager;
import com.example.company.dbConnection.SqlRequest;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class EmployeeDAO {

    public List<Employee> findAll() {
        Connection connection = ConnectionManager.getInstance().getConnection();
        List<Employee> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SqlRequest.FIND_ALL_EMPLOYEE);
            while (rs.next()) {
                int employeeId = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                Date dateOfBirth = rs.getDate("birthdate");
                int departmentId = rs.getInt("department_id");
                String departmentName = rs.getString("department");
                LocalTime startTime = LocalTime.parse(rs.getString("start_time"));
                LocalTime endTime = LocalTime.parse(rs.getString("end_time"));
                boolean preference = rs.getBoolean("preference");
                Employee employee = new Employee(employeeId, firstname, lastname, dateOfBirth, departmentId, departmentName, startTime, endTime, preference);
                result.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public void addEmployee(Employee employee) throws SQLException {
        Connection connection = ConnectionManager.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlRequest.ADD_EMPLOYEE);
        preparedStatement.setString(1, employee.getFirstName());
        preparedStatement.setString(2, employee.getLastName());
        preparedStatement.setDate(3, employee.getDateOfBirth());
        preparedStatement.setInt(4, employee.getDepartmentId());
        preparedStatement.setTime(5, Time.valueOf(employee.getStartTime()));
        preparedStatement.setTime(6, Time.valueOf(employee.getEndTime()));
        preparedStatement.setBoolean(7, employee.isPreference());
        preparedStatement.executeUpdate();
    }

    public void changeScheduleEmployee(Employee employee) throws SQLException {
        Connection connection = ConnectionManager.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlRequest.CHANGE_SCHEDULE_EMPLOYEE);
        preparedStatement.setTime(1, Time.valueOf(employee.getStartTime()));
        preparedStatement.setTime(2, Time.valueOf(employee.getEndTime()));
        preparedStatement.setBoolean(3, employee.isPreference());
        preparedStatement.setInt(4, employee.getId());
        preparedStatement.executeUpdate();
    }
}
