package com.travels.aut.autSubname.ux.framework.database;

import com.travels.aut.autSubname.ux.framework.utils.PropertiesReader;

import java.sql.*;
import java.util.HashMap;
import java.util.List;

public class Postgres extends DatabaseAbstract {
    private static final String JDBCDRIVER = PropertiesReader.getApplicationProperty().getProperty("postgres.url");
    private static final String USERNAME = PropertiesReader.getApplicationProperty().getProperty("postgres.name");
    private static final String PASSWORD = PropertiesReader.getApplicationProperty().getProperty("postgres.password");
    private Statement stmt;


    /**
     * select - returns map [columnName: value] depends of query
     * @param query
     * @param columns
     * @return
     */
    @Override
    public HashMap<String, String> select(String query, List<String> columns) {
        HashMap<String, String> map = new HashMap<>();
        try {
            stmt = getConnection(JDBCDRIVER, USERNAME, PASSWORD).createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                for (String s : columns) {
                    map.put(s, rs.getString(s));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return map;
    }

    /**
     * update - update database
     * @param query
     */
    @Override
    public void update(String query) {
        try{
            stmt = getConnection(JDBCDRIVER, USERNAME, PASSWORD).createStatement();
            stmt.executeUpdate(query);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}