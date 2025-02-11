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
