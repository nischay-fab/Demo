package com.demo.spring.controller;
import com.demo.spring.newservice.PrestoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/presto")
public class PrestoController {

    @Autowired
    private PrestoQueryService prestoQueryService;

    @GetMapping("/execute")
    public List<Map<String, Object>> executeQuery(@RequestParam String query) {
        return prestoQueryService.executeQuery(query);
    }

    @GetMapping("/tables")
    public List<Map<String, Object>> getTables(@RequestParam String schema) {
        String query = "SHOW TABLES IN " + schema;
        return prestoQueryService.executeQuery(query);
    }

    @GetMapping("/databases")
    public List<Map<String, Object>> getDatabases() {
        String query = "SHOW SCHEMAS";
        return prestoQueryService.executeQuery(query);
    }
}
