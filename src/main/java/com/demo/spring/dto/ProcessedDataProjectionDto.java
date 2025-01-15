/*
package com.demo.spring.dto;

import java.util.Date;

public class ProcessedDataProjectionDto {

    private String bookingId;
    private String summaryUuid;
    private Date checkIn;
    private Date checkOut;
    private Double grandTotal;
    private String corporateId;
    private Double comparisonPrice;
    private String localCurrency;
    private Double localCurrencyAmount;
    private String noShowReason;
    private String travellerName;

    // Constructor to map and sanitize data
    public ProcessedDataProjectionDto(DataProjectionDto dto) {
        this.bookingId = dto.getBookingId();
        this.summaryUuid = dto.getSummaryUuid();
        this.checkIn = dto.getCheckIn();
        this.checkOut = dto.getCheckOut();
        this.grandTotal = dto.getGrandTotal();
        this.corporateId = dto.getCorporateId() != null ? dto.getCorporateId() : "Default Corporate ID";
        this.comparisonPrice = dto.getComparisonPrice() != null ? dto.getComparisonPrice() : 0.0;
        this.localCurrency = dto.getLocalCurrency() != null ? dto.getLocalCurrency() : "Default Currency";
        this.localCurrencyAmount = dto.getLocalCurrencyAmount() != null ? dto.getLocalCurrencyAmount() : 0.0;
        this.noShowReason = dto.getNoShowReason() != null ? dto.getNoShowReason() : "No Reason Provided";
        this.travellerName = dto.getTravellerName() != null ? dto.getTravellerName() : "Unknown";
    }

    // Getters and setters
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getSummaryUuid() {
        return summaryUuid;
    }

    public void setSummaryUuid(String summaryUuid) {
        this.summaryUuid = summaryUuid;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getCorporateId() {
        return corporateId;
    }

    public void setCorporateId(String corporateId) {
        this.corporateId = corporateId;
    }

    public Double getComparisonPrice() {
        return comparisonPrice;
    }

    public void setComparisonPrice(Double comparisonPrice) {
        this.comparisonPrice = comparisonPrice;
    }

    public String getLocalCurrency() {
        return localCurrency;
    }

    public void setLocalCurrency(String localCurrency) {
        this.localCurrency = localCurrency;
    }

    public Double getLocalCurrencyAmount() {
        return localCurrencyAmount;
    }

    public void setLocalCurrencyAmount(Double localCurrencyAmount) {
        this.localCurrencyAmount = localCurrencyAmount;
    }

    public String getNoShowReason() {
        return noShowReason;
    }

    public void setNoShowReason(String noShowReason) {
        this.noShowReason = noShowReason;
    }

    public String getTravellerName() {
        return travellerName;
    }

    public void setTravellerName(String travellerName) {
        this.travellerName = travellerName;
    }
}
*/
