package com.demo.spring.model;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "unified_booking_data")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@NotNull
@Size

public class UnifiedBookingData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "booking_id")
    private String bookingId;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "checkin")
    /*@Temporal(TemporalType.TIMESTAMP)*/
    private long checkin;

    @Column(name = "checkout")
    /*@Temporal(TemporalType.TIMESTAMP)*/
    private long checkout;

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

    @Column(name = "hotel_trip_id")
    private String hotelTripId;

    public Double getGrandTotal() {
        return grandTotal;
    }

    public Long getId() {
        return id;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getUuid() {
        return uuid;
    }

    public long getCheckin() {
        return checkin;
    }

    public long getCheckout() {
        return checkout;
    }

    public String getCorporateId() {
        return corporateId;
    }

    public Double getComparisonPrice() {
        return comparisonPrice;
    }

    public String getLocalCurrency() {
        return localCurrency;
    }

    public Double getLocalCurrencyAmount() {
        return localCurrencyAmount;
    }

    public String getNoShowReason() {
        return noShowReason;
    }

    public String getTravellerName() {
        return travellerName;
    }

    public String getHotelTripId() {return hotelTripId; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setCheckin(long checkin) {
        this.checkin = checkin;
    }

    public void setCheckout(long checkout) {
        this.checkout = checkout;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void setCorporateId(String corporateId) {
        this.corporateId = corporateId;
    }

    public void setComparisonPrice(Double comparisonPrice) {
        this.comparisonPrice = comparisonPrice;
    }

    public void setLocalCurrency(String localCurrency) {
        this.localCurrency = localCurrency;
    }

    public void setLocalCurrencyAmount(Double localCurrencyAmount) {
        this.localCurrencyAmount = localCurrencyAmount;
    }

    public void setNoShowReason(String noShowReason) {
        this.noShowReason = noShowReason;
    }

    public void setTravellerName(String travellerName) {
        this.travellerName = travellerName;
    }

    public void setHotelTripId(String hotelTripId) { this.hotelTripId=hotelTripId;}
}