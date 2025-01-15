/*
package com.demo.spring.newservice;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Service
public class CsvHudi {

    private static final Logger logger = LoggerFactory.getLogger(CsvHudi.class);

    private final SparkSession sparkSession;

    @Value("${hudi.base.path}")
    private String basePath;

    @Value("${hudi.table.name}")
    private String tableName;

    public CsvHudi(SparkSession sparkSession) {
        this.sparkSession = sparkSession;
    }

    public void processCsvToHudi(String filePath) {
        try {
            Dataset<Row> csvData = sparkSession.read()
                    .format("csv")
                    .option("header", "true")
                    .option("inferSchema", "true")
                    .load(filePath);

            Map<String, String> hudiOptions = new HashMap<>();
            hudiOptions.put("hoodie.datasource.write.recordkey.field", "id");
            hudiOptions.put("hoodie.datasource.write.precombine.field", "grand_total");
            hudiOptions.put("hoodie.datasource.write.partitionpath.field", "corporate_id");
            hudiOptions.put("hoodie.datasource.write.table.type", "MERGE_ON_READ");
            hudiOptions.put("hoodie.table.name", tableName);

            csvData.write()
                    .format("hudi")
                    .options(hudiOptions)
                    .mode(SaveMode.Overwrite)
                    .save(basePath);

            logger.info("CSV data written to Hudi table successfully!");
        } catch (Exception e) {
            logger.error("Error processing CSV file for Hudi", e);
        }
    }

    public Dataset<Row> readFromHudi() {
        return sparkSession.read()
                .format("hudi")
                .load(basePath + "/*");
    }
}
*/



package com.demo.spring.newservice;
import org.apache.spark.sql.*;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class CsvHudi {

    private static final String TABLE_NAME = "booking_data_hudi";
    private static final String BASE_PATH = "file:///tmp/hudi/booking_data_hudi";

    private final SparkSession sparkSession;

    public CsvHudi() {
        this.sparkSession = SparkSession.builder()
                .appName("HudiService")
                .config("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
                .master("local[*]")
                .getOrCreate();
    }

    public void processCsvToHudi(String filePath) {
        try {
            // Read CSV data
            Dataset<Row> csvData = sparkSession.read()
                    .format("csv")
                    .option("header", "true")
                    .option("inferSchema", "true")
                    .load(filePath);

            // Prepare Hudi options
            Map<String, String> hudiOptions = new HashMap<>();
            hudiOptions.put("hoodie.datasource.write.recordkey.field", "id");
            hudiOptions.put("hoodie.datasource.write.precombine.field", "grand_total");
            hudiOptions.put("hoodie.datasource.write.partitionpath.field", "corporate_id");
            hudiOptions.put("hoodie.datasource.write.table.type", "COPY_ON_WRITE");
            hudiOptions.put("hoodie.table.name", TABLE_NAME);

            csvData.write()
                    .format("hudi")
                    .options(hudiOptions)
                    .mode(SaveMode.Overwrite)
                    .save(BASE_PATH);

            System.out.println("CSV data written to Hudi table successfully!");
        } catch (Exception e) {
            System.err.println("Error processing CSV file for Hudi: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Dataset<Row> readFromHudi() {
        return sparkSession.read()
                .format("hudi")
                .load(BASE_PATH + "/*");
    }
}
