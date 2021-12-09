package com.example.company.data;

import java.sql.Date;
import java.time.LocalTime;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private int departmentId;
    private String departmentName;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean preference;

    public Employee(int id, String firstName, String lastName, Date dateOfBirth, int departmentId, String departmentName, LocalTime startTime, LocalTime endTime, boolean preference) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.preference = preference;
    }

    public Employee(String firstName, String lastName, Date dateOfBirth, int departmentId, String departmentName, LocalTime startTime, LocalTime endTime, boolean preference) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.preference = preference;
    }

    public Employee(int id, LocalTime startTime, LocalTime endTime, boolean preference) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.preference = preference;
    }

    public Employee() {

    }

    public boolean isPreference() {
        return preference;
    }

    public void setPreference(boolean preference) {
        this.preference = preference;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

}
