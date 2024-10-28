package com.demo.spring.repository;

import com.demo.spring.model.BookingNoShowReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingNoShowReasonRepository extends JpaRepository<BookingNoShowReason, Long> {
    // Custom query methods can be defined here if needed
}
