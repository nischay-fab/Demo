package com.demo.spring.model;

import lombok.Data; 
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "unified_booking_data")
@Data  
public class UnifiedBookingData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "booking_id")
    private String bookingId;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "checkin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkin;

    @Column(name = "checkout")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkout;

    @Column(name = "grand_total")
    private Double grandTotal;

    @Column(name = "corporate_id")
    private String corporateId;

    @Column(name = "comparison_price")
    private Double comparisonPrice;

    @Column(name = "local_currency")
    private String localCurrency;

    @Column(name = "local_currency_amount")
    private Double localCurrencyAmount;

    @Column(name = "no_show_reason")
    private String noShowReason;

    @Column(name = "traveller_name")
    private String travellerName;
}
