package com.demo.spring.controller;


import com.demo.spring.newservice.HudiToMySQLService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsvHudiController {

    private final HudiToMySQLService hudiToMySQLService;

    public CsvHudiController(HudiToMySQLService hudiToMySQLService) {
        this.hudiToMySQLService = hudiToMySQLService;
    }

    @GetMapping("/exportHudiToMySQL")
    public String exportHudiToMySQL(@RequestParam String hudiTableName, @RequestParam String mysqlTableName) {
        hudiToMySQLService.exportHudiToMySQL(hudiTableName, mysqlTableName);
        return "Export initiated for Hudi table '" + hudiTableName + "' to MySQL table '" + mysqlTableName + "'.";
    }
}







/*
@RestController
@RequestMapping("/hudi")
public class CsvHudiController {

    @Autowired
    private CsvHudi csvHudi;

    @PostMapping("/write")
    public String writeToHudi(@RequestParam String filePath) {
        try {
            csvHudi.processCsvToHudi(filePath);
            return "Data successfully written to Hudi!";
        } catch (Exception e) {
            return "Error writing to Hudi: " + e.getMessage();
        }
    }

    @GetMapping("/read")
    public String readFromHudi() {
        try {
            Dataset<Row> data = csvHudi.readFromHudi();
            return data.showString(10, 0, false);
        } catch (Exception e) {
            return "Error reading from Hudi: " + e.getMessage();
        }
    }
}
*/
