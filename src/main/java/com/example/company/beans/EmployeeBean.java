package com.example.company.beans;

import com.example.company.data.Employee;

import java.util.List;

public class EmployeeBean {
    private List<Employee> employees;

    public EmployeeBean(List<Employee> employees) {
        this.employees = employees;
    }

    public EmployeeBean() {
    }

    public int getSize() {
        return employees.size();
    }

    public void setEmployee(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
