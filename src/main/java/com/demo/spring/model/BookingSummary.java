package com.demo.spring.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;  // Import Lombok's Data annotation

@Data
@Entity
@Table(name = "booking_summary") 
public class BookingSummary {

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

    @Column(name = "booking_source")
    private Integer bookingSource;

    @Column(name = "booking_source_desc")
    private String bookingSourceDesc;

    @Column(name = "initial_booking_status")
    private Integer initialBookingStatus;

    @Column(name = "booking_status")
    private Integer bookingStatus;

    @Column(name = "booking_status_desc")
    private String bookingStatusDesc;

    @Column(name = "initial_guest_status")
    private Integer initialGuestStatus;

    @Column(name = "guest_status")
    private Integer guestStatus;

    @Column(name = "guest_status_desc")
    private String guestStatusDesc;

    @Column(name = "property_id")
    private Integer propertyId;

    @Column(name = "nights")
    private Short nights;

    @Column(name = "rooms")
    private Short rooms;

    @Column(name = "guests")
    private Short guests;

    @Column(name = "room_type_ids")
    private String roomTypeIds;

    @Column(name = "checkin")
    private Date checkin;

    @Column(name = "checkout")
    private Date checkout;

    @Column(name = "commission")
    private Double commission;

    @Column(name = "gstin")
    private String gstin;

    @Column(name = "gst_company_name")
    private String gstCompanyName;

    @Column(name = "gst_address")
    private String gstAddress;

    @Column(name = "gst_pin_code")
    private String gstPinCode;

    @Column(name = "initial_sub_total")
    private Double initialSubTotal;

    @Column(name = "sub_total")
    private Double subTotal;

    @Column(name = "breakfast_cost")
    private Double breakfastCost;

    @Column(name = "inclusions_cost")
    private Double inclusionsCost;

    @Column(name = "initial_tax")
    private Double initialTax;

    @Column(name = "tax")
    private Double tax;

    @Column(name = "initial_grand_total")
    private Double initialGrandTotal;

    @Column(name = "grand_total")
    private Double grandTotal;

    @Column(name = "margin")
    private Double margin;

    @Column(name = "cgst_tax")
    private Double cgstTax;

    @Column(name = "igst_tax")
    private Double igstTax;

    @Column(name = "convenience_fee_type")
    private String convenienceFeeType;

    @Column(name = "configured_convenience_fee")
    private Double configuredConvenienceFee;

    @Column(name = "convenience_fee")
    private Double convenienceFee;

    @Column(name = "convenience_fee_sgst")
    private Double convenienceFeeSgst;

    @Column(name = "convenience_fee_cgst")
    private Double convenienceFeeCgst;

    @Column(name = "convenience_fee_igst")
    private Double convenienceFeeIgst;

    @Column(name = "convenience_fee_tax")
    private Double convenienceFeeTax;

    @Column(name = "sgst_tax")
    private Double sgstTax;

    @Column(name = "sbc_tax")
    private Double sbcTax;

    @Column(name = "kkc_tax")
    private Double kkcTax;

    @Column(name = "service_tax")
    private Double serviceTax;

    @Column(name = "is_sez")
    private Boolean isSez;

    @Column(name = "payment_mode")
    private String paymentMode;

    @Column(name = "initial_payment_mode")
    private String initialPaymentMode;

    @Column(name = "when_to_pay")
    private String whenToPay;

    @Column(name = "occupancy")
    private String occupancy;

    @Column(name = "coupon_code")
    private String couponCode;

    @Column(name = "points")
    private Double points;

    @Column(name = "points_transaction_id")
    private String pointsTransactionId;

    @Column(name = "gift_voucher_code")
    private String giftVoucherCode;

    @Column(name = "gift_voucher_amount")
    private Double giftVoucherAmount;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "discount_type")
    private Integer discountType;

    @Column(name = "inclusion_id")
    private Integer inclusionId;

    @Column(name = "inclusion_name")
    private String inclusionName;

    @Column(name = "description")
    private String description;

    @Column(name = "inclusion_cost")
    private Double inclusionCost;

    @Column(name = "inclusion_type")
    private String inclusionType;

    @Column(name = "inclusion_provider")
    private String inclusionProvider;

    @Column(name = "ota_booking_source")
    private Integer otaBookingSource;

    @Column(name = "ota_booking_source_desc")
    private String otaBookingSourceDesc;

    @Column(name = "other_booking_source")
    private String otherBookingSource;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "traveller_ids")
    private String travellerIds;

    @Column(name = "special_request")
    private String specialRequest;

    @Column(name = "inclusions")
    private String inclusions;

    @Column(name = "internal_comments")
    private String internalComments;

    @Column(name = "is_vip")
    private Boolean isVip;

    @Column(name = "is_travel_plus")
    private Boolean isTravelPlus;

    @Column(name = "is_early_checkout")
    private Boolean isEarlyCheckout;

    @Column(name = "is_walkin")
    private Integer isWalkin;

    @Column(name = "cancel_datetime")
    private Date cancelDatetime;

    @Column(name = "cancelled_reason")
    private String cancelledReason;

    @Column(name = "checkin_datetime")
    private Date checkinDatetime;

    @Column(name = "checkout_datetime")
    private Date checkoutDatetime;

    @Column(name = "noshow_datetime")
    private Date noshowDatetime;

    @Column(name = "room_numbers")
    private String roomNumbers;

    @Column(name = "shifted_from")
    private Integer shiftedFrom;

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

    @Column(name = "meal_charges")
    private Double mealCharges;

    @Column(name = "ta_company_id")
    private String taCompanyId;

    @Column(name = "ta_sales_person_email")
    private String taSalesPersonEmail;

    @Column(name = "ta_sales_person_mobile")
    private String taSalesPersonMobile;

    @Column(name = "ta_sales_person_name")
    private String taSalesPersonName;

    @Column(name = "tmc_id")
    private String tmcId;

    @Column(name = "tmc_sales_person_name")
    private String tmcSalesPersonName;

    @Column(name = "tmc_sales_person_email")
    private String tmcSalesPersonEmail;

    @Column(name = "tmc_sales_person_mobile")
    private String tmcSalesPersonMobile;

    @Column(name = "cab_charges")
    private Double cabCharges;

    @Column(name = "travel_agent_commission")
    private Double travelAgentCommission;

    @Column(name = "app_version")
    private String appVersion;

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

    @Column(name = "modification_status")
    private String modificationStatus;

    @Column(name = "trip_id")
    private String tripId;

    @Column(name = "hotel_trip_id")
    private String hotelTripId;

    @Column(name = "checkin_denial_datetime")
    private Date checkinDenialDatetime;

    @Column(name = "checkin_denial_reason")
    private String checkinDenialReason;

    @Column(name = "rate")
    private String rate;

    @Column(name = "confirmation_datetime")
    private Date confirmationDatetime;

    @Column(name = "confirmation_type")
    private String confirmationType;

    @Column(name = "rate_plan_codes")
    private String ratePlanCodes;

    @Column(name = "rate_source")
    private String rateSource;

}
