package com.demo.spring.config;

import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SparkConfig {

    @Value("${hadoop.home.dir}")
    private String hadoopHomePath;

    @Value("${hudi.base.path}")
    private String hudiBasePath;

    @Bean
    public SparkSession sparkSession() {
        System.setProperty("hadoop.home.dir", hadoopHomePath);
        System.setProperty("hudi.base.path", hudiBasePath);

        return SparkSession.builder()
                .appName("UnifiedBookingDataApp")
                .master("local[*]")
                .config("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
                .getOrCreate();
    }
}
