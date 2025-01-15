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
}