package com.demo.spring.newservice;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Service
public class DrillJdbcService {

    private static final String DRILL_JDBC_URL = "jdbc:drill:drillbit=localhost";

    public String executeQuery(String query) {
        StringBuilder result = new StringBuilder();

        try (Connection connection = DriverManager.getConnection(DRILL_JDBC_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            int columnCount = resultSet.getMetaData().getColumnCount();

            // Fetch column names
            for (int i = 1; i <= columnCount; i++) {
                result.append(resultSet.getMetaData().getColumnName(i)).append("\t");
            }
            result.append("\n");

            // Fetch rows
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    result.append(resultSet.getString(i)).append("\t");
                }
                result.append("\n");
            }
        } catch (Exception e) {
            return "Error executing query: " + e.getMessage();
        }

        return result.toString();
    }
}




