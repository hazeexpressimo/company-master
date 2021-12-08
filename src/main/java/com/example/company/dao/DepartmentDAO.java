package com.example.company.dao;

import com.example.company.data.Department;
import com.example.company.dbConnection.ConnectionManager;
import com.example.company.dbConnection.SqlRequest;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    public Date convertDate(java.util.Date date) throws ParseException {
        java.util.Date formattedDate = new SimpleDateFormat("HH:mm").parse(String.valueOf(date));
        return new Date(formattedDate.getTime());
    }

    public List<Department> findAll() {
        Connection connection = ConnectionManager.getInstance().getConnection();
        List<Department> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SqlRequest.FIND_ALL_DEPARTMENTS);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                LocalTime startTime = LocalTime.parse(rs.getString("startTime"));
                LocalTime endTime = LocalTime.parse(rs.getString("endTime"));
                int floor = rs.getInt("floor");
                Department department = new Department(id, name, startTime, endTime, floor);
                result.add(department);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public void addDepartment(Department department) throws SQLException, ParseException {
        Connection connection = ConnectionManager.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlRequest.ADD_DEPARTMENT);
        preparedStatement.setString(1, department.getName());
        preparedStatement.setTime(2, Time.valueOf(department.getStartTime()));
        preparedStatement.setTime(3, Time.valueOf(department.getEndTime()));
        preparedStatement.setInt(4, department.getFloor());
        preparedStatement.executeUpdate();
    }
}
