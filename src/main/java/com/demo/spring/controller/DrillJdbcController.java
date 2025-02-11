package com.demo.spring.controller;

import com.demo.spring.newservice.DrillJdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class DrillJdbcController {

    @Autowired
    private DrillJdbcService drillJdbcService;

    @PostMapping("/drill/jdbc/query")
    public String executeDrillQuery(@RequestBody Map<String, String> request) {
        // Extract the query from the request body
        String query = request.get("query");

        // Log the query to check what we received
        System.out.println("Received query: " + query);

        // Check if the query is null or empty and handle it accordingly
        if (query == null || query.trim().isEmpty()) {
            return "Error: Query parameter is missing or empty!";
        }

        // Call the DrillJdbcService to execute the query and return the result
        return drillJdbcService.executeQuery(query);
    }
}
