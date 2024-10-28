package com.demo.spring.repository;

import com.demo.spring.model.BookingSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingSummaryRepository extends JpaRepository<BookingSummary, Long> {
    
}
