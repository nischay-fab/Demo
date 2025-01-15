package com.demo.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;

@Configuration
public class PrestoConfig {

    @Bean(name = "prestoJdbcTemplate")
    public JdbcTemplate prestoJdbcTemplate() {
        try {
            // Configure DataSource for Presto
            DataSource dataSource = DataSourceBuilder.create()
                    .driverClassName("com.facebook.presto.jdbc.PrestoDriver")
                    .url("jdbc:presto://localhost:8080/hudi")
                    .username("presto")
                    .build();

            return new JdbcTemplate(dataSource);
        } catch (Exception e) {
            throw new RuntimeException("Failed to configure Presto JDBC Template: " + e.getMessage(), e);
        }
    }
}