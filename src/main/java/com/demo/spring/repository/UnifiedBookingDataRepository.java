package com.demo.spring.repository;

import java.util.List;

import com.demo.spring.dto.DataProjectionDto;
import com.demo.spring.model.UnifiedBookingData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UnifiedBookingDataRepository extends JpaRepository<UnifiedBookingData, Long> {

    @Query(value="SELECT " + 
                "b.booking_id AS bookingId, " + 
                "b.uuid AS summaryUuid, " + 
                "b.checkin AS checkIn, " + 
                "b.checkout AS checkOut, " + 
                "b.grand_total AS grandtotal, " + 
                "c.corporate_id AS corporateid, " + 
                "c.comparison_price AS comparisonprice, " + 
                "e.local_currency AS localcurrency, " + 
                "e.local_currency_amount AS localcurrencyamount, " + 
                "n.no_show_reason AS noshowreason, " + 
                "CONCAT(t.title, ' ', t.middle_name) AS traveller_name " + 
                "FROM " + 
                "    Booking.booking_summary b " + 
                "LEFT JOIN " + 
                "    Booking.booking_corporate_details c ON b.booking_id = c.booking_id " + 
                "LEFT JOIN " + 
                "    Booking.booking_travellers t ON b.booking_id = t.booking_id " + 
                "LEFT JOIN " + 
                "    Booking.booking_extra_info e ON b.booking_id = e.booking_id " + 
                "LEFT JOIN " + 
                "    Booking.booking_no_show_reason n ON b.booking_id = n.booking_id " + 
                "WHERE " + 
                "b.is_deleted = 0 " + 
                "LIMIT 100 ",
                nativeQuery=true)
    List<DataProjectionDto> fetchCombinedBookingData();
}


