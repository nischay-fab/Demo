package com.demo.spring.controller;
import com.demo.spring.newservice.CsvHdfs;
import com.demo.spring.newservice.HdfsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hdfs")

public class HdfsController {

    private static final String HADOOP_PATH = "/opt/homebrew/opt/hadoop";

    @Value("${hadoop.home.dir}")
    String hadoopHomePath;
    @Autowired
    private HdfsService hdfsService;

    @PostMapping("/write")
    public String writeToHdfs(@RequestBody String content) {
        hdfsService.writeToHdfs(HADOOP_PATH, content);
        return "Data written to HDFS successfully!";

    }
}
