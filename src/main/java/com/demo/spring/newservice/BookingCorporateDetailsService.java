package com.demo.spring.newservice;

import com.demo.spring.model.BookingCorporateDetails;
import java.util.List;

public interface BookingCorporateDetailsService {
    List<BookingCorporateDetails> getAllCorporateDetails();
    BookingCorporateDetails getCorporateDetailById(Long id);
    BookingCorporateDetails saveCorporateDetail(BookingCorporateDetails corporateDetail);
    void deleteCorporateDetail(Long id);
}
