package com.example.company.dao;

import com.example.company.dbConnection.ConnectionManager;
import com.example.company.dbConnection.SqlRequest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CompanyDAO {

    public int getCompanyPreference() {
        int deltaPref = 0;
        Connection connection = ConnectionManager.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SqlRequest.GET_PREFERENCE_EMPLOYEES);
            while (rs.next()) {
                boolean preference = rs.getBoolean("preference");
                if (preference) {
                    deltaPref++;
                } else {
                    deltaPref--;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return deltaPref;
    }
}
