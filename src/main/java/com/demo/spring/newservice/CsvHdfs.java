package com.demo.spring.newservice;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;

@Service
public class CsvHdfs {

    private final FileSystem hdfs;

    public CsvHdfs(FileSystem hdfs) {
        this.hdfs = hdfs;
    }

    public void writeToHdfs(String filePath, String content) throws IOException {
        Path path = new Path(filePath);
        try (OutputStream outputStream = hdfs.create(path)) {
            outputStream.write(content.getBytes());
            System.out.println("Data written to HDFS at: " + filePath);
        }
    }
}
