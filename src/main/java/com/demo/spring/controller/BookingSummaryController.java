package com.demo.spring.controller;

import com.demo.spring.model.BookingSummary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingSummaryController {
//
//    private final BookingSummaryService bookingSummaryService;
//
//
//    public BookingSummaryController(BookingSummaryService bookingSummaryService) {
//        this.bookingSummaryService = bookingSummaryService;
//    }
//
//    @GetMapping
//    public List<BookingSummary> getAllBookingSummaries() {
//        return bookingSummaryService.getAllBookingSummaries();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<BookingSummary> getBookingSummaryById(@PathVariable Long id) {
//        BookingSummary bookingSummary = bookingSummaryService.getBookingSummaryById(id);
//        return ResponseEntity.ok(bookingSummary);
//    }
//
//    @PostMapping
//    public BookingSummary saveBookingSummary(@RequestBody BookingSummary bookingSummary) {
//        return bookingSummaryService.saveBookingSummary(bookingSummary);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBookingSummary(@PathVariable Long id) {
//        bookingSummaryService.deleteBookingSummary(id);
//        return ResponseEntity.noContent().build();
//    }
}
