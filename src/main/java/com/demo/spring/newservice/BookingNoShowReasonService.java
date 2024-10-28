package com.demo.spring.newservice;

import com.demo.spring.model.BookingNoShowReason;

import java.util.List;

public interface BookingNoShowReasonService {
    List<BookingNoShowReason> getAllNoShowReasons();
    BookingNoShowReason getNoShowReasonById(Long id);
    BookingNoShowReason saveNoShowReason(BookingNoShowReason noShowReason);
    void deleteNoShowReason(Long id);
}
