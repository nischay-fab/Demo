package com.demo.spring.newservice.impl;

import com.demo.spring.model.BookingCorporateDetails;
import com.demo.spring.newservice.BookingCorporateDetailsService;
import com.demo.spring.repository.BookingCorporateDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingCorporateDetailsServiceImpl implements BookingCorporateDetailsService {

    private final BookingCorporateDetailsRepository corporateDetailsRepository;

    @Autowired
    public BookingCorporateDetailsServiceImpl(BookingCorporateDetailsRepository corporateDetailsRepository) {
        this.corporateDetailsRepository = corporateDetailsRepository;
    }

    @Override
    public List<BookingCorporateDetails> getAllCorporateDetails() {
        return corporateDetailsRepository.findAll();
    }

    @Override
    public BookingCorporateDetails getCorporateDetailById(Long id) {
        return corporateDetailsRepository.findById(id).orElse(null);
    }

    @Override
    public BookingCorporateDetails saveCorporateDetail(BookingCorporateDetails corporateDetail) {
        return corporateDetailsRepository.save(corporateDetail);
    }

    @Override
    public void deleteCorporateDetail(Long id) {
        corporateDetailsRepository.deleteById(id);
    }
}
