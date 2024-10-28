package com.demo.spring.controller;

import com.demo.spring.model.BookingTravellers;
import com.demo.spring.newservice.BookingTravellersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/travellers")
public class BookingTravellersController {

    @Autowired
    private BookingTravellersService travellersService;

    @GetMapping
    public List<BookingTravellers> getAllTravellers() {
        return travellersService.getAllTravellers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingTravellers> getTravellerById(@PathVariable Long id) {
        BookingTravellers traveller = travellersService.getTravellerById(id);
        return ResponseEntity.ok(traveller);
    }

    @PostMapping
    public BookingTravellers saveTraveller(@RequestBody BookingTravellers traveller) {
        return travellersService.saveTraveller(traveller);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTraveller(@PathVariable Long id) {
        travellersService.deleteTraveller(id);
        return ResponseEntity.noContent().build();
    }
}
