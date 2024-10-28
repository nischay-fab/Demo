package com.demo.spring.newservice.impl;

import com.demo.spring.model.BookingNoShowReason;
import com.demo.spring.newservice.BookingNoShowReasonService;
import com.demo.spring.repository.BookingNoShowReasonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingNoShowReasonServiceImpl implements BookingNoShowReasonService {

    private final BookingNoShowReasonRepository noShowReasonRepository;


    public BookingNoShowReasonServiceImpl(BookingNoShowReasonRepository noShowReasonRepository) {
        this.noShowReasonRepository = noShowReasonRepository;
    }

    @Override
    public List<BookingNoShowReason> getAllNoShowReasons() {
        return noShowReasonRepository.findAll();
    }

    @Override
    public BookingNoShowReason getNoShowReasonById(Long id) {
        return noShowReasonRepository.findById(id).orElse(null);
    }

    @Override
    public BookingNoShowReason saveNoShowReason(BookingNoShowReason noShowReason) {
        return noShowReasonRepository.save(noShowReason);
    }

    @Override
    public void deleteNoShowReason(Long id) {
        noShowReasonRepository.deleteById(id);
    }
}
