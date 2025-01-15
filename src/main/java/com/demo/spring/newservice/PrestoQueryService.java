package com.demo.spring.newservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class PrestoQueryService {

    @Autowired
    private JdbcTemplate prestoJdbcTemplate;

    public List<Map<String, Object>> executeQuery(String query) {
        return prestoJdbcTemplate.queryForList(query);
    }
}
