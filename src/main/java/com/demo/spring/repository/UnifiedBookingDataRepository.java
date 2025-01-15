package com.demo.spring.repository;
import java.util.List;
import com.demo.spring.dto.DataProjectionDto;
import com.demo.spring.model.UnifiedBookingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface UnifiedBookingDataRepository extends JpaRepository<UnifiedBookingData, Long> {
    @Query(value = "SELECT " +
            "COALESCE(b.id, 0) AS id, " +
            "COALESCE(b.booking_id, 'Default Booking ID') AS booking_id, " +
            "COALESCE(b.uuid, 'Default UUID') AS uuid, " +
            "UNIX_TIMESTAMP(b.checkin) * 1000 AS checkin, " +
            "UNIX_TIMESTAMP(b.checkout) * 1000 AS checkout, " +
            "COALESCE(b.grand_total, 0.0) AS grand_total, " +
            "COALESCE(c.corporate_id, 'Default Corporate ID') AS corporate_id, " +
            "COALESCE(c.comparison_price, 0.0) AS comparison_price, " +
            "COALESCE(e.local_currency, 'Default Currency') AS local_currency, " +
            "COALESCE(e.local_currency_amount, 0.0) AS local_currency_amount, " +
            "COALESCE(n.no_show_reason, 'No Reason Provided') AS no_show_reason, " +
            "COALESCE(CONCAT(t.title, ' ', t.middle_name), 'Unknown Traveller') AS traveller_name " +
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
            "    b.is_deleted = 0 " +
            "LIMIT 1000",
            nativeQuery = true)
    List<UnifiedBookingData> fetchCombinedBookingData();
}

