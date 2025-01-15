package com.demo.spring.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "booking_travellers")  
public class BookingTravellers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "tenant_id")
    private String tenantId;

    @Column(name = "booking_id")
    private String bookingId;

    @Column(name = "traveller_id")
    private String travellerId;

    @Column(name = "title")
    private String title;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "purpose_of_travel")
    private String purposeOfTravel;

    @Column(name = "arrival_date_time")
    private LocalDateTime arrivalDateTime;

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "guest_type")
    private String guestType;

    @Column(name = "primary_guest")
    private Boolean primaryGuest;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Override
    public String toString() {
        return this.travellerId;
    }
}
