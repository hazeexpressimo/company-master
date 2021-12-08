package com.example.company.dbConnection;

public class SqlRequest {
    public static final String FIND_ALL_EMPLOYEE = "SELECT DISTINCT ON(firstname) firstname,\n" +
            "       lastname,\n" +
            "       birthdate,\n" +
            "       \"departmentId\",\n" +
            "       employee.\"startTime\",\n" +
            "       employee.\"endTime\",\n" +
            "       department.name as department\n" +
            "from department,\n" +
            "     employee\n" +
            "         inner join department d on employee.\"departmentId\" = d.id";
    public static String ADD_EMPLOYEE = "INSERT into employee (firstname, lastname, birthdate, \"departmentId\", \"startTime\", \"endTime\") values (?, ?, ?, ?, ?, ?)";

    public static final String FIND_ALL_DEPARTMENTS = "SELECT id, name, \"startTime\", \"endTime\", floor from department";
    public static String ADD_DEPARTMENT = "INSERT into department (name, \"startTime\", \"endTime\", floor) values (?, ?, ?, ?)";

}
