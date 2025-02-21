package com.demo.spring.controller;

import com.demo.spring.newservice.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/query")
public class QueryController {

    @Autowired
    private QueryService queryService;

    // Endpoint for executing dynamic query based on tableName and bookingId
    @PostMapping("/fetchData")
    public ResponseEntity<?> fetchData(@RequestBody Map<String, String> requestData) {
        String tableName = requestData.get("tableName");
        String bookingId = requestData.get("bookingId");

        // Construct the query dynamically based on table name and booking ID
        String query = "SELECT * FROM dfs.hudi.`" + tableName + "` WHERE bookingId = '" + bookingId + "' LIMIT 10";

        // Call query service to execute the query
        String result = queryService.executeQuery(query);

        // Return the result
        return ResponseEntity.ok(result);
    }
       // Endpoint for executing custom query
    @PostMapping("/execute")
    public ResponseEntity<?> executeQuery(@RequestBody Map<String, String> request) {
        String query = request.get("query");
        String result = queryService.executeQuery(query);
        return ResponseEntity.ok(result);
    }
}


/*
package com.demo.spring.controller;

import com.demo.spring.newservice.QueryService;
import com.demo.spring.validator.QueryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/query")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @PostMapping("/table")
    public ResponseEntity<?> getByTableAndBookingId(@RequestBody Map<String, String> request) {
        String tableName = request.get("tableName");
        String bookingId = request.get("bookingId");
        List<Map<String, Object>> result = queryService.executeQuery(tableName, bookingId);
        return ResponseEntity.ok(result);
    }
}
*/
