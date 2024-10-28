package com.demo.spring.controller;
import com.demo.spring.newservice.HdfsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HdfsController {

    private static final String HADOOP_PATH = "/opt/homebrew/opt/hadoop";

    @Autowired
    private HdfsService hdfsService;

    // public HdfsController(HdfsService hdfsService) {
    //     this.hdfsService = hdfsService;
    // }

    @PostMapping("/hdfs/write")
    public String writeToHdfs(@RequestBody String content) {
        hdfsService.writeToHdfs(HADOOP_PATH, content);
        return "Data written to HDFS successfully!";

    }
}
