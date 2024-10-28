package com.demo.spring.dto;

import java.util.Date;

public interface DataProjectionDto {

    String getBookingId();

    String getSummaryUuid();

    Date getCheckIn();

    Date getCheckOut();

    Double getGrandTotal();

    String getCorporateId();

    Double getComparisonPrice();

    String getLocalCurrency();

    Double getLocalCurrencyAmount();

    String getNoShowReason();

    String getTravellerName();
}

