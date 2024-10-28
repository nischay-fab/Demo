package com.demo.spring.controller;

import com.demo.spring.model.BookingCorporateDetails;
import com.demo.spring.newservice.BookingCorporateDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/corporate-details")
public class BookingCorporateDetailsController {

    @Autowired
    private BookingCorporateDetailsService corporateDetailsService;
//
//    @Autowired
//    public BookingCorporateDetailsController(BookingCorporateDetailsService corporateDetailsService) {
//        this.corporateDetailsService = corporateDetailsService;
//    }

    @GetMapping
    public List<BookingCorporateDetails> getAllCorporateDetails() {
        return corporateDetailsService.getAllCorporateDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingCorporateDetails> getCorporateDetailById(@PathVariable Long id) {
        BookingCorporateDetails corporateDetail = corporateDetailsService.getCorporateDetailById(id);
        return ResponseEntity.ok(corporateDetail);
    }

    @PostMapping
    public BookingCorporateDetails saveCorporateDetail(@RequestBody BookingCorporateDetails corporateDetail) {
        return corporateDetailsService.saveCorporateDetail(corporateDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCorporateDetail(@PathVariable Long id) {
        corporateDetailsService.deleteCorporateDetail(id);
        return ResponseEntity.noContent().build();
    }
}
