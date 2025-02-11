package com.demo.spring.newservice;
import com.demo.spring.model.UnifiedBookingData;
import com.demo.spring.repository.UnifiedBookingDataRepository;
import com.google.gson.Gson;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UnifiedBookingDataService {

    @Autowired
    private UnifiedBookingDataRepository unifiedBookingDataRepository;

    @Autowired
    private HudiService hudiService;

    @Autowired
    private HdfsService hdfsService;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Autowired
    private PrestoQueryService prestoQueryService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UnifiedBookingDataService.class);

    public void insertCombinedBookingData() {

        try {

            List<UnifiedBookingData> results = unifiedBookingDataRepository.fetchCombinedBookingData();

            if (results == null || results.isEmpty()) {
                LOGGER.warn("No data found to process.");
                return;
            }

            LOGGER.info("Number of records to process: {}", results.size());

            // Save to Database
            unifiedBookingDataRepository.saveAll(results);
            LOGGER.info("Data successfully saved to the database.");

            // Publish to Kafka
            results.forEach(record -> {
                try {
                    String kafkaMessage = formatRecordForKafka(record);
                    kafkaProducerService.sendMessage(record.getBookingId(), kafkaMessage);
                    LOGGER.info("Record successfully sent to Kafka: {}", record.getBookingId());
                } catch (Exception kafkaException) {
                    LOGGER.error("Failed to send record to Kafka: {}", record.getBookingId(), kafkaException);
                }
            });
            // Write data to Hudi
            Dataset<Row> unifiedBookingDataFrame = hudiService.prepareDataForHudi(results);
            hudiService.writeToHudi(unifiedBookingDataFrame);
            LOGGER.info("Data successfully written to Hudi.");

            // Write data to HDFS
            String hdfsFilePath = "/opt/homebrew/opt/hadoop";
            String formattedContent = formatDataForHDFS(results);
            hdfsService.writeToHdfs(hdfsFilePath, formattedContent);
            LOGGER.info("Data successfully written to HDFS at {}", hdfsFilePath);

        } catch (Exception e) {
            LOGGER.error("Error processing booking data: ", e);
        }
    }
    // Format data for HDFS
    private String formatDataForHDFS(List<UnifiedBookingData> results) {
        Gson gson = new Gson();
        return gson.toJson(results);
    }

    // Format individual record for Kafka
    private String formatRecordForKafka(UnifiedBookingData record) {
        Gson gson = new Gson();
        return gson.toJson(record);
    }
}
