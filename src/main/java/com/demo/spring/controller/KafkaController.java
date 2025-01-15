/*
package com.demo.spring.controller;

import com.demo.spring.newservice.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducerService producerService;

    @PostMapping("/publish")
    public String sendMessage(@RequestParam("key") String key, @RequestParam("message") String message) {
        producerService.sendMessage(key, message);
        return "Message sent successfully!";
    }
}

*/
