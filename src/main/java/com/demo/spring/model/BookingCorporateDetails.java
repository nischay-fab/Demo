package com.demo.spring.model;
import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;  // Import Lombok's Data annotation

@Data  // Lombok will generate getters, setters, toString, equals, and hashCode
@Entity
@Table(name = "booking_corporate_details") 
public class BookingCorporateDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "tenant_id")
    private String tenantId;

    @Column(name = "booking_id")
    private String bookingId;

    @Column(name = "ota_booking_id")  
    private String otaBookingId;

    @Column(name = "reference_booking_id")  
    private String referenceBookingId;

    @Column(name = "btc_company")
    private String btcCompany;

    @Column(name = "cr_company_name")
    private String crCompanyName;

    @Column(name = "cr_manager_email")
    private String crManagerEmail;

    @Column(name = "cr_manager_name")
    private String crManagerName;

    @Column(name = "cr_manager_phone")
    private String crManagerPhone;

    @Column(name = "cr_contract_id")
    private String crContractId;

    @Column(name = "corporate_id")
    private String corporateId;

    @Column(name = "comparison_price")
    private Double comparisonPrice;

    @Column(name = "cr_child_id")
    private String crChildId;

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
