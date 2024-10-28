package com.demo.spring.controller;

import com.demo.spring.newservice.UnifiedBookingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UnifiedBookingDataController {

    @Autowired 
    private UnifiedBookingDataService unifiedBookingDataService;

    @GetMapping("/combined-booking-data")
    public String getCombinedBookingData() {
        unifiedBookingDataService.insertCombinedBookingData(); // This should now work
        return "Booking data inserted successfully!";
    }


/*
package com.demo.spring.controller;

import com.demo.spring.Service.UnifiedBookingDataService;
import com.demo.spring.model.BookingSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UnifiedBookingDataController {

    @Autowired
    private UnifiedBookingDataService unifiedBookingDataService;

    // Existing endpoint to insert combined booking data
    @GetMapping("/combined-booking-data")
    public String getCombinedBookingData() {
        unifiedBookingDataService.insertCombinedBookingData(); // This should now work
        return "Booking data inserted successfully!";
    }

    // NEW: CRUD Operations for BookingSummary

    // CREATE a new BookingSummary
    @PostMapping("/booking-summary")
    public BookingSummary createBookingSummary(@RequestBody BookingSummary bookingSummary) {
        return unifiedBookingDataService.createBookingSummary(bookingSummary);
    }

    // READ all BookingSummary records
    @GetMapping("/booking-summary")
    public List<BookingSummary> getAllBookingSummaries() {
        return unifiedBookingDataService.getAllBookingSummaries();
    }

    // READ a specific BookingSummary by ID
    @GetMapping("/booking-summary/{id}")
    public ResponseEntity<BookingSummary> getBookingSummaryById(@PathVariable Long id) {
        Optional<BookingSummary> bookingSummary = unifiedBookingDataService.getBookingSummaryById(id);
        return bookingSummary.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // UPDATE a BookingSummary by ID
    @PutMapping("/booking-summary/{id}")
    public BookingSummary updateBookingSummary(@PathVariable Long id, @RequestBody BookingSummary bookingSummary) {
        return unifiedBookingDataService.updateBookingSummary(id, bookingSummary);
    }

    // DELETE a BookingSummary by ID
    @DeleteMapping("/booking-summary/{id}")
    public ResponseEntity<?> deleteBookingSummary(@PathVariable Long id) {
        unifiedBookingDataService.deleteBookingSummary(id);
        return ResponseEntity.ok().build();
    }
}

*/

}

