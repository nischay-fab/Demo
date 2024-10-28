package com.demo.spring.newservice;

public interface HdfsService {
    void writeToHdfs(String path, String content);
}
