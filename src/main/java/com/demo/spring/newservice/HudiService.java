package com.demo.spring.newservice;

import com.demo.spring.model.UnifiedBookingData;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import java.util.List;

public interface HudiService {

    /**
     * Write data to Hudi
     * @param data - The data to be written to Hudi
     */
    void writeToHudi(Dataset<Row> data);

    /**
     * Convert list of DataProjectionDto to a Dataset<Row> for writing to Hudi
     * @param results - The list of DataProjectionDto objects to be converted
     * @return Dataset<Row> - The Spark Dataset containing the data
     */
    Dataset<Row> prepareDataForHudi(List<UnifiedBookingData> results);
}
