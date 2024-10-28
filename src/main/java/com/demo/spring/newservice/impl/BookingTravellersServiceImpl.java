package com.demo.spring.newservice.impl;

import com.demo.spring.model.BookingTravellers;
import com.demo.spring.newservice.BookingTravellersService;
import com.demo.spring.repository.BookingTravellersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingTravellersServiceImpl implements BookingTravellersService {

    private final BookingTravellersRepository travellersRepository;

  
    public BookingTravellersServiceImpl(BookingTravellersRepository travellersRepository) {
        this.travellersRepository = travellersRepository;
    }

    @Override
    public List<BookingTravellers> getAllTravellers() {
        return travellersRepository.findAll();
    }

    @Override
    public BookingTravellers getTravellerById(Long id) {
        return travellersRepository.findById(id).orElse(null);
    }

    @Override
    public BookingTravellers saveTraveller(BookingTravellers traveller) {
        return travellersRepository.save(traveller);
    }

    @Override
    public void deleteTraveller(Long id) {
        travellersRepository.deleteById(id);
    }
}
