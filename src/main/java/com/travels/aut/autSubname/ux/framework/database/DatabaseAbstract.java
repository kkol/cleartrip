package com.travels.aut.autSubname.ux.framework.database;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

@Getter
@Setter
public abstract class DatabaseAbstract {
    private Connection connection = null;

    public Connection getConnection(String jdbcDriver, String userName, String password) {
        try {
            connection = DriverManager.getConnection(jdbcDriver, userName, password);
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return connection;
    }

    public abstract HashMap<String, String> select(String query, List<String> columns);

    public abstract void update(String query);


}