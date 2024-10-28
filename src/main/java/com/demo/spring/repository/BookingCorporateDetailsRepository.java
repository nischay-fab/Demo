package com.demo.spring.repository;

import com.demo.spring.model.BookingCorporateDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingCorporateDetailsRepository extends JpaRepository<BookingCorporateDetails, Long> {
    
}
