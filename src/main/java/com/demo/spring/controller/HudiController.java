package com.demo.spring.controller;

import com.demo.spring.newservice.UnifiedBookingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/hudi")
public class HudiController {

    @Autowired
    private UnifiedBookingDataService unifiedBookingDataService;

    // Method to confirm the controller is loaded
    @PostConstruct
    public void init() {
        System.out.println("HudiController loaded successfully!");
    }


    @GetMapping("/write-booking-data")
    public String writeBookingDataToHudi() {
        try {
            // Call the service method to write data into Hudi
            unifiedBookingDataService.insertCombinedBookingData();
            return "Booking data successfully written to Hudi!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error while writing data to Hudi: " + e.getMessage();
        }
    }

    @GetMapping("/test")
    public String testController() {
        return "HudiController is up and running!";
    }
}

