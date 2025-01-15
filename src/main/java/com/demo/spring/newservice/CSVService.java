package com.demo.spring.newservice;

import com.demo.spring.dto.BookingData;
import com.demo.spring.newservice.CsvProducer;
import com.demo.spring.newservice.CsvHdfs;
import com.google.gson.Gson;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVService {

    @Autowired
    private CsvProducer csvProducer;

    @Autowired
    private CsvHdfs csvHdfs;

    @Autowired
    private CsvHudi csvHudi;

    @Value("${hdfs.base.path}") // HDFS path configured in application.properties
    private String hdfsBasePath;

    public void processCsvData(String filePath) throws IOException {
        List<BookingData> bookingDataList = readCsvData(filePath);

        if (bookingDataList.isEmpty()) {
            System.out.println("No data found in the CSV file.");
            return;
        }

        sendToKafka(bookingDataList); // Send to Kafka

        // Write to Hudi and HDFS
        writeToHudi(filePath);
        writeToHdfs(bookingDataList);
    }

    public List<BookingData> readCsvData(String filePath) throws IOException {
        List<BookingData> bookingDataList = new ArrayList<>();

        try (FileReader reader = new FileReader(filePath)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withHeader()
                    .withSkipHeaderRecord()
                    .parse(reader);

            for (CSVRecord record : records) {
                validateHeaders(record);

                BookingData data = new BookingData();
                data.setId(Long.parseLong(record.get("id")));
                data.setBookingId(record.get("booking_id"));
                data.setUuid(record.get("uuid"));
                data.setCheckin(Long.parseLong(record.get("checkin")));
                data.setCheckout(Long.parseLong(record.get("checkout")));
                data.setGrandTotal(Double.parseDouble(record.get("grand_total")));
                data.setCorporateId(record.get("corporate_id"));
                data.setComparisonPrice(Double.parseDouble(record.get("comparison_price")));
                data.setLocalCurrency(record.get("local_currency"));
                data.setLocalCurrencyAmount(Double.parseDouble(record.get("local_currency_amount")));
                data.setNoShowReason(record.get("no_show_reason"));
                data.setTravellerName(record.get("traveller_name"));

                bookingDataList.add(data);
            }
        }

        return bookingDataList;
    }

    private void validateHeaders(CSVRecord record) {
        if (!record.isMapped("id") || !record.isMapped("booking_id")) {
            throw new IllegalArgumentException("Missing required headers in the CSV file");
        }
    }

    private void sendToKafka(List<BookingData> bookingDataList) {
        bookingDataList.forEach(data -> {
            String message = new Gson().toJson(data);
            csvProducer.sendMessage(data.getId().toString(), message);
        });
    }

    private void writeToHudi(String filePath) {
        try {
            csvHudi.processCsvToHudi(filePath);
        } catch (Exception e) {
            System.err.println("Error writing to Hudi: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void writeToHdfs(List<BookingData> bookingDataList) throws IOException {
        String content = new Gson().toJson(bookingDataList);
        String hdfsFilePath = hdfsBasePath + "/csv_data.json";

        csvHdfs.writeToHdfs(hdfsFilePath, content);
        System.out.println("CSV data written to HDFS at: " + hdfsFilePath);
    }
}
