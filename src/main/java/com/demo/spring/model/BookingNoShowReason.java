package com.demo.spring.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;
@Data  
@Entity
@Table(name = "booking_no_show_reason")  
public class BookingNoShowReason {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "booking_id")
    private String bookingId;

    @Column(name = "guest_stayed")
    private Boolean guestStayed;

    @Column(name = "room_numbers")
    private String roomNumbers;

    @Column(name = "no_show_reason")
    private String noShowReason;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "tenant_id")
    private String tenantId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "is_published")
    private Boolean isPublished;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;
}
