package com.demo.spring.config;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class HdfsConfig {

    @Bean
    public FileSystem hdfsFileSystem() throws IOException {
        org.apache.hadoop.conf.Configuration hadoopConfig = new org.apache.hadoop.conf.Configuration();
        hadoopConfig.set("fs.defaultFS", "hdfs://localhost:9000");
        return FileSystem.get(hadoopConfig);
    }
}

