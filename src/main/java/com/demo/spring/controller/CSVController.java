package com.demo.spring.controller;

import com.demo.spring.newservice.CsvHudi;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/csv-hudi")
public class CSVController {

    private final CsvHudi csvHudi;

    @Autowired
    public CSVController(CsvHudi csvHudi) {
        this.csvHudi = csvHudi;
    }

    // Endpoint to process a CSV file and write it to Hudi
    @PostMapping("/process")
    public String processCsvToHudi(@RequestParam("filePath") String filePath) {
        try {
            csvHudi.processCsvToHudi(filePath);
            return "CSV data successfully written to Hudi table!";
        } catch (Exception e) {
            return "Error processing CSV file: " + e.getMessage();
        }
    }

    // Endpoint to read data from Hudi
    @GetMapping("/read")
    public List<Row> readFromHudi() {
        try {
            Dataset<Row> hudiData = csvHudi.readFromHudi();
            return hudiData.collectAsList(); // Convert to List for response
        } catch (Exception e) {
            throw new RuntimeException("Error reading from Hudi: " + e.getMessage());
        }
    }
}

