package com.demo.spring.newservice;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HudiToMySQLService {

    @Value("${hudi.base.path}")
    private String hudiBasePath;

    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    private final SparkSession sparkSession;

    public HudiToMySQLService(SparkSession sparkSession) {
        this.sparkSession = sparkSession;
    }

    public void exportHudiToMySQL(String hudiTableName, String mysqlTableName) {
        String hudiTablePath = hudiBasePath + "/" + hudiTableName;

        try {
            // Read Hudi data
            Dataset<Row> hudiData = sparkSession.read()
                    .format("hudi")
                    .load(hudiTablePath);

            // Optionally, remove system columns or handle missing ones
            Dataset<Row> processedData = hudiData.drop("_hoodie_commit_time")
                    .drop("_hoodie_record_key")
                    .drop("_hoodie_partition_path");


            // Write to MySQL
            processedData.write()
                    .format("jdbc")
                    .option("url", "jdbc:mysql://localhost:3306/Presto")  // MySQL JDBC URL
                    .option("dbtable", "unified_booking_data")
                    .option("user", "nischaysinghintech")  // MySQL username
                    .option("password", "Nischay@2003")  // MySQL password
                    .mode(SaveMode.Overwrite)  // Append data to the table
                    .save();

            System.out.println("Data exported successfully from Hudi to MySQL table: " + mysqlTableName);
        } catch (Exception e) {
            System.err.println("Error during export: " + e.getMessage());
            e.printStackTrace();
        }
    }
}