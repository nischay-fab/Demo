package com.demo.spring.newservice.impl;

import com.demo.spring.model.UnifiedBookingData;
import com.demo.spring.newservice.HudiService;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HudiServiceImpl implements HudiService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HudiServiceImpl.class);

    @Autowired
    private SparkSession sparkSession;

    private static final String HUDI_BASE_PATH = "file:///tmp/hudi/unified_booking_data";

    @Override
    public void writeToHudi(Dataset<Row> data) {
        if (data == null || data.isEmpty()) {
            LOGGER.error("Data to write is null or empty.");
            throw new IllegalArgumentException("Cannot write null or empty data.");
        }

        Map<String, String> hudiOptions = new HashMap<>();
        hudiOptions.put("hoodie.table.name", "unified_booking_data");
        hudiOptions.put("hoodie.datasource.write.recordkey.field", "bookingId");
        hudiOptions.put("hoodie.datasource.write.precombine.field", "checkin");
        hudiOptions.put("hoodie.datasource.write.partitionpath.field", "checkout");
        hudiOptions.put("hoodie.datasource.write.keygenerator.class", "org.apache.hudi.keygen.SimpleKeyGenerator");
        hudiOptions.put("hoodie.datasource.write.operation", "upsert");
        hudiOptions.put("hoodie.datasource.write.schema.allow.auto.evolution", "true");
        hudiOptions.put("hoodie.embed.timeline.server", "false");

        try {
            LOGGER.info("Writing data to Hudi with row count: {}", data.count());
            data.write()
                    .format("org.apache.hudi")
                    .options(hudiOptions)
                    .mode(SaveMode.Overwrite)
                    .save(HUDI_BASE_PATH);

            LOGGER.info("Data successfully written to Hudi at {}", HUDI_BASE_PATH);
        } catch (Exception e) {
            LOGGER.error("Error writing to Hudi", e);
            throw new RuntimeException("Failed to write data to Hudi.", e);
        }
    }

    @Override
    public Dataset<Row> prepareDataForHudi(List<UnifiedBookingData> results) {
        if (results == null || results.isEmpty()) {
            LOGGER.error("The input list is null or empty.");
            throw new IllegalArgumentException("The input list is null or empty.");
        }

        try {
            Dataset<Row> dataset = sparkSession.createDataFrame(results, UnifiedBookingData.class);
            dataset.printSchema();
            LOGGER.info("Dataset row count: {}", dataset.count());
            dataset.show(100, false);
            dataset.cache();
            return dataset;
        } catch (Exception e) {
            LOGGER.error("Error preparing data for Hudi", e);
            throw new RuntimeException("Failed to prepare data for Hudi.", e);
        }
    }
}
