package com.demo.spring.newservice;

import com.demo.spring.model.BookingTravellers;

import java.util.List;

public interface BookingTravellersService {
    List<BookingTravellers> getAllTravellers();
    BookingTravellers getTravellerById(Long id);
    BookingTravellers saveTraveller(BookingTravellers traveller);
    void deleteTraveller(Long id);
}
