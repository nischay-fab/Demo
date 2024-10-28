package com.demo.spring.repository;

import com.demo.spring.model.BookingExtraInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingExtraInfoRepository extends JpaRepository<BookingExtraInfo, Long> {
    
}
