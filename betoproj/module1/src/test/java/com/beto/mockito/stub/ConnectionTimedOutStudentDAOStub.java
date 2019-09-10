package com.beto.mockito.stub;

import com.beto.mockito.StudentDAO;

import java.sql.SQLException;

public class ConnectionTimedOutStudentDAOStub implements StudentDAO {
    public String create(String name, String className) throws SQLException {
        throw new SQLException("DB connection timed out");
    }
}
