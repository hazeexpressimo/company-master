package com.example.company.beans;

import com.example.company.data.Department;

import java.util.List;

public class DepartmentBean {
    private List<Department> departments;

    public DepartmentBean(List<Department> departments) {
        this.departments = departments;
    }

    public DepartmentBean() {
    }

    public int getSize() {
        return departments.size();
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Department> getDepartments() {
        return departments;
    }
}
