package com.demo.spring.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataProjectionDto {

    String bookingId;

    String summaryUuid;

    Long checkIn;

    Long checkOut;

    Double grandTotal;

    String corporateId;

    Double comparisonPrice;

    String localCurrency;

    Double localCurrencyAmount;

    String noShowReason;

    String travellerName;

    String hotelTripId;
}



