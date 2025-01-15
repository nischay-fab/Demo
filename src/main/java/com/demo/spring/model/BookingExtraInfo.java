package com.demo.spring.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;  

@Data  // Lombok will generate getters, setters, toString, equals, and hashCode
@Entity
@Table(name = "booking_extra_info")  
public class BookingExtraInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "booking_id")
    private String bookingId;

    @Column(name = "excluded_prices")
    private String excludedPrices;

    @Column(name = "local_currency")
    private String localCurrency;

    @Column(name = "local_currency_amount")
    private Float localCurrencyAmount;

    @Column(name = "conversion_rate")
    private Float conversionRate;

    @Column(name = "rate_plan_amenities")
    private String ratePlanAmenities;

    @Column(name = "room_type_amenities")
    private String roomTypeAmenities;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "tenant_id")
    private String tenantId;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "is_published")
    private Boolean isPublished;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    // No need for a custom toString method if using Lombok's @Data
}
