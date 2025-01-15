package com.demo.spring.newservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
@Service
public class PrestoCsvService {
    private static final String PRESTO_JDBC_URL = "jdbc:presto://localhost:8080?SSL=true";
    private static final String USERNAME = "presto";
    private static final String PASSWORD = "1234";

    public List<Map<String, Object>> executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(PRESTO_JDBC_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                // Process each row of the result set
                System.out.println(resultSet.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error executing query in Presto", e);
        }
        return null;
    }
}

