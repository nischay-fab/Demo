package com.demo.spring.newservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CsvConsumer {

    @KafkaListener(topics = "booking_csv_topic", groupId = "booking_group")
    public void consumeMessage(String message) {
        System.out.println("Consumed message: " + message);
    }
}
