/*
package com.demo.spring.newservice.impl;

import com.demo.spring.newservice.QueryService;
import com.demo.spring.validator.QueryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class QueryServiceImpl implements QueryService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private QueryValidator queryValidator;

    @Autowired
    public QueryServiceImpl(DataSource drillDataSource) {
        this.jdbcTemplate = new JdbcTemplate(drillDataSource);
    }

    @Override
    public List<Map<String, Object>> executeQuery(String query) {
        if (!queryValidator.isValidQuery(query)) {
            throw new RuntimeException("Unauthorized query");
        }
        return jdbcTemplate.queryForList(query);
    }

    @Override
    public List<Map<String, Object>> executeQuery(String tableName, String bookingId) {
        return Collections.emptyList();
    }
}
*/


/*
package com.demo.spring.newservice.impl;

import com.demo.spring.newservice.QueryService;
import com.demo.spring.validator.QueryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Service
public class QueryServiceImpl implements QueryService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private QueryValidator queryValidator;

    @Autowired
    public QueryServiceImpl(DataSource drillDataSource) {
        this.jdbcTemplate = new JdbcTemplate(drillDataSource);
    }

    @Override
    public List<Map<String, Object>> executeQuery(String query) {
        if (!queryValidator.isValidQuery(query)) {
            throw new RuntimeException("Unauthorized query");
        }
        return jdbcTemplate.queryForList(query);
    }

    @Override
    public List<Map<String, Object>> executeQuery(String tableName, String bookingId) {
        String query = "SELECT * FROM " + tableName + " WHERE bookingId = ?";
        return jdbcTemplate.queryForList(query, bookingId);
    }
}
*/


package com.demo.spring.newservice.impl;

import com.demo.spring.newservice.DrillJdbcService;
import com.demo.spring.newservice.QueryService;
import com.demo.spring.validator.QueryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Service
public class QueryServiceImpl implements QueryService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private QueryValidator queryValidator;

    @Autowired
    private DrillJdbcService drillJdbcService;

    @Autowired
    public QueryServiceImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public String executeQuery(String query) {
        if (!queryValidator.isValidQuery(query)) {
            throw new RuntimeException("Unauthorized query");
        }
        // Check if query is for Drill or MySQL
        if (query.toLowerCase().contains("hudi") || query.toLowerCase().contains("dfs")) {
            // Send to Drill
            return drillJdbcService.executeQuery(query);
        } else {
            // Send to MySQL
            return jdbcTemplate.queryForList(query).toString();
        }
    }

    @Override
    public List<Map<String, Object>> executeQuery(String tableName, String bookingId) {
        String query = "SELECT * FROM dfs.hudi.`" + tableName + "` WHERE CAST(booking_id AS VARCHAR) = '" + bookingId + "'";
        return jdbcTemplate.queryForList(query, bookingId);
    }

}
