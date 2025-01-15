package com.demo.spring.newservice.impl;
import com.demo.spring.newservice.HdfsService;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.stereotype.Service;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

@Service
public class HdfsServiceImpl implements HdfsService {

    @Override
    public void writeToHdfs(String path, String content) {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://localhost:9000"); // Set your HDFS URI
        FileSystem fileSystem = null;

        try {
            fileSystem = FileSystem.get(configuration);
            Path hdfsPath = new Path(path);
            if (!fileSystem.exists(hdfsPath)) {
                fileSystem.create(hdfsPath);
            }

            // Write content to HDFS
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileSystem.create(hdfsPath)))) {
                writer.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileSystem != null) {
                    fileSystem.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
