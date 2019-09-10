package com.beto.mockito;

import java.sql.SQLException;

public interface StudentDAO {
    public String create(String name, String className)
            throws SQLException;
}
