package com.demo.spring.controller;

import com.demo.spring.model.BookingNoShowReason;
import com.demo.spring.newservice.BookingNoShowReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/no-show-reasons")
public class BookingNoShowReasonController {

    @Autowired
    private BookingNoShowReasonService noShowReasonService;

    @GetMapping
    public List<BookingNoShowReason> getAllNoShowReasons() {
        return noShowReasonService.getAllNoShowReasons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingNoShowReason> getNoShowReasonById(@PathVariable Long id) {
        BookingNoShowReason noShowReason = noShowReasonService.getNoShowReasonById(id);
        return ResponseEntity.ok(noShowReason);
    }

    @PostMapping
    public BookingNoShowReason saveNoShowReason(@RequestBody BookingNoShowReason noShowReason) {
        return noShowReasonService.saveNoShowReason(noShowReason);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoShowReason(@PathVariable Long id) {
        noShowReasonService.deleteNoShowReason(id);
        return ResponseEntity.noContent().build();
    }
}
