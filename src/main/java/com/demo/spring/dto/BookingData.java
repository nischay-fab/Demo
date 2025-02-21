package com.demo.spring.dto;

public class BookingData {

    private Long id;
    private String bookingId;
    private String uuid;
    private Long checkin;
    private Long checkout;
    private Double grandTotal;
    private String corporateId;
    private Double comparisonPrice;
    private String localCurrency;
    private Double localCurrencyAmount;
    private String noShowReason;
    private String travellerName;
    private String city;

    // Getters and setters for all the fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getCheckin() {
        return checkin;
    }

    public void setCheckin(Long checkin) {
        this.checkin = checkin;
    }

    public Long getCheckout() {
        return checkout;
    }

    public void setCheckout(Long checkout) {
        this.checkout = checkout;
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

    public String getCity() {
        return city;}

    public void setCity(String city) {
        this.city = city;
    }
}
