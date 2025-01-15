package com.demo.spring.newservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "booking_updates", groupId = "booking_group")
    public void consumeMessage(String message) {
        System.out.println("Consumed message: " + message);
    }
}

